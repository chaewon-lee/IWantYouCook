package com.moco.wonchu.iwantyoucook;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moco.wonchu.iwantyoucook.Helper.DBHelper;
import com.moco.wonchu.iwantyoucook.Helper.ImageHelper;
import com.moco.wonchu.iwantyoucook.Model.RecipeItem;

import java.util.ArrayList;

/**
 * Created by Chaewon on 2018-01-25.
 */

public class RecipeFragment extends Fragment {

    ImageHelper imageHelper = new ImageHelper();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_recipe, container, false);

        DBHelper dbHelper = new DBHelper(getContext(), "Recipes.db", null, 1);
        ArrayList<RecipeItem> defaultDataList = dbHelper.recipes_SelectAll(getContext());
        if (defaultDataList == null || defaultDataList.size() == 0) {
            //Set Bibimap data
            Drawable drawable = getResources().getDrawable(R.drawable.bibimbap, getActivity().getTheme());
            byte[] bibimbap = imageHelper.getByteArrayFromDrawable(drawable);

            dbHelper.recipes_Insert("Korea", "Bibimbap",
                    "1. rice \n 2. hubs and egg \n 3. minx", "Korean traditional food",
                    bibimbap, bibimbap, 0);

            int bibmbapId = dbHelper.recipes_GetIdByName("Bibimbap");
            ArrayList<String> bibmbapIngre = new ArrayList<>();
            bibmbapIngre.add("rice");
            bibmbapIngre.add("egg");
            bibmbapIngre.add("sesame oil");
            bibmbapIngre.add("gochujang");
            bibmbapIngre.add("carrot");

            for (int i = 0; i < bibmbapIngre.size(); i++) {
                dbHelper.ingredients_Insert(bibmbapId, bibmbapIngre.get(i));
            }

            //Set Bulgogi data
            drawable = getResources().getDrawable(R.drawable.bulgogi, getActivity().getTheme());
            byte[] bulgogi = imageHelper.getByteArrayFromDrawable(drawable);

            dbHelper.recipes_Insert("Korea", "Bulgogi",
                    "1. Thinly slice 1 pound of sirloin or tenderloin beef against the grain.\n" +
                            "2. Mix these ingredients to make a marinade:\n" +
                            "\t 2 tbs of soy sauce\n" +
                            "\t 3 tbs of water\n" +
                            "\t 1 tbs of brown sugar\n" +
                            "\t 1 tbs of honey\n" +
                            "\t 1 tbs of sesame oil\n" +
                            "\t 1 tbs of toasted sesame seeds\n" +
                            "\t 2 chopped green onions\n" +
                            "\t 4 cloves of minced garlic\n" +
                            "\t ½ ts of black pepper.\n" +
                            "3. Add the beef to the marinade and keep in the fridge at least 30 minutes. If your cut of beef is tough, you can marinate longer to soften it, or use a Korean pear in the marinade, like I do in this recipe.\n" +
                            "4. Cook it on a pan or a grill, and transfer to a plate or a cast iron plate to serve.\n" +
                            "5. Sprinkle chopped green onion and toasted sesame seeds over top.\n" +
                            "6. Wrap a piece of bulgogi in a lettuce left with a little bit of ssamjang, and put it in your mouth. You can dip carrot or cucumber strips into the ssamjang.", "Korean traditional food",
                    bulgogi, bulgogi, 4);

            int bulgogiId = dbHelper.recipes_GetIdByName("Bulgogi");
            ArrayList<String> bulgogiIngre = new ArrayList<>();
            bulgogiIngre.add("soy sauce");
            bulgogiIngre.add("brown sugar");
            bulgogiIngre.add("sesame oil");
            bulgogiIngre.add("gochujang");
            bulgogiIngre.add("green onion");
            bulgogiIngre.add("onion");

            for (int i = 0; i < bulgogiIngre.size(); i++) {
                dbHelper.ingredients_Insert(bulgogiId, bulgogiIngre.get(i));
            }

            //Set Bolognese data
            drawable = getResources().getDrawable(R.drawable.bolognese, getActivity().getTheme());
            byte[] bolognese = imageHelper.getByteArrayFromDrawable(drawable);

            dbHelper.recipes_Insert("Itay", "Bolognese",
                    "1. Put the onion and oil in a large pan and fry over a fairly high heat for 3-4 mins. Add the garlic and mince and fry until they both brown. Add the mushrooms and herbs, and cook for another couple of mins.\n" +
                            "2. Stir in the tomatoes, beef stock, tomato ketchup or purée, Worcestershire sauce and seasoning. Bring to the boil, then reduce the heat, cover and simmer, stirring occasionally, for 30 mins.\n" +
                            "3. Meanwhile, cook the spaghetti in a large pan of boiling, salted water, according to packet instructions. Drain well, run hot water through it, put it back in the pan and add a dash of olive oil, if you like, then stir in the meat sauce. Serve in hot bowls and hand round Parmesan cheese, for sprinkling on top.",
                    "Make our traditional spaghetti Bolognese recipe with homemade Bolognese sauce and tender chunks of beef, making this dish a family favourite.",
                    bolognese, bolognese, 6);

            int bologneseId = dbHelper.recipes_GetIdByName("Bolognese");
            ArrayList<String> bologneseIngre = new ArrayList<>();
            bologneseIngre.add("onion");
            bologneseIngre.add("olive oil");
            bologneseIngre.add("spaghetti");
            bologneseIngre.add("Parmesan");
            bologneseIngre.add("mushroom");
            bologneseIngre.add("oregano");
            bologneseIngre.add("tomatoes");
            bologneseIngre.add("beef stock");
            bologneseIngre.add("beef");

            for (int i = 0; i < bologneseIngre.size(); i++) {
                dbHelper.ingredients_Insert(bologneseId, bologneseIngre.get(i));
            }

            //Set Chicken Cacciatore data
            drawable = getResources().getDrawable(R.drawable.chickencacciatore, getActivity().getTheme());
            byte[] chickencacciatore = imageHelper.getByteArrayFromDrawable(drawable);

            dbHelper.recipes_Insert("Itay", "Chicken Cacciatore ",
                    "1. Combine the flour, salt and pepper in a plastic bag. Shake the chicken pieces in flour until coated. Heat the oil in a large skillet (one that has a cover/lid). Fry the chicken pieces until they are browned on both sides. Remove from skillet.\n" +
                            "2. Add the onion, garlic and bell pepper to the skillet and saute until the onion is slightly browned. Return the chicken to the skillet and add the tomatoes, oregano and wine. Cover and simmer for 30 minutes over medium low heat.\n" +
                            "3. Add the mushrooms and salt and pepper to taste. Simmer for 10 more minutes.",
                    "Many food names reflect various occupations or trades.",
                    chickencacciatore, chickencacciatore, 2);

            int chickencacciatoreId = dbHelper.recipes_GetIdByName("Chicken Cacciatore ");
            ArrayList<String> chickencacciatoreIngre = new ArrayList<>();
            chickencacciatoreIngre.add("flour");
            chickencacciatoreIngre.add("salt");
            chickencacciatoreIngre.add("black pepper");
            chickencacciatoreIngre.add("chicken");
            chickencacciatoreIngre.add("vegetable oil");
            chickencacciatoreIngre.add("onion");
            chickencacciatoreIngre.add("tomatoes");
            chickencacciatoreIngre.add("oregano");
            chickencacciatoreIngre.add("wine");

            for (int i = 0; i < chickencacciatoreIngre.size(); i++) {
                dbHelper.ingredients_Insert(chickencacciatoreId, chickencacciatoreIngre.get(i));
            }

            //Set abzhorka data
            drawable = getResources().getDrawable(R.drawable.abzhorka, getActivity().getTheme());
            byte[] abzhorka = imageHelper.getByteArrayFromDrawable(drawable);

            dbHelper.recipes_Insert("Russia", "Abzhorka",
                    "1. Put the onion and oil in a large pan and fry over a fairly high heat for 3-4 mins. Add the garlic and mince and fry until they both brown. Add the mushrooms and herbs, and cook for another couple of mins.\n" +
                            "2. Stir in the tomatoes, beef stock, tomato ketchup or purée, Worcestershire sauce and seasoning. Bring to the boil, then reduce the heat, cover and simmer, stirring occasionally, for 30 mins.\n" +
                            "3. Meanwhile, cook the spaghetti in a large pan of boiling, salted water, according to packet instructions. Drain well, run hot water through it, put it back in the pan and add a dash of olive oil, if you like, then stir in the meat sauce. Serve in hot bowls and hand round Parmesan cheese, for sprinkling on top.",
                    "Make our traditional spaghetti Bolognese recipe with homemade Bolognese sauce and tender chunks of beef, making this dish a family favourite.",
                    abzhorka, abzhorka, 3);

            int abzhorkaId = dbHelper.recipes_GetIdByName("Abzhorka");
            ArrayList<String> abzhorkaIngre = new ArrayList<>();
            abzhorkaIngre.add("carrot");
            abzhorkaIngre.add("pickle");
            abzhorkaIngre.add("onion");
            abzhorkaIngre.add("beef");

            for (int i = 0; i < abzhorkaIngre.size(); i++) {
                dbHelper.ingredients_Insert(abzhorkaId, abzhorkaIngre.get(i));
            }

            //Set beefstroganoff data
            drawable = getResources().getDrawable(R.drawable.beefstroganoff, getActivity().getTheme());
            byte[] beefstroganoff = imageHelper.getByteArrayFromDrawable(drawable);

            dbHelper.recipes_Insert("Russia", "Beef Stroganoff",
                    "Chop the meat long wise fibers (fibres) and beat the pieces a little. After that cut the pieces into stripes 2 cm long and 1/2 cm wide. Season and roll them in flour. Fry chopped onion in the pan and when it is gold brown, put the stripes there. Fry on hot heat until the meat is light brown. Make a sauce: fry 1 tb flour pounded with butter for few minutes, add sour cream, ketchup, salt. Pour the sauce over meat and stew on a low heat during 15-20 minutes. Don't let sauce to boil, overwise the meat will be hard. Beef Stroganoff is served with fried potatoes.\n",
                    "Beef stroganoff is a dish consisting of strips of lean beef sauteed and served in a sour-cream sauce with onions and mushrooms. Legend has it that when he was stationed in deepest Siberia, his chef discovered that the beef was frozen so solid that it could only be coped with by cutting it into very thin strips.",
                    beefstroganoff, beefstroganoff, 8);

            int beefstroganoffId = dbHelper.recipes_GetIdByName("Beef Stroganoff");
            ArrayList<String> beefstroganoffIngre = new ArrayList<>();
            beefstroganoffIngre.add("beef");
            beefstroganoffIngre.add("flour");
            beefstroganoffIngre.add("ketchup");
            beefstroganoffIngre.add("sour cream");
            beefstroganoffIngre.add("broth");
            beefstroganoffIngre.add("onion");

            for (int i = 0; i < beefstroganoffIngre.size(); i++) {
                dbHelper.ingredients_Insert(beefstroganoffId, beefstroganoffIngre.get(i));
            }
        }
        return view;
    }
}
