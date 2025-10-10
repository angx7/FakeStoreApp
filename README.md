# 🛍️ FakeStoreApp

Aplicación Android escrita en **Kotlin + Jetpack Compose** que consume la **FakeStore API** para mostrar un catálogo de productos, categorías y una pantalla de detalle moderna y reutilizable.

---

## ✨ Características

- **HomeScreen** completa con:
    - Barra de búsqueda, encabezados y banner promocional (`HotSaleBanner`)
    - **Categorías** con íconos personalizados (`CategoryRow` / `CategoryItem` + `Icons.kt`)
    - **Grid** de productos (`GridProductCard`)
    - **Placeholder** para estados vacíos (`EmptyBannerPlaceholder`)

- **ProductDetailScreen** con:
    - Imagen, título, **precio y rating** (`PriceAndRating` + `RatingStars`)
    - Descripción con scroll (`DescriptionBox`)
    - Acciones principales (`ActionButtons`): *Order Now* y *Add To Wishlist*
    - Carga dinámica desde **FakeStore API** (Retrofit + Gson)

- **Tema y diseño** centralizados: colores, tipografía e íconos en `ui/theme`.

---

## 🧱 Estructura del proyecto (esencial)

```text
.
├── README.md
├── app
│   ├── build.gradle.kts
│   └── src
│       └── main
│           ├── AndroidManifest.xml
│           ├── java
│           │   └── com
│           │       └── example
│           │           └── fakestoreapp
│           │               ├── MainActivity.kt
│           │               ├── models
│           │               │   ├── Product.kt
│           │               │   └── Rating.kt
│           │               ├── services
│           │               │   └── ProductService.kt
│           │               ├── components
│           │               │   ├── ActionButtons.kt
│           │               │   ├── CategoryItem.kt
│           │               │   ├── CategoryRow.kt
│           │               │   ├── DescriptionBox.kt
│           │               │   ├── EmptyBannerPlaceholder.kt
│           │               │   ├── GridProductCard.kt
│           │               │   ├── HotSaleBanner.kt
│           │               │   ├── PriceAndRating.kt
│           │               │   ├── RatingStars.kt
│           │               │   ├── SectionHeader.kt
│           │               │   └── TopBarStub.kt
│           │               ├── screens
│           │               │   ├── HomeScreen.kt
│           │               │   └── ProductDetailScreen.kt
│           │               └── ui
│           │                   └── theme
│           │                       ├── Color.kt
│           │                       ├── Icons.kt
│           │                       ├── Routes.kt
│           │                       ├── Theme.kt
│           │                       └── Type.kt
│           └── res
│               ├── drawable
│               │   ├── ic_launcher_background.xml
│               │   └── ic_launcher_foreground.xml
│               ├── font
│               │   ├── merriweathersans_bold.ttf
│               │   ├── merriweathersans_bolditalic.ttf
│               │   ├── merriweathersans_extrabold.ttf
│               │   ├── merriweathersans_italic.ttf
│               │   ├── merriweathersans_light.ttf
│               │   ├── merriweathersans_medium.ttf
│               │   └── merriweathersans_regular.ttf
│               ├── mipmap-*
│               │   └── (ic_launcher.*)
│               ├── values
│               │   ├── colors.xml
│               │   ├── strings.xml
│               │   └── themes.xml
│               └── xml
│                   ├── backup_rules.xml
│                   └── data_extraction_rules.xml
├── build.gradle.kts
├── gradle
│   ├── libs.versions.toml
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradle.properties
├── settings.gradle.kts
└── gradlew*
```

---

## 🛠️ Stack técnico

- **Kotlin**, **Jetpack Compose**, **Material 3**
- **Retrofit** + **GsonConverterFactory** (REST)
- **Coil 3** (`AsyncImage`) para imágenes remotas
- Theming con **`Color.kt`**, **`Type.kt`** y **`Theme.kt`**
- Íconos personalizados en **`Icons.kt`**

---

## ⚙️ Configuración y ejecución

1) Clona el repo y abre en **Android Studio**:
```bash
git clone https://github.com/<tu-usuario>/FakeStoreApp.git
cd FakeStoreApp
```

2) Sincroniza Gradle y compila.

3) Ejecuta en emulador o dispositivo físico.

> **Requisitos:** Android Studio Giraffe o superior, JDK 17, Gradle Wrapper incluido.

---

## 🌐 API utilizada

- **Base URL:** `https://fakestoreapi.com/`
- **Endpoints usados:**
    - `GET /products` — listado
    - `GET /products/{id}` — detalle

> La configuración del cliente está en `services/ProductService.kt`.

---

## 🧩 Componentes clave

- **Visuales generales:** `SectionHeader`, `TopBarStub`, `EmptyBannerPlaceholder`
- **Catálogo:** `CategoryRow`, `CategoryItem`, `GridProductCard`, `HotSaleBanner`
- **Detalle:** `PriceAndRating`, `RatingStars`, `DescriptionBox`, `ActionButtons`

---

## 🧹 Convenciones de commits

Se usa estilo tipo **Conventional Commits**:
- `feat:` nuevas funcionalidades
- `fix:` correcciones
- `refactor:` cambios internos sin modificar comportamiento
- `style:` cambios visuales/estéticos (colores, tipografía)
- `chore:` mantenimiento (imports, formateo, tooling)
- `test:` pruebas

Ejemplos recientes:
- `feat(ui): implementación final de la HomeScreen`
- `feat(screen): ProductDetailScreen con consumo de API`
- `refactor(ui): limpieza de ProductDetailScreen con componentes reutilizables`
- `style(theme): reemplazo de colors hex por variables de Color.kt`

---

## 🗺️ Roadmap (ideas)

- Modo oscuro (tints e íconos adaptativos)
- Estado de carga/errores más rico (skeletons/toasts)
- Búsqueda real con filtrado por categoría
- Carrito y wishlist persistentes
- Navegación con animaciones

---

## 👤 Autor

**Taco** — Software Developer  
Proyecto académico/demostrativo con Jetpack Compose y APIs REST.

---

## 📄 Licencia

Este proyecto se distribuye bajo la licencia **MIT** (opcional). Añade `LICENSE` si deseas especificarla.
