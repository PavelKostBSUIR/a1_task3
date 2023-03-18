package com.a1.a1.service;

import com.a1.a1.entity.dto.GetPostDto;
import com.a1.a1.mapper.*;
import com.a1.a1.parser.MyCSVParser;
import com.a1.a1.repo.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final GetPostMapper getPostMapper;
    private final PostRepository postRepository;
    private final PostParserMapper postParserMapper;
    private final CurrencyRepository currencyRepository;
    private final CurrencyParserMapper currencyParserMapper;
    private final ApplicationRepository applicationRepository;
    private final ApplicationParserMapper applicationParserMapper;
    private final DepartmentRepository departmentRepository;
    private final DepartmentParserMapper departmentParserMapper;
    private final BUnRepository bUnRepository;
    private final BunParserMapper bUnParserMapper;
    private final UserRepository userRepository;
    private final UserParserMapper userParserMapper;
    private final PostItemRepository postItemRepository;
    private final PostItemParserMapper postItemParserMapper;
    private final ItemRepository itemRepository;
    private final ItemParserMapper itemParserMapper;

    @Autowired
    public PostService(PostRepository postRepository, GetPostMapper getPostMapper, PostParserMapper postParserMapper, CurrencyRepository currencyRepository, CurrencyParserMapper currencyParserMapper, ApplicationRepository applicationRepository, ApplicationParserMapper applicationParserMapper, DepartmentRepository departmentRepository, DepartmentParserMapper departmentParserMapper, BUnRepository bUnRepository, BunParserMapper bUnParserMapper, UserRepository userRepository, UserParserMapper userParserMapper, PostItemRepository postItemRepository, PostItemParserMapper postItemParserMapper, ItemRepository itemRepository, ItemParserMapper itemParserMapper) {
        this.postRepository = postRepository;
        this.getPostMapper = getPostMapper;
        this.postParserMapper = postParserMapper;
        this.currencyRepository = currencyRepository;
        this.currencyParserMapper = currencyParserMapper;
        this.applicationRepository = applicationRepository;
        this.applicationParserMapper = applicationParserMapper;
        this.departmentRepository = departmentRepository;
        this.departmentParserMapper = departmentParserMapper;
        this.bUnRepository = bUnRepository;
        this.bUnParserMapper = bUnParserMapper;
        this.userRepository = userRepository;
        this.userParserMapper = userParserMapper;
        this.postItemRepository = postItemRepository;
        this.postItemParserMapper = postItemParserMapper;
        this.itemRepository = itemRepository;
        this.itemParserMapper = itemParserMapper;
    }

    @Transactional
    public List<GetPostDto> getInPeriod(Date postDateStart, Date postDateEnd) {
        return postRepository.findByPostDateBetween(postDateStart, postDateEnd).stream().peek(post -> post.setItems(postItemRepository.findByPost(post))).map(getPostMapper::postToGetPostDto).collect(Collectors.toList());
    }

    public void ParseFiles(File posts, File logins) {
        try {
            currencyRepository.saveAll(MyCSVParser.getCurrencies(posts, ";").stream().map(currencyParserMapper::currencyParserDtoToCurrency).collect(Collectors.toList()));
            applicationRepository.saveAll(MyCSVParser.getApplications(logins, ",").stream().map(applicationParserMapper::applicationParserDtoToApplication).collect(Collectors.toList()));
            departmentRepository.saveAll(MyCSVParser.getDepartments(logins, ",").stream().map(departmentParserMapper::departmentParserDtoToDepartment).collect(Collectors.toList()));
            bUnRepository.saveAll(MyCSVParser.getBuns(posts, ";").stream().map(bUnParserMapper::bunParserDtoToBun).collect(Collectors.toList()));
            MyCSVParser.getUsers(logins, ",").stream().map(userParserMapper::userParserDtoToUser).collect(Collectors.toList()).forEach(user -> {
                if (userRepository.findByAppAccountName(user.getAppAccountName()) == null) userRepository.save(user);
            });
            MyCSVParser.getItems(posts, ";").stream().map(itemParserMapper::itemParserDtoToItem).collect(Collectors.toList()).forEach(item -> {
                if (itemRepository.findByDescription(item.getDescription()) == null) itemRepository.save(item);
            });
            postRepository.saveAll(MyCSVParser.getPosts(posts, ";").stream().map(postParserMapper::postParserDtoToPost).peek(post -> {
                        post.setAuthorized(post.getUser() != null && post.getUser().getIsActive());
                    }
            ).collect(Collectors.toList()));
            postItemRepository.saveAll(MyCSVParser.getPostItems(posts, ";").stream().map(postItemParserMapper::postItemParserDtoToPostItem).collect(Collectors.toList()));
        } catch (DataIntegrityViolationException | IOException e) {
            System.out.println("fuck");
        }
    }
}
