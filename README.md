<img src="https://github.com/user-attachments/assets/2227660a-9a9b-498c-a281-aad01b974650" width="300" height="700" />
<img src="https://github.com/user-attachments/assets/fc2cc672-299c-4a7b-b474-76791f4960aa" width="300" height="700" />

Приложение для оформления микрозаймов.
Типичный сценарий: Пользователь регистрируется в приложении, после чего осуществляет вход. 
Видит информацию, поясняющую что ему делать далее. 
Поняв, как все работает, пользователь оформляет заявку на займ, указав необходимые данные. Если 
заявка оформлена успешно, пользователь видит экран с успехом и пояснение что ему делать дальше.
Зайдя в приложение повторно пользователь видит список оформленных займов и их статусы. Он 
может перейти в каждую конкретную заявку и посмотреть подробную информацию о ней.
********* 
- Неавторизованный пользователь имеет возможность:
    - Зарегистрироваться с уникальным именем и любым паролем
    - Авторизоваться
- Авторизованный пользователь имеет возможность:
  	- Посмотреть инструкцию как оформить займ
	- Оформить займ, ознакомившись с текущими условиями и указав необходимые данные
  	- Увидеть информацию о том, что займ успешно оформлен
  	- Видеть историю оформленных займов с актуальным статусом займа
  	- Обновлять историю оформленных займов
  	- При выборе займа в истории видеть детальную информацию о нём, а также инструкцию как его 
      получить в банке / оформить на карту
  	- Видеть необходимую информацию о произошедших ошибках
  	- Не вводить заново логин и пароль при повторном открытии приложения

********* 

- Стек использованных технологий:
	- Clean Architecture
	- MVVM
	- Вертикальная многомодульность (по feature)
	- Dagger2
	- Retrofit2
	- Facebook Shimmer
	- Coroutines
	- LiveData
	- Views
