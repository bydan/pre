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
package com.bydan.erp.sris.business.dataaccess;

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

import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.sris.util.*;//TransaccionLocalConstantesFunciones;


import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class TransaccionLocalDataAccess extends  TransaccionLocalDataAccessAdditional{ //TransaccionLocalDataAccessAdditional,DataAccessHelper<TransaccionLocal>
	//static Logger logger = Logger.getLogger(TransaccionLocalDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="transaccion_local";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+"(version_row,id_compra,ruc,razon_social,id_periodo_declara,id_transaccion_conta,id_cliente,identificacion,id_tipo_comprobante,fecha_emision,fecha_registro_contable,numero_secuencial,numero_serie,numero_autorizacion,fecha_caducidad,id_tipo_tributario,numero_documento_contable,id_asiento_contable,es_rise,bienes_iva,bienes_sin_iva,id_tipo_iva,servicios_iva,servicios_sin_iva,monto_iva,total_iva,total_sin_iva,monto_ice,transfe_iva_retener,presta_iva_retener,id_tipo_retencion_iva,id_tipo_retencion_iva_presta,transfe_iva_retenido,presta_iva_retenido,permite_devolucion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_compra=?,ruc=?,razon_social=?,id_periodo_declara=?,id_transaccion_conta=?,id_cliente=?,identificacion=?,id_tipo_comprobante=?,fecha_emision=?,fecha_registro_contable=?,numero_secuencial=?,numero_serie=?,numero_autorizacion=?,fecha_caducidad=?,id_tipo_tributario=?,numero_documento_contable=?,id_asiento_contable=?,es_rise=?,bienes_iva=?,bienes_sin_iva=?,id_tipo_iva=?,servicios_iva=?,servicios_sin_iva=?,monto_iva=?,total_iva=?,total_sin_iva=?,monto_ice=?,transfe_iva_retener=?,presta_iva_retener=?,id_tipo_retencion_iva=?,id_tipo_retencion_iva_presta=?,transfe_iva_retenido=?,presta_iva_retenido=?,permite_devolucion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select transaccionlocal from "+TransaccionLocalConstantesFunciones.SPERSISTENCENAME+" transaccionlocal";
	public static String QUERYSELECTNATIVE="select "+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".version_row,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_compra,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".ruc,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".razon_social,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_periodo_declara,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_transaccion_conta,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_cliente,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".identificacion,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_tipo_comprobante,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".fecha_emision,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".fecha_registro_contable,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".numero_secuencial,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".numero_serie,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".numero_autorizacion,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".fecha_caducidad,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_tipo_tributario,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".numero_documento_contable,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_asiento_contable,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".es_rise,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".bienes_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".bienes_sin_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_tipo_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".servicios_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".servicios_sin_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".monto_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".total_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".total_sin_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".monto_ice,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".transfe_iva_retener,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".presta_iva_retener,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_tipo_retencion_iva,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id_tipo_retencion_iva_presta,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".transfe_iva_retenido,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".presta_iva_retenido,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".permite_devolucion from "+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME;//+" as "+TransaccionLocalConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".id,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".version_row,"+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+".razon_social from "+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME;//+" as "+TransaccionLocalConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TransaccionLocalConstantesFunciones.SCHEMA+"."+TransaccionLocalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_compra=?,ruc=?,razon_social=?,id_periodo_declara=?,id_transaccion_conta=?,id_cliente=?,identificacion=?,id_tipo_comprobante=?,fecha_emision=?,fecha_registro_contable=?,numero_secuencial=?,numero_serie=?,numero_autorizacion=?,fecha_caducidad=?,id_tipo_tributario=?,numero_documento_contable=?,id_asiento_contable=?,es_rise=?,bienes_iva=?,bienes_sin_iva=?,id_tipo_iva=?,servicios_iva=?,servicios_sin_iva=?,monto_iva=?,total_iva=?,total_sin_iva=?,monto_ice=?,transfe_iva_retener=?,presta_iva_retener=?,id_tipo_retencion_iva=?,id_tipo_retencion_iva_presta=?,transfe_iva_retenido=?,presta_iva_retenido=?,permite_devolucion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TRANSACCIONLOCAL_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TRANSACCIONLOCAL_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TRANSACCIONLOCAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TRANSACCIONLOCAL_SELECT(?,?)";
	
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
	
	
	protected TransaccionLocalDataAccessAdditional transaccionlocalDataAccessAdditional=null;
	
	public TransaccionLocalDataAccessAdditional getTransaccionLocalDataAccessAdditional() {
		return this.transaccionlocalDataAccessAdditional;
	}
	
	public void setTransaccionLocalDataAccessAdditional(TransaccionLocalDataAccessAdditional transaccionlocalDataAccessAdditional) {
		try {
			this.transaccionlocalDataAccessAdditional=transaccionlocalDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TransaccionLocalDataAccess() {
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
		TransaccionLocalDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TransaccionLocalDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TransaccionLocalDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTransaccionLocalOriginal(TransaccionLocal transaccionlocal)throws Exception  {
		transaccionlocal.setTransaccionLocalOriginal((TransaccionLocal)transaccionlocal.clone());		
	}
	
	public void setTransaccionLocalsOriginal(List<TransaccionLocal> transaccionlocals)throws Exception  {
		
		for(TransaccionLocal transaccionlocal:transaccionlocals){
			transaccionlocal.setTransaccionLocalOriginal((TransaccionLocal)transaccionlocal.clone());
		}
	}
	
	public static void setTransaccionLocalOriginalStatic(TransaccionLocal transaccionlocal)throws Exception  {
		transaccionlocal.setTransaccionLocalOriginal((TransaccionLocal)transaccionlocal.clone());		
	}
	
	public static void setTransaccionLocalsOriginalStatic(List<TransaccionLocal> transaccionlocals)throws Exception  {
		
		for(TransaccionLocal transaccionlocal:transaccionlocals){
			transaccionlocal.setTransaccionLocalOriginal((TransaccionLocal)transaccionlocal.clone());
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
	
	public  TransaccionLocal getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TransaccionLocal entity = new TransaccionLocal();		
		
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
	
	public  TransaccionLocal getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TransaccionLocal entity = new TransaccionLocal();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TransaccionLocalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransaccionLocalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Sris.TransaccionLocal.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTransaccionLocalOriginal(new TransaccionLocal());
      	    	entity=super.getEntity("",entity,resultSet,TransaccionLocalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTransaccionLocal("",entity,resultSet); 
				
				//entity.setTransaccionLocalOriginal(super.getEntity("",entity.getTransaccionLocalOriginal(),resultSet,TransaccionLocalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionLocalOriginal(this.getEntityTransaccionLocal("",entity.getTransaccionLocalOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTransaccionLocal(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TransaccionLocal getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TransaccionLocal entity = new TransaccionLocal();
				
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
	
	public  TransaccionLocal getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TransaccionLocal entity = new TransaccionLocal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TransaccionLocalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransaccionLocalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionLocalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Sris.TransaccionLocal.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTransaccionLocalOriginal(new TransaccionLocal());
      	    	entity=super.getEntity("",entity,resultSet,TransaccionLocalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTransaccionLocal("",entity,resultSet);    
				
				//entity.setTransaccionLocalOriginal(super.getEntity("",entity.getTransaccionLocalOriginal(),resultSet,TransaccionLocalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionLocalOriginal(this.getEntityTransaccionLocal("",entity.getTransaccionLocalOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTransaccionLocal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TransaccionLocal
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TransaccionLocal entity = new TransaccionLocal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransaccionLocalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransaccionLocalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionLocalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Sris.TransaccionLocal.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTransaccionLocal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TransaccionLocal> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TransaccionLocal> entities = new  ArrayList<TransaccionLocal>();
		TransaccionLocal entity = new TransaccionLocal();		  
		
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
	
	public  List<TransaccionLocal> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TransaccionLocal> entities = new  ArrayList<TransaccionLocal>();
		TransaccionLocal entity = new TransaccionLocal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TransaccionLocalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransaccionLocalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionLocalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionLocal();
      	    	entity=super.getEntity("",entity,resultSet,TransaccionLocalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransaccionLocal("",entity,resultSet);
      	    	
				//entity.setTransaccionLocalOriginal( new TransaccionLocal());
      	    	//entity.setTransaccionLocalOriginal(super.getEntity("",entity.getTransaccionLocalOriginal(),resultSet,TransaccionLocalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionLocalOriginal(this.getEntityTransaccionLocal("",entity.getTransaccionLocalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransaccionLocals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccionLocal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TransaccionLocal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TransaccionLocal> entities = new  ArrayList<TransaccionLocal>();
		TransaccionLocal entity = new TransaccionLocal();		  
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
	
	public  List<TransaccionLocal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TransaccionLocal> entities = new  ArrayList<TransaccionLocal>();
		TransaccionLocal entity = new TransaccionLocal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionLocal();
				
				if(conMapGenerico) {
					entity.inicializarMapTransaccionLocal();
					//entity.setMapTransaccionLocal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTransaccionLocalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTransaccionLocal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TransaccionLocalDataAccess.ISWITHSCHEMA);         		
					entity=TransaccionLocalDataAccess.getEntityTransaccionLocal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTransaccionLocalOriginal( new TransaccionLocal());
					////entity.setTransaccionLocalOriginal(super.getEntity("",entity.getTransaccionLocalOriginal(),resultSet,TransaccionLocalDataAccess.ISWITHSCHEMA));         		
					////entity.setTransaccionLocalOriginal(this.getEntityTransaccionLocal("",entity.getTransaccionLocalOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransaccionLocals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccionLocal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TransaccionLocal getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TransaccionLocal entity = new TransaccionLocal();		  
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
	
	public  TransaccionLocal getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TransaccionLocal entity = new TransaccionLocal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionLocal();
				
				if(conMapGenerico) {
					entity.inicializarMapTransaccionLocal();
					//entity.setMapTransaccionLocal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTransaccionLocalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTransaccionLocal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TransaccionLocalDataAccess.ISWITHSCHEMA);         		
					entity=TransaccionLocalDataAccess.getEntityTransaccionLocal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTransaccionLocalOriginal( new TransaccionLocal());
					////entity.setTransaccionLocalOriginal(super.getEntity("",entity.getTransaccionLocalOriginal(),resultSet,TransaccionLocalDataAccess.ISWITHSCHEMA));         		
					////entity.setTransaccionLocalOriginal(this.getEntityTransaccionLocal("",entity.getTransaccionLocalOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTransaccionLocal(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccionLocal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TransaccionLocal getEntityTransaccionLocal(String strPrefijo,TransaccionLocal entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TransaccionLocal.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TransaccionLocal.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TransaccionLocalDataAccess.setFieldReflectionTransaccionLocal(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTransaccionLocal=TransaccionLocalConstantesFunciones.getTodosTiposColumnasTransaccionLocal();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTransaccionLocal) {
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
							field = TransaccionLocal.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TransaccionLocal.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TransaccionLocalDataAccess.setFieldReflectionTransaccionLocal(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTransaccionLocal(Field field,String strPrefijo,String sColumn,TransaccionLocal entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TransaccionLocalConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.IDCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.RAZONSOCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.IDPERIODODECLARA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.IDTRANSACCIONCONTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.IDENTIFICACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.IDTIPOCOMPROBANTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case TransaccionLocalConstantesFunciones.FECHAREGISTROCONTABLE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case TransaccionLocalConstantesFunciones.NUMEROSECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.NUMEROSERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.NUMEROAUTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.FECHACADUCIDAD:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case TransaccionLocalConstantesFunciones.IDTIPOTRIBUTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.NUMERODOCUMENTOCONTABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.ESRISE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.BIENESIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.BIENESSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.IDTIPOIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.SERVICIOSIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.SERVICIOSSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.MONTOIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.TOTALIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.TOTALSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.MONTOICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.TRANSFEIVARETENER:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.PRESTAIVARETENER:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVAPRESTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.TRANSFEIVARETENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.PRESTAIVARETENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransaccionLocalConstantesFunciones.PERMITEDEVOLUCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TransaccionLocal>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TransaccionLocal> entities = new  ArrayList<TransaccionLocal>();
		TransaccionLocal entity = new TransaccionLocal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransaccionLocalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransaccionLocalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionLocalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TransaccionLocal();
					entity=super.getEntity("",entity,resultSet,TransaccionLocalDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTransaccionLocal("",entity,resultSet);
					
					//entity.setTransaccionLocalOriginal( new TransaccionLocal());
					//entity.setTransaccionLocalOriginal(super.getEntity("",entity.getTransaccionLocalOriginal(),resultSet,TransaccionLocalDataAccess.ISWITHSCHEMA));         		
					//entity.setTransaccionLocalOriginal(this.getEntityTransaccionLocal("",entity.getTransaccionLocalOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTransaccionLocals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccionLocal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TransaccionLocal>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TransaccionLocal> entities = new  ArrayList<TransaccionLocal>();
		TransaccionLocal entity = new TransaccionLocal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransaccionLocalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransaccionLocalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionLocalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TransaccionLocal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransaccionLocal> entities = new  ArrayList<TransaccionLocal>();
		TransaccionLocal entity = new TransaccionLocal();		  
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
	
	public  List<TransaccionLocal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransaccionLocal> entities = new  ArrayList<TransaccionLocal>();
		TransaccionLocal entity = new TransaccionLocal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionLocal();
      	    	entity=super.getEntity("",entity,resultSet,TransaccionLocalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransaccionLocal("",entity,resultSet);
      	    	
				//entity.setTransaccionLocalOriginal( new TransaccionLocal());
      	    	//entity.setTransaccionLocalOriginal(super.getEntity("",entity.getTransaccionLocalOriginal(),resultSet,TransaccionLocalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionLocalOriginal(this.getEntityTransaccionLocal("",entity.getTransaccionLocalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTransaccionLocals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccionLocal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TransaccionLocal> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransaccionLocal> entities = new  ArrayList<TransaccionLocal>();
		TransaccionLocal entity = new TransaccionLocal();		  
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
	
	public  List<TransaccionLocal> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransaccionLocal> entities = new  ArrayList<TransaccionLocal>();
		TransaccionLocal entity = new TransaccionLocal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionLocal();
      	    	entity=super.getEntity("",entity,resultSet,TransaccionLocalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransaccionLocal("",entity,resultSet);
      	    	
				//entity.setTransaccionLocalOriginal( new TransaccionLocal());
      	    	//entity.setTransaccionLocalOriginal(super.getEntity("",entity.getTransaccionLocalOriginal(),resultSet,TransaccionLocalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionLocalOriginal(this.getEntityTransaccionLocal("",entity.getTransaccionLocalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransaccionLocals(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TransaccionLocal getEntityTransaccionLocal(String strPrefijo,TransaccionLocal entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_compra(resultSet.getLong(strPrefijo+TransaccionLocalConstantesFunciones.IDCOMPRA));if(resultSet.wasNull()) {entity.setid_compra(null); }
				entity.setruc(resultSet.getString(strPrefijo+TransaccionLocalConstantesFunciones.RUC));
				entity.setrazon_social(resultSet.getString(strPrefijo+TransaccionLocalConstantesFunciones.RAZONSOCIAL));
				entity.setid_periodo_declara(resultSet.getLong(strPrefijo+TransaccionLocalConstantesFunciones.IDPERIODODECLARA));
				entity.setid_transaccion_conta(resultSet.getLong(strPrefijo+TransaccionLocalConstantesFunciones.IDTRANSACCIONCONTA));
				entity.setid_cliente(resultSet.getLong(strPrefijo+TransaccionLocalConstantesFunciones.IDCLIENTE));
				entity.setidentificacion(resultSet.getString(strPrefijo+TransaccionLocalConstantesFunciones.IDENTIFICACION));
				entity.setid_tipo_comprobante(resultSet.getLong(strPrefijo+TransaccionLocalConstantesFunciones.IDTIPOCOMPROBANTE));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+TransaccionLocalConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_registro_contable(new Date(resultSet.getDate(strPrefijo+TransaccionLocalConstantesFunciones.FECHAREGISTROCONTABLE).getTime()));
				entity.setnumero_secuencial(resultSet.getString(strPrefijo+TransaccionLocalConstantesFunciones.NUMEROSECUENCIAL));
				entity.setnumero_serie(resultSet.getString(strPrefijo+TransaccionLocalConstantesFunciones.NUMEROSERIE));
				entity.setnumero_autorizacion(resultSet.getString(strPrefijo+TransaccionLocalConstantesFunciones.NUMEROAUTORIZACION));
				entity.setfecha_caducidad(new Date(resultSet.getDate(strPrefijo+TransaccionLocalConstantesFunciones.FECHACADUCIDAD).getTime()));
				entity.setid_tipo_tributario(resultSet.getLong(strPrefijo+TransaccionLocalConstantesFunciones.IDTIPOTRIBUTARIO));
				entity.setnumero_documento_contable(resultSet.getString(strPrefijo+TransaccionLocalConstantesFunciones.NUMERODOCUMENTOCONTABLE));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+TransaccionLocalConstantesFunciones.IDASIENTOCONTABLE));if(resultSet.wasNull()) {entity.setid_asiento_contable(null); }
				entity.setes_rise(resultSet.getBoolean(strPrefijo+TransaccionLocalConstantesFunciones.ESRISE));
				entity.setbienes_iva(resultSet.getDouble(strPrefijo+TransaccionLocalConstantesFunciones.BIENESIVA));
				entity.setbienes_sin_iva(resultSet.getDouble(strPrefijo+TransaccionLocalConstantesFunciones.BIENESSINIVA));
				entity.setid_tipo_iva(resultSet.getLong(strPrefijo+TransaccionLocalConstantesFunciones.IDTIPOIVA));
				entity.setservicios_iva(resultSet.getDouble(strPrefijo+TransaccionLocalConstantesFunciones.SERVICIOSIVA));
				entity.setservicios_sin_iva(resultSet.getDouble(strPrefijo+TransaccionLocalConstantesFunciones.SERVICIOSSINIVA));
				entity.setmonto_iva(resultSet.getDouble(strPrefijo+TransaccionLocalConstantesFunciones.MONTOIVA));
				entity.settotal_iva(resultSet.getDouble(strPrefijo+TransaccionLocalConstantesFunciones.TOTALIVA));
				entity.settotal_sin_iva(resultSet.getDouble(strPrefijo+TransaccionLocalConstantesFunciones.TOTALSINIVA));
				entity.setmonto_ice(resultSet.getDouble(strPrefijo+TransaccionLocalConstantesFunciones.MONTOICE));
				entity.settransfe_iva_retener(resultSet.getDouble(strPrefijo+TransaccionLocalConstantesFunciones.TRANSFEIVARETENER));
				entity.setpresta_iva_retener(resultSet.getDouble(strPrefijo+TransaccionLocalConstantesFunciones.PRESTAIVARETENER));
				entity.setid_tipo_retencion_iva(resultSet.getLong(strPrefijo+TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVA));
				entity.setid_tipo_retencion_iva_presta(resultSet.getLong(strPrefijo+TransaccionLocalConstantesFunciones.IDTIPORETENCIONIVAPRESTA));
				entity.settransfe_iva_retenido(resultSet.getDouble(strPrefijo+TransaccionLocalConstantesFunciones.TRANSFEIVARETENIDO));
				entity.setpresta_iva_retenido(resultSet.getDouble(strPrefijo+TransaccionLocalConstantesFunciones.PRESTAIVARETENIDO));
				entity.setpermite_devolucion(resultSet.getBoolean(strPrefijo+TransaccionLocalConstantesFunciones.PERMITEDEVOLUCION));
			} else {
				entity.setrazon_social(resultSet.getString(strPrefijo+TransaccionLocalConstantesFunciones.RAZONSOCIAL));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTransaccionLocal(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TransaccionLocal entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TransaccionLocalDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TransaccionLocalDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TransaccionLocalDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TransaccionLocalDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TransaccionLocalConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TransaccionLocalDataAccess.TABLENAME,TransaccionLocalDataAccess.ISWITHSTOREPROCEDURES);
			
			TransaccionLocalDataAccess.setTransaccionLocalOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Compra getCompra(Connexion connexion,TransaccionLocal reltransaccionlocal)throws SQLException,Exception {

		Compra compra= new Compra();

		try {
			CompraDataAccess compraDataAccess=new CompraDataAccess();

			compraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			compraDataAccess.setConnexionType(this.connexionType);
			compraDataAccess.setParameterDbType(this.parameterDbType);

			compra=compraDataAccess.getEntity(connexion,reltransaccionlocal.getid_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return compra;

	}

	public PeriodoDeclara getPeriodoDeclara(Connexion connexion,TransaccionLocal reltransaccionlocal)throws SQLException,Exception {

		PeriodoDeclara periododeclara= new PeriodoDeclara();

		try {
			PeriodoDeclaraDataAccess periododeclaraDataAccess=new PeriodoDeclaraDataAccess();

			periododeclaraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periododeclaraDataAccess.setConnexionType(this.connexionType);
			periododeclaraDataAccess.setParameterDbType(this.parameterDbType);

			periododeclara=periododeclaraDataAccess.getEntity(connexion,reltransaccionlocal.getid_periodo_declara());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periododeclara;

	}

	public TransaccionConta getTransaccionConta(Connexion connexion,TransaccionLocal reltransaccionlocal)throws SQLException,Exception {

		TransaccionConta transaccionconta= new TransaccionConta();

		try {
			TransaccionContaDataAccess transaccioncontaDataAccess=new TransaccionContaDataAccess();

			transaccioncontaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccioncontaDataAccess.setConnexionType(this.connexionType);
			transaccioncontaDataAccess.setParameterDbType(this.parameterDbType);

			transaccionconta=transaccioncontaDataAccess.getEntity(connexion,reltransaccionlocal.getid_transaccion_conta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccionconta;

	}

	public Cliente getCliente(Connexion connexion,TransaccionLocal reltransaccionlocal)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,reltransaccionlocal.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoComprobante getTipoComprobante(Connexion connexion,TransaccionLocal reltransaccionlocal)throws SQLException,Exception {

		TipoComprobante tipocomprobante= new TipoComprobante();

		try {
			TipoComprobanteDataAccess tipocomprobanteDataAccess=new TipoComprobanteDataAccess();

			tipocomprobanteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocomprobanteDataAccess.setConnexionType(this.connexionType);
			tipocomprobanteDataAccess.setParameterDbType(this.parameterDbType);

			tipocomprobante=tipocomprobanteDataAccess.getEntity(connexion,reltransaccionlocal.getid_tipo_comprobante());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocomprobante;

	}

	public TipoTributario getTipoTributario(Connexion connexion,TransaccionLocal reltransaccionlocal)throws SQLException,Exception {

		TipoTributario tipotributario= new TipoTributario();

		try {
			TipoTributarioDataAccess tipotributarioDataAccess=new TipoTributarioDataAccess();

			tipotributarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotributarioDataAccess.setConnexionType(this.connexionType);
			tipotributarioDataAccess.setParameterDbType(this.parameterDbType);

			tipotributario=tipotributarioDataAccess.getEntity(connexion,reltransaccionlocal.getid_tipo_tributario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotributario;

	}

	public AsientoContable getAsientoContable(Connexion connexion,TransaccionLocal reltransaccionlocal)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,reltransaccionlocal.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}

	public TipoIva getTipoIva(Connexion connexion,TransaccionLocal reltransaccionlocal)throws SQLException,Exception {

		TipoIva tipoiva= new TipoIva();

		try {
			TipoIvaDataAccess tipoivaDataAccess=new TipoIvaDataAccess();

			tipoivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoivaDataAccess.setConnexionType(this.connexionType);
			tipoivaDataAccess.setParameterDbType(this.parameterDbType);

			tipoiva=tipoivaDataAccess.getEntity(connexion,reltransaccionlocal.getid_tipo_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoiva;

	}

	public TipoRetencionIva getTipoRetencionIva(Connexion connexion,TransaccionLocal reltransaccionlocal)throws SQLException,Exception {

		TipoRetencionIva tiporetencioniva= new TipoRetencionIva();

		try {
			TipoRetencionIvaDataAccess tiporetencionivaDataAccess=new TipoRetencionIvaDataAccess();

			tiporetencionivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionivaDataAccess.setConnexionType(this.connexionType);
			tiporetencionivaDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencioniva=tiporetencionivaDataAccess.getEntity(connexion,reltransaccionlocal.getid_tipo_retencion_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencioniva;

	}

	public TipoRetencionIva getTipoRetencionIvaPresta(Connexion connexion,TransaccionLocal reltransaccionlocal)throws SQLException,Exception {

		TipoRetencionIva tiporetencioniva= new TipoRetencionIva();

		try {
			TipoRetencionIvaDataAccess tiporetencionivaDataAccess=new TipoRetencionIvaDataAccess();

			tiporetencionivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionivaDataAccess.setConnexionType(this.connexionType);
			tiporetencionivaDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencioniva=tiporetencionivaDataAccess.getEntity(connexion,reltransaccionlocal.getid_tipo_retencion_iva_presta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencioniva;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TransaccionLocal transaccionlocal) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!transaccionlocal.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_compra.setValue(transaccionlocal.getid_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(transaccionlocal.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuerazon_social=new ParameterValue<String>();
					parameterMaintenanceValuerazon_social.setValue(transaccionlocal.getrazon_social());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuerazon_social);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo_declara=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo_declara.setValue(transaccionlocal.getid_periodo_declara());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo_declara);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_conta=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_conta.setValue(transaccionlocal.getid_transaccion_conta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_conta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(transaccionlocal.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueidentificacion=new ParameterValue<String>();
					parameterMaintenanceValueidentificacion.setValue(transaccionlocal.getidentificacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidentificacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_comprobante=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_comprobante.setValue(transaccionlocal.getid_tipo_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(transaccionlocal.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_registro_contable=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_registro_contable.setValue(transaccionlocal.getfecha_registro_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_registro_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_secuencial=new ParameterValue<String>();
					parameterMaintenanceValuenumero_secuencial.setValue(transaccionlocal.getnumero_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_secuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_serie=new ParameterValue<String>();
					parameterMaintenanceValuenumero_serie.setValue(transaccionlocal.getnumero_serie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_serie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_autorizacion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_autorizacion.setValue(transaccionlocal.getnumero_autorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_autorizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_caducidad=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_caducidad.setValue(transaccionlocal.getfecha_caducidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_caducidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_tributario=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_tributario.setValue(transaccionlocal.getid_tipo_tributario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_tributario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_documento_contable=new ParameterValue<String>();
					parameterMaintenanceValuenumero_documento_contable.setValue(transaccionlocal.getnumero_documento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_documento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(transaccionlocal.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_rise=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_rise.setValue(transaccionlocal.getes_rise());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_rise);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebienes_iva=new ParameterValue<Double>();
					parameterMaintenanceValuebienes_iva.setValue(transaccionlocal.getbienes_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebienes_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebienes_sin_iva=new ParameterValue<Double>();
					parameterMaintenanceValuebienes_sin_iva.setValue(transaccionlocal.getbienes_sin_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebienes_sin_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_iva=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_iva.setValue(transaccionlocal.getid_tipo_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueservicios_iva=new ParameterValue<Double>();
					parameterMaintenanceValueservicios_iva.setValue(transaccionlocal.getservicios_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueservicios_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueservicios_sin_iva=new ParameterValue<Double>();
					parameterMaintenanceValueservicios_sin_iva.setValue(transaccionlocal.getservicios_sin_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueservicios_sin_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_iva=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_iva.setValue(transaccionlocal.getmonto_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_iva.setValue(transaccionlocal.gettotal_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_sin_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_sin_iva.setValue(transaccionlocal.gettotal_sin_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_sin_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_ice=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_ice.setValue(transaccionlocal.getmonto_ice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_ice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetransfe_iva_retener=new ParameterValue<Double>();
					parameterMaintenanceValuetransfe_iva_retener.setValue(transaccionlocal.gettransfe_iva_retener());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetransfe_iva_retener);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuepresta_iva_retener=new ParameterValue<Double>();
					parameterMaintenanceValuepresta_iva_retener.setValue(transaccionlocal.getpresta_iva_retener());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepresta_iva_retener);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion_iva=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion_iva.setValue(transaccionlocal.getid_tipo_retencion_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion_iva_presta=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion_iva_presta.setValue(transaccionlocal.getid_tipo_retencion_iva_presta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion_iva_presta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetransfe_iva_retenido=new ParameterValue<Double>();
					parameterMaintenanceValuetransfe_iva_retenido.setValue(transaccionlocal.gettransfe_iva_retenido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetransfe_iva_retenido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuepresta_iva_retenido=new ParameterValue<Double>();
					parameterMaintenanceValuepresta_iva_retenido.setValue(transaccionlocal.getpresta_iva_retenido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepresta_iva_retenido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuepermite_devolucion=new ParameterValue<Boolean>();
					parameterMaintenanceValuepermite_devolucion.setValue(transaccionlocal.getpermite_devolucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepermite_devolucion);
					parametersTemp.add(parameterMaintenance);
					
						if(!transaccionlocal.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(transaccionlocal.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(transaccionlocal.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(transaccionlocal.getId());
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
	
	public void setIsNewIsChangedFalseTransaccionLocal(TransaccionLocal transaccionlocal)throws Exception  {		
		transaccionlocal.setIsNew(false);
		transaccionlocal.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTransaccionLocals(List<TransaccionLocal> transaccionlocals)throws Exception  {				
		for(TransaccionLocal transaccionlocal:transaccionlocals) {
			transaccionlocal.setIsNew(false);
			transaccionlocal.setIsChanged(false);
		}
	}
	
	public void generarExportarTransaccionLocal(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
