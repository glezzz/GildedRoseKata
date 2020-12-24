package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateQualityForItem(items[i]);
        }
    }

    public void updateQualityForItem(Item item) {
        if (item.name.equals("Aged Brie")) {
            updateQualityForAgedBrie(item);

        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateQualityForBackstage(item);

        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            updateQualityForSulfuras(item);

        } else if(item.name.equals("Conjured Mana Cake")) {
            updateQualityForConjured(item);

        } else {
            updateQualityForNormalItem(item);
        }

}

    public void updateQualityForAgedBrie(Item item) {
        item.sellIn--;
        //"Aged Brie" actually increases in Quality the older it gets
        //quality of an item is never more than 50
        if (item.quality < 50) {
            item.quality++;

        }
    }

    public void updateQualityForBackstage(Item item) {
        item.sellIn--;
        //Backstage passes", like aged brie, increases in Quality as its SellIn value approaches
        //Quality drops to 0 after the concert
        if (item.sellIn < 0) {
            item.quality = 0;

        } else {
            //Quality increases by 3 when there are 5 days or less
            if (item.sellIn <= 5) {
                item.quality += 2;

                //Quality increases by 2 when there are 10 days or less
            } else if (item.sellIn <= 10) {
                item.quality += 3;
            }
        }
    }

    public void updateQualityForSulfuras(Item item) {
        item.sellIn--;
        //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
        //"Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
        item.quality = 80;
    }

    public void updateQualityForNormalItem(Item item) {
        item.sellIn--;

        //quality decreases each day
        if (item.quality > 0) {
            item.quality--;
        }

        //Once the sell by date has passed, Quality degrades twice as fast
        if (item.sellIn < 0) {
            item.quality -= 2;
        }

        //The Quality of an item is never negative
        if (item.quality < 0) {
            item.quality = 0;
        }

        //The Quality of an item is never more than 50
        if (item.quality > 50) {
            item.quality = 50;
        }
    }

    public void updateQualityForConjured(Item item) {
        item.sellIn--;

        //quality decreases each day
        if (item.quality > 0) {
            //"Conjured" items degrade in Quality twice as fast as normal items
            item.quality -= 2;
        }

        //Once the sell by date has passed, Quality degrades twice as fast
        if (item.sellIn < 0) {
            //"Conjured" items degrade in Quality twice as fast as normal items
            item.quality -= 4;
        }

        //The Quality of an item is never negative
        if (item.quality < 0) {
            item.quality = 0;
        }

        //The Quality of an item is never more than 50
        if (item.quality > 50) {
            item.quality = 50;
        }
    }
}
