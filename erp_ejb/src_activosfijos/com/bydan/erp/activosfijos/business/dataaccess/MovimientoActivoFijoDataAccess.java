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
package com.bydan.erp.activosfijos.business.dataaccess;

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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.util.*;//MovimientoActivoFijoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class MovimientoActivoFijoDataAccess extends  MovimientoActivoFijoDataAccessAdditional{ //MovimientoActivoFijoDataAccessAdditional,DataAccessHelper<MovimientoActivoFijo>
	//static Logger logger = Logger.getLogger(MovimientoActivoFijoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="movimiento_activo_fijo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_usuario,secuencial,id_empresa_origen,id_sucursal_origen,id_detalle_activo_fijo_origen,id_empresa_destino,id_sucursal_destino,id_detalle_activo_fijo_destino,fecha,numero_documento,costo,depreciacion,costo_origen,depreciacion_origen,razon,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,secuencial=?,id_empresa_origen=?,id_sucursal_origen=?,id_detalle_activo_fijo_origen=?,id_empresa_destino=?,id_sucursal_destino=?,id_detalle_activo_fijo_destino=?,fecha=?,numero_documento=?,costo=?,depreciacion=?,costo_origen=?,depreciacion_origen=?,razon=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select movimientoactivofijo from "+MovimientoActivoFijoConstantesFunciones.SPERSISTENCENAME+" movimientoactivofijo";
	public static String QUERYSELECTNATIVE="select "+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_sucursal,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_usuario,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".secuencial,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_empresa_origen,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_sucursal_origen,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_detalle_activo_fijo_origen,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_empresa_destino,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_sucursal_destino,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_detalle_activo_fijo_destino,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".fecha,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".numero_documento,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".costo,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".depreciacion,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".costo_origen,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".depreciacion_origen,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".razon,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".descripcion from "+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME;//+" as "+MovimientoActivoFijoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".version_row from "+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME;//+" as "+MovimientoActivoFijoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,secuencial=?,id_empresa_origen=?,id_sucursal_origen=?,id_detalle_activo_fijo_origen=?,id_empresa_destino=?,id_sucursal_destino=?,id_detalle_activo_fijo_destino=?,fecha=?,numero_documento=?,costo=?,depreciacion=?,costo_origen=?,depreciacion_origen=?,razon=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_MOVIMIENTOACTIVOFIJO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_MOVIMIENTOACTIVOFIJO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_MOVIMIENTOACTIVOFIJO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_MOVIMIENTOACTIVOFIJO_SELECT(?,?)";
	
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
	
	
	protected MovimientoActivoFijoDataAccessAdditional movimientoactivofijoDataAccessAdditional=null;
	
	public MovimientoActivoFijoDataAccessAdditional getMovimientoActivoFijoDataAccessAdditional() {
		return this.movimientoactivofijoDataAccessAdditional;
	}
	
	public void setMovimientoActivoFijoDataAccessAdditional(MovimientoActivoFijoDataAccessAdditional movimientoactivofijoDataAccessAdditional) {
		try {
			this.movimientoactivofijoDataAccessAdditional=movimientoactivofijoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public MovimientoActivoFijoDataAccess() {
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
		MovimientoActivoFijoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		MovimientoActivoFijoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		MovimientoActivoFijoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setMovimientoActivoFijoOriginal(MovimientoActivoFijo movimientoactivofijo)throws Exception  {
		movimientoactivofijo.setMovimientoActivoFijoOriginal((MovimientoActivoFijo)movimientoactivofijo.clone());		
	}
	
	public void setMovimientoActivoFijosOriginal(List<MovimientoActivoFijo> movimientoactivofijos)throws Exception  {
		
		for(MovimientoActivoFijo movimientoactivofijo:movimientoactivofijos){
			movimientoactivofijo.setMovimientoActivoFijoOriginal((MovimientoActivoFijo)movimientoactivofijo.clone());
		}
	}
	
	public static void setMovimientoActivoFijoOriginalStatic(MovimientoActivoFijo movimientoactivofijo)throws Exception  {
		movimientoactivofijo.setMovimientoActivoFijoOriginal((MovimientoActivoFijo)movimientoactivofijo.clone());		
	}
	
	public static void setMovimientoActivoFijosOriginalStatic(List<MovimientoActivoFijo> movimientoactivofijos)throws Exception  {
		
		for(MovimientoActivoFijo movimientoactivofijo:movimientoactivofijos){
			movimientoactivofijo.setMovimientoActivoFijoOriginal((MovimientoActivoFijo)movimientoactivofijo.clone());
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
	
	public  MovimientoActivoFijo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		MovimientoActivoFijo entity = new MovimientoActivoFijo();		
		
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
	
	public  MovimientoActivoFijo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		MovimientoActivoFijo entity = new MovimientoActivoFijo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=MovimientoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MovimientoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.MovimientoActivoFijo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setMovimientoActivoFijoOriginal(new MovimientoActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,MovimientoActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityMovimientoActivoFijo("",entity,resultSet); 
				
				//entity.setMovimientoActivoFijoOriginal(super.getEntity("",entity.getMovimientoActivoFijoOriginal(),resultSet,MovimientoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMovimientoActivoFijoOriginal(this.getEntityMovimientoActivoFijo("",entity.getMovimientoActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseMovimientoActivoFijo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  MovimientoActivoFijo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		MovimientoActivoFijo entity = new MovimientoActivoFijo();
				
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
	
	public  MovimientoActivoFijo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		MovimientoActivoFijo entity = new MovimientoActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=MovimientoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MovimientoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MovimientoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.MovimientoActivoFijo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setMovimientoActivoFijoOriginal(new MovimientoActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,MovimientoActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityMovimientoActivoFijo("",entity,resultSet);    
				
				//entity.setMovimientoActivoFijoOriginal(super.getEntity("",entity.getMovimientoActivoFijoOriginal(),resultSet,MovimientoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMovimientoActivoFijoOriginal(this.getEntityMovimientoActivoFijo("",entity.getMovimientoActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseMovimientoActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //MovimientoActivoFijo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		MovimientoActivoFijo entity = new MovimientoActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MovimientoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MovimientoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MovimientoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.MovimientoActivoFijo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseMovimientoActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<MovimientoActivoFijo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<MovimientoActivoFijo> entities = new  ArrayList<MovimientoActivoFijo>();
		MovimientoActivoFijo entity = new MovimientoActivoFijo();		  
		
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
	
	public  List<MovimientoActivoFijo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<MovimientoActivoFijo> entities = new  ArrayList<MovimientoActivoFijo>();
		MovimientoActivoFijo entity = new MovimientoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=MovimientoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MovimientoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MovimientoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MovimientoActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,MovimientoActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMovimientoActivoFijo("",entity,resultSet);
      	    	
				//entity.setMovimientoActivoFijoOriginal( new MovimientoActivoFijo());
      	    	//entity.setMovimientoActivoFijoOriginal(super.getEntity("",entity.getMovimientoActivoFijoOriginal(),resultSet,MovimientoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMovimientoActivoFijoOriginal(this.getEntityMovimientoActivoFijo("",entity.getMovimientoActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMovimientoActivoFijos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMovimientoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<MovimientoActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<MovimientoActivoFijo> entities = new  ArrayList<MovimientoActivoFijo>();
		MovimientoActivoFijo entity = new MovimientoActivoFijo();		  
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
	
	public  List<MovimientoActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<MovimientoActivoFijo> entities = new  ArrayList<MovimientoActivoFijo>();
		MovimientoActivoFijo entity = new MovimientoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MovimientoActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapMovimientoActivoFijo();
					//entity.setMapMovimientoActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapMovimientoActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapMovimientoActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MovimientoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=MovimientoActivoFijoDataAccess.getEntityMovimientoActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setMovimientoActivoFijoOriginal( new MovimientoActivoFijo());
					////entity.setMovimientoActivoFijoOriginal(super.getEntity("",entity.getMovimientoActivoFijoOriginal(),resultSet,MovimientoActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setMovimientoActivoFijoOriginal(this.getEntityMovimientoActivoFijo("",entity.getMovimientoActivoFijoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMovimientoActivoFijos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMovimientoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public MovimientoActivoFijo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		MovimientoActivoFijo entity = new MovimientoActivoFijo();		  
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
	
	public  MovimientoActivoFijo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		MovimientoActivoFijo entity = new MovimientoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MovimientoActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapMovimientoActivoFijo();
					//entity.setMapMovimientoActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapMovimientoActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapMovimientoActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MovimientoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=MovimientoActivoFijoDataAccess.getEntityMovimientoActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setMovimientoActivoFijoOriginal( new MovimientoActivoFijo());
					////entity.setMovimientoActivoFijoOriginal(super.getEntity("",entity.getMovimientoActivoFijoOriginal(),resultSet,MovimientoActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setMovimientoActivoFijoOriginal(this.getEntityMovimientoActivoFijo("",entity.getMovimientoActivoFijoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseMovimientoActivoFijo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMovimientoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static MovimientoActivoFijo getEntityMovimientoActivoFijo(String strPrefijo,MovimientoActivoFijo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = MovimientoActivoFijo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = MovimientoActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					MovimientoActivoFijoDataAccess.setFieldReflectionMovimientoActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasMovimientoActivoFijo=MovimientoActivoFijoConstantesFunciones.getTodosTiposColumnasMovimientoActivoFijo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasMovimientoActivoFijo) {
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
							field = MovimientoActivoFijo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = MovimientoActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						MovimientoActivoFijoDataAccess.setFieldReflectionMovimientoActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionMovimientoActivoFijo(Field field,String strPrefijo,String sColumn,MovimientoActivoFijo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case MovimientoActivoFijoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.IDEMPRESAORIGEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.IDSUCURSALORIGEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJOORIGEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.IDEMPRESADESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.IDSUCURSALDESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJODESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.DEPRECIACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.COSTOORIGEN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.DEPRECIACIONORIGEN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.RAZON:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientoActivoFijoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<MovimientoActivoFijo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<MovimientoActivoFijo> entities = new  ArrayList<MovimientoActivoFijo>();
		MovimientoActivoFijo entity = new MovimientoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MovimientoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MovimientoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MovimientoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new MovimientoActivoFijo();
					entity=super.getEntity("",entity,resultSet,MovimientoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityMovimientoActivoFijo("",entity,resultSet);
					
					//entity.setMovimientoActivoFijoOriginal( new MovimientoActivoFijo());
					//entity.setMovimientoActivoFijoOriginal(super.getEntity("",entity.getMovimientoActivoFijoOriginal(),resultSet,MovimientoActivoFijoDataAccess.ISWITHSCHEMA));         		
					//entity.setMovimientoActivoFijoOriginal(this.getEntityMovimientoActivoFijo("",entity.getMovimientoActivoFijoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseMovimientoActivoFijos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMovimientoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<MovimientoActivoFijo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<MovimientoActivoFijo> entities = new  ArrayList<MovimientoActivoFijo>();
		MovimientoActivoFijo entity = new MovimientoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MovimientoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MovimientoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MovimientoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<MovimientoActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MovimientoActivoFijo> entities = new  ArrayList<MovimientoActivoFijo>();
		MovimientoActivoFijo entity = new MovimientoActivoFijo();		  
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
	
	public  List<MovimientoActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MovimientoActivoFijo> entities = new  ArrayList<MovimientoActivoFijo>();
		MovimientoActivoFijo entity = new MovimientoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MovimientoActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,MovimientoActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMovimientoActivoFijo("",entity,resultSet);
      	    	
				//entity.setMovimientoActivoFijoOriginal( new MovimientoActivoFijo());
      	    	//entity.setMovimientoActivoFijoOriginal(super.getEntity("",entity.getMovimientoActivoFijoOriginal(),resultSet,MovimientoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMovimientoActivoFijoOriginal(this.getEntityMovimientoActivoFijo("",entity.getMovimientoActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseMovimientoActivoFijos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMovimientoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<MovimientoActivoFijo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MovimientoActivoFijo> entities = new  ArrayList<MovimientoActivoFijo>();
		MovimientoActivoFijo entity = new MovimientoActivoFijo();		  
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
	
	public  List<MovimientoActivoFijo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MovimientoActivoFijo> entities = new  ArrayList<MovimientoActivoFijo>();
		MovimientoActivoFijo entity = new MovimientoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MovimientoActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,MovimientoActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMovimientoActivoFijo("",entity,resultSet);
      	    	
				//entity.setMovimientoActivoFijoOriginal( new MovimientoActivoFijo());
      	    	//entity.setMovimientoActivoFijoOriginal(super.getEntity("",entity.getMovimientoActivoFijoOriginal(),resultSet,MovimientoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMovimientoActivoFijoOriginal(this.getEntityMovimientoActivoFijo("",entity.getMovimientoActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMovimientoActivoFijos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public MovimientoActivoFijo getEntityMovimientoActivoFijo(String strPrefijo,MovimientoActivoFijo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+MovimientoActivoFijoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+MovimientoActivoFijoConstantesFunciones.IDSUCURSAL));
				entity.setid_usuario(resultSet.getLong(strPrefijo+MovimientoActivoFijoConstantesFunciones.IDUSUARIO));
				entity.setsecuencial(resultSet.getString(strPrefijo+MovimientoActivoFijoConstantesFunciones.SECUENCIAL));
				entity.setid_empresa_origen(resultSet.getLong(strPrefijo+MovimientoActivoFijoConstantesFunciones.IDEMPRESAORIGEN));
				entity.setid_sucursal_origen(resultSet.getLong(strPrefijo+MovimientoActivoFijoConstantesFunciones.IDSUCURSALORIGEN));
				entity.setid_detalle_activo_fijo_origen(resultSet.getLong(strPrefijo+MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJOORIGEN));
				entity.setid_empresa_destino(resultSet.getLong(strPrefijo+MovimientoActivoFijoConstantesFunciones.IDEMPRESADESTINO));
				entity.setid_sucursal_destino(resultSet.getLong(strPrefijo+MovimientoActivoFijoConstantesFunciones.IDSUCURSALDESTINO));
				entity.setid_detalle_activo_fijo_destino(resultSet.getLong(strPrefijo+MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJODESTINO));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+MovimientoActivoFijoConstantesFunciones.FECHA).getTime()));
				entity.setnumero_documento(resultSet.getString(strPrefijo+MovimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO));
				entity.setcosto(resultSet.getDouble(strPrefijo+MovimientoActivoFijoConstantesFunciones.COSTO));
				entity.setdepreciacion(resultSet.getDouble(strPrefijo+MovimientoActivoFijoConstantesFunciones.DEPRECIACION));
				entity.setcosto_origen(resultSet.getDouble(strPrefijo+MovimientoActivoFijoConstantesFunciones.COSTOORIGEN));
				entity.setdepreciacion_origen(resultSet.getDouble(strPrefijo+MovimientoActivoFijoConstantesFunciones.DEPRECIACIONORIGEN));
				entity.setrazon(resultSet.getString(strPrefijo+MovimientoActivoFijoConstantesFunciones.RAZON));
				entity.setdescripcion(resultSet.getString(strPrefijo+MovimientoActivoFijoConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowMovimientoActivoFijo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(MovimientoActivoFijo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=MovimientoActivoFijoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=MovimientoActivoFijoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=MovimientoActivoFijoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=MovimientoActivoFijoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(MovimientoActivoFijoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,MovimientoActivoFijoDataAccess.TABLENAME,MovimientoActivoFijoDataAccess.ISWITHSTOREPROCEDURES);
			
			MovimientoActivoFijoDataAccess.setMovimientoActivoFijoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,MovimientoActivoFijo relmovimientoactivofijo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relmovimientoactivofijo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,MovimientoActivoFijo relmovimientoactivofijo)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relmovimientoactivofijo.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Usuario getUsuario(Connexion connexion,MovimientoActivoFijo relmovimientoactivofijo)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relmovimientoactivofijo.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Empresa getEmpresaOrigen(Connexion connexion,MovimientoActivoFijo relmovimientoactivofijo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relmovimientoactivofijo.getid_empresa_origen());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursalOrigen(Connexion connexion,MovimientoActivoFijo relmovimientoactivofijo)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relmovimientoactivofijo.getid_sucursal_origen());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public DetalleActivoFijo getDetalleActivoFijoOrigen(Connexion connexion,MovimientoActivoFijo relmovimientoactivofijo)throws SQLException,Exception {

		DetalleActivoFijo detalleactivofijo= new DetalleActivoFijo();

		try {
			DetalleActivoFijoDataAccess detalleactivofijoDataAccess=new DetalleActivoFijoDataAccess();

			detalleactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detalleactivofijoDataAccess.setConnexionType(this.connexionType);
			detalleactivofijoDataAccess.setParameterDbType(this.parameterDbType);

			detalleactivofijo=detalleactivofijoDataAccess.getEntity(connexion,relmovimientoactivofijo.getid_detalle_activo_fijo_origen());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleactivofijo;

	}

	public Empresa getEmpresaDestino(Connexion connexion,MovimientoActivoFijo relmovimientoactivofijo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relmovimientoactivofijo.getid_empresa_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursalDestino(Connexion connexion,MovimientoActivoFijo relmovimientoactivofijo)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relmovimientoactivofijo.getid_sucursal_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public DetalleActivoFijo getDetalleActivoFijoDestino(Connexion connexion,MovimientoActivoFijo relmovimientoactivofijo)throws SQLException,Exception {

		DetalleActivoFijo detalleactivofijo= new DetalleActivoFijo();

		try {
			DetalleActivoFijoDataAccess detalleactivofijoDataAccess=new DetalleActivoFijoDataAccess();

			detalleactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detalleactivofijoDataAccess.setConnexionType(this.connexionType);
			detalleactivofijoDataAccess.setParameterDbType(this.parameterDbType);

			detalleactivofijo=detalleactivofijoDataAccess.getEntity(connexion,relmovimientoactivofijo.getid_detalle_activo_fijo_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleactivofijo;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,MovimientoActivoFijo movimientoactivofijo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!movimientoactivofijo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(movimientoactivofijo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(movimientoactivofijo.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(movimientoactivofijo.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial.setValue(movimientoactivofijo.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa_origen=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa_origen.setValue(movimientoactivofijo.getid_empresa_origen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa_origen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal_origen=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal_origen.setValue(movimientoactivofijo.getid_sucursal_origen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal_origen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_detalle_activo_fijo_origen=new ParameterValue<Long>();
					parameterMaintenanceValueid_detalle_activo_fijo_origen.setValue(movimientoactivofijo.getid_detalle_activo_fijo_origen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_detalle_activo_fijo_origen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa_destino.setValue(movimientoactivofijo.getid_empresa_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal_destino.setValue(movimientoactivofijo.getid_sucursal_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_detalle_activo_fijo_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_detalle_activo_fijo_destino.setValue(movimientoactivofijo.getid_detalle_activo_fijo_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_detalle_activo_fijo_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(movimientoactivofijo.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_documento=new ParameterValue<String>();
					parameterMaintenanceValuenumero_documento.setValue(movimientoactivofijo.getnumero_documento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_documento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(movimientoactivofijo.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedepreciacion=new ParameterValue<Double>();
					parameterMaintenanceValuedepreciacion.setValue(movimientoactivofijo.getdepreciacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedepreciacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_origen=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_origen.setValue(movimientoactivofijo.getcosto_origen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_origen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedepreciacion_origen=new ParameterValue<Double>();
					parameterMaintenanceValuedepreciacion_origen.setValue(movimientoactivofijo.getdepreciacion_origen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedepreciacion_origen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuerazon=new ParameterValue<String>();
					parameterMaintenanceValuerazon.setValue(movimientoactivofijo.getrazon());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuerazon);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(movimientoactivofijo.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!movimientoactivofijo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(movimientoactivofijo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(movimientoactivofijo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(movimientoactivofijo.getId());
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
	
	public void setIsNewIsChangedFalseMovimientoActivoFijo(MovimientoActivoFijo movimientoactivofijo)throws Exception  {		
		movimientoactivofijo.setIsNew(false);
		movimientoactivofijo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseMovimientoActivoFijos(List<MovimientoActivoFijo> movimientoactivofijos)throws Exception  {				
		for(MovimientoActivoFijo movimientoactivofijo:movimientoactivofijos) {
			movimientoactivofijo.setIsNew(false);
			movimientoactivofijo.setIsChanged(false);
		}
	}
	
	public void generarExportarMovimientoActivoFijo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
