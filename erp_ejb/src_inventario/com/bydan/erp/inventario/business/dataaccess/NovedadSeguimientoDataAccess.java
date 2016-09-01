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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//NovedadSeguimientoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class NovedadSeguimientoDataAccess extends  NovedadSeguimientoDataAccessAdditional{ //NovedadSeguimientoDataAccessAdditional,DataAccessHelper<NovedadSeguimiento>
	//static Logger logger = Logger.getLogger(NovedadSeguimientoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="novedad_seguimiento";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_detalle_movimiento_inventario,id_novedad_producto,numero_comprobante,fecha_novedad,fecha_seguimiento,descripcion,id_estado_novedad_seguimiento)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_detalle_movimiento_inventario=?,id_novedad_producto=?,numero_comprobante=?,fecha_novedad=?,fecha_seguimiento=?,descripcion=?,id_estado_novedad_seguimiento=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select novedadseguimiento from "+NovedadSeguimientoConstantesFunciones.SPERSISTENCENAME+" novedadseguimiento";
	public static String QUERYSELECTNATIVE="select "+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".id,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".version_row,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".id_empresa,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".id_sucursal,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".id_detalle_movimiento_inventario,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".id_novedad_producto,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".numero_comprobante,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".fecha_novedad,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".fecha_seguimiento,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".descripcion,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".id_estado_novedad_seguimiento from "+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME;//+" as "+NovedadSeguimientoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".id,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".version_row from "+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME;//+" as "+NovedadSeguimientoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_detalle_movimiento_inventario=?,id_novedad_producto=?,numero_comprobante=?,fecha_novedad=?,fecha_seguimiento=?,descripcion=?,id_estado_novedad_seguimiento=?";
	
	public static String STOREPROCEDUREINSERT="call SP_NOVEDADSEGUIMIENTO_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_NOVEDADSEGUIMIENTO_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_NOVEDADSEGUIMIENTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_NOVEDADSEGUIMIENTO_SELECT(?,?)";
	
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
	
	
	protected NovedadSeguimientoDataAccessAdditional novedadseguimientoDataAccessAdditional=null;
	
	public NovedadSeguimientoDataAccessAdditional getNovedadSeguimientoDataAccessAdditional() {
		return this.novedadseguimientoDataAccessAdditional;
	}
	
	public void setNovedadSeguimientoDataAccessAdditional(NovedadSeguimientoDataAccessAdditional novedadseguimientoDataAccessAdditional) {
		try {
			this.novedadseguimientoDataAccessAdditional=novedadseguimientoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public NovedadSeguimientoDataAccess() {
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
		NovedadSeguimientoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		NovedadSeguimientoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		NovedadSeguimientoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setNovedadSeguimientoOriginal(NovedadSeguimiento novedadseguimiento)throws Exception  {
		novedadseguimiento.setNovedadSeguimientoOriginal((NovedadSeguimiento)novedadseguimiento.clone());		
	}
	
	public void setNovedadSeguimientosOriginal(List<NovedadSeguimiento> novedadseguimientos)throws Exception  {
		
		for(NovedadSeguimiento novedadseguimiento:novedadseguimientos){
			novedadseguimiento.setNovedadSeguimientoOriginal((NovedadSeguimiento)novedadseguimiento.clone());
		}
	}
	
	public static void setNovedadSeguimientoOriginalStatic(NovedadSeguimiento novedadseguimiento)throws Exception  {
		novedadseguimiento.setNovedadSeguimientoOriginal((NovedadSeguimiento)novedadseguimiento.clone());		
	}
	
	public static void setNovedadSeguimientosOriginalStatic(List<NovedadSeguimiento> novedadseguimientos)throws Exception  {
		
		for(NovedadSeguimiento novedadseguimiento:novedadseguimientos){
			novedadseguimiento.setNovedadSeguimientoOriginal((NovedadSeguimiento)novedadseguimiento.clone());
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
	
	public  NovedadSeguimiento getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		NovedadSeguimiento entity = new NovedadSeguimiento();		
		
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
	
	public  NovedadSeguimiento getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		NovedadSeguimiento entity = new NovedadSeguimiento();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NovedadSeguimientoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NovedadSeguimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.NovedadSeguimiento.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setNovedadSeguimientoOriginal(new NovedadSeguimiento());
      	    	entity=super.getEntity("",entity,resultSet,NovedadSeguimientoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNovedadSeguimiento("",entity,resultSet); 
				
				//entity.setNovedadSeguimientoOriginal(super.getEntity("",entity.getNovedadSeguimientoOriginal(),resultSet,NovedadSeguimientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNovedadSeguimientoOriginal(this.getEntityNovedadSeguimiento("",entity.getNovedadSeguimientoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseNovedadSeguimiento(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  NovedadSeguimiento getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NovedadSeguimiento entity = new NovedadSeguimiento();
				
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
	
	public  NovedadSeguimiento getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NovedadSeguimiento entity = new NovedadSeguimiento();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NovedadSeguimientoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NovedadSeguimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NovedadSeguimientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.NovedadSeguimiento.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setNovedadSeguimientoOriginal(new NovedadSeguimiento());
      	    	entity=super.getEntity("",entity,resultSet,NovedadSeguimientoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNovedadSeguimiento("",entity,resultSet);    
				
				//entity.setNovedadSeguimientoOriginal(super.getEntity("",entity.getNovedadSeguimientoOriginal(),resultSet,NovedadSeguimientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNovedadSeguimientoOriginal(this.getEntityNovedadSeguimiento("",entity.getNovedadSeguimientoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseNovedadSeguimiento(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //NovedadSeguimiento
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		NovedadSeguimiento entity = new NovedadSeguimiento();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NovedadSeguimientoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NovedadSeguimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NovedadSeguimientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.NovedadSeguimiento.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseNovedadSeguimiento(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<NovedadSeguimiento> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NovedadSeguimiento> entities = new  ArrayList<NovedadSeguimiento>();
		NovedadSeguimiento entity = new NovedadSeguimiento();		  
		
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
	
	public  List<NovedadSeguimiento> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NovedadSeguimiento> entities = new  ArrayList<NovedadSeguimiento>();
		NovedadSeguimiento entity = new NovedadSeguimiento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=NovedadSeguimientoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NovedadSeguimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NovedadSeguimientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NovedadSeguimiento();
      	    	entity=super.getEntity("",entity,resultSet,NovedadSeguimientoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNovedadSeguimiento("",entity,resultSet);
      	    	
				//entity.setNovedadSeguimientoOriginal( new NovedadSeguimiento());
      	    	//entity.setNovedadSeguimientoOriginal(super.getEntity("",entity.getNovedadSeguimientoOriginal(),resultSet,NovedadSeguimientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNovedadSeguimientoOriginal(this.getEntityNovedadSeguimiento("",entity.getNovedadSeguimientoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNovedadSeguimientos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNovedadSeguimiento(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NovedadSeguimiento> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NovedadSeguimiento> entities = new  ArrayList<NovedadSeguimiento>();
		NovedadSeguimiento entity = new NovedadSeguimiento();		  
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
	
	public  List<NovedadSeguimiento> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NovedadSeguimiento> entities = new  ArrayList<NovedadSeguimiento>();
		NovedadSeguimiento entity = new NovedadSeguimiento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NovedadSeguimiento();
				
				if(conMapGenerico) {
					entity.inicializarMapNovedadSeguimiento();
					//entity.setMapNovedadSeguimiento(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapNovedadSeguimientoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNovedadSeguimiento().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NovedadSeguimientoDataAccess.ISWITHSCHEMA);         		
					entity=NovedadSeguimientoDataAccess.getEntityNovedadSeguimiento("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNovedadSeguimientoOriginal( new NovedadSeguimiento());
					////entity.setNovedadSeguimientoOriginal(super.getEntity("",entity.getNovedadSeguimientoOriginal(),resultSet,NovedadSeguimientoDataAccess.ISWITHSCHEMA));         		
					////entity.setNovedadSeguimientoOriginal(this.getEntityNovedadSeguimiento("",entity.getNovedadSeguimientoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNovedadSeguimientos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNovedadSeguimiento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public NovedadSeguimiento getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NovedadSeguimiento entity = new NovedadSeguimiento();		  
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
	
	public  NovedadSeguimiento getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NovedadSeguimiento entity = new NovedadSeguimiento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NovedadSeguimiento();
				
				if(conMapGenerico) {
					entity.inicializarMapNovedadSeguimiento();
					//entity.setMapNovedadSeguimiento(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapNovedadSeguimientoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNovedadSeguimiento().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NovedadSeguimientoDataAccess.ISWITHSCHEMA);         		
					entity=NovedadSeguimientoDataAccess.getEntityNovedadSeguimiento("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNovedadSeguimientoOriginal( new NovedadSeguimiento());
					////entity.setNovedadSeguimientoOriginal(super.getEntity("",entity.getNovedadSeguimientoOriginal(),resultSet,NovedadSeguimientoDataAccess.ISWITHSCHEMA));         		
					////entity.setNovedadSeguimientoOriginal(this.getEntityNovedadSeguimiento("",entity.getNovedadSeguimientoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseNovedadSeguimiento(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNovedadSeguimiento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static NovedadSeguimiento getEntityNovedadSeguimiento(String strPrefijo,NovedadSeguimiento entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = NovedadSeguimiento.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = NovedadSeguimiento.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					NovedadSeguimientoDataAccess.setFieldReflectionNovedadSeguimiento(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasNovedadSeguimiento=NovedadSeguimientoConstantesFunciones.getTodosTiposColumnasNovedadSeguimiento();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasNovedadSeguimiento) {
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
							field = NovedadSeguimiento.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = NovedadSeguimiento.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						NovedadSeguimientoDataAccess.setFieldReflectionNovedadSeguimiento(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionNovedadSeguimiento(Field field,String strPrefijo,String sColumn,NovedadSeguimiento entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case NovedadSeguimientoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NovedadSeguimientoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NovedadSeguimientoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NovedadSeguimientoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NovedadSeguimientoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NovedadSeguimientoConstantesFunciones.IDNOVEDADPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NovedadSeguimientoConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NovedadSeguimientoConstantesFunciones.FECHANOVEDAD:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case NovedadSeguimientoConstantesFunciones.FECHASEGUIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case NovedadSeguimientoConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NovedadSeguimientoConstantesFunciones.IDESTADONOVEDADSEGUIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NovedadSeguimiento>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<NovedadSeguimiento> entities = new  ArrayList<NovedadSeguimiento>();
		NovedadSeguimiento entity = new NovedadSeguimiento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NovedadSeguimientoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NovedadSeguimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NovedadSeguimientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new NovedadSeguimiento();
					entity=super.getEntity("",entity,resultSet,NovedadSeguimientoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityNovedadSeguimiento("",entity,resultSet);
					
					//entity.setNovedadSeguimientoOriginal( new NovedadSeguimiento());
					//entity.setNovedadSeguimientoOriginal(super.getEntity("",entity.getNovedadSeguimientoOriginal(),resultSet,NovedadSeguimientoDataAccess.ISWITHSCHEMA));         		
					//entity.setNovedadSeguimientoOriginal(this.getEntityNovedadSeguimiento("",entity.getNovedadSeguimientoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseNovedadSeguimientos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNovedadSeguimiento(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NovedadSeguimiento>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<NovedadSeguimiento> entities = new  ArrayList<NovedadSeguimiento>();
		NovedadSeguimiento entity = new NovedadSeguimiento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NovedadSeguimientoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NovedadSeguimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NovedadSeguimientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<NovedadSeguimiento> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NovedadSeguimiento> entities = new  ArrayList<NovedadSeguimiento>();
		NovedadSeguimiento entity = new NovedadSeguimiento();		  
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
	
	public  List<NovedadSeguimiento> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NovedadSeguimiento> entities = new  ArrayList<NovedadSeguimiento>();
		NovedadSeguimiento entity = new NovedadSeguimiento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NovedadSeguimiento();
      	    	entity=super.getEntity("",entity,resultSet,NovedadSeguimientoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNovedadSeguimiento("",entity,resultSet);
      	    	
				//entity.setNovedadSeguimientoOriginal( new NovedadSeguimiento());
      	    	//entity.setNovedadSeguimientoOriginal(super.getEntity("",entity.getNovedadSeguimientoOriginal(),resultSet,NovedadSeguimientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNovedadSeguimientoOriginal(this.getEntityNovedadSeguimiento("",entity.getNovedadSeguimientoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseNovedadSeguimientos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNovedadSeguimiento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NovedadSeguimiento> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NovedadSeguimiento> entities = new  ArrayList<NovedadSeguimiento>();
		NovedadSeguimiento entity = new NovedadSeguimiento();		  
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
	
	public  List<NovedadSeguimiento> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NovedadSeguimiento> entities = new  ArrayList<NovedadSeguimiento>();
		NovedadSeguimiento entity = new NovedadSeguimiento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NovedadSeguimiento();
      	    	entity=super.getEntity("",entity,resultSet,NovedadSeguimientoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNovedadSeguimiento("",entity,resultSet);
      	    	
				//entity.setNovedadSeguimientoOriginal( new NovedadSeguimiento());
      	    	//entity.setNovedadSeguimientoOriginal(super.getEntity("",entity.getNovedadSeguimientoOriginal(),resultSet,NovedadSeguimientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNovedadSeguimientoOriginal(this.getEntityNovedadSeguimiento("",entity.getNovedadSeguimientoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNovedadSeguimientos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public NovedadSeguimiento getEntityNovedadSeguimiento(String strPrefijo,NovedadSeguimiento entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+NovedadSeguimientoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+NovedadSeguimientoConstantesFunciones.IDSUCURSAL));
				entity.setid_detalle_movimiento_inventario(resultSet.getLong(strPrefijo+NovedadSeguimientoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO));
				entity.setid_novedad_producto(resultSet.getLong(strPrefijo+NovedadSeguimientoConstantesFunciones.IDNOVEDADPRODUCTO));
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+NovedadSeguimientoConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setfecha_novedad(new Date(resultSet.getDate(strPrefijo+NovedadSeguimientoConstantesFunciones.FECHANOVEDAD).getTime()));
				entity.setfecha_seguimiento(new Date(resultSet.getDate(strPrefijo+NovedadSeguimientoConstantesFunciones.FECHASEGUIMIENTO).getTime()));
				entity.setdescripcion(resultSet.getString(strPrefijo+NovedadSeguimientoConstantesFunciones.DESCRIPCION));
				entity.setid_estado_novedad_seguimiento(resultSet.getLong(strPrefijo+NovedadSeguimientoConstantesFunciones.IDESTADONOVEDADSEGUIMIENTO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowNovedadSeguimiento(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(NovedadSeguimiento entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=NovedadSeguimientoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=NovedadSeguimientoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=NovedadSeguimientoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=NovedadSeguimientoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(NovedadSeguimientoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,NovedadSeguimientoDataAccess.TABLENAME,NovedadSeguimientoDataAccess.ISWITHSTOREPROCEDURES);
			
			NovedadSeguimientoDataAccess.setNovedadSeguimientoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,NovedadSeguimiento relnovedadseguimiento)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relnovedadseguimiento.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,NovedadSeguimiento relnovedadseguimiento)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relnovedadseguimiento.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public DetalleMovimientoInventario getDetalleMovimientoInventario(Connexion connexion,NovedadSeguimiento relnovedadseguimiento)throws SQLException,Exception {

		DetalleMovimientoInventario detallemovimientoinventario= new DetalleMovimientoInventario();

		try {
			DetalleMovimientoInventarioDataAccess detallemovimientoinventarioDataAccess=new DetalleMovimientoInventarioDataAccess();

			detallemovimientoinventarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detallemovimientoinventarioDataAccess.setConnexionType(this.connexionType);
			detallemovimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);

			detallemovimientoinventario=detallemovimientoinventarioDataAccess.getEntity(connexion,relnovedadseguimiento.getid_detalle_movimiento_inventario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallemovimientoinventario;

	}

	public NovedadProducto getNovedadProducto(Connexion connexion,NovedadSeguimiento relnovedadseguimiento)throws SQLException,Exception {

		NovedadProducto novedadproducto= new NovedadProducto();

		try {
			NovedadProductoDataAccess novedadproductoDataAccess=new NovedadProductoDataAccess();

			novedadproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			novedadproductoDataAccess.setConnexionType(this.connexionType);
			novedadproductoDataAccess.setParameterDbType(this.parameterDbType);

			novedadproducto=novedadproductoDataAccess.getEntity(connexion,relnovedadseguimiento.getid_novedad_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return novedadproducto;

	}

	public EstadoNovedadSeguimiento getEstadoNovedadSeguimiento(Connexion connexion,NovedadSeguimiento relnovedadseguimiento)throws SQLException,Exception {

		EstadoNovedadSeguimiento estadonovedadseguimiento= new EstadoNovedadSeguimiento();

		try {
			EstadoNovedadSeguimientoDataAccess estadonovedadseguimientoDataAccess=new EstadoNovedadSeguimientoDataAccess();

			estadonovedadseguimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadonovedadseguimientoDataAccess.setConnexionType(this.connexionType);
			estadonovedadseguimientoDataAccess.setParameterDbType(this.parameterDbType);

			estadonovedadseguimiento=estadonovedadseguimientoDataAccess.getEntity(connexion,relnovedadseguimiento.getid_estado_novedad_seguimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadonovedadseguimiento;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,NovedadSeguimiento novedadseguimiento) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!novedadseguimiento.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(novedadseguimiento.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(novedadseguimiento.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_detalle_movimiento_inventario=new ParameterValue<Long>();
					parameterMaintenanceValueid_detalle_movimiento_inventario.setValue(novedadseguimiento.getid_detalle_movimiento_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_detalle_movimiento_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_novedad_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_novedad_producto.setValue(novedadseguimiento.getid_novedad_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_novedad_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(novedadseguimiento.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_novedad=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_novedad.setValue(novedadseguimiento.getfecha_novedad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_novedad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_seguimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_seguimiento.setValue(novedadseguimiento.getfecha_seguimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_seguimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(novedadseguimiento.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_novedad_seguimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_novedad_seguimiento.setValue(novedadseguimiento.getid_estado_novedad_seguimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_novedad_seguimiento);
					parametersTemp.add(parameterMaintenance);
					
						if(!novedadseguimiento.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(novedadseguimiento.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(novedadseguimiento.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(novedadseguimiento.getId());
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
	
	public void setIsNewIsChangedFalseNovedadSeguimiento(NovedadSeguimiento novedadseguimiento)throws Exception  {		
		novedadseguimiento.setIsNew(false);
		novedadseguimiento.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseNovedadSeguimientos(List<NovedadSeguimiento> novedadseguimientos)throws Exception  {				
		for(NovedadSeguimiento novedadseguimiento:novedadseguimientos) {
			novedadseguimiento.setIsNew(false);
			novedadseguimiento.setIsChanged(false);
		}
	}
	
	public void generarExportarNovedadSeguimiento(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
