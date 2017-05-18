package asteroids.model.programs.expressions;

import java.util.Iterator;

import asteroids.model.Entity;
import asteroids.model.Ship;
import asteroids.model.World;
import asteroids.model.programs.ProgramExecutionTimeException;
import asteroids.model.programs.Scope;
import asteroids.model.programs.expressions.types.EntityLiteral;
import asteroids.part3.programs.SourceLocation;

public class AnyExpression extends Expression<EntityLiteral>{
	
	public AnyExpression(SourceLocation location) throws IllegalArgumentException{
		super(location);
	}

	@Override
	public EntityLiteral evaluate(Scope scope, World world, Ship executor) throws ExpressionEvaluationException, ProgramExecutionTimeException {
		Iterator<Entity> iterator = world.getAllEntities().iterator();
		Entity result = iterator.hasNext() ? iterator.next() : null;
		result = (result == executor && iterator.hasNext()) ? iterator.next() : result;
		return new EntityLiteral(result);
	}

}
