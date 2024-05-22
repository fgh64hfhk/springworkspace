package com.spring.example.app.initializer;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.spring.example.app.POJO.Category;
import com.spring.example.app.POJO.ProductEntity;
import com.spring.example.app.dao.ICategoryDao;
import com.spring.example.app.dao.IProductDao;
import com.spring.example.app.utils.JSONUtil;

@Component
public class Initializer {

	@Value("${helmet_file}")
	private String helmetFilePath;

	@Value("${trench_coat_file}")
	private String trenchCoatFilePath;

	@Value("${gloves_file}")
	private String glovesFilePath;

	@Autowired
	ICategoryDao categoryDao;

	@Autowired
	IProductDao productDao;

	public Initializer() {

	}

	public void initialize_product() {

		File helmetFile = new File(helmetFilePath);

		JSONObject jsonHelmet = JSONUtil.createJSONObject(helmetFile);

		File trenchCoatFile = new File(trenchCoatFilePath);

		JSONObject jsonTrenchCoat = JSONUtil.createJSONObject(trenchCoatFile);

		File glovesFile = new File(glovesFilePath);

		JSONObject jsonGloves = JSONUtil.createJSONObject(glovesFile);

		Map<String, String> categories = new HashMap<String, String>();

		String categoryName = "安全帽";
		String describeInfo = "包含全罩式、3/4罩式、復古式、可掀式";

		String categoryName2 = "防摔衣";
		String describeInfo2 = "包含防潑水、連帽、軟殼運動風格、競技";

		String categoryName3 = "防摔手套";
		String describeInfo3 = "包含防水、碳纖維、皮革";

		categories.put(categoryName, describeInfo);
		categories.put(categoryName2, describeInfo2);
		categories.put(categoryName3, describeInfo3);

		// 設置注入的 Category 實例的屬性
		categories.forEach((t, u) -> {
			Category category = new Category();
			category.setName(t);
			category.setDescription(u);
			categoryDao.save(category);
			Set<String> keys = categories.keySet();

			List<JSONObject> products = new CopyOnWriteArrayList<JSONObject>();
			products.add(jsonHelmet);
			products.add(jsonTrenchCoat);
			products.add(jsonGloves);

			products.forEach(product -> {
				keys.forEach(key -> {
					if (product.has(key)) {
						JSONArray array = product.getJSONArray(key);
						for (int i = 0; i < array.length(); i++) {

							ProductEntity entity = new ProductEntity();
							String[] strs = array.getJSONObject(i).getString("型號").split(" ");
							entity.setModel(strs[0].trim());
							entity.setSubCategory(array.getJSONObject(i).getString("種類"));
							entity.setBrand(array.getJSONObject(i).getString("品牌"));
							entity.setName(array.getJSONObject(i).getString("型號"));
							entity.setDescription(array.getJSONObject(i).getString("介紹"));
							entity.setPrice(array.getJSONObject(i).getDouble("價格"));

							// 處理尺寸的集合
							JSONArray sizes_json = array.getJSONObject(i).getJSONArray("尺寸");

							Set<String> sizes = new HashSet<String>();
							for (int j = 0; j < sizes_json.length(); j++) {
								sizes.add(sizes_json.getString(j));
							}

							entity.setSizes(sizes);

							// 處理顏色的集合

							JSONArray colors_json = array.getJSONObject(i).getJSONArray("顏色");

							Set<String> colors = new HashSet<String>();
							for (int j = 0; j < colors_json.length(); j++) {
								String c = colors_json.getString(j);
								colors.add(c);

								// 處理圖片的集合

								JSONObject pictures_json = array.getJSONObject(i).getJSONObject("照片");

								Map<String, String> pictures = new HashMap<String, String>();
								
								pictures.put(c, pictures_json.getString(c));

								entity.setPhotos(pictures);
							}

							entity.setColors(colors);

							// 處理種類的類別

							entity.setCategory(category);

							productDao.save(entity);
						}
					}
				});
			});
		});

	}

}
