package base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.model.entity.Voucher;
import base.repository.VoucherRepository;
@Service
public class  VoucherService {
	@Autowired
	private VoucherRepository voucherRepo;
	
	public Optional<Voucher> applyVoucher(String code) {
	    Optional<Voucher> voucher = voucherRepo.findByCode(code);
	    	return voucher;

	}
	
	public List<Voucher> findAll(){
		return voucherRepo.findAll();
	}
	
	
	public Voucher addCoupon(Voucher voucher) {
		return voucherRepo.save(voucher);
	}

	public Voucher editVoucher(int id , Voucher voucher){
		Voucher v = voucherRepo.findById(id);
        v.setCode(voucher.getCode());
		return  voucherRepo.save(v);
	}

	public void deleteVoucher(int id){
		voucherRepo.deleteById(id);
	}
}
