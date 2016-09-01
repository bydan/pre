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
import com.bydan.erp.cartera.util.*;//DetalleClienteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class DetalleClienteDataAccess extends  DetalleClienteDataAccessAdditional{ //DetalleClienteDataAccessAdditional,DataAccessHelper<DetalleCliente>
	//static Logger logger = Logger.getLogger(DetalleClienteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_cliente";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_modulo,id_asiento_contable,id_cliente,id_transaccion,id_factura,numero_factura,fecha_vence,descripcion,debito_mone_local,credito_mone_local,debito_mone_extra,credito_mone_extra,id_moneda,cotizacion,id_sucursal_movimiento,id_tipo_transaccion_modulo,fecha_emision,beneficiario,monto_mone_local,monto_mone_extra,numero_comprobante,id_estado_detalle_cliente)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_modulo=?,id_asiento_contable=?,id_cliente=?,id_transaccion=?,id_factura=?,numero_factura=?,fecha_vence=?,descripcion=?,debito_mone_local=?,credito_mone_local=?,debito_mone_extra=?,credito_mone_extra=?,id_moneda=?,cotizacion=?,id_sucursal_movimiento=?,id_tipo_transaccion_modulo=?,fecha_emision=?,beneficiario=?,monto_mone_local=?,monto_mone_extra=?,numero_comprobante=?,id_estado_detalle_cliente=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallecliente from "+DetalleClienteConstantesFunciones.SPERSISTENCENAME+" detallecliente";
	public static String QUERYSELECTNATIVE="select "+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".version_row,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_empresa,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_periodo,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_anio,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_mes,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_modulo,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_asiento_contable,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_cliente,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_transaccion,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_factura,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".numero_factura,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".fecha_vence,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".descripcion,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".debito_mone_local,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".credito_mone_local,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".debito_mone_extra,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".credito_mone_extra,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_moneda,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".cotizacion,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_sucursal_movimiento,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".fecha_emision,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".beneficiario,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".monto_mone_local,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".monto_mone_extra,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_estado_detalle_cliente from "+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME;//+" as "+DetalleClienteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".version_row from "+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME;//+" as "+DetalleClienteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_modulo=?,id_asiento_contable=?,id_cliente=?,id_transaccion=?,id_factura=?,numero_factura=?,fecha_vence=?,descripcion=?,debito_mone_local=?,credito_mone_local=?,debito_mone_extra=?,credito_mone_extra=?,id_moneda=?,cotizacion=?,id_sucursal_movimiento=?,id_tipo_transaccion_modulo=?,fecha_emision=?,beneficiario=?,monto_mone_local=?,monto_mone_extra=?,numero_comprobante=?,id_estado_detalle_cliente=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLECLIENTE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLECLIENTE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLECLIENTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLECLIENTE_SELECT(?,?)";
	
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
	
	
	protected DetalleClienteDataAccessAdditional detalleclienteDataAccessAdditional=null;
	
	public DetalleClienteDataAccessAdditional getDetalleClienteDataAccessAdditional() {
		return this.detalleclienteDataAccessAdditional;
	}
	
	public void setDetalleClienteDataAccessAdditional(DetalleClienteDataAccessAdditional detalleclienteDataAccessAdditional) {
		try {
			this.detalleclienteDataAccessAdditional=detalleclienteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleClienteDataAccess() {
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
		DetalleClienteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleClienteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleClienteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleClienteOriginal(DetalleCliente detallecliente)throws Exception  {
		detallecliente.setDetalleClienteOriginal((DetalleCliente)detallecliente.clone());		
	}
	
	public void setDetalleClientesOriginal(List<DetalleCliente> detalleclientes)throws Exception  {
		
		for(DetalleCliente detallecliente:detalleclientes){
			detallecliente.setDetalleClienteOriginal((DetalleCliente)detallecliente.clone());
		}
	}
	
	public static void setDetalleClienteOriginalStatic(DetalleCliente detallecliente)throws Exception  {
		detallecliente.setDetalleClienteOriginal((DetalleCliente)detallecliente.clone());		
	}
	
	public static void setDetalleClientesOriginalStatic(List<DetalleCliente> detalleclientes)throws Exception  {
		
		for(DetalleCliente detallecliente:detalleclientes){
			detallecliente.setDetalleClienteOriginal((DetalleCliente)detallecliente.clone());
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
	
	public  DetalleCliente getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleCliente entity = new DetalleCliente();		
		
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
	
	public  DetalleCliente getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleCliente entity = new DetalleCliente();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.DetalleCliente.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleClienteOriginal(new DetalleCliente());
      	    	entity=super.getEntity("",entity,resultSet,DetalleClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleCliente("",entity,resultSet); 
				
				//entity.setDetalleClienteOriginal(super.getEntity("",entity.getDetalleClienteOriginal(),resultSet,DetalleClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleClienteOriginal(this.getEntityDetalleCliente("",entity.getDetalleClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleCliente(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleCliente getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleCliente entity = new DetalleCliente();
				
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
	
	public  DetalleCliente getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleCliente entity = new DetalleCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.DetalleCliente.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleClienteOriginal(new DetalleCliente());
      	    	entity=super.getEntity("",entity,resultSet,DetalleClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleCliente("",entity,resultSet);    
				
				//entity.setDetalleClienteOriginal(super.getEntity("",entity.getDetalleClienteOriginal(),resultSet,DetalleClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleClienteOriginal(this.getEntityDetalleCliente("",entity.getDetalleClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleCliente
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleCliente entity = new DetalleCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.DetalleCliente.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleCliente> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleCliente> entities = new  ArrayList<DetalleCliente>();
		DetalleCliente entity = new DetalleCliente();		  
		
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
	
	public  List<DetalleCliente> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleCliente> entities = new  ArrayList<DetalleCliente>();
		DetalleCliente entity = new DetalleCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCliente();
      	    	entity=super.getEntity("",entity,resultSet,DetalleClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleCliente("",entity,resultSet);
      	    	
				//entity.setDetalleClienteOriginal( new DetalleCliente());
      	    	//entity.setDetalleClienteOriginal(super.getEntity("",entity.getDetalleClienteOriginal(),resultSet,DetalleClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleClienteOriginal(this.getEntityDetalleCliente("",entity.getDetalleClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleClientes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleCliente> entities = new  ArrayList<DetalleCliente>();
		DetalleCliente entity = new DetalleCliente();		  
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
	
	public  List<DetalleCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleCliente> entities = new  ArrayList<DetalleCliente>();
		DetalleCliente entity = new DetalleCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleCliente();
					//entity.setMapDetalleCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleClienteDataAccess.ISWITHSCHEMA);         		
					entity=DetalleClienteDataAccess.getEntityDetalleCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleClienteOriginal( new DetalleCliente());
					////entity.setDetalleClienteOriginal(super.getEntity("",entity.getDetalleClienteOriginal(),resultSet,DetalleClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleClienteOriginal(this.getEntityDetalleCliente("",entity.getDetalleClienteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleClientes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleCliente getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleCliente entity = new DetalleCliente();		  
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
	
	public  DetalleCliente getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleCliente entity = new DetalleCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleCliente();
					//entity.setMapDetalleCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleClienteDataAccess.ISWITHSCHEMA);         		
					entity=DetalleClienteDataAccess.getEntityDetalleCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleClienteOriginal( new DetalleCliente());
					////entity.setDetalleClienteOriginal(super.getEntity("",entity.getDetalleClienteOriginal(),resultSet,DetalleClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleClienteOriginal(this.getEntityDetalleCliente("",entity.getDetalleClienteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleCliente(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleCliente getEntityDetalleCliente(String strPrefijo,DetalleCliente entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleCliente.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleClienteDataAccess.setFieldReflectionDetalleCliente(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleCliente=DetalleClienteConstantesFunciones.getTodosTiposColumnasDetalleCliente();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleCliente) {
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
							field = DetalleCliente.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleClienteDataAccess.setFieldReflectionDetalleCliente(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleCliente(Field field,String strPrefijo,String sColumn,DetalleCliente entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleClienteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.FECHAVENCE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleClienteConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.DEBITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.CREDITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.DEBITOMONEEXTRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.CREDITOMONEEXTRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.COTIZACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.IDSUCURSALMOVIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.IDTIPOTRANSACCIONMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleClienteConstantesFunciones.BENEFICIARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.MONTOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.MONTOMONEEXTRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleClienteConstantesFunciones.IDESTADODETALLECLIENTE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleCliente>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleCliente> entities = new  ArrayList<DetalleCliente>();
		DetalleCliente entity = new DetalleCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleCliente();
					entity=super.getEntity("",entity,resultSet,DetalleClienteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleCliente("",entity,resultSet);
					
					//entity.setDetalleClienteOriginal( new DetalleCliente());
					//entity.setDetalleClienteOriginal(super.getEntity("",entity.getDetalleClienteOriginal(),resultSet,DetalleClienteDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleClienteOriginal(this.getEntityDetalleCliente("",entity.getDetalleClienteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleClientes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleCliente>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleCliente> entities = new  ArrayList<DetalleCliente>();
		DetalleCliente entity = new DetalleCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleCliente> entities = new  ArrayList<DetalleCliente>();
		DetalleCliente entity = new DetalleCliente();		  
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
	
	public  List<DetalleCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleCliente> entities = new  ArrayList<DetalleCliente>();
		DetalleCliente entity = new DetalleCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCliente();
      	    	entity=super.getEntity("",entity,resultSet,DetalleClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleCliente("",entity,resultSet);
      	    	
				//entity.setDetalleClienteOriginal( new DetalleCliente());
      	    	//entity.setDetalleClienteOriginal(super.getEntity("",entity.getDetalleClienteOriginal(),resultSet,DetalleClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleClienteOriginal(this.getEntityDetalleCliente("",entity.getDetalleClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleClientes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleCliente> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleCliente> entities = new  ArrayList<DetalleCliente>();
		DetalleCliente entity = new DetalleCliente();		  
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
	
	public  List<DetalleCliente> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleCliente> entities = new  ArrayList<DetalleCliente>();
		DetalleCliente entity = new DetalleCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCliente();
      	    	entity=super.getEntity("",entity,resultSet,DetalleClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleCliente("",entity,resultSet);
      	    	
				//entity.setDetalleClienteOriginal( new DetalleCliente());
      	    	//entity.setDetalleClienteOriginal(super.getEntity("",entity.getDetalleClienteOriginal(),resultSet,DetalleClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleClienteOriginal(this.getEntityDetalleCliente("",entity.getDetalleClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleClientes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleCliente getEntityDetalleCliente(String strPrefijo,DetalleCliente entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleClienteConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleClienteConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleClienteConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleClienteConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetalleClienteConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetalleClienteConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_modulo(resultSet.getLong(strPrefijo+DetalleClienteConstantesFunciones.IDMODULO));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+DetalleClienteConstantesFunciones.IDASIENTOCONTABLE));
				entity.setid_cliente(resultSet.getLong(strPrefijo+DetalleClienteConstantesFunciones.IDCLIENTE));
				entity.setid_transaccion(resultSet.getLong(strPrefijo+DetalleClienteConstantesFunciones.IDTRANSACCION));
				entity.setid_factura(resultSet.getLong(strPrefijo+DetalleClienteConstantesFunciones.IDFACTURA));
				entity.setnumero_factura(resultSet.getString(strPrefijo+DetalleClienteConstantesFunciones.NUMEROFACTURA));
				entity.setfecha_vence(new Date(resultSet.getDate(strPrefijo+DetalleClienteConstantesFunciones.FECHAVENCE).getTime()));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleClienteConstantesFunciones.DESCRIPCION));
				entity.setdebito_mone_local(resultSet.getDouble(strPrefijo+DetalleClienteConstantesFunciones.DEBITOMONELOCAL));
				entity.setcredito_mone_local(resultSet.getDouble(strPrefijo+DetalleClienteConstantesFunciones.CREDITOMONELOCAL));
				entity.setdebito_mone_extra(resultSet.getDouble(strPrefijo+DetalleClienteConstantesFunciones.DEBITOMONEEXTRA));
				entity.setcredito_mone_extra(resultSet.getDouble(strPrefijo+DetalleClienteConstantesFunciones.CREDITOMONEEXTRA));
				entity.setid_moneda(resultSet.getLong(strPrefijo+DetalleClienteConstantesFunciones.IDMONEDA));
				entity.setcotizacion(resultSet.getDouble(strPrefijo+DetalleClienteConstantesFunciones.COTIZACION));
				entity.setid_sucursal_movimiento(resultSet.getLong(strPrefijo+DetalleClienteConstantesFunciones.IDSUCURSALMOVIMIENTO));
				entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+DetalleClienteConstantesFunciones.IDTIPOTRANSACCIONMODULO));if(resultSet.wasNull()) {entity.setid_tipo_transaccion_modulo(null); }
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+DetalleClienteConstantesFunciones.FECHAEMISION).getTime()));
				entity.setbeneficiario(resultSet.getString(strPrefijo+DetalleClienteConstantesFunciones.BENEFICIARIO));
				entity.setmonto_mone_local(resultSet.getDouble(strPrefijo+DetalleClienteConstantesFunciones.MONTOMONELOCAL));
				entity.setmonto_mone_extra(resultSet.getDouble(strPrefijo+DetalleClienteConstantesFunciones.MONTOMONEEXTRA));
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+DetalleClienteConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setid_estado_detalle_cliente(resultSet.getLong(strPrefijo+DetalleClienteConstantesFunciones.IDESTADODETALLECLIENTE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleCliente(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleCliente entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleClienteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleClienteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleClienteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleClienteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleClienteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleClienteDataAccess.TABLENAME,DetalleClienteDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleClienteDataAccess.setDetalleClienteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleCliente reldetallecliente)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallecliente.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleCliente reldetallecliente)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallecliente.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleCliente reldetallecliente)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetallecliente.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleCliente reldetallecliente)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetallecliente.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,DetalleCliente reldetallecliente)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetallecliente.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetalleCliente reldetallecliente)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetallecliente.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Modulo getModulo(Connexion connexion,DetalleCliente reldetallecliente)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,reldetallecliente.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public AsientoContable getAsientoContable(Connexion connexion,DetalleCliente reldetallecliente)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,reldetallecliente.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}

	public Cliente getCliente(Connexion connexion,DetalleCliente reldetallecliente)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,reldetallecliente.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Transaccion getTransaccion(Connexion connexion,DetalleCliente reldetallecliente)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,reldetallecliente.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Factura getFactura(Connexion connexion,DetalleCliente reldetallecliente)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,reldetallecliente.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public Moneda getMoneda(Connexion connexion,DetalleCliente reldetallecliente)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,reldetallecliente.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Sucursal getSucursalMovimiento(Connexion connexion,DetalleCliente reldetallecliente)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallecliente.getid_sucursal_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,DetalleCliente reldetallecliente)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,reldetallecliente.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}

	public EstadoDetalleCliente getEstadoDetalleCliente(Connexion connexion,DetalleCliente reldetallecliente)throws SQLException,Exception {

		EstadoDetalleCliente estadodetallecliente= new EstadoDetalleCliente();

		try {
			EstadoDetalleClienteDataAccess estadodetalleclienteDataAccess=new EstadoDetalleClienteDataAccess();

			estadodetalleclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadodetalleclienteDataAccess.setConnexionType(this.connexionType);
			estadodetalleclienteDataAccess.setParameterDbType(this.parameterDbType);

			estadodetallecliente=estadodetalleclienteDataAccess.getEntity(connexion,reldetallecliente.getid_estado_detalle_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadodetallecliente;

	}


		
		public List<DetalleRecap> getDetalleRecaps(Connexion connexion,DetalleCliente detallecliente)throws SQLException,Exception {

		List<DetalleRecap> detallerecaps= new ArrayList<DetalleRecap>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleClienteConstantesFunciones.SCHEMA+".detalle_cliente ON "+DetalleRecapConstantesFunciones.SCHEMA+".detalle_recap.id_detalle_cliente="+DetalleClienteConstantesFunciones.SCHEMA+".detalle_cliente.id WHERE "+DetalleClienteConstantesFunciones.SCHEMA+".detalle_cliente.id="+String.valueOf(detallecliente.getId());
			} else {
				sQuery=" INNER JOIN detallerecap.DetalleCliente WHERE detallerecap.DetalleCliente.id="+String.valueOf(detallecliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleRecapDataAccess detallerecapDataAccess=new DetalleRecapDataAccess();

			detallerecapDataAccess.setConnexionType(this.connexionType);
			detallerecapDataAccess.setParameterDbType(this.parameterDbType);
			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallerecaps;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleCliente detallecliente) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallecliente.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallecliente.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detallecliente.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detallecliente.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detallecliente.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detallecliente.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detallecliente.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(detallecliente.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(detallecliente.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(detallecliente.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(detallecliente.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(detallecliente.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_factura=new ParameterValue<String>();
					parameterMaintenanceValuenumero_factura.setValue(detallecliente.getnumero_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vence=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vence.setValue(detallecliente.getfecha_vence());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vence);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detallecliente.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedebito_mone_local=new ParameterValue<Double>();
					parameterMaintenanceValuedebito_mone_local.setValue(detallecliente.getdebito_mone_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedebito_mone_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecredito_mone_local=new ParameterValue<Double>();
					parameterMaintenanceValuecredito_mone_local.setValue(detallecliente.getcredito_mone_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecredito_mone_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedebito_mone_extra=new ParameterValue<Double>();
					parameterMaintenanceValuedebito_mone_extra.setValue(detallecliente.getdebito_mone_extra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedebito_mone_extra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecredito_mone_extra=new ParameterValue<Double>();
					parameterMaintenanceValuecredito_mone_extra.setValue(detallecliente.getcredito_mone_extra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecredito_mone_extra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(detallecliente.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecotizacion=new ParameterValue<Double>();
					parameterMaintenanceValuecotizacion.setValue(detallecliente.getcotizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecotizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal_movimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal_movimiento.setValue(detallecliente.getid_sucursal_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal_movimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_transaccion_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_transaccion_modulo.setValue(detallecliente.getid_tipo_transaccion_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_transaccion_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(detallecliente.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuebeneficiario=new ParameterValue<String>();
					parameterMaintenanceValuebeneficiario.setValue(detallecliente.getbeneficiario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebeneficiario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_mone_local=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_mone_local.setValue(detallecliente.getmonto_mone_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_mone_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_mone_extra=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_mone_extra.setValue(detallecliente.getmonto_mone_extra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_mone_extra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(detallecliente.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_detalle_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_detalle_cliente.setValue(detallecliente.getid_estado_detalle_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_detalle_cliente);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallecliente.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallecliente.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallecliente.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallecliente.getId());
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
	
	public void setIsNewIsChangedFalseDetalleCliente(DetalleCliente detallecliente)throws Exception  {		
		detallecliente.setIsNew(false);
		detallecliente.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleClientes(List<DetalleCliente> detalleclientes)throws Exception  {				
		for(DetalleCliente detallecliente:detalleclientes) {
			detallecliente.setIsNew(false);
			detallecliente.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleCliente(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
