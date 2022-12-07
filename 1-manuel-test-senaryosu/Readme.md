## Sepet sayfasındaki işlemler için işlevsel test seneryoları geliştiriniz:
https://www.e-bebek.com/cart
sayfasında aksi belirtilmedikçe önceden eklenen bir üründen bir adet bulunduğunu farz edilerek aşağıdaki testler yapılacaktır

1. Ürün sayısını arttır
    > 1 adet olan ürüne "+" butonuna bastıkça sepetteki sayısı artmalı
2. Ürün sayısı artınca sadece ürün fiyatı kadar artış olmalı toplam fiyatta
    > 1 adet olan ürüne "+" butonuna bastıkça toplam fiyat sadece arttırılan sayı çarpı ürünün fiyatı kadar artmalı
3. Ürün sayısını azalt
    > 1 adet olan ürüne "-" butonuna basınca  "Sepetinizde ürün bulunmamaktadır." yazısı gelmeli.
4. 10 adet olan ürünü 2 adete indir 8 kere basarak
    > Önceden 10 kere eklenen bir ürünü "-" butonuna 8 kere basınca 2 adet olmalı.
5. Ürün sayısını arttırıp sayfada geri gidip sonra tekrar sepet sayfasına git
    > 1 adet olan ürüne "+" butonuna basıp sayfada geri gidilip tekrar sepete girince ürün 2 adet olmalı
6. Başka bir sayfa daha açıp ürün ekle
    > 1 adet olan ürün sepetteyken yeni bir sayfa açılıp ordan da ürün eklenir ama ilk açılan sayfada hala bir ürün görülmeli
7. Başka bir sayfa daha açıp ürün sil
   > 1 adet olan ürün sepetteyken yeni bir sayfa açılıp ordan  ürün silinir ama ilk açılan sayfada hala bir ürün görülmeli
