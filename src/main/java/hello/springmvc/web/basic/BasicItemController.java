package hello.springmvc.web.basic;

import hello.springmvc.item.Item;
import hello.springmvc.item.ItemRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {
  private final ItemRepository itemRepository;

  //  @RequiredArgsConstructor
//  @Autowired
//  public BasicItemController(ItemRepository itemRepository) {
//    this.itemRepository = itemRepository;
//  }
  @GetMapping
  public String items(Model model) {
    List<Item> items = itemRepository.findAll();
    model.addAttribute("items", items);
    return "basic/items";
  }

  @GetMapping("/{itemId}")
  public String item(@PathVariable long itemId, Model model) {
    Item item = itemRepository.findById(itemId);
    model.addAttribute("item", item);
    return "basic/item";
  }

  @GetMapping("/add")
  public String addForm(Model model) {
    model.addAttribute("itemDto", new Item());
    return "basic/addForm";
  }

//  @PostMapping("/add/item-save")
//  public String save(@RequestParam String itemName, @RequestParam Integer price,
//      @RequestParam Integer quantity, Model model) {
//    Item item = new Item();
//    item.setItemName(itemName);
//    item.setPrice(price);
//    item.setQuantity(quantity);
//    itemRepository.save(item);
//    model.addAttribute("itemDto", item);
//    return "redirect:/basic/item";
//  }

  @PostMapping("/add/item-save")
  public String addItem(@ModelAttribute("ItemDto") Item itemValue, RedirectAttributes redirectAttributes) {
    Item savedItem = itemRepository.save(itemValue);
    System.out.println(savedItem);
//    model.addAttribute("itemDto", item); // ModelAttribute에서 자동 추가됨
//    redirectAttributes.addAttribute("itemId", savedItem.getId());
    return "redirect:/basic/items";
  }

  @PostConstruct
  public void init() {
    itemRepository.save(new Item("itemA", 10000, 10));
    itemRepository.save(new Item("itemB", 20000, 20));
  }
}
