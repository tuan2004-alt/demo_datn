package poly.store.datn.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import poly.store.datn.dtos.OrderDTO;
import poly.store.datn.models.Order;
import java.util.List;

@RestController
@RequestMapping("{api.prefix}/orders")
public class OrderController {
    @PatchMapping("")
    public ResponseEntity<?> createOrder(
            @RequestBody @Valid OrderDTO orderDTO,
            BindingResult result) {
        try {
            if (result.hasErrors()) {
                List<String> errorMessages = result.getFielErrors()
                        .stream
                        .map(FielErrors::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            return ResponseEntity.ok(body: "createOrder successfully");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{user_id}") // them bien duong dan "user id"
    public ResponseEntity<?> getOrders(@Validated @PathVariable ("user_id") Long  userId) {
        try{
            return ResponseEntity.ok(body: "Lay ra danh sach order tu user_id")
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public  ResponseEntity<?> updateOrder(
            @Validated @PathVariable long id,
            @Validated @ResponseBody Order DTO orderDTO){
        return ResponseEntity.ok(body: "Cap nhat thong tin 1 order" );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteOrder(@Validated @PathVariable Long id){
        // xoa mem =>> cap nhat truong acctive = false
        return ResponseEntity.ok("Order deleted successfully");
    }
}
