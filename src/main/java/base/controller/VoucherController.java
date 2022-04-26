package base.controller;



import base.model.entity.Voucher;
import base.model.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import base.service.VoucherService;

@RestController
@RequestMapping("/voucher")
public class VoucherController {
	  @Autowired
      private  VoucherService couponService;
  
      
      @GetMapping("code")
      public ResponseEntity<?> applyCoupon(@RequestParam String code){
    	  
    	 return ResponseEntity.ok(couponService.applyVoucher(code));   	  
      }

      @PutMapping("voucher/edit/{id}")
    public  ResponseEntity<?> edit(@RequestParam int id, @RequestBody Voucher voucher){
          return ResponseEntity.ok(couponService.editVoucher(id,voucher));
      }

    @PutMapping("voucher/add")
    public  ResponseEntity<?> add(@RequestBody Voucher voucher){
        return ResponseEntity.ok(couponService.addCoupon(voucher));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@RequestParam int id) {
        try {
            couponService.deleteVoucher(id);
            return new ResponseEntity(new ApiResponse(true, "delete sucess"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new ApiResponse(false, "delete failed"), HttpStatus.BAD_REQUEST);
        }
    }
}
