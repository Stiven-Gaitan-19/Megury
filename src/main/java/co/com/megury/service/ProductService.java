package co.com.megury.service;

import co.com.megury.repository.ProductRepository;
import co.com.megury.service.dto.ProductDTO;
import co.com.megury.service.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    ProductService(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDTO save(ProductDTO dto){
        return productMapper.toDto(productRepository.save(productMapper.toEntity(dto)));
    }

    public List<ProductDTO> findAll(){
        return productMapper.toDtoList(productRepository.findAll());
    }

    public Optional<ProductDTO> findById(Long id){
        return productRepository.findById(id).map(productMapper::toDto);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

}
