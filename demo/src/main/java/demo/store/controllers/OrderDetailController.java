package poly.store.datn.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import poly.store.datn.dtos.OrderDTO;
import poly.store.datn.dtos.OrderDetailDTO;
import poly.store.datn.models.Order;
import poly.store.datn.models.OrderDetail;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("${api.prefix}/order_details")
public class OrderDetailController {
    // them moi 1 orderdetail
    @PostMapping
    public ResponseEntity<?> createOrderDetail(
            @Validated @RequestBody OrderDetailDTO newOrderDetail){
        return  ResponseEntity.ok(body: "createOrderDetai here");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> (
            @Validated @PathVariable("id") Long id){
        return ResponseEntity.ok("getOrderDetail with id"+id );
    }
    // lay ra danh sach cac order_details cua 1 order nao do
    @GetMapping("/order/{orderId}")
    public  ResponseEntity<List<?>> getOrderDetails(@Validated @PathVariable("orderId") Long orderId){
        return ResponseEntity.ok(body:"getOrderDetails with orderId = "+ orderId);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetail(
            @Validated @PathVariable("id") Long id,
            @ResponseBody OrderDetailDTO newOrderDetailData){
        return ResponseEntity.ok("updateOrderDetail with id = "+id
                +",newOrderDetailData: "+newOrderDetailData );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetail(
            @Validated @PathVariable("id") Long id){
        return ResponseEntity.noContent().build();
    }
}
