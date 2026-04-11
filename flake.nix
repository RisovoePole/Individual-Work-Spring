{
  description = "Dev environment: Java 21 + Maven + Docker + Just";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = import nixpkgs {
          inherit system;
          config.allowUnfree = true;
        };
      in {
        devShells.default = pkgs.mkShell {
          packages = with pkgs; [
            jdk21
            maven
            just
            docker
            docker-compose
          ];

          shellHook = ''
            export JAVA_HOME=${pkgs.jdk21}
            echo "JAVA_HOME set to $JAVA_HOME"
          '';
        };
      });
}