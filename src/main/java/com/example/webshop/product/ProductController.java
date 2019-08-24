package com.example.webshop.product;
import com.example.webshop.category.CategoryService;
import com.example.webshop.category.CategoryType;
import com.example.webshop.product.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private ProductService productService;
    private AuthorService authorService;
    private CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping({"/products", "products"})
    public String getAllUsers(Model model){
        model.addAttribute("productList", productService.findAll());
        model.addAttribute("product", new Product());
        return "products";
    }
    @PostMapping("/addProduct")
    public String addProduct(Model model, @ModelAttribute Product product){
        model.addAttribute(productService.addProduct(product));
        model.addAttribute("productTypes", ProductType.values());
        model.addAttribute("categoryTypes", CategoryType.values());
        return "redirect:products";
    }
    @GetMapping(value = "/product")
    public String addProduct(Model model) {
        model.addAttribute("productTypes", ProductType.values());
        return "addProduct";
    }
    @RequestMapping(value="/deleteprdct/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id){
        productService.deleteById(id);
        return "redirect:/products";
    }
}
