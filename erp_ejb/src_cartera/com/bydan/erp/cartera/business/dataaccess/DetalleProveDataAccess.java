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
package com.bydan.erp.cartera.business.dataaccess;

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

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//DetalleProveConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class DetalleProveDataAccess extends  DetalleProveDataAccessAdditional{ //DetalleProveDataAccessAdditional,DataAccessHelper<DetalleProve>
	//static Logger logger = Logger.getLogger(DetalleProveDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_prove";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_sucursal_movimiento,id_ejercicio,id_periodo,id_modulo,id_moneda,id_cliente,id_transaccion,id_tipo_transaccion_modulo,id_asiento_contable,id_factura,id_orden_compra,id_estado_detalle_cliente,fecha_venta,fecha_emision,fecha_pago,fecha_vencimiento,monto_mone_local,monto_mone_extra,numero_comprobante,numero_factura,debito_mone_local,credito_mone_local,debito_mone_extra,credito_mone_extra,descripcion,id_anio,id_mes)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_sucursal_movimiento=?,id_ejercicio=?,id_periodo=?,id_modulo=?,id_moneda=?,id_cliente=?,id_transaccion=?,id_tipo_transaccion_modulo=?,id_asiento_contable=?,id_factura=?,id_orden_compra=?,id_estado_detalle_cliente=?,fecha_venta=?,fecha_emision=?,fecha_pago=?,fecha_vencimiento=?,monto_mone_local=?,monto_mone_extra=?,numero_comprobante=?,numero_factura=?,debito_mone_local=?,credito_mone_local=?,debito_mone_extra=?,credito_mone_extra=?,descripcion=?,id_anio=?,id_mes=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleprove from "+DetalleProveConstantesFunciones.SPERSISTENCENAME+" detalleprove";
	public static String QUERYSELECTNATIVE="select "+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".version_row,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_empresa,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_sucursal_movimiento,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_periodo,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_modulo,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_moneda,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_cliente,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_transaccion,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_asiento_contable,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_factura,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_orden_compra,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_estado_detalle_cliente,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".fecha_venta,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".fecha_emision,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".fecha_pago,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".fecha_vencimiento,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".monto_mone_local,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".monto_mone_extra,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".numero_factura,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".debito_mone_local,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".credito_mone_local,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".debito_mone_extra,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".credito_mone_extra,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".descripcion,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_anio,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_mes from "+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME;//+" as "+DetalleProveConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".version_row from "+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME;//+" as "+DetalleProveConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_sucursal_movimiento=?,id_ejercicio=?,id_periodo=?,id_modulo=?,id_moneda=?,id_cliente=?,id_transaccion=?,id_tipo_transaccion_modulo=?,id_asiento_contable=?,id_factura=?,id_orden_compra=?,id_estado_detalle_cliente=?,fecha_venta=?,fecha_emision=?,fecha_pago=?,fecha_vencimiento=?,monto_mone_local=?,monto_mone_extra=?,numero_comprobante=?,numero_factura=?,debito_mone_local=?,credito_mone_local=?,debito_mone_extra=?,credito_mone_extra=?,descripcion=?,id_anio=?,id_mes=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEPROVE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEPROVE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEPROVE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEPROVE_SELECT(?,?)";
	
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
	
	
	protected DetalleProveDataAccessAdditional detalleproveDataAccessAdditional=null;
	
	public DetalleProveDataAccessAdditional getDetalleProveDataAccessAdditional() {
		return this.detalleproveDataAccessAdditional;
	}
	
	public void setDetalleProveDataAccessAdditional(DetalleProveDataAccessAdditional detalleproveDataAccessAdditional) {
		try {
			this.detalleproveDataAccessAdditional=detalleproveDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleProveDataAccess() {
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
		DetalleProveDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleProveDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleProveDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleProveOriginal(DetalleProve detalleprove)throws Exception  {
		detalleprove.setDetalleProveOriginal((DetalleProve)detalleprove.clone());		
	}
	
	public void setDetalleProvesOriginal(List<DetalleProve> detalleproves)throws Exception  {
		
		for(DetalleProve detalleprove:detalleproves){
			detalleprove.setDetalleProveOriginal((DetalleProve)detalleprove.clone());
		}
	}
	
	public static void setDetalleProveOriginalStatic(DetalleProve detalleprove)throws Exception  {
		detalleprove.setDetalleProveOriginal((DetalleProve)detalleprove.clone());		
	}
	
	public static void setDetalleProvesOriginalStatic(List<DetalleProve> detalleproves)throws Exception  {
		
		for(DetalleProve detalleprove:detalleproves){
			detalleprove.setDetalleProveOriginal((DetalleProve)detalleprove.clone());
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
	
	public  DetalleProve getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleProve entity = new DetalleProve();		
		
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
	
	public  DetalleProve getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleProve entity = new DetalleProve();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleProveDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.DetalleProve.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleProveOriginal(new DetalleProve());
      	    	entity=super.getEntity("",entity,resultSet,DetalleProveDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleProve("",entity,resultSet); 
				
				//entity.setDetalleProveOriginal(super.getEntity("",entity.getDetalleProveOriginal(),resultSet,DetalleProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleProveOriginal(this.getEntityDetalleProve("",entity.getDetalleProveOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleProve(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleProve getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleProve entity = new DetalleProve();
				
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
	
	public  DetalleProve getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleProve entity = new DetalleProve();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleProveDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.DetalleProve.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleProveOriginal(new DetalleProve());
      	    	entity=super.getEntity("",entity,resultSet,DetalleProveDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleProve("",entity,resultSet);    
				
				//entity.setDetalleProveOriginal(super.getEntity("",entity.getDetalleProveOriginal(),resultSet,DetalleProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleProveOriginal(this.getEntityDetalleProve("",entity.getDetalleProveOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleProve(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleProve
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleProve entity = new DetalleProve();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleProveDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.DetalleProve.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleProve(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleProve> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleProve> entities = new  ArrayList<DetalleProve>();
		DetalleProve entity = new DetalleProve();		  
		
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
	
	public  List<DetalleProve> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleProve> entities = new  ArrayList<DetalleProve>();
		DetalleProve entity = new DetalleProve();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleProveDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleProve();
      	    	entity=super.getEntity("",entity,resultSet,DetalleProveDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleProve("",entity,resultSet);
      	    	
				//entity.setDetalleProveOriginal( new DetalleProve());
      	    	//entity.setDetalleProveOriginal(super.getEntity("",entity.getDetalleProveOriginal(),resultSet,DetalleProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleProveOriginal(this.getEntityDetalleProve("",entity.getDetalleProveOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleProves(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleProve(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleProve> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleProve> entities = new  ArrayList<DetalleProve>();
		DetalleProve entity = new DetalleProve();		  
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
	
	public  List<DetalleProve> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleProve> entities = new  ArrayList<DetalleProve>();
		DetalleProve entity = new DetalleProve();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleProve();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleProve();
					//entity.setMapDetalleProve(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleProveValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleProve().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleProveDataAccess.ISWITHSCHEMA);         		
					entity=DetalleProveDataAccess.getEntityDetalleProve("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleProveOriginal( new DetalleProve());
					////entity.setDetalleProveOriginal(super.getEntity("",entity.getDetalleProveOriginal(),resultSet,DetalleProveDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleProveOriginal(this.getEntityDetalleProve("",entity.getDetalleProveOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleProves(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleProve(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleProve getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleProve entity = new DetalleProve();		  
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
	
	public  DetalleProve getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleProve entity = new DetalleProve();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleProve();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleProve();
					//entity.setMapDetalleProve(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleProveValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleProve().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleProveDataAccess.ISWITHSCHEMA);         		
					entity=DetalleProveDataAccess.getEntityDetalleProve("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleProveOriginal( new DetalleProve());
					////entity.setDetalleProveOriginal(super.getEntity("",entity.getDetalleProveOriginal(),resultSet,DetalleProveDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleProveOriginal(this.getEntityDetalleProve("",entity.getDetalleProveOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleProve(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleProve(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleProve getEntityDetalleProve(String strPrefijo,DetalleProve entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleProve.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleProve.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleProveDataAccess.setFieldReflectionDetalleProve(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleProve=DetalleProveConstantesFunciones.getTodosTiposColumnasDetalleProve();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleProve) {
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
							field = DetalleProve.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleProve.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleProveDataAccess.setFieldReflectionDetalleProve(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleProve(Field field,String strPrefijo,String sColumn,DetalleProve entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleProveConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.IDSUCURSALMOVIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.IDTIPOTRANSACCIONMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.IDORDENCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.IDESTADODETALLECLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.FECHAVENTA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleProveConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleProveConstantesFunciones.FECHAPAGO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleProveConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleProveConstantesFunciones.MONTOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.MONTOMONEEXTRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.DEBITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.CREDITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.DEBITOMONEEXTRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.CREDITOMONEEXTRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleProveConstantesFunciones.IDMES:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleProve>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleProve> entities = new  ArrayList<DetalleProve>();
		DetalleProve entity = new DetalleProve();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleProveDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleProve();
					entity=super.getEntity("",entity,resultSet,DetalleProveDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleProve("",entity,resultSet);
					
					//entity.setDetalleProveOriginal( new DetalleProve());
					//entity.setDetalleProveOriginal(super.getEntity("",entity.getDetalleProveOriginal(),resultSet,DetalleProveDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleProveOriginal(this.getEntityDetalleProve("",entity.getDetalleProveOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleProves(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleProve(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleProve>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleProve> entities = new  ArrayList<DetalleProve>();
		DetalleProve entity = new DetalleProve();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleProveDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleProve> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleProve> entities = new  ArrayList<DetalleProve>();
		DetalleProve entity = new DetalleProve();		  
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
	
	public  List<DetalleProve> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleProve> entities = new  ArrayList<DetalleProve>();
		DetalleProve entity = new DetalleProve();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleProve();
      	    	entity=super.getEntity("",entity,resultSet,DetalleProveDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleProve("",entity,resultSet);
      	    	
				//entity.setDetalleProveOriginal( new DetalleProve());
      	    	//entity.setDetalleProveOriginal(super.getEntity("",entity.getDetalleProveOriginal(),resultSet,DetalleProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleProveOriginal(this.getEntityDetalleProve("",entity.getDetalleProveOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleProves(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleProve(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleProve> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleProve> entities = new  ArrayList<DetalleProve>();
		DetalleProve entity = new DetalleProve();		  
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
	
	public  List<DetalleProve> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleProve> entities = new  ArrayList<DetalleProve>();
		DetalleProve entity = new DetalleProve();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleProve();
      	    	entity=super.getEntity("",entity,resultSet,DetalleProveDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleProve("",entity,resultSet);
      	    	
				//entity.setDetalleProveOriginal( new DetalleProve());
      	    	//entity.setDetalleProveOriginal(super.getEntity("",entity.getDetalleProveOriginal(),resultSet,DetalleProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleProveOriginal(this.getEntityDetalleProve("",entity.getDetalleProveOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleProves(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleProve getEntityDetalleProve(String strPrefijo,DetalleProve entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleProveConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleProveConstantesFunciones.IDSUCURSAL));
				entity.setid_sucursal_movimiento(resultSet.getLong(strPrefijo+DetalleProveConstantesFunciones.IDSUCURSALMOVIMIENTO));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleProveConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleProveConstantesFunciones.IDPERIODO));
				entity.setid_modulo(resultSet.getLong(strPrefijo+DetalleProveConstantesFunciones.IDMODULO));
				entity.setid_moneda(resultSet.getLong(strPrefijo+DetalleProveConstantesFunciones.IDMONEDA));
				entity.setid_cliente(resultSet.getLong(strPrefijo+DetalleProveConstantesFunciones.IDCLIENTE));
				entity.setid_transaccion(resultSet.getLong(strPrefijo+DetalleProveConstantesFunciones.IDTRANSACCION));
				entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+DetalleProveConstantesFunciones.IDTIPOTRANSACCIONMODULO));if(resultSet.wasNull()) {entity.setid_tipo_transaccion_modulo(null); }
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+DetalleProveConstantesFunciones.IDASIENTOCONTABLE));
				entity.setid_factura(resultSet.getLong(strPrefijo+DetalleProveConstantesFunciones.IDFACTURA));
				entity.setid_orden_compra(resultSet.getLong(strPrefijo+DetalleProveConstantesFunciones.IDORDENCOMPRA));if(resultSet.wasNull()) {entity.setid_orden_compra(null); }
				entity.setid_estado_detalle_cliente(resultSet.getLong(strPrefijo+DetalleProveConstantesFunciones.IDESTADODETALLECLIENTE));
				entity.setfecha_venta(new Date(resultSet.getDate(strPrefijo+DetalleProveConstantesFunciones.FECHAVENTA).getTime()));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+DetalleProveConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_pago(new Date(resultSet.getDate(strPrefijo+DetalleProveConstantesFunciones.FECHAPAGO).getTime()));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+DetalleProveConstantesFunciones.FECHAVENCIMIENTO).getTime()));
				entity.setmonto_mone_local(resultSet.getDouble(strPrefijo+DetalleProveConstantesFunciones.MONTOMONELOCAL));
				entity.setmonto_mone_extra(resultSet.getDouble(strPrefijo+DetalleProveConstantesFunciones.MONTOMONEEXTRA));
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+DetalleProveConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setnumero_factura(resultSet.getString(strPrefijo+DetalleProveConstantesFunciones.NUMEROFACTURA));
				entity.setdebito_mone_local(resultSet.getDouble(strPrefijo+DetalleProveConstantesFunciones.DEBITOMONELOCAL));
				entity.setcredito_mone_local(resultSet.getDouble(strPrefijo+DetalleProveConstantesFunciones.CREDITOMONELOCAL));
				entity.setdebito_mone_extra(resultSet.getDouble(strPrefijo+DetalleProveConstantesFunciones.DEBITOMONEEXTRA));
				entity.setcredito_mone_extra(resultSet.getDouble(strPrefijo+DetalleProveConstantesFunciones.CREDITOMONEEXTRA));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleProveConstantesFunciones.DESCRIPCION));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetalleProveConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetalleProveConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleProve(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleProve entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleProveDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleProveDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleProveDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleProveDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleProveConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleProveDataAccess.TABLENAME,DetalleProveDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleProveDataAccess.setDetalleProveOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleProve reldetalleprove)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleprove.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleProve reldetalleprove)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalleprove.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Sucursal getSucursalMovimiento(Connexion connexion,DetalleProve reldetalleprove)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalleprove.getid_sucursal_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleProve reldetalleprove)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetalleprove.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleProve reldetalleprove)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetalleprove.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Modulo getModulo(Connexion connexion,DetalleProve reldetalleprove)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,reldetalleprove.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Moneda getMoneda(Connexion connexion,DetalleProve reldetalleprove)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,reldetalleprove.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Cliente getCliente(Connexion connexion,DetalleProve reldetalleprove)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,reldetalleprove.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Transaccion getTransaccion(Connexion connexion,DetalleProve reldetalleprove)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,reldetalleprove.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,DetalleProve reldetalleprove)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,reldetalleprove.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}

	public AsientoContable getAsientoContable(Connexion connexion,DetalleProve reldetalleprove)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,reldetalleprove.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}

	public Factura getFactura(Connexion connexion,DetalleProve reldetalleprove)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,reldetalleprove.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public OrdenCompra getOrdenCompra(Connexion connexion,DetalleProve reldetalleprove)throws SQLException,Exception {

		OrdenCompra ordencompra= new OrdenCompra();

		try {
			OrdenCompraDataAccess ordencompraDataAccess=new OrdenCompraDataAccess();

			ordencompraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ordencompraDataAccess.setConnexionType(this.connexionType);
			ordencompraDataAccess.setParameterDbType(this.parameterDbType);

			ordencompra=ordencompraDataAccess.getEntity(connexion,reldetalleprove.getid_orden_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordencompra;

	}

	public EstadoDetalleCliente getEstadoDetalleCliente(Connexion connexion,DetalleProve reldetalleprove)throws SQLException,Exception {

		EstadoDetalleCliente estadodetallecliente= new EstadoDetalleCliente();

		try {
			EstadoDetalleClienteDataAccess estadodetalleclienteDataAccess=new EstadoDetalleClienteDataAccess();

			estadodetalleclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadodetalleclienteDataAccess.setConnexionType(this.connexionType);
			estadodetalleclienteDataAccess.setParameterDbType(this.parameterDbType);

			estadodetallecliente=estadodetalleclienteDataAccess.getEntity(connexion,reldetalleprove.getid_estado_detalle_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadodetallecliente;

	}

	public Anio getAnio(Connexion connexion,DetalleProve reldetalleprove)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetalleprove.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetalleProve reldetalleprove)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetalleprove.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
		public List<PagoAuto> getPagoAutos(Connexion connexion,DetalleProve detalleprove)throws SQLException,Exception {

		List<PagoAuto> pagoautos= new ArrayList<PagoAuto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleProveConstantesFunciones.SCHEMA+".detalle_prove ON "+PagoAutoConstantesFunciones.SCHEMA+".pago_auto.id_detalle_prove="+DetalleProveConstantesFunciones.SCHEMA+".detalle_prove.id WHERE "+DetalleProveConstantesFunciones.SCHEMA+".detalle_prove.id="+String.valueOf(detalleprove.getId());
			} else {
				sQuery=" INNER JOIN pagoauto.DetalleProve WHERE pagoauto.DetalleProve.id="+String.valueOf(detalleprove.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PagoAutoDataAccess pagoautoDataAccess=new PagoAutoDataAccess();

			pagoautoDataAccess.setConnexionType(this.connexionType);
			pagoautoDataAccess.setParameterDbType(this.parameterDbType);
			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pagoautos;

	}

	public List<AutoriPago> getAutoriPagos(Connexion connexion,DetalleProve detalleprove)throws SQLException,Exception {

		List<AutoriPago> autoripagos= new ArrayList<AutoriPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleProveConstantesFunciones.SCHEMA+".detalle_prove ON "+AutoriPagoConstantesFunciones.SCHEMA+".autori_pago.id_detalle_prove="+DetalleProveConstantesFunciones.SCHEMA+".detalle_prove.id WHERE "+DetalleProveConstantesFunciones.SCHEMA+".detalle_prove.id="+String.valueOf(detalleprove.getId());
			} else {
				sQuery=" INNER JOIN autoripago.DetalleProve WHERE autoripago.DetalleProve.id="+String.valueOf(detalleprove.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AutoriPagoDataAccess autoripagoDataAccess=new AutoriPagoDataAccess();

			autoripagoDataAccess.setConnexionType(this.connexionType);
			autoripagoDataAccess.setParameterDbType(this.parameterDbType);
			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return autoripagos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleProve detalleprove) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleprove.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleprove.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalleprove.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal_movimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal_movimiento.setValue(detalleprove.getid_sucursal_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal_movimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detalleprove.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detalleprove.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(detalleprove.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(detalleprove.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(detalleprove.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(detalleprove.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_transaccion_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_transaccion_modulo.setValue(detalleprove.getid_tipo_transaccion_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_transaccion_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(detalleprove.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(detalleprove.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_orden_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_orden_compra.setValue(detalleprove.getid_orden_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_orden_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_detalle_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_detalle_cliente.setValue(detalleprove.getid_estado_detalle_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_detalle_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_venta=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_venta.setValue(detalleprove.getfecha_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(detalleprove.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_pago=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_pago.setValue(detalleprove.getfecha_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(detalleprove.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_mone_local=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_mone_local.setValue(detalleprove.getmonto_mone_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_mone_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_mone_extra=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_mone_extra.setValue(detalleprove.getmonto_mone_extra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_mone_extra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(detalleprove.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_factura=new ParameterValue<String>();
					parameterMaintenanceValuenumero_factura.setValue(detalleprove.getnumero_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedebito_mone_local=new ParameterValue<Double>();
					parameterMaintenanceValuedebito_mone_local.setValue(detalleprove.getdebito_mone_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedebito_mone_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecredito_mone_local=new ParameterValue<Double>();
					parameterMaintenanceValuecredito_mone_local.setValue(detalleprove.getcredito_mone_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecredito_mone_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedebito_mone_extra=new ParameterValue<Double>();
					parameterMaintenanceValuedebito_mone_extra.setValue(detalleprove.getdebito_mone_extra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedebito_mone_extra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecredito_mone_extra=new ParameterValue<Double>();
					parameterMaintenanceValuecredito_mone_extra.setValue(detalleprove.getcredito_mone_extra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecredito_mone_extra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detalleprove.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detalleprove.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detalleprove.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleprove.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleprove.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleprove.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleprove.getId());
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
	
	public void setIsNewIsChangedFalseDetalleProve(DetalleProve detalleprove)throws Exception  {		
		detalleprove.setIsNew(false);
		detalleprove.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleProves(List<DetalleProve> detalleproves)throws Exception  {				
		for(DetalleProve detalleprove:detalleproves) {
			detalleprove.setIsNew(false);
			detalleprove.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleProve(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
