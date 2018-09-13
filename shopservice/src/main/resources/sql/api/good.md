queryGoodsByGoodType
===
   select * from  shop_goods where is_on_sale = 0 and goods_type = #type# order by id desc