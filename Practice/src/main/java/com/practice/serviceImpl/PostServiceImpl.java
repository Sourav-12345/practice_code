package com.practice.serviceImpl;

import com.practice.entities.Post;
import com.practice.payload.PostDto;
import com.practice.repository.PostRepository;
import com.practice.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post savedPost=postRepository.save(post);

       PostDto dto = mapToDto(post);
        return dto;
    }
    Post mapToEntity(PostDto postDto){
//        Post post=new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
        Post post = modelMapper.map(postDto, Post.class);
        return post;
    }
    PostDto mapToDto(Post post){
//        PostDto dto=new PostDto();
//        dto.setId(post.getId());
//        dto.setTitle(post.getTitle());
//        dto.setDescription(post.getDescription());
//        dto.setContent(post.getContent());
        PostDto dto = modelMapper.map(post, PostDto.class);
        return dto;
    }
}
