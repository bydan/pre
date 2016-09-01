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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//TipoMovimientoModuloConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.puntoventa.util.*;




@SuppressWarnings("unused")
final public class TipoMovimientoModuloDataAccess extends  TipoMovimientoModuloDataAccessAdditional{ //TipoMovimientoModuloDataAccessAdditional,DataAccessHelper<TipoMovimientoModulo>
	//static Logger logger = Logger.getLogger(TipoMovimientoModuloDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_movimiento_modulo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+"(id,version_row,id_modulo,codigo,nombre)values(?,current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_modulo=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipomovimientomodulo from "+TipoMovimientoModuloConstantesFunciones.SPERSISTENCENAME+" tipomovimientomodulo";
	public static String QUERYSELECTNATIVE="select "+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+".id,"+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+".version_row,"+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+".id_modulo,"+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+".codigo,"+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+".nombre from "+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME;//+" as "+TipoMovimientoModuloConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+".id,"+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+".version_row,"+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+".nombre from "+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME;//+" as "+TipoMovimientoModuloConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_modulo=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOMOVIMIENTOMODULO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOMOVIMIENTOMODULO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOMOVIMIENTOMODULO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOMOVIMIENTOMODULO_SELECT(?,?)";
	
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
	
	
	protected TipoMovimientoModuloDataAccessAdditional tipomovimientomoduloDataAccessAdditional=null;
	
	public TipoMovimientoModuloDataAccessAdditional getTipoMovimientoModuloDataAccessAdditional() {
		return this.tipomovimientomoduloDataAccessAdditional;
	}
	
