package com.example.webshop.product;
import com.example.webshop.category.Category;
import com.example.webshop.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }
    @RequestMapping(value = {"/products", "products"}, method = RequestMethod.GET)
    public String getAllProducts(Model model){
        model.addAttribute("productList", productService.findAll());
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("product", new Product());
        return "products";
    }
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(Model model, @ModelAttribute Product product, @ModelAttribute(name = "cat") String cat_id){
        Category category = categoryService.findById(Long.valueOf(cat_id));
        product.setCategory(category);
        model.addAttribute(productService.addProduct(product));
        return "redirect:products";
    }
    @RequestMapping(value = "/product", method = RequestMethod.GET)
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
