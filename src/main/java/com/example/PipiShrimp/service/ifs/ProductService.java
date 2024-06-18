package com.example.PipiShrimp.service.ifs;

import com.example.PipiShrimp.entity.Product;
import com.example.PipiShrimp.vo.ProductRes;
import com.example.PipiShrimp.vo.ProductSearchRes;

public interface ProductService {

	// �C�ӱb����ܤ��P�ӫ~
	public ProductSearchRes getProductInfoByUserId(int id);

	/**
	 * �s�W�ӫ~&�s��ӫ~
	 **/
	public ProductRes create(Product product);

	/**
	 * �R���浧�ӫ~(�Ѽƨϥ�product_id)
	 **/
	public ProductRes delete(int id);

	/**
	 * ���o��@�ӫ~��T(�Ѽƨϥ�product_id)
	 **/
	public ProductRes getProductInfo(int id);

	/**
	 * ���o�ӫ~��T(�Ҧ����~)
	 **/
	public ProductSearchRes getAllProductInfo();

	/**
	 * ���o�j�M�ӫ~�W�٪��ӫ~��T(�ҽk�j�M)
	 **/
	public ProductSearchRes getProductByName(String productName);

	/**
	 * ���o�ӫ~��T(�̻����Ƨ� �C => ��)
	 **/
	public ProductSearchRes getProductByPrice();

	/**
	 * ���o�ӫ~��T(�̻����Ƨ� �� => �C)
	 **/
	public ProductSearchRes getProductByPriceDesc();

	public ProductSearchRes getByProductType(String ProductType);
}