	public void setTipoMovimientoModuloDataAccessAdditional(TipoMovimientoModuloDataAccessAdditional tipomovimientomoduloDataAccessAdditional) {
		try {
			this.tipomovimientomoduloDataAccessAdditional=tipomovimientomoduloDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoMovimientoModuloDataAccess() {
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
		TipoMovimientoModuloDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoMovimientoModuloDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoMovimientoModuloDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoMovimientoModuloOriginal(TipoMovimientoModulo tipomovimientomodulo)throws Exception  {
		tipomovimientomodulo.setTipoMovimientoModuloOriginal((TipoMovimientoModulo)tipomovimientomodulo.clone());		
	}
	
	public void setTipoMovimientoModulosOriginal(List<TipoMovimientoModulo> tipomovimientomodulos)throws Exception  {
		
		for(TipoMovimientoModulo tipomovimientomodulo:tipomovimientomodulos){
			tipomovimientomodulo.setTipoMovimientoModuloOriginal((TipoMovimientoModulo)tipomovimientomodulo.clone());
		}
	}
	
	public static void setTipoMovimientoModuloOriginalStatic(TipoMovimientoModulo tipomovimientomodulo)throws Exception  {
		tipomovimientomodulo.setTipoMovimientoModuloOriginal((TipoMovimientoModulo)tipomovimientomodulo.clone());		
	}
	
	public static void setTipoMovimientoModulosOriginalStatic(List<TipoMovimientoModulo> tipomovimientomodulos)throws Exception  {
		
		for(TipoMovimientoModulo tipomovimientomodulo:tipomovimientomodulos){
			tipomovimientomodulo.setTipoMovimientoModuloOriginal((TipoMovimientoModulo)tipomovimientomodulo.clone());
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
	
	public  TipoMovimientoModulo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoMovimientoModulo entity = new TipoMovimientoModulo();		
		
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
	
	public  TipoMovimientoModulo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoMovimientoModulo entity = new TipoMovimientoModulo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMovimientoModuloDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMovimientoModuloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TipoMovimientoModulo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoMovimientoModuloOriginal(new TipoMovimientoModulo());
      	    	entity=super.getEntity("",entity,resultSet,TipoMovimientoModuloDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoMovimientoModulo("",entity,resultSet); 
				
				//entity.setTipoMovimientoModuloOriginal(super.getEntity("",entity.getTipoMovimientoModuloOriginal(),resultSet,TipoMovimientoModuloDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMovimientoModuloOriginal(this.getEntityTipoMovimientoModulo("",entity.getTipoMovimientoModuloOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoMovimientoModulo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoMovimientoModulo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoMovimientoModulo entity = new TipoMovimientoModulo();
				
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
	
	public  TipoMovimientoModulo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoMovimientoModulo entity = new TipoMovimientoModulo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMovimientoModuloDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMovimientoModuloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoMovimientoModuloDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoMovimientoModulo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoMovimientoModuloOriginal(new TipoMovimientoModulo());
      	    	entity=super.getEntity("",entity,resultSet,TipoMovimientoModuloDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoMovimientoModulo("",entity,resultSet);    
				
				//entity.setTipoMovimientoModuloOriginal(super.getEntity("",entity.getTipoMovimientoModuloOriginal(),resultSet,TipoMovimientoModuloDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMovimientoModuloOriginal(this.getEntityTipoMovimientoModulo("",entity.getTipoMovimientoModuloOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoMovimientoModulo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoMovimientoModulo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoMovimientoModulo entity = new TipoMovimientoModulo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMovimientoModuloDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMovimientoModuloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoMovimientoModuloDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoMovimientoModulo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoMovimientoModulo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoMovimientoModulo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoMovimientoModulo> entities = new  ArrayList<TipoMovimientoModulo>();
		TipoMovimientoModulo entity = new TipoMovimientoModulo();		  
		
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
	
	public  List<TipoMovimientoModulo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoMovimientoModulo> entities = new  ArrayList<TipoMovimientoModulo>();
		TipoMovimientoModulo entity = new TipoMovimientoModulo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMovimientoModuloDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMovimientoModuloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoMovimientoModuloDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMovimientoModulo();
      	    	entity=super.getEntity("",entity,resultSet,TipoMovimientoModuloDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoMovimientoModulo("",entity,resultSet);
      	    	
				//entity.setTipoMovimientoModuloOriginal( new TipoMovimientoModulo());
      	    	//entity.setTipoMovimientoModuloOriginal(super.getEntity("",entity.getTipoMovimientoModuloOriginal(),resultSet,TipoMovimientoModuloDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMovimientoModuloOriginal(this.getEntityTipoMovimientoModulo("",entity.getTipoMovimientoModuloOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoMovimientoModulos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMovimientoModulo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoMovimientoModulo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoMovimientoModulo> entities = new  ArrayList<TipoMovimientoModulo>();
		TipoMovimientoModulo entity = new TipoMovimientoModulo();		  
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
	
	public  List<TipoMovimientoModulo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoMovimientoModulo> entities = new  ArrayList<TipoMovimientoModulo>();
		TipoMovimientoModulo entity = new TipoMovimientoModulo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMovimientoModulo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoMovimientoModulo();
					//entity.setMapTipoMovimientoModulo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoMovimientoModuloValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoMovimientoModulo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoMovimientoModuloDataAccess.ISWITHSCHEMA);         		
					entity=TipoMovimientoModuloDataAccess.getEntityTipoMovimientoModulo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoMovimientoModuloOriginal( new TipoMovimientoModulo());
					////entity.setTipoMovimientoModuloOriginal(super.getEntity("",entity.getTipoMovimientoModuloOriginal(),resultSet,TipoMovimientoModuloDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoMovimientoModuloOriginal(this.getEntityTipoMovimientoModulo("",entity.getTipoMovimientoModuloOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoMovimientoModulos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMovimientoModulo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoMovimientoModulo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoMovimientoModulo entity = new TipoMovimientoModulo();		  
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
	
	public  TipoMovimientoModulo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoMovimientoModulo entity = new TipoMovimientoModulo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMovimientoModulo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoMovimientoModulo();
					//entity.setMapTipoMovimientoModulo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoMovimientoModuloValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoMovimientoModulo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoMovimientoModuloDataAccess.ISWITHSCHEMA);         		
					entity=TipoMovimientoModuloDataAccess.getEntityTipoMovimientoModulo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoMovimientoModuloOriginal( new TipoMovimientoModulo());
					////entity.setTipoMovimientoModuloOriginal(super.getEntity("",entity.getTipoMovimientoModuloOriginal(),resultSet,TipoMovimientoModuloDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoMovimientoModuloOriginal(this.getEntityTipoMovimientoModulo("",entity.getTipoMovimientoModuloOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoMovimientoModulo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMovimientoModulo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoMovimientoModulo getEntityTipoMovimientoModulo(String strPrefijo,TipoMovimientoModulo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoMovimientoModulo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoMovimientoModulo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoMovimientoModuloDataAccess.setFieldReflectionTipoMovimientoModulo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoMovimientoModulo=TipoMovimientoModuloConstantesFunciones.getTodosTiposColumnasTipoMovimientoModulo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoMovimientoModulo) {
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
							field = TipoMovimientoModulo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoMovimientoModulo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoMovimientoModuloDataAccess.setFieldReflectionTipoMovimientoModulo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoMovimientoModulo(Field field,String strPrefijo,String sColumn,TipoMovimientoModulo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoMovimientoModuloConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoMovimientoModuloConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoMovimientoModuloConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoMovimientoModuloConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoMovimientoModuloConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoMovimientoModulo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoMovimientoModulo> entities = new  ArrayList<TipoMovimientoModulo>();
		TipoMovimientoModulo entity = new TipoMovimientoModulo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMovimientoModuloDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMovimientoModuloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoMovimientoModuloDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoMovimientoModulo();
					entity=super.getEntity("",entity,resultSet,TipoMovimientoModuloDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoMovimientoModulo("",entity,resultSet);
					
					//entity.setTipoMovimientoModuloOriginal( new TipoMovimientoModulo());
					//entity.setTipoMovimientoModuloOriginal(super.getEntity("",entity.getTipoMovimientoModuloOriginal(),resultSet,TipoMovimientoModuloDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoMovimientoModuloOriginal(this.getEntityTipoMovimientoModulo("",entity.getTipoMovimientoModuloOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoMovimientoModulos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMovimientoModulo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoMovimientoModulo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoMovimientoModulo> entities = new  ArrayList<TipoMovimientoModulo>();
		TipoMovimientoModulo entity = new TipoMovimientoModulo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMovimientoModuloDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMovimientoModuloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoMovimientoModuloDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoMovimientoModulo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMovimientoModulo> entities = new  ArrayList<TipoMovimientoModulo>();
		TipoMovimientoModulo entity = new TipoMovimientoModulo();		  
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
	
	public  List<TipoMovimientoModulo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMovimientoModulo> entities = new  ArrayList<TipoMovimientoModulo>();
		TipoMovimientoModulo entity = new TipoMovimientoModulo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMovimientoModulo();
      	    	entity=super.getEntity("",entity,resultSet,TipoMovimientoModuloDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoMovimientoModulo("",entity,resultSet);
      	    	
				//entity.setTipoMovimientoModuloOriginal( new TipoMovimientoModulo());
      	    	//entity.setTipoMovimientoModuloOriginal(super.getEntity("",entity.getTipoMovimientoModuloOriginal(),resultSet,TipoMovimientoModuloDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMovimientoModuloOriginal(this.getEntityTipoMovimientoModulo("",entity.getTipoMovimientoModuloOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoMovimientoModulos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMovimientoModulo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoMovimientoModulo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMovimientoModulo> entities = new  ArrayList<TipoMovimientoModulo>();
		TipoMovimientoModulo entity = new TipoMovimientoModulo();		  
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
	
	public  List<TipoMovimientoModulo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMovimientoModulo> entities = new  ArrayList<TipoMovimientoModulo>();
		TipoMovimientoModulo entity = new TipoMovimientoModulo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMovimientoModulo();
      	    	entity=super.getEntity("",entity,resultSet,TipoMovimientoModuloDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoMovimientoModulo("",entity,resultSet);
      	    	
				//entity.setTipoMovimientoModuloOriginal( new TipoMovimientoModulo());
      	    	//entity.setTipoMovimientoModuloOriginal(super.getEntity("",entity.getTipoMovimientoModuloOriginal(),resultSet,TipoMovimientoModuloDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMovimientoModuloOriginal(this.getEntityTipoMovimientoModulo("",entity.getTipoMovimientoModuloOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoMovimientoModulos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoMovimientoModulo getEntityTipoMovimientoModulo(String strPrefijo,TipoMovimientoModulo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_modulo(resultSet.getLong(strPrefijo+TipoMovimientoModuloConstantesFunciones.IDMODULO));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoMovimientoModuloConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoMovimientoModuloConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoMovimientoModuloConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoMovimientoModulo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoMovimientoModulo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoMovimientoModuloDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoMovimientoModuloDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoMovimientoModuloDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoMovimientoModuloDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoMovimientoModuloConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoMovimientoModuloDataAccess.TABLENAME,TipoMovimientoModuloDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoMovimientoModuloDataAccess.setTipoMovimientoModuloOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Modulo getModulo(Connexion connexion,TipoMovimientoModulo reltipomovimientomodulo)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,reltipomovimientomodulo.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}


		
		public List<ParametroCompra> getParametroCompras(Connexion connexion,TipoMovimientoModulo tipomovimientomodulo)throws SQLException,Exception {

		List<ParametroCompra> parametrocompras= new ArrayList<ParametroCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo ON "+ParametroCompraConstantesFunciones.SCHEMA+".parametro_compra.id_tipo_movimiento_modulo="+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo.id WHERE "+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo.id="+String.valueOf(tipomovimientomodulo.getId());
			} else {
				sQuery=" INNER JOIN parametrocompra.TipoMovimientoModulo WHERE parametrocompra.TipoMovimientoModulo.id="+String.valueOf(tipomovimientomodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroCompraDataAccess parametrocompraDataAccess=new ParametroCompraDataAccess();

			parametrocompraDataAccess.setConnexionType(this.connexionType);
			parametrocompraDataAccess.setParameterDbType(this.parameterDbType);
			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocompras;

	}

	public List<FacturaProveedor> getFacturaProveedors(Connexion connexion,TipoMovimientoModulo tipomovimientomodulo)throws SQLException,Exception {

		List<FacturaProveedor> facturaproveedors= new ArrayList<FacturaProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo ON "+FacturaProveedorConstantesFunciones.SCHEMA+".factura_proveedor.id_tipo_movimiento_modulo="+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo.id WHERE "+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo.id="+String.valueOf(tipomovimientomodulo.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedor.TipoMovimientoModulo WHERE facturaproveedor.TipoMovimientoModulo.id="+String.valueOf(tipomovimientomodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorDataAccess facturaproveedorDataAccess=new FacturaProveedorDataAccess();

			facturaproveedorDataAccess.setConnexionType(this.connexionType);
			facturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedors;

	}

	public List<AsientoContableCajaChica> getAsientoContableCajaChicas(Connexion connexion,TipoMovimientoModulo tipomovimientomodulo)throws SQLException,Exception {

		List<AsientoContableCajaChica> asientocontablecajachicas= new ArrayList<AsientoContableCajaChica>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo ON "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+".asiento_contable_caja_chica.id_tipo_movimiento_modulo="+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo.id WHERE "+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo.id="+String.valueOf(tipomovimientomodulo.getId());
			} else {
				sQuery=" INNER JOIN asientocontablecajachica.TipoMovimientoModulo WHERE asientocontablecajachica.TipoMovimientoModulo.id="+String.valueOf(tipomovimientomodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsientoContableCajaChicaDataAccess asientocontablecajachicaDataAccess=new AsientoContableCajaChicaDataAccess();

			asientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			asientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontablecajachicas;

	}

	public List<FacturaProveedorServicio> getFacturaProveedorServicios(Connexion connexion,TipoMovimientoModulo tipomovimientomodulo)throws SQLException,Exception {

		List<FacturaProveedorServicio> facturaproveedorservicios= new ArrayList<FacturaProveedorServicio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo ON "+FacturaProveedorServicioConstantesFunciones.SCHEMA+".factura_proveedor_servicio.id_tipo_movimiento_modulo="+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo.id WHERE "+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo.id="+String.valueOf(tipomovimientomodulo.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedorservicio.TipoMovimientoModulo WHERE facturaproveedorservicio.TipoMovimientoModulo.id="+String.valueOf(tipomovimientomodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorServicioDataAccess facturaproveedorservicioDataAccess=new FacturaProveedorServicioDataAccess();

			facturaproveedorservicioDataAccess.setConnexionType(this.connexionType);
			facturaproveedorservicioDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedorservicios;

	}

	public List<Secuencial> getSecuencials(Connexion connexion,TipoMovimientoModulo tipomovimientomodulo)throws SQLException,Exception {

		List<Secuencial> secuencials= new ArrayList<Secuencial>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo ON "+SecuencialConstantesFunciones.SCHEMA+".secuencial.id_tipo_movimiento_modulo="+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo.id WHERE "+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo.id="+String.valueOf(tipomovimientomodulo.getId());
			} else {
				sQuery=" INNER JOIN secuencial.TipoMovimientoModulo WHERE secuencial.TipoMovimientoModulo.id="+String.valueOf(tipomovimientomodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SecuencialDataAccess secuencialDataAccess=new SecuencialDataAccess();

			secuencialDataAccess.setConnexionType(this.connexionType);
			secuencialDataAccess.setParameterDbType(this.parameterDbType);
			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return secuencials;

	}

	public List<AsientoContable> getAsientoContables(Connexion connexion,TipoMovimientoModulo tipomovimientomodulo)throws SQLException,Exception {

		List<AsientoContable> asientocontables= new ArrayList<AsientoContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo ON "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id_tipo_movimiento_modulo="+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo.id WHERE "+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo.id="+String.valueOf(tipomovimientomodulo.getId());
			} else {
				sQuery=" INNER JOIN asientocontable.TipoMovimientoModulo WHERE asientocontable.TipoMovimientoModulo.id="+String.valueOf(tipomovimientomodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);
			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontables;

	}

	public List<TipoDocumento> getTipoDocumentos(Connexion connexion,TipoMovimientoModulo tipomovimientomodulo)throws SQLException,Exception {

		List<TipoDocumento> tipodocumentos= new ArrayList<TipoDocumento>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo ON "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id_tipo_movimiento_modulo="+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo.id WHERE "+TipoMovimientoModuloConstantesFunciones.SCHEMA+".tipo_movimiento_modulo.id="+String.valueOf(tipomovimientomodulo.getId());
			} else {
				sQuery=" INNER JOIN tipodocumento.TipoMovimientoModulo WHERE tipodocumento.TipoMovimientoModulo.id="+String.valueOf(tipomovimientomodulo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);
			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumentos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoMovimientoModulo tipomovimientomodulo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipomovimientomodulo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipomovimientomodulo.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(tipomovimientomodulo.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipomovimientomodulo.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipomovimientomodulo.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipomovimientomodulo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipomovimientomodulo.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipomovimientomodulo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipomovimientomodulo.getId());
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
	
	public void setIsNewIsChangedFalseTipoMovimientoModulo(TipoMovimientoModulo tipomovimientomodulo)throws Exception  {		
		tipomovimientomodulo.setIsNew(false);
		tipomovimientomodulo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoMovimientoModulos(List<TipoMovimientoModulo> tipomovimientomodulos)throws Exception  {				
		for(TipoMovimientoModulo tipomovimientomodulo:tipomovimientomodulos) {
			tipomovimientomodulo.setIsNew(false);
			tipomovimientomodulo.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoMovimientoModulo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
