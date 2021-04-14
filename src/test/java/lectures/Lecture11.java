package lectures;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

import beans.Car;
import beans.Makers;
import mockdata.MockData;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    String join = "";

    for(String name : names) {
      join += name + ", ";
    }

    System.out.println(join.substring(0, join.length()-2));

  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String join = names.stream().collect(Collectors.joining(", ", " ", ""));
    System.out.println(join);
  }
  
  @Test
  public void groupAndCountByMaker() throws IOException {
	  
//	  Tem uma classe chamada Cars, nela tem o fabricante.
//	  Eu faço -> pega a lista de carros -> agrupo por fabricante -> conto quantas vezes um fabricante aparece
//	  -> transformo essa  map de fabricantes/vezes que apareceu em uma lista de uma classe que conta o fabricante e as vezes que ele aparece
//	  -> orderno pelo que apareceu menos pra mais
	  
	  MockData.getCars().stream().collect(Collectors.groupingBy(Car::getMake, Collectors.counting()))
	  .entrySet().stream().map(Makers::statisticToMaker).sorted(Comparator.comparingLong(Makers::getTimesBuyed).reversed())
	  .collect(Collectors.toList()).forEach(System.out::println);
	  
//	  Tem uma classe chamada Cars, nela tem o fabricante.
//	  Eu faço -> pega a lista de carros -> agrupo por fabricante -> conto quantas vezes um fabricante aparece
//	  -> transformo essa  map de fabricantes/vezes que apareceu em uma lista de uma classe que conta o fabricante e as vezes que ele aparece
//	  -> orderno pelo que apareceu menos pra mais E filtra que vendeu mais de 50
	  
	  MockData.getCars().stream().collect(Collectors.groupingBy(Car::getMake, Collectors.counting()))
	  .entrySet().stream().map(Makers::statisticToMaker).sorted(Comparator.comparingLong(Makers::getTimesBuyed).reversed())
	  .filter(maker -> maker.getTimesBuyed() > 50).forEach(System.out::println);
	  
  }
}
