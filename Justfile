set dotenv-load
set shell := ["bash", "-cu"]

sql_migrations_location := "filesystem:sql/migrations"

default:
    @just --list --list-submodules

# Apply migrations to started db
[group('dev')]
migrate:
    test -n "${DB_LOCAL_URL:-}" || { echo "DB_LOCAL_URL is missing. Run just init and fill in .env"; exit 1; }
    test -n "${DB_USER:-}" || { echo "DB_USER is missing. Run just init and fill in .env"; exit 1; }
    test -n "${DB_PASSWORD:-}" || { echo "DB_PASSWORD is missing. Run just init and fill in .env"; exit 1; }

    mvn flyway:clean \
        -Dflyway.cleanDisabled=false \
        -Dflyway.locations={{sql_migrations_location}} \
        -Dflyway.url="$DB_LOCAL_URL" \
        -Dflyway.user="$DB_USER" \
        -Dflyway.password="$DB_PASSWORD"

    mvn flyway:migrate \
        -Dflyway.locations={{sql_migrations_location}} \
        -Dflyway.url="$DB_LOCAL_URL" \
        -Dflyway.user="$DB_USER" \
        -Dflyway.password="$DB_PASSWORD"

# Initialize project
init:
    cp -n .env.example .env
    @echo "Project initialized"

# Start db and apply migrations
[group('dev')]
up:
    docker compose up -d --wait db
    just migrate
    @echo "Migrations completed"


# Start backend
[group('dev')]
dev:
    docker compose up -d backend

# Stop all services
down:
    docker compose down

prod:
    docker compose up -d
