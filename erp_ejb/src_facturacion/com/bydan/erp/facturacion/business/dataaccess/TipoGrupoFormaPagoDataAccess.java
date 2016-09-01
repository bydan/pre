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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//TipoGrupoFormaPagoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class TipoGrupoFormaPagoDataAccess extends  TipoGrupoFormaPagoDataAccessAdditional{ //TipoGrupoFormaPagoDataAccessAdditional,DataAccessHelper<TipoGrupoFormaPago>
	//static Logger logger = Logger.getLogger(TipoGrupoFormaPagoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_grupo_forma_pago";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"."+TipoGrupoFormaPagoConstantesFunciones.TABLENAME+"(id,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"."+TipoGrupoFormaPagoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"."+TipoGrupoFormaPagoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipogrupoformapago from "+TipoGrupoFormaPagoConstantesFunciones.SPERSISTENCENAME+" tipogrupoformapago";
	public static String QUERYSELECTNATIVE="select "+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"."+TipoGrupoFormaPagoConstantesFunciones.TABLENAME+".id,"+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"."+TipoGrupoFormaPagoConstantesFunciones.TABLENAME+".version_row,"+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"."+TipoGrupoFormaPagoConstantesFunciones.TABLENAME+".nombre from "+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"."+TipoGrupoFormaPagoConstantesFunciones.TABLENAME;//+" as "+TipoGrupoFormaPagoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"."+TipoGrupoFormaPagoConstantesFunciones.TABLENAME+".id,"+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"."+TipoGrupoFormaPagoConstantesFunciones.TABLENAME+".version_row,"+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"."+TipoGrupoFormaPagoConstantesFunciones.TABLENAME+".nombre from "+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"."+TipoGrupoFormaPagoConstantesFunciones.TABLENAME;//+" as "+TipoGrupoFormaPagoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+"."+TipoGrupoFormaPagoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOGRUPOFORMAPAGO_INSERT(?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOGRUPOFORMAPAGO_UPDATE(? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOGRUPOFORMAPAGO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOGRUPOFORMAPAGO_SELECT(?,?)";
	
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
	
	
	protected TipoGrupoFormaPagoDataAccessAdditional tipogrupoformapagoDataAccessAdditional=null;
	
	public TipoGrupoFormaPagoDataAccessAdditional getTipoGrupoFormaPagoDataAccessAdditional() {
		return this.tipogrupoformapagoDataAccessAdditional;
	}
	
	public void setTipoGrupoFormaPagoDataAccessAdditional(TipoGrupoFormaPagoDataAccessAdditional tipogrupoformapagoDataAccessAdditional) {
		try {
			this.tipogrupoformapagoDataAccessAdditional=tipogrupoformapagoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoGrupoFormaPagoDataAccess() {
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
		TipoGrupoFormaPagoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoGrupoFormaPagoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoGrupoFormaPagoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoGrupoFormaPagoOriginal(TipoGrupoFormaPago tipogrupoformapago)throws Exception  {
		tipogrupoformapago.setTipoGrupoFormaPagoOriginal((TipoGrupoFormaPago)tipogrupoformapago.clone());		
	}
	
	public void setTipoGrupoFormaPagosOriginal(List<TipoGrupoFormaPago> tipogrupoformapagos)throws Exception  {
		
		for(TipoGrupoFormaPago tipogrupoformapago:tipogrupoformapagos){
			tipogrupoformapago.setTipoGrupoFormaPagoOriginal((TipoGrupoFormaPago)tipogrupoformapago.clone());
		}
	}
	
	public static void setTipoGrupoFormaPagoOriginalStatic(TipoGrupoFormaPago tipogrupoformapago)throws Exception  {
		tipogrupoformapago.setTipoGrupoFormaPagoOriginal((TipoGrupoFormaPago)tipogrupoformapago.clone());		
	}
	
	public static void setTipoGrupoFormaPagosOriginalStatic(List<TipoGrupoFormaPago> tipogrupoformapagos)throws Exception  {
		
		for(TipoGrupoFormaPago tipogrupoformapago:tipogrupoformapagos){
			tipogrupoformapago.setTipoGrupoFormaPagoOriginal((TipoGrupoFormaPago)tipogrupoformapago.clone());
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
	
	public  TipoGrupoFormaPago getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();		
		
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
	
	public  TipoGrupoFormaPago getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGrupoFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGrupoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.TipoGrupoFormaPago.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoGrupoFormaPagoOriginal(new TipoGrupoFormaPago());
      	    	entity=super.getEntity("",entity,resultSet,TipoGrupoFormaPagoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoGrupoFormaPago("",entity,resultSet); 
				
				//entity.setTipoGrupoFormaPagoOriginal(super.getEntity("",entity.getTipoGrupoFormaPagoOriginal(),resultSet,TipoGrupoFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGrupoFormaPagoOriginal(this.getEntityTipoGrupoFormaPago("",entity.getTipoGrupoFormaPagoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoGrupoFormaPago(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoGrupoFormaPago getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();
				
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
	
	public  TipoGrupoFormaPago getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGrupoFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGrupoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoGrupoFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoGrupoFormaPago.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoGrupoFormaPagoOriginal(new TipoGrupoFormaPago());
      	    	entity=super.getEntity("",entity,resultSet,TipoGrupoFormaPagoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoGrupoFormaPago("",entity,resultSet);    
				
				//entity.setTipoGrupoFormaPagoOriginal(super.getEntity("",entity.getTipoGrupoFormaPagoOriginal(),resultSet,TipoGrupoFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGrupoFormaPagoOriginal(this.getEntityTipoGrupoFormaPago("",entity.getTipoGrupoFormaPagoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoGrupoFormaPago(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoGrupoFormaPago
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGrupoFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGrupoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoGrupoFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoGrupoFormaPago.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoGrupoFormaPago(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoGrupoFormaPago> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoGrupoFormaPago> entities = new  ArrayList<TipoGrupoFormaPago>();
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();		  
		
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
	
	public  List<TipoGrupoFormaPago> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoGrupoFormaPago> entities = new  ArrayList<TipoGrupoFormaPago>();
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGrupoFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGrupoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoGrupoFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGrupoFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,TipoGrupoFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoGrupoFormaPago("",entity,resultSet);
      	    	
				//entity.setTipoGrupoFormaPagoOriginal( new TipoGrupoFormaPago());
      	    	//entity.setTipoGrupoFormaPagoOriginal(super.getEntity("",entity.getTipoGrupoFormaPagoOriginal(),resultSet,TipoGrupoFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGrupoFormaPagoOriginal(this.getEntityTipoGrupoFormaPago("",entity.getTipoGrupoFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoGrupoFormaPagos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGrupoFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoGrupoFormaPago> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoGrupoFormaPago> entities = new  ArrayList<TipoGrupoFormaPago>();
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();		  
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
	
	public  List<TipoGrupoFormaPago> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoGrupoFormaPago> entities = new  ArrayList<TipoGrupoFormaPago>();
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGrupoFormaPago();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoGrupoFormaPago();
					//entity.setMapTipoGrupoFormaPago(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoGrupoFormaPagoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoGrupoFormaPago().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoGrupoFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=TipoGrupoFormaPagoDataAccess.getEntityTipoGrupoFormaPago("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoGrupoFormaPagoOriginal( new TipoGrupoFormaPago());
					////entity.setTipoGrupoFormaPagoOriginal(super.getEntity("",entity.getTipoGrupoFormaPagoOriginal(),resultSet,TipoGrupoFormaPagoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoGrupoFormaPagoOriginal(this.getEntityTipoGrupoFormaPago("",entity.getTipoGrupoFormaPagoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoGrupoFormaPagos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGrupoFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoGrupoFormaPago getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();		  
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
	
	public  TipoGrupoFormaPago getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGrupoFormaPago();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoGrupoFormaPago();
					//entity.setMapTipoGrupoFormaPago(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoGrupoFormaPagoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoGrupoFormaPago().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoGrupoFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=TipoGrupoFormaPagoDataAccess.getEntityTipoGrupoFormaPago("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoGrupoFormaPagoOriginal( new TipoGrupoFormaPago());
					////entity.setTipoGrupoFormaPagoOriginal(super.getEntity("",entity.getTipoGrupoFormaPagoOriginal(),resultSet,TipoGrupoFormaPagoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoGrupoFormaPagoOriginal(this.getEntityTipoGrupoFormaPago("",entity.getTipoGrupoFormaPagoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoGrupoFormaPago(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGrupoFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoGrupoFormaPago getEntityTipoGrupoFormaPago(String strPrefijo,TipoGrupoFormaPago entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoGrupoFormaPago.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoGrupoFormaPago.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoGrupoFormaPagoDataAccess.setFieldReflectionTipoGrupoFormaPago(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoGrupoFormaPago=TipoGrupoFormaPagoConstantesFunciones.getTodosTiposColumnasTipoGrupoFormaPago();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoGrupoFormaPago) {
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
							field = TipoGrupoFormaPago.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoGrupoFormaPago.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoGrupoFormaPagoDataAccess.setFieldReflectionTipoGrupoFormaPago(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoGrupoFormaPago(Field field,String strPrefijo,String sColumn,TipoGrupoFormaPago entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoGrupoFormaPagoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGrupoFormaPagoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoGrupoFormaPagoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoGrupoFormaPago>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoGrupoFormaPago> entities = new  ArrayList<TipoGrupoFormaPago>();
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGrupoFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGrupoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoGrupoFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoGrupoFormaPago();
					entity=super.getEntity("",entity,resultSet,TipoGrupoFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoGrupoFormaPago("",entity,resultSet);
					
					//entity.setTipoGrupoFormaPagoOriginal( new TipoGrupoFormaPago());
					//entity.setTipoGrupoFormaPagoOriginal(super.getEntity("",entity.getTipoGrupoFormaPagoOriginal(),resultSet,TipoGrupoFormaPagoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoGrupoFormaPagoOriginal(this.getEntityTipoGrupoFormaPago("",entity.getTipoGrupoFormaPagoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoGrupoFormaPagos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGrupoFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoGrupoFormaPago>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoGrupoFormaPago> entities = new  ArrayList<TipoGrupoFormaPago>();
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGrupoFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGrupoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoGrupoFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoGrupoFormaPago> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGrupoFormaPago> entities = new  ArrayList<TipoGrupoFormaPago>();
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();		  
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
	
	public  List<TipoGrupoFormaPago> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGrupoFormaPago> entities = new  ArrayList<TipoGrupoFormaPago>();
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGrupoFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,TipoGrupoFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoGrupoFormaPago("",entity,resultSet);
      	    	
				//entity.setTipoGrupoFormaPagoOriginal( new TipoGrupoFormaPago());
      	    	//entity.setTipoGrupoFormaPagoOriginal(super.getEntity("",entity.getTipoGrupoFormaPagoOriginal(),resultSet,TipoGrupoFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGrupoFormaPagoOriginal(this.getEntityTipoGrupoFormaPago("",entity.getTipoGrupoFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoGrupoFormaPagos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGrupoFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoGrupoFormaPago> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGrupoFormaPago> entities = new  ArrayList<TipoGrupoFormaPago>();
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();		  
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
	
	public  List<TipoGrupoFormaPago> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGrupoFormaPago> entities = new  ArrayList<TipoGrupoFormaPago>();
		TipoGrupoFormaPago entity = new TipoGrupoFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGrupoFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,TipoGrupoFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoGrupoFormaPago("",entity,resultSet);
      	    	
				//entity.setTipoGrupoFormaPagoOriginal( new TipoGrupoFormaPago());
      	    	//entity.setTipoGrupoFormaPagoOriginal(super.getEntity("",entity.getTipoGrupoFormaPagoOriginal(),resultSet,TipoGrupoFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGrupoFormaPagoOriginal(this.getEntityTipoGrupoFormaPago("",entity.getTipoGrupoFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoGrupoFormaPagos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoGrupoFormaPago getEntityTipoGrupoFormaPago(String strPrefijo,TipoGrupoFormaPago entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+TipoGrupoFormaPagoConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoGrupoFormaPagoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoGrupoFormaPago(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoGrupoFormaPago entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoGrupoFormaPagoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoGrupoFormaPagoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoGrupoFormaPagoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoGrupoFormaPagoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoGrupoFormaPagoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoGrupoFormaPagoDataAccess.TABLENAME,TipoGrupoFormaPagoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoGrupoFormaPagoDataAccess.setTipoGrupoFormaPagoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<TipoFormaPago> getTipoFormaPagos(Connexion connexion,TipoGrupoFormaPago tipogrupoformapago)throws SQLException,Exception {

		List<TipoFormaPago> tipoformapagos= new ArrayList<TipoFormaPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+".tipo_grupo_forma_pago ON "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id_tipo_grupo_forma_pago="+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+".tipo_grupo_forma_pago.id WHERE "+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+".tipo_grupo_forma_pago.id="+String.valueOf(tipogrupoformapago.getId());
			} else {
				sQuery=" INNER JOIN tipoformapago.TipoGrupoFormaPago WHERE tipoformapago.TipoGrupoFormaPago.id="+String.valueOf(tipogrupoformapago.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TipoFormaPagoDataAccess tipoformapagoDataAccess=new TipoFormaPagoDataAccess();

			tipoformapagoDataAccess.setConnexionType(this.connexionType);
			tipoformapagoDataAccess.setParameterDbType(this.parameterDbType);
			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoformapagos;

	}

	public List<DatoGeneralEmpleado> getDatoGeneralEmpleados(Connexion connexion,TipoGrupoFormaPago tipogrupoformapago)throws SQLException,Exception {

		List<DatoGeneralEmpleado> datogeneralempleados= new ArrayList<DatoGeneralEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+".tipo_grupo_forma_pago ON "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+".dato_general_empleado.id_tipo_grupo_forma_pago="+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+".tipo_grupo_forma_pago.id WHERE "+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+".tipo_grupo_forma_pago.id="+String.valueOf(tipogrupoformapago.getId());
			} else {
				sQuery=" INNER JOIN datogeneralempleado.TipoGrupoFormaPago WHERE datogeneralempleado.TipoGrupoFormaPago.id="+String.valueOf(tipogrupoformapago.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DatoGeneralEmpleadoDataAccess datogeneralempleadoDataAccess=new DatoGeneralEmpleadoDataAccess();

			datogeneralempleadoDataAccess.setConnexionType(this.connexionType);
			datogeneralempleadoDataAccess.setParameterDbType(this.parameterDbType);
			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return datogeneralempleados;

	}

	public List<AnticipoCliente> getAnticipoClientes(Connexion connexion,TipoGrupoFormaPago tipogrupoformapago)throws SQLException,Exception {

		List<AnticipoCliente> anticipoclientes= new ArrayList<AnticipoCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+".tipo_grupo_forma_pago ON "+AnticipoClienteConstantesFunciones.SCHEMA+".anticipo_cliente.id_tipo_grupo_forma_pago="+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+".tipo_grupo_forma_pago.id WHERE "+TipoGrupoFormaPagoConstantesFunciones.SCHEMA+".tipo_grupo_forma_pago.id="+String.valueOf(tipogrupoformapago.getId());
			} else {
				sQuery=" INNER JOIN anticipocliente.TipoGrupoFormaPago WHERE anticipocliente.TipoGrupoFormaPago.id="+String.valueOf(tipogrupoformapago.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AnticipoClienteDataAccess anticipoclienteDataAccess=new AnticipoClienteDataAccess();

			anticipoclienteDataAccess.setConnexionType(this.connexionType);
			anticipoclienteDataAccess.setParameterDbType(this.parameterDbType);
			anticipoclientes=anticipoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anticipoclientes;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoGrupoFormaPago tipogrupoformapago) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipogrupoformapago.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipogrupoformapago.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipogrupoformapago.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipogrupoformapago.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipogrupoformapago.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipogrupoformapago.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipogrupoformapago.getId());
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
	
	public void setIsNewIsChangedFalseTipoGrupoFormaPago(TipoGrupoFormaPago tipogrupoformapago)throws Exception  {		
		tipogrupoformapago.setIsNew(false);
		tipogrupoformapago.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoGrupoFormaPagos(List<TipoGrupoFormaPago> tipogrupoformapagos)throws Exception  {				
		for(TipoGrupoFormaPago tipogrupoformapago:tipogrupoformapagos) {
			tipogrupoformapago.setIsNew(false);
			tipogrupoformapago.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoGrupoFormaPago(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
