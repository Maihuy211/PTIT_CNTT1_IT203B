package exercise03.business;

import exercise03.dao.SurgeryDAO;

public class SurgeryBusiness {
    public static void calculateSurgerFee(){
        double fee = SurgeryDAO.calculateSurgerFee(1);
        System.out.println("Chi phí phẫu thuật: " + fee);
    }
}
