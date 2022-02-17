package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import entity.Apple;
import entity.Color;
import entity.Country;

@FunctionalInterface
interface SupplierFruit<T> {
	public T get(Color color, int weightMax, Country country);
}

public class Factory {
	 /**
     * ������� ������������� �������
     * @param  <T> - ����� ������
     * @param count - ���������� �������
     * @param weightMax - ������������ ���
     * @param supplier - ��������� ������ �� ����������� ������
     * @return ���� �������
     */
	public static <T> List<T> GenerateutFruit(int count, int weightMax, SupplierFruit<T> supplier) {
		List<T> list = new ArrayList<>();
		Color[] colors = Color.values();
		Country[] countries = Country.values();
		final Random RANDOM = new Random();
		for (int i = 0; i < count; i++) {
			list.add(supplier.get(colors[RANDOM.nextInt(colors.length)], RANDOM.nextInt(weightMax),
					countries[RANDOM.nextInt(countries.length)]));
		}
		return list;

	}
}
