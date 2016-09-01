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
package com.bydan.erp.puntoventa.business.dataaccess;

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

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//TarjetaCreditoDescuentoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TarjetaCreditoDescuentoDataAccess extends  TarjetaCreditoDescuentoDataAccessAdditional{ //TarjetaCreditoDescuentoDataAccessAdditional,DataAccessHelper<TarjetaCreditoDescuento>
	//static Logger logger = Logger.getLogger(TarjetaCreditoDescuentoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tarjeta_credito_descuento";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_tarjeta_credito,porcentaje,numero_meses,es_corriente,con_interes)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tarjeta_credito=?,porcentaje=?,numero_meses=?,es_corriente=?,con_interes=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tarjetacreditodescuento from "+TarjetaCreditoDescuentoConstantesFunciones.SPERSISTENCENAME+" tarjetacreditodescuento";
	public static String QUERYSELECTNATIVE="select "+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".id,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".version_row,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".id_empresa,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".id_sucursal,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".id_tarjeta_credito,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".porcentaje,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".numero_meses,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".es_corriente,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".con_interes from "+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME;//+" as "+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".id,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".version_row from "+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME;//+" as "+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tarjeta_credito=?,porcentaje=?,numero_meses=?,es_corriente=?,con_interes=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TARJETACREDITODESCUENTO_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TARJETACREDITODESCUENTO_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TARJETACREDITODESCUENTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TARJETACREDITODESCUENTO_SELECT(?,?)";
	
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
	
	
	protected TarjetaCreditoDescuentoDataAccessAdditional tarjetacreditodescuentoDataAccessAdditional=null;
	
	public TarjetaCreditoDescuentoDataAccessAdditional getTarjetaCreditoDescuentoDataAccessAdditional() {
		return this.tarjetacreditodescuentoDataAccessAdditional;
	}
	
	public void setTarjetaCreditoDescuentoDataAccessAdditional(TarjetaCreditoDescuentoDataAccessAdditional tarjetacreditodescuentoDataAccessAdditional) {
		try {
			this.tarjetacreditodescuentoDataAccessAdditional=tarjetacreditodescuentoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TarjetaCreditoDescuentoDataAccess() {
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
		TarjetaCreditoDescuentoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TarjetaCreditoDescuentoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TarjetaCreditoDescuentoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTarjetaCreditoDescuentoOriginal(TarjetaCreditoDescuento tarjetacreditodescuento)throws Exception  {
		tarjetacreditodescuento.setTarjetaCreditoDescuentoOriginal((TarjetaCreditoDescuento)tarjetacreditodescuento.clone());		
	}
	
	public void setTarjetaCreditoDescuentosOriginal(List<TarjetaCreditoDescuento> tarjetacreditodescuentos)throws Exception  {
		
		for(TarjetaCreditoDescuento tarjetacreditodescuento:tarjetacreditodescuentos){
			tarjetacreditodescuento.setTarjetaCreditoDescuentoOriginal((TarjetaCreditoDescuento)tarjetacreditodescuento.clone());
		}
	}
	
	public static void setTarjetaCreditoDescuentoOriginalStatic(TarjetaCreditoDescuento tarjetacreditodescuento)throws Exception  {
		tarjetacreditodescuento.setTarjetaCreditoDescuentoOriginal((TarjetaCreditoDescuento)tarjetacreditodescuento.clone());		
	}
	
	public static void setTarjetaCreditoDescuentosOriginalStatic(List<TarjetaCreditoDescuento> tarjetacreditodescuentos)throws Exception  {
		
		for(TarjetaCreditoDescuento tarjetacreditodescuento:tarjetacreditodescuentos){
			tarjetacreditodescuento.setTarjetaCreditoDescuentoOriginal((TarjetaCreditoDescuento)tarjetacreditodescuento.clone());
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
	
	public  TarjetaCreditoDescuento getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();		
		
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
	
	public  TarjetaCreditoDescuento getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TarjetaCreditoDescuentoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TarjetaCreditoDescuentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.TarjetaCreditoDescuento.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTarjetaCreditoDescuentoOriginal(new TarjetaCreditoDescuento());
      	    	entity=super.getEntity("",entity,resultSet,TarjetaCreditoDescuentoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTarjetaCreditoDescuento("",entity,resultSet); 
				
				//entity.setTarjetaCreditoDescuentoOriginal(super.getEntity("",entity.getTarjetaCreditoDescuentoOriginal(),resultSet,TarjetaCreditoDescuentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTarjetaCreditoDescuentoOriginal(this.getEntityTarjetaCreditoDescuento("",entity.getTarjetaCreditoDescuentoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTarjetaCreditoDescuento(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TarjetaCreditoDescuento getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();
				
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
	
	public  TarjetaCreditoDescuento getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TarjetaCreditoDescuentoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TarjetaCreditoDescuentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TarjetaCreditoDescuentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.TarjetaCreditoDescuento.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTarjetaCreditoDescuentoOriginal(new TarjetaCreditoDescuento());
      	    	entity=super.getEntity("",entity,resultSet,TarjetaCreditoDescuentoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTarjetaCreditoDescuento("",entity,resultSet);    
				
				//entity.setTarjetaCreditoDescuentoOriginal(super.getEntity("",entity.getTarjetaCreditoDescuentoOriginal(),resultSet,TarjetaCreditoDescuentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTarjetaCreditoDescuentoOriginal(this.getEntityTarjetaCreditoDescuento("",entity.getTarjetaCreditoDescuentoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTarjetaCreditoDescuento(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TarjetaCreditoDescuento
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TarjetaCreditoDescuentoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TarjetaCreditoDescuentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TarjetaCreditoDescuentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.TarjetaCreditoDescuento.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTarjetaCreditoDescuento(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TarjetaCreditoDescuento> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TarjetaCreditoDescuento> entities = new  ArrayList<TarjetaCreditoDescuento>();
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();		  
		
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
	
	public  List<TarjetaCreditoDescuento> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TarjetaCreditoDescuento> entities = new  ArrayList<TarjetaCreditoDescuento>();
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TarjetaCreditoDescuentoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TarjetaCreditoDescuentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TarjetaCreditoDescuentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetaCreditoDescuento();
      	    	entity=super.getEntity("",entity,resultSet,TarjetaCreditoDescuentoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTarjetaCreditoDescuento("",entity,resultSet);
      	    	
				//entity.setTarjetaCreditoDescuentoOriginal( new TarjetaCreditoDescuento());
      	    	//entity.setTarjetaCreditoDescuentoOriginal(super.getEntity("",entity.getTarjetaCreditoDescuentoOriginal(),resultSet,TarjetaCreditoDescuentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTarjetaCreditoDescuentoOriginal(this.getEntityTarjetaCreditoDescuento("",entity.getTarjetaCreditoDescuentoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTarjetaCreditoDescuentos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTarjetaCreditoDescuento(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TarjetaCreditoDescuento> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TarjetaCreditoDescuento> entities = new  ArrayList<TarjetaCreditoDescuento>();
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();		  
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
	
	public  List<TarjetaCreditoDescuento> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TarjetaCreditoDescuento> entities = new  ArrayList<TarjetaCreditoDescuento>();
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetaCreditoDescuento();
				
				if(conMapGenerico) {
					entity.inicializarMapTarjetaCreditoDescuento();
					//entity.setMapTarjetaCreditoDescuento(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTarjetaCreditoDescuentoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTarjetaCreditoDescuento().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TarjetaCreditoDescuentoDataAccess.ISWITHSCHEMA);         		
					entity=TarjetaCreditoDescuentoDataAccess.getEntityTarjetaCreditoDescuento("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTarjetaCreditoDescuentoOriginal( new TarjetaCreditoDescuento());
					////entity.setTarjetaCreditoDescuentoOriginal(super.getEntity("",entity.getTarjetaCreditoDescuentoOriginal(),resultSet,TarjetaCreditoDescuentoDataAccess.ISWITHSCHEMA));         		
					////entity.setTarjetaCreditoDescuentoOriginal(this.getEntityTarjetaCreditoDescuento("",entity.getTarjetaCreditoDescuentoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTarjetaCreditoDescuentos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTarjetaCreditoDescuento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TarjetaCreditoDescuento getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();		  
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
	
	public  TarjetaCreditoDescuento getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetaCreditoDescuento();
				
				if(conMapGenerico) {
					entity.inicializarMapTarjetaCreditoDescuento();
					//entity.setMapTarjetaCreditoDescuento(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTarjetaCreditoDescuentoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTarjetaCreditoDescuento().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TarjetaCreditoDescuentoDataAccess.ISWITHSCHEMA);         		
					entity=TarjetaCreditoDescuentoDataAccess.getEntityTarjetaCreditoDescuento("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTarjetaCreditoDescuentoOriginal( new TarjetaCreditoDescuento());
					////entity.setTarjetaCreditoDescuentoOriginal(super.getEntity("",entity.getTarjetaCreditoDescuentoOriginal(),resultSet,TarjetaCreditoDescuentoDataAccess.ISWITHSCHEMA));         		
					////entity.setTarjetaCreditoDescuentoOriginal(this.getEntityTarjetaCreditoDescuento("",entity.getTarjetaCreditoDescuentoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTarjetaCreditoDescuento(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTarjetaCreditoDescuento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TarjetaCreditoDescuento getEntityTarjetaCreditoDescuento(String strPrefijo,TarjetaCreditoDescuento entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TarjetaCreditoDescuento.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TarjetaCreditoDescuento.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TarjetaCreditoDescuentoDataAccess.setFieldReflectionTarjetaCreditoDescuento(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTarjetaCreditoDescuento=TarjetaCreditoDescuentoConstantesFunciones.getTodosTiposColumnasTarjetaCreditoDescuento();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTarjetaCreditoDescuento) {
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
							field = TarjetaCreditoDescuento.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TarjetaCreditoDescuento.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TarjetaCreditoDescuentoDataAccess.setFieldReflectionTarjetaCreditoDescuento(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTarjetaCreditoDescuento(Field field,String strPrefijo,String sColumn,TarjetaCreditoDescuento entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TarjetaCreditoDescuentoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoDescuentoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TarjetaCreditoDescuentoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoDescuentoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoDescuentoConstantesFunciones.IDTARJETACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoDescuentoConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TarjetaCreditoDescuentoConstantesFunciones.NUMEROMESES:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case TarjetaCreditoDescuentoConstantesFunciones.ESCORRIENTE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TarjetaCreditoDescuentoConstantesFunciones.CONINTERES:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TarjetaCreditoDescuento>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TarjetaCreditoDescuento> entities = new  ArrayList<TarjetaCreditoDescuento>();
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TarjetaCreditoDescuentoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TarjetaCreditoDescuentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TarjetaCreditoDescuentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TarjetaCreditoDescuento();
					entity=super.getEntity("",entity,resultSet,TarjetaCreditoDescuentoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTarjetaCreditoDescuento("",entity,resultSet);
					
					//entity.setTarjetaCreditoDescuentoOriginal( new TarjetaCreditoDescuento());
					//entity.setTarjetaCreditoDescuentoOriginal(super.getEntity("",entity.getTarjetaCreditoDescuentoOriginal(),resultSet,TarjetaCreditoDescuentoDataAccess.ISWITHSCHEMA));         		
					//entity.setTarjetaCreditoDescuentoOriginal(this.getEntityTarjetaCreditoDescuento("",entity.getTarjetaCreditoDescuentoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTarjetaCreditoDescuentos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTarjetaCreditoDescuento(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TarjetaCreditoDescuento>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TarjetaCreditoDescuento> entities = new  ArrayList<TarjetaCreditoDescuento>();
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TarjetaCreditoDescuentoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TarjetaCreditoDescuentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TarjetaCreditoDescuentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TarjetaCreditoDescuento> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TarjetaCreditoDescuento> entities = new  ArrayList<TarjetaCreditoDescuento>();
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();		  
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
	
	public  List<TarjetaCreditoDescuento> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TarjetaCreditoDescuento> entities = new  ArrayList<TarjetaCreditoDescuento>();
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetaCreditoDescuento();
      	    	entity=super.getEntity("",entity,resultSet,TarjetaCreditoDescuentoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTarjetaCreditoDescuento("",entity,resultSet);
      	    	
				//entity.setTarjetaCreditoDescuentoOriginal( new TarjetaCreditoDescuento());
      	    	//entity.setTarjetaCreditoDescuentoOriginal(super.getEntity("",entity.getTarjetaCreditoDescuentoOriginal(),resultSet,TarjetaCreditoDescuentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTarjetaCreditoDescuentoOriginal(this.getEntityTarjetaCreditoDescuento("",entity.getTarjetaCreditoDescuentoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTarjetaCreditoDescuentos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTarjetaCreditoDescuento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TarjetaCreditoDescuento> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TarjetaCreditoDescuento> entities = new  ArrayList<TarjetaCreditoDescuento>();
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();		  
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
	
	public  List<TarjetaCreditoDescuento> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TarjetaCreditoDescuento> entities = new  ArrayList<TarjetaCreditoDescuento>();
		TarjetaCreditoDescuento entity = new TarjetaCreditoDescuento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetaCreditoDescuento();
      	    	entity=super.getEntity("",entity,resultSet,TarjetaCreditoDescuentoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTarjetaCreditoDescuento("",entity,resultSet);
      	    	
				//entity.setTarjetaCreditoDescuentoOriginal( new TarjetaCreditoDescuento());
      	    	//entity.setTarjetaCreditoDescuentoOriginal(super.getEntity("",entity.getTarjetaCreditoDescuentoOriginal(),resultSet,TarjetaCreditoDescuentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTarjetaCreditoDescuentoOriginal(this.getEntityTarjetaCreditoDescuento("",entity.getTarjetaCreditoDescuentoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTarjetaCreditoDescuentos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TarjetaCreditoDescuento getEntityTarjetaCreditoDescuento(String strPrefijo,TarjetaCreditoDescuento entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TarjetaCreditoDescuentoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+TarjetaCreditoDescuentoConstantesFunciones.IDSUCURSAL));
				entity.setid_tarjeta_credito(resultSet.getLong(strPrefijo+TarjetaCreditoDescuentoConstantesFunciones.IDTARJETACREDITO));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+TarjetaCreditoDescuentoConstantesFunciones.PORCENTAJE));
				entity.setnumero_meses(resultSet.getInt(strPrefijo+TarjetaCreditoDescuentoConstantesFunciones.NUMEROMESES));
				entity.setes_corriente(resultSet.getBoolean(strPrefijo+TarjetaCreditoDescuentoConstantesFunciones.ESCORRIENTE));
				entity.setcon_interes(resultSet.getBoolean(strPrefijo+TarjetaCreditoDescuentoConstantesFunciones.CONINTERES));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTarjetaCreditoDescuento(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TarjetaCreditoDescuento entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TarjetaCreditoDescuentoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TarjetaCreditoDescuentoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TarjetaCreditoDescuentoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TarjetaCreditoDescuentoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TarjetaCreditoDescuentoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TarjetaCreditoDescuentoDataAccess.TABLENAME,TarjetaCreditoDescuentoDataAccess.ISWITHSTOREPROCEDURES);
			
			TarjetaCreditoDescuentoDataAccess.setTarjetaCreditoDescuentoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TarjetaCreditoDescuento reltarjetacreditodescuento)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltarjetacreditodescuento.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,TarjetaCreditoDescuento reltarjetacreditodescuento)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reltarjetacreditodescuento.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TarjetaCredito getTarjetaCredito(Connexion connexion,TarjetaCreditoDescuento reltarjetacreditodescuento)throws SQLException,Exception {

		TarjetaCredito tarjetacredito= new TarjetaCredito();

		try {
			TarjetaCreditoDataAccess tarjetacreditoDataAccess=new TarjetaCreditoDataAccess();

			tarjetacreditoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tarjetacreditoDataAccess.setConnexionType(this.connexionType);
			tarjetacreditoDataAccess.setParameterDbType(this.parameterDbType);

			tarjetacredito=tarjetacreditoDataAccess.getEntity(connexion,reltarjetacreditodescuento.getid_tarjeta_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tarjetacredito;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TarjetaCreditoDescuento tarjetacreditodescuento) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tarjetacreditodescuento.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tarjetacreditodescuento.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(tarjetacreditodescuento.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tarjeta_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_tarjeta_credito.setValue(tarjetacreditodescuento.getid_tarjeta_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tarjeta_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(tarjetacreditodescuento.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_meses=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_meses.setValue(tarjetacreditodescuento.getnumero_meses());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_meses);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_corriente=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_corriente.setValue(tarjetacreditodescuento.getes_corriente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_corriente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_interes=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_interes.setValue(tarjetacreditodescuento.getcon_interes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_interes);
					parametersTemp.add(parameterMaintenance);
					
						if(!tarjetacreditodescuento.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tarjetacreditodescuento.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tarjetacreditodescuento.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tarjetacreditodescuento.getId());
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
	
	public void setIsNewIsChangedFalseTarjetaCreditoDescuento(TarjetaCreditoDescuento tarjetacreditodescuento)throws Exception  {		
		tarjetacreditodescuento.setIsNew(false);
		tarjetacreditodescuento.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTarjetaCreditoDescuentos(List<TarjetaCreditoDescuento> tarjetacreditodescuentos)throws Exception  {				
		for(TarjetaCreditoDescuento tarjetacreditodescuento:tarjetacreditodescuentos) {
			tarjetacreditodescuento.setIsNew(false);
			tarjetacreditodescuento.setIsChanged(false);
		}
	}
	
	public void generarExportarTarjetaCreditoDescuento(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
