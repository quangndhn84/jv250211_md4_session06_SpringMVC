package ra.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//Đánh dấu lớp Java này là 1 lớp cấu hình của ứng dụng
@Configuration
//Kích hoạt web mvc của Spring
@EnableWebMvc
//Chỉ định scan các package nào để khởi tạo các componnent của Spring để khi ứng dụng chạy nó sẽ tìm, khởi tạo và nạp vào containner
@ComponentScan(basePackages = {"ra.com.controller", "ra.com.service", "ra.com.repository.imp"})
public class AppConfig {
    //Tạo 1 bean để cấu hình cho view - ViewResolver
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //Đường dẫn chứa các view của ứng dụng
        viewResolver.setPrefix("/views/");
        //Mở rộng của file - Đuôi file là jsp
        viewResolver.setSuffix(".jsp");
        //--> gọi 1 view là students --> hiểu là gọi file students.jsp trong thư mục views
        return viewResolver;
    }
}
