/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.inventario.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//EstadoDetalleMovimientoInventarioConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class EstadoDetalleMovimientoInventarioDataAccess extends  EstadoDetalleMovimientoInventarioDataAccessAdditional{ //EstadoDetalleMovimientoInventarioDataAccessAdditional,DataAccessHelper<EstadoDetalleMovimientoInventario>
	//static Logger logger = Logger.getLogger(EstadoDetalleMovimientoInventarioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_detalle_movimiento_inventario";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadodetallemovimientoinventario from "+EstadoDetalleMovimientoInventarioConstantesFunciones.SPERSISTENCENAME+" estadodetallemovimientoinventario";
	public static String QUERYSELECTNATIVE="select "+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id,"+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".codigo,"+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".nombre from "+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id,"+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".codigo from "+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADODETALLEMOVIMIENTOINVENTARIO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADODETALLEMOVIMIENTOINVENTARIO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADODETALLEMOVIMIENTOINVENTARIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADODETALLEMOVIMIENTOINVENTARIO_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected EstadoDetalleMovimientoInventarioDataAccessAdditional estadodetallemovimientoinventarioDataAccessAdditional=null;
	
	public EstadoDetalleMovimientoInventarioDataAccessAdditional getEstadoDetalleMovimientoInventarioDataAccessAdditional() {
		return this.estadodetallemovimientoinventarioDataAccessAdditional;
	}
	
	public void setEstadoDetalleMovimientoInventarioDataAccessAdditional(EstadoDetalleMovimientoInventarioDataAccessAdditional estadodetallemovimientoinventarioDataAccessAdditional) {
		try {
			this.estadodetallemovimientoinventarioDataAccessAdditional=estadodetallemovimientoinventarioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EstadoDetalleMovimientoInventarioDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		EstadoDetalleMovimientoInventarioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoDetalleMovimientoInventarioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoDetalleMovimientoInventarioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}

	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setEstadoDetalleMovimientoInventarioOriginal(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario)throws Exception  {
		estadodetallemovimientoinventario.setEstadoDetalleMovimientoInventarioOriginal((EstadoDetalleMovimientoInventario)estadodetallemovimientoinventario.clone());		
	}
	
	public void setEstadoDetalleMovimientoInventariosOriginal(List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarios)throws Exception  {
		
		for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario:estadodetallemovimientoinventarios){
			estadodetallemovimientoinventario.setEstadoDetalleMovimientoInventarioOriginal((EstadoDetalleMovimientoInventario)estadodetallemovimientoinventario.clone());
		}
	}
	
	public static void setEstadoDetalleMovimientoInventarioOriginalStatic(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario)throws Exception  {
		estadodetallemovimientoinventario.setEstadoDetalleMovimientoInventarioOriginal((EstadoDetalleMovimientoInventario)estadodetallemovimientoinventario.clone());		
	}
	
	public static void setEstadoDetalleMovimientoInventariosOriginalStatic(List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarios)throws Exception  {
		
		for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario:estadodetallemovimientoinventarios){
			estadodetallemovimientoinventario.setEstadoDetalleMovimientoInventarioOriginal((EstadoDetalleMovimientoInventario)estadodetallemovimientoinventario.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  EstadoDetalleMovimientoInventario getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  EstadoDetalleMovimientoInventario getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.EstadoDetalleMovimientoInventario.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoDetalleMovimientoInventarioOriginal(new EstadoDetalleMovimientoInventario());
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoDetalleMovimientoInventario("",entity,resultSet); 
				
				//entity.setEstadoDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getEstadoDetalleMovimientoInventarioOriginal(),resultSet,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleMovimientoInventarioOriginal(this.getEntityEstadoDetalleMovimientoInventario("",entity.getEstadoDetalleMovimientoInventarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoDetalleMovimientoInventario(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoDetalleMovimientoInventario getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  EstadoDetalleMovimientoInventario getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleMovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.EstadoDetalleMovimientoInventario.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoDetalleMovimientoInventarioOriginal(new EstadoDetalleMovimientoInventario());
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoDetalleMovimientoInventario("",entity,resultSet);    
				
				//entity.setEstadoDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getEstadoDetalleMovimientoInventarioOriginal(),resultSet,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleMovimientoInventarioOriginal(this.getEntityEstadoDetalleMovimientoInventario("",entity.getEstadoDetalleMovimientoInventarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoDetalleMovimientoInventario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoDetalleMovimientoInventario
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleMovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.EstadoDetalleMovimientoInventario.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalseEstadoDetalleMovimientoInventario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoDetalleMovimientoInventario> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoDetalleMovimientoInventario> entities = new  ArrayList<EstadoDetalleMovimientoInventario>();
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<EstadoDetalleMovimientoInventario> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoDetalleMovimientoInventario> entities = new  ArrayList<EstadoDetalleMovimientoInventario>();
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleMovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleMovimientoInventario();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleMovimientoInventario("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleMovimientoInventarioOriginal( new EstadoDetalleMovimientoInventario());
      	    	//entity.setEstadoDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getEstadoDetalleMovimientoInventarioOriginal(),resultSet,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleMovimientoInventarioOriginal(this.getEntityEstadoDetalleMovimientoInventario("",entity.getEstadoDetalleMovimientoInventarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleMovimientoInventarios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoDetalleMovimientoInventario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoDetalleMovimientoInventario> entities = new  ArrayList<EstadoDetalleMovimientoInventario>();
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<EstadoDetalleMovimientoInventario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoDetalleMovimientoInventario> entities = new  ArrayList<EstadoDetalleMovimientoInventario>();
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleMovimientoInventario();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoDetalleMovimientoInventario();
					//entity.setMapEstadoDetalleMovimientoInventario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoDetalleMovimientoInventarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoDetalleMovimientoInventario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
					entity=EstadoDetalleMovimientoInventarioDataAccess.getEntityEstadoDetalleMovimientoInventario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoDetalleMovimientoInventarioOriginal( new EstadoDetalleMovimientoInventario());
					////entity.setEstadoDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getEstadoDetalleMovimientoInventarioOriginal(),resultSet,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoDetalleMovimientoInventarioOriginal(this.getEntityEstadoDetalleMovimientoInventario("",entity.getEstadoDetalleMovimientoInventarioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleMovimientoInventarios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoDetalleMovimientoInventario getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  EstadoDetalleMovimientoInventario getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleMovimientoInventario();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoDetalleMovimientoInventario();
					//entity.setMapEstadoDetalleMovimientoInventario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoDetalleMovimientoInventarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoDetalleMovimientoInventario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
					entity=EstadoDetalleMovimientoInventarioDataAccess.getEntityEstadoDetalleMovimientoInventario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoDetalleMovimientoInventarioOriginal( new EstadoDetalleMovimientoInventario());
					////entity.setEstadoDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getEstadoDetalleMovimientoInventarioOriginal(),resultSet,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoDetalleMovimientoInventarioOriginal(this.getEntityEstadoDetalleMovimientoInventario("",entity.getEstadoDetalleMovimientoInventarioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleMovimientoInventario(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoDetalleMovimientoInventario getEntityEstadoDetalleMovimientoInventario(String strPrefijo,EstadoDetalleMovimientoInventario entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoDetalleMovimientoInventario.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoDetalleMovimientoInventario.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoDetalleMovimientoInventarioDataAccess.setFieldReflectionEstadoDetalleMovimientoInventario(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoDetalleMovimientoInventario=EstadoDetalleMovimientoInventarioConstantesFunciones.getTodosTiposColumnasEstadoDetalleMovimientoInventario();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoDetalleMovimientoInventario) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = EstadoDetalleMovimientoInventario.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoDetalleMovimientoInventario.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoDetalleMovimientoInventarioDataAccess.setFieldReflectionEstadoDetalleMovimientoInventario(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoDetalleMovimientoInventario(Field field,String strPrefijo,String sColumn,EstadoDetalleMovimientoInventario entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoDetalleMovimientoInventarioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoDetalleMovimientoInventarioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoDetalleMovimientoInventarioConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoDetalleMovimientoInventarioConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoDetalleMovimientoInventario>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoDetalleMovimientoInventario> entities = new  ArrayList<EstadoDetalleMovimientoInventario>();
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleMovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new EstadoDetalleMovimientoInventario();
					entity=super.getEntity("",entity,resultSet,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoDetalleMovimientoInventario("",entity,resultSet);
					
					//entity.setEstadoDetalleMovimientoInventarioOriginal( new EstadoDetalleMovimientoInventario());
					//entity.setEstadoDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getEstadoDetalleMovimientoInventarioOriginal(),resultSet,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoDetalleMovimientoInventarioOriginal(this.getEntityEstadoDetalleMovimientoInventario("",entity.getEstadoDetalleMovimientoInventarioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoDetalleMovimientoInventarios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoDetalleMovimientoInventario>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoDetalleMovimientoInventario> entities = new  ArrayList<EstadoDetalleMovimientoInventario>();
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleMovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<EstadoDetalleMovimientoInventario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleMovimientoInventario> entities = new  ArrayList<EstadoDetalleMovimientoInventario>();
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<EstadoDetalleMovimientoInventario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleMovimientoInventario> entities = new  ArrayList<EstadoDetalleMovimientoInventario>();
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleMovimientoInventario();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleMovimientoInventario("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleMovimientoInventarioOriginal( new EstadoDetalleMovimientoInventario());
      	    	//entity.setEstadoDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getEstadoDetalleMovimientoInventarioOriginal(),resultSet,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleMovimientoInventarioOriginal(this.getEntityEstadoDetalleMovimientoInventario("",entity.getEstadoDetalleMovimientoInventarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoDetalleMovimientoInventarios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoDetalleMovimientoInventario> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleMovimientoInventario> entities = new  ArrayList<EstadoDetalleMovimientoInventario>();
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<EstadoDetalleMovimientoInventario> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleMovimientoInventario> entities = new  ArrayList<EstadoDetalleMovimientoInventario>();
		EstadoDetalleMovimientoInventario entity = new EstadoDetalleMovimientoInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleMovimientoInventario();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleMovimientoInventario("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleMovimientoInventarioOriginal( new EstadoDetalleMovimientoInventario());
      	    	//entity.setEstadoDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getEstadoDetalleMovimientoInventarioOriginal(),resultSet,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleMovimientoInventarioOriginal(this.getEntityEstadoDetalleMovimientoInventario("",entity.getEstadoDetalleMovimientoInventarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleMovimientoInventarios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EstadoDetalleMovimientoInventario getEntityEstadoDetalleMovimientoInventario(String strPrefijo,EstadoDetalleMovimientoInventario entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoDetalleMovimientoInventarioConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoDetalleMovimientoInventarioConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoDetalleMovimientoInventarioConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoDetalleMovimientoInventario(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoDetalleMovimientoInventario entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoDetalleMovimientoInventarioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoDetalleMovimientoInventarioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoDetalleMovimientoInventarioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoDetalleMovimientoInventarioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoDetalleMovimientoInventarioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoDetalleMovimientoInventarioDataAccess.TABLENAME,EstadoDetalleMovimientoInventarioDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoDetalleMovimientoInventarioDataAccess.setEstadoDetalleMovimientoInventarioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<DetalleMovimientoInventario> getDetalleMovimientoInventarios(Connexion connexion,EstadoDetalleMovimientoInventario estadodetallemovimientoinventario)throws SQLException,Exception {

		List<DetalleMovimientoInventario> detallemovimientoinventarios= new ArrayList<DetalleMovimientoInventario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+".estado_detalle_movimiento_inventario ON "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+".detalle_movimiento_inventario.id_estado_detalle_movimiento_inventario="+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+".estado_detalle_movimiento_inventario.id WHERE "+EstadoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+".estado_detalle_movimiento_inventario.id="+String.valueOf(estadodetallemovimientoinventario.getId());
			} else {
				sQuery=" INNER JOIN detallemovimientoinventario.EstadoDetalleMovimientoInventario WHERE detallemovimientoinventario.EstadoDetalleMovimientoInventario.id="+String.valueOf(estadodetallemovimientoinventario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleMovimientoInventarioDataAccess detallemovimientoinventarioDataAccess=new DetalleMovimientoInventarioDataAccess();

			detallemovimientoinventarioDataAccess.setConnexionType(this.connexionType);
			detallemovimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallemovimientoinventarios;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoDetalleMovimientoInventario estadodetallemovimientoinventario) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadodetallemovimientoinventario.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadodetallemovimientoinventario.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadodetallemovimientoinventario.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadodetallemovimientoinventario.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadodetallemovimientoinventario.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadodetallemovimientoinventario.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadodetallemovimientoinventario.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadodetallemovimientoinventario.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalseEstadoDetalleMovimientoInventario(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario)throws Exception  {		
		estadodetallemovimientoinventario.setIsNew(false);
		estadodetallemovimientoinventario.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoDetalleMovimientoInventarios(List<EstadoDetalleMovimientoInventario> estadodetallemovimientoinventarios)throws Exception  {				
		for(EstadoDetalleMovimientoInventario estadodetallemovimientoinventario:estadodetallemovimientoinventarios) {
			estadodetallemovimientoinventario.setIsNew(false);
			estadodetallemovimientoinventario.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoDetalleMovimientoInventario(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
