# Claude Contributions

A quick note on where Claude has helped out on this project:

- **Compose Previews** — Generated `@Preview` functions for UI components to speed up visual iteration without needing a full app run.
- **Reusable Compose Components** — Helped build out reusable, composable UI pieces that can be shared across screens.
- **DTO Models** — Generated data transfer object (DTO) models for API response parsing.

## ⚠️ Note on Testing Locally

The **Android emulator needs its location set up beforehand** (via Extended Controls → Location, or by setting a mock GPS coordinate) before testing any location-dependent features (e.g. `FusedLocationProviderClient` flows). Without this, location calls may return null or fail silently on the emulator.
