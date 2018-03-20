package diellza.touristguide.Helpers;

import android.annotation.SuppressLint;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;

import java.lang.reflect.Field;

/**
 * Created by SINKOPA on 3/14/2018.
 */

public class DisableShiftingBNV {

@SuppressLint("RestrictedApi")
public  static void disableShiftingMode(BottomNavigationView view)
{
    BottomNavigationMenuView menuView=(BottomNavigationMenuView) view.getChildAt(0);

    try {
        Field shiftMode= menuView.getClass().getDeclaredField("mShiftingMode");
        shiftMode.setAccessible(true);
        //menuView-objektit te cilit do i nderrohet fusha(Field) dhe vlera e re per fushesh(mShiftingMode)
        shiftMode.setBoolean(menuView,false);
        shiftMode.setAccessible(false);
        for(int i=0;i<menuView.getChildCount();i++)
        {
            BottomNavigationItemView item=(BottomNavigationItemView) menuView.getChildAt(i);
            //noinspection RestrictedApi
            item.setShiftingMode(false);
            item.setChecked(item.getItemData().isChecked());
        }

    } catch (NoSuchFieldException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }
}
}











