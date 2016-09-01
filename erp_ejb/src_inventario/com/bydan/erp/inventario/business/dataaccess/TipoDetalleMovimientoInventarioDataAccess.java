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
import com.bydan.erp.inventario.util.*;//TipoDetalleMovimientoInventarioConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class TipoDetalleMovimientoInventarioDataAccess extends  DataAccessHelperSinIdGenerated<TipoDetalleMovimientoInventario>{ //TipoDetalleMovimientoInventarioDataAccessAdditional,DataAccessHelper<TipoDetalleMovimientoInventario>
	//static Logger logger = Logger.getLogger(TipoDetalleMovimientoInventarioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_detalle_movimiento_inventario";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipodetallemovimientoinventario from "+TipoDetalleMovimientoInventarioConstantesFunciones.SPERSISTENCENAME+" tipodetallemovimientoinventario";
	public static String QUERYSELECTNATIVE="select "+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id,"+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".version_row,"+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".codigo,"+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".nombre from "+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME;//+" as "+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".id,"+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".version_row,"+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+".codigo from "+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME;//+" as "+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+"."+TipoDetalleMovimientoInventarioConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPODETALLEMOVIMIENTOINVENTARIO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPODETALLEMOVIMIENTOINVENTARIO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPODETALLEMOVIMIENTOINVENTARIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPODETALLEMOVIMIENTOINVENTARIO_SELECT(?,?)";
	
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
	
	
	public TipoDetalleMovimientoInventarioDataAccess() {
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
		TipoDetalleMovimientoInventarioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoDetalleMovimientoInventarioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoDetalleMovimientoInventarioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoDetalleMovimientoInventarioOriginal(TipoDetalleMovimientoInventario tipodetallemovimientoinventario)throws Exception  {
		tipodetallemovimientoinventario.setTipoDetalleMovimientoInventarioOriginal((TipoDetalleMovimientoInventario)tipodetallemovimientoinventario.clone());		
	}
	
	public void setTipoDetalleMovimientoInventariosOriginal(List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarios)throws Exception  {
		
		for(TipoDetalleMovimientoInventario tipodetallemovimientoinventario:tipodetallemovimientoinventarios){
			tipodetallemovimientoinventario.setTipoDetalleMovimientoInventarioOriginal((TipoDetalleMovimientoInventario)tipodetallemovimientoinventario.clone());
		}
	}
	
	public static void setTipoDetalleMovimientoInventarioOriginalStatic(TipoDetalleMovimientoInventario tipodetallemovimientoinventario)throws Exception  {
		tipodetallemovimientoinventario.setTipoDetalleMovimientoInventarioOriginal((TipoDetalleMovimientoInventario)tipodetallemovimientoinventario.clone());		
	}
	
	public static void setTipoDetalleMovimientoInventariosOriginalStatic(List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarios)throws Exception  {
		
		for(TipoDetalleMovimientoInventario tipodetallemovimientoinventario:tipodetallemovimientoinventarios){
			tipodetallemovimientoinventario.setTipoDetalleMovimientoInventarioOriginal((TipoDetalleMovimientoInventario)tipodetallemovimientoinventario.clone());
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
	
	public  TipoDetalleMovimientoInventario getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDetalleMovimientoInventario entity = new TipoDetalleMovimientoInventario();		
		
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
	
	public  TipoDetalleMovimientoInventario getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDetalleMovimientoInventario entity = new TipoDetalleMovimientoInventario();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.TipoDetalleMovimientoInventario.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoDetalleMovimientoInventarioOriginal(new TipoDetalleMovimientoInventario());
      	    	entity=super.getEntity("",entity,resultSet,TipoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDetalleMovimientoInventario("",entity,resultSet); 
				
				//entity.setTipoDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getTipoDetalleMovimientoInventarioOriginal(),resultSet,TipoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDetalleMovimientoInventarioOriginal(this.getEntityTipoDetalleMovimientoInventario("",entity.getTipoDetalleMovimientoInventarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDetalleMovimientoInventario(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoDetalleMovimientoInventario getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDetalleMovimientoInventario entity = new TipoDetalleMovimientoInventario();
				
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
	
	public  TipoDetalleMovimientoInventario getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDetalleMovimientoInventario entity = new TipoDetalleMovimientoInventario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoDetalleMovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoDetalleMovimientoInventario.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoDetalleMovimientoInventarioOriginal(new TipoDetalleMovimientoInventario());
      	    	entity=super.getEntity("",entity,resultSet,TipoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDetalleMovimientoInventario("",entity,resultSet);    
				
				//entity.setTipoDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getTipoDetalleMovimientoInventarioOriginal(),resultSet,TipoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDetalleMovimientoInventarioOriginal(this.getEntityTipoDetalleMovimientoInventario("",entity.getTipoDetalleMovimientoInventarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDetalleMovimientoInventario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoDetalleMovimientoInventario
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoDetalleMovimientoInventario entity = new TipoDetalleMovimientoInventario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoDetalleMovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoDetalleMovimientoInventario.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoDetalleMovimientoInventario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoDetalleMovimientoInventario> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDetalleMovimientoInventario> entities = new  ArrayList<TipoDetalleMovimientoInventario>();
		TipoDetalleMovimientoInventario entity = new TipoDetalleMovimientoInventario();		  
		
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
	
	public  List<TipoDetalleMovimientoInventario> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDetalleMovimientoInventario> entities = new  ArrayList<TipoDetalleMovimientoInventario>();
		TipoDetalleMovimientoInventario entity = new TipoDetalleMovimientoInventario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoDetalleMovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDetalleMovimientoInventario();
      	    	entity=super.getEntity("",entity,resultSet,TipoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDetalleMovimientoInventario("",entity,resultSet);
      	    	
				//entity.setTipoDetalleMovimientoInventarioOriginal( new TipoDetalleMovimientoInventario());
      	    	//entity.setTipoDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getTipoDetalleMovimientoInventarioOriginal(),resultSet,TipoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDetalleMovimientoInventarioOriginal(this.getEntityTipoDetalleMovimientoInventario("",entity.getTipoDetalleMovimientoInventarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDetalleMovimientoInventarios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDetalleMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoDetalleMovimientoInventario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDetalleMovimientoInventario> entities = new  ArrayList<TipoDetalleMovimientoInventario>();
		TipoDetalleMovimientoInventario entity = new TipoDetalleMovimientoInventario();		  
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
	
	public  List<TipoDetalleMovimientoInventario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDetalleMovimientoInventario> entities = new  ArrayList<TipoDetalleMovimientoInventario>();
		TipoDetalleMovimientoInventario entity = new TipoDetalleMovimientoInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDetalleMovimientoInventario();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDetalleMovimientoInventario();
					//entity.setMapTipoDetalleMovimientoInventario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoDetalleMovimientoInventarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDetalleMovimientoInventario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
					entity=TipoDetalleMovimientoInventarioDataAccess.getEntityTipoDetalleMovimientoInventario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDetalleMovimientoInventarioOriginal( new TipoDetalleMovimientoInventario());
					////entity.setTipoDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getTipoDetalleMovimientoInventarioOriginal(),resultSet,TipoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDetalleMovimientoInventarioOriginal(this.getEntityTipoDetalleMovimientoInventario("",entity.getTipoDetalleMovimientoInventarioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDetalleMovimientoInventarios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDetalleMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoDetalleMovimientoInventario getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDetalleMovimientoInventario entity = new TipoDetalleMovimientoInventario();		  
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
	
	public  TipoDetalleMovimientoInventario getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDetalleMovimientoInventario entity = new TipoDetalleMovimientoInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDetalleMovimientoInventario();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDetalleMovimientoInventario();
					//entity.setMapTipoDetalleMovimientoInventario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoDetalleMovimientoInventarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDetalleMovimientoInventario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
					entity=TipoDetalleMovimientoInventarioDataAccess.getEntityTipoDetalleMovimientoInventario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDetalleMovimientoInventarioOriginal( new TipoDetalleMovimientoInventario());
					////entity.setTipoDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getTipoDetalleMovimientoInventarioOriginal(),resultSet,TipoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDetalleMovimientoInventarioOriginal(this.getEntityTipoDetalleMovimientoInventario("",entity.getTipoDetalleMovimientoInventarioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoDetalleMovimientoInventario(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDetalleMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoDetalleMovimientoInventario getEntityTipoDetalleMovimientoInventario(String strPrefijo,TipoDetalleMovimientoInventario entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoDetalleMovimientoInventario.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoDetalleMovimientoInventario.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoDetalleMovimientoInventarioDataAccess.setFieldReflectionTipoDetalleMovimientoInventario(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoDetalleMovimientoInventario=TipoDetalleMovimientoInventarioConstantesFunciones.getTodosTiposColumnasTipoDetalleMovimientoInventario();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoDetalleMovimientoInventario) {
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
							field = TipoDetalleMovimientoInventario.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoDetalleMovimientoInventario.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoDetalleMovimientoInventarioDataAccess.setFieldReflectionTipoDetalleMovimientoInventario(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoDetalleMovimientoInventario(Field field,String strPrefijo,String sColumn,TipoDetalleMovimientoInventario entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoDetalleMovimientoInventarioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDetalleMovimientoInventarioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDetalleMovimientoInventarioConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDetalleMovimientoInventarioConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDetalleMovimientoInventario>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoDetalleMovimientoInventario> entities = new  ArrayList<TipoDetalleMovimientoInventario>();
		TipoDetalleMovimientoInventario entity = new TipoDetalleMovimientoInventario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoDetalleMovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoDetalleMovimientoInventario();
					entity=super.getEntity("",entity,resultSet,TipoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoDetalleMovimientoInventario("",entity,resultSet);
					
					//entity.setTipoDetalleMovimientoInventarioOriginal( new TipoDetalleMovimientoInventario());
					//entity.setTipoDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getTipoDetalleMovimientoInventarioOriginal(),resultSet,TipoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoDetalleMovimientoInventarioOriginal(this.getEntityTipoDetalleMovimientoInventario("",entity.getTipoDetalleMovimientoInventarioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoDetalleMovimientoInventarios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDetalleMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDetalleMovimientoInventario>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoDetalleMovimientoInventario> entities = new  ArrayList<TipoDetalleMovimientoInventario>();
		TipoDetalleMovimientoInventario entity = new TipoDetalleMovimientoInventario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDetalleMovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoDetalleMovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoDetalleMovimientoInventario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDetalleMovimientoInventario> entities = new  ArrayList<TipoDetalleMovimientoInventario>();
		TipoDetalleMovimientoInventario entity = new TipoDetalleMovimientoInventario();		  
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
	
	public  List<TipoDetalleMovimientoInventario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDetalleMovimientoInventario> entities = new  ArrayList<TipoDetalleMovimientoInventario>();
		TipoDetalleMovimientoInventario entity = new TipoDetalleMovimientoInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDetalleMovimientoInventario();
      	    	entity=super.getEntity("",entity,resultSet,TipoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDetalleMovimientoInventario("",entity,resultSet);
      	    	
				//entity.setTipoDetalleMovimientoInventarioOriginal( new TipoDetalleMovimientoInventario());
      	    	//entity.setTipoDetalleMovimientoInventarioOriginal(super.getEntity("",entity.getTipoDetalleMovimientoInventarioOriginal(),resultSet,TipoDetalleMovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDetalleMovimientoInventarioOriginal(this.getEntityTipoDetalleMovimientoInventario("",entity.getTipoDetalleMovimientoInventarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoDetalleMovimientoInventarios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDetalleMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoDetalleMovimientoInventario getEntityTipoDetalleMovimientoInventario(String strPrefijo,TipoDetalleMovimientoInventario entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDetalleMovimientoInventarioConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoDetalleMovimientoInventarioConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDetalleMovimientoInventarioConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoDetalleMovimientoInventario(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoDetalleMovimientoInventario entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoDetalleMovimientoInventarioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoDetalleMovimientoInventarioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoDetalleMovimientoInventarioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoDetalleMovimientoInventarioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoDetalleMovimientoInventarioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoDetalleMovimientoInventarioDataAccess.TABLENAME,TipoDetalleMovimientoInventarioDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoDetalleMovimientoInventarioDataAccess.setTipoDetalleMovimientoInventarioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<DetalleMovimientoInventario> getDetalleMovimientoInventarios(Connexion connexion,TipoDetalleMovimientoInventario tipodetallemovimientoinventario)throws SQLException,Exception {

		List<DetalleMovimientoInventario> detallemovimientoinventarios= new ArrayList<DetalleMovimientoInventario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+".tipo_detalle_movimiento_inventario ON "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+".detalle_movimiento_inventario.id_tipo_detalle_movimiento_inventario="+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+".tipo_detalle_movimiento_inventario.id WHERE "+TipoDetalleMovimientoInventarioConstantesFunciones.SCHEMA+".tipo_detalle_movimiento_inventario.id="+String.valueOf(tipodetallemovimientoinventario.getId());
			} else {
				sQuery=" INNER JOIN detallemovimientoinventario.TipoDetalleMovimientoInventario WHERE detallemovimientoinventario.TipoDetalleMovimientoInventario.id="+String.valueOf(tipodetallemovimientoinventario.getId());

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


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoDetalleMovimientoInventario tipodetallemovimientoinventario) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipodetallemovimientoinventario.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipodetallemovimientoinventario.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipodetallemovimientoinventario.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipodetallemovimientoinventario.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipodetallemovimientoinventario.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipodetallemovimientoinventario.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipodetallemovimientoinventario.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipodetallemovimientoinventario.getId());
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
	
	public void setIsNewIsChangedFalseTipoDetalleMovimientoInventario(TipoDetalleMovimientoInventario tipodetallemovimientoinventario)throws Exception  {		
		tipodetallemovimientoinventario.setIsNew(false);
		tipodetallemovimientoinventario.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoDetalleMovimientoInventarios(List<TipoDetalleMovimientoInventario> tipodetallemovimientoinventarios)throws Exception  {				
		for(TipoDetalleMovimientoInventario tipodetallemovimientoinventario:tipodetallemovimientoinventarios) {
			tipodetallemovimientoinventario.setIsNew(false);
			tipodetallemovimientoinventario.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoDetalleMovimientoInventario(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
