package com.belikov.valteris.cycle.bicycle;

import com.belikov.valteris.cycle.bicycle.model.Bicycle;
import com.belikov.valteris.cycle.bicycle.model.BicycleType;
import com.belikov.valteris.cycle.bicycle.model.SortType;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BicycleController {

    private final BicycleService bicycleService;

    @GetMapping("/bicycles")
    public String bicyclesListPage() {
        return "bicycle-list";
    }

//    @GetMapping("/bicycles/all/page/{numberOfPage}")
//    @ResponseBody
//    public String getPageOfBicycles(@PathVariable int numberOfPage) {
//        final Page<Bicycle> bicyclePage = bicycleService.findPage(numberOfPage);
//        final int totalPages = bicyclePage.getTotalPages();
//        numberOfPage = checkNumberOfPage(numberOfPage, totalPages);
//
//        return getJson(numberOfPage, bicyclePage, totalPages);
//    }

    @GetMapping("/bicycles/all/sort/{typeOfSort}/type/{bicycleType}/page/{numberOfPage}")
    @ResponseBody
    public String getSortedPageOfBicycles(@PathVariable String typeOfSort,
                                          @PathVariable String bicycleType, @PathVariable int numberOfPage) {
        final Page<Bicycle> bicyclePage = bicycleService.findSortedPage(SortType.valueOf(typeOfSort),
                BicycleType.valueOf(bicycleType), numberOfPage);
        final int totalPages = bicyclePage.getTotalPages();
        numberOfPage = checkNumberOfPage(numberOfPage, totalPages);

        return getJson(numberOfPage, bicyclePage, totalPages);
    }

//    @GetMapping("/bicycles/all/type/{bicycleType}/page/{numberOfPage}")
//    @ResponseBody
//    public String getSortedByTypePageOfBicycles(@PathVariable String bicycleType, @PathVariable int numberOfPage) {
//        final Page<Bicycle> bicyclePage = bicycleService.findSortedByTypePage(BicycleType.valueOf(bicycleType), numberOfPage);
//        final int totalPages = bicyclePage.getTotalPages();
//        numberOfPage = checkNumberOfPage(numberOfPage, totalPages);
//
//        return getJson(numberOfPage, bicyclePage, totalPages);
//    }

    @GetMapping("/{id}")
    public Bicycle getBicycle(@PathVariable Long id) {
        return bicycleService.getById(id).get();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Bicycle newBicycle) {
        bicycleService.save(newBicycle);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bicycleService.delete(id);
    }

    private int checkNumberOfPage(int numberOfPage, int totalPages) {
        if (numberOfPage < 1 || numberOfPage > totalPages) {
            numberOfPage = 1;
        }
        return numberOfPage;
    }

    private String getJson(@PathVariable int numberOfPage, Page<Bicycle> bicyclePage, int totalPages) {
        JSONObject json = new JSONObject();
        json.put("currentPage", numberOfPage);
        json.put("totalPages", totalPages);
        json.put("bicycles", bicyclePage.get().collect(Collectors.toList()));

        return json.toString();
    }
}
