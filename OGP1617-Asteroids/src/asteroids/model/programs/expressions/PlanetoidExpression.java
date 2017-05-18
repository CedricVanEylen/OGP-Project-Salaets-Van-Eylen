package asteroids.model.programs.expressions;

import asteroids.model.Planetoid;
import asteroids.model.Ship;
import asteroids.model.World;
import asteroids.model.programs.ProgramExecutionTimeException;
import asteroids.model.programs.Scope;
import asteroids.model.programs.expressions.types.EntityLiteral;
import asteroids.part3.programs.SourceLocation;

public class PlanetoidExpression extends Expression<EntityLiteral>{
	
	public PlanetoidExpression(SourceLocation location) throws IllegalArgumentException{
		super(location);
	}

	@Override
	public EntityLiteral evaluate(Scope scope, World world, Ship executor) throws ExpressionEvaluationException, ProgramExecutionTimeException {
		Planetoid closest = world.getPlanetoids().stream().reduce(
				(a, b) -> a.getDistanceBetween(executor) < b.getDistanceBetween(executor) ? a : b
																		).orElse(null);
		return new EntityLiteral(closest);
	}

}