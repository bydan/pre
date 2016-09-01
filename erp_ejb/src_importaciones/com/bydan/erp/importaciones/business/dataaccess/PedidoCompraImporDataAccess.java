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
package com.bydan.erp.importaciones.business.dataaccess;

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

import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.importaciones.util.*;//PedidoCompraImporConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class PedidoCompraImporDataAccess extends  PedidoCompraImporDataAccessAdditional{ //PedidoCompraImporDataAccessAdditional,DataAccessHelper<PedidoCompraImpor>
	//static Logger logger = Logger.getLogger(PedidoCompraImporDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="pedido_compra_impor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_modulo,id_ejercicio,id_periodo,id_pais,id_cliente,id_cliente_proveedor,id_empleado,id_usuario,id_tipo_cambio,id_moneda,id_tipo_prorrateo_impor,id_embarcador,id_tipo_via_transporte,id_puerto,id_puerto_destino,id_tipo_terminos_impor,id_estado_pedido_compra,forma_pago,numero_dui,secuencial,numero_orden,uso_en,responsable,orden_compra,lugar_entrega,descripcion,fecha,fecha_emision,fecha_entrega,fecha_entrega_cliente,nombre_seguro,nombre_consignatario,precios,flete,seguro,gastos,cfr,cif,total,id_formato,id_anio,id_mes)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_ejercicio=?,id_periodo=?,id_pais=?,id_cliente=?,id_cliente_proveedor=?,id_empleado=?,id_usuario=?,id_tipo_cambio=?,id_moneda=?,id_tipo_prorrateo_impor=?,id_embarcador=?,id_tipo_via_transporte=?,id_puerto=?,id_puerto_destino=?,id_tipo_terminos_impor=?,id_estado_pedido_compra=?,forma_pago=?,numero_dui=?,secuencial=?,numero_orden=?,uso_en=?,responsable=?,orden_compra=?,lugar_entrega=?,descripcion=?,fecha=?,fecha_emision=?,fecha_entrega=?,fecha_entrega_cliente=?,nombre_seguro=?,nombre_consignatario=?,precios=?,flete=?,seguro=?,gastos=?,cfr=?,cif=?,total=?,id_formato=?,id_anio=?,id_mes=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select pedidocompraimpor from "+PedidoCompraImporConstantesFunciones.SPERSISTENCENAME+" pedidocompraimpor";
	public static String QUERYSELECTNATIVE="select "+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".version_row,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_empresa,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_sucursal,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_modulo,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_ejercicio,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_periodo,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_pais,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_cliente,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_cliente_proveedor,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_empleado,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_usuario,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_tipo_cambio,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_moneda,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_tipo_prorrateo_impor,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_embarcador,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_tipo_via_transporte,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_puerto,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_puerto_destino,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_tipo_terminos_impor,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_estado_pedido_compra,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".forma_pago,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".numero_dui,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".secuencial,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".numero_orden,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".uso_en,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".responsable,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".orden_compra,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".lugar_entrega,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".descripcion,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".fecha,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".fecha_emision,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".fecha_entrega,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".fecha_entrega_cliente,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".nombre_seguro,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".nombre_consignatario,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".precios,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".flete,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".seguro,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".gastos,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".cfr,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".cif,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".total,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_formato,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_anio,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id_mes from "+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME;//+" as "+PedidoCompraImporConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".id,"+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+".version_row from "+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME;//+" as "+PedidoCompraImporConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PedidoCompraImporConstantesFunciones.SCHEMA+"."+PedidoCompraImporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_ejercicio=?,id_periodo=?,id_pais=?,id_cliente=?,id_cliente_proveedor=?,id_empleado=?,id_usuario=?,id_tipo_cambio=?,id_moneda=?,id_tipo_prorrateo_impor=?,id_embarcador=?,id_tipo_via_transporte=?,id_puerto=?,id_puerto_destino=?,id_tipo_terminos_impor=?,id_estado_pedido_compra=?,forma_pago=?,numero_dui=?,secuencial=?,numero_orden=?,uso_en=?,responsable=?,orden_compra=?,lugar_entrega=?,descripcion=?,fecha=?,fecha_emision=?,fecha_entrega=?,fecha_entrega_cliente=?,nombre_seguro=?,nombre_consignatario=?,precios=?,flete=?,seguro=?,gastos=?,cfr=?,cif=?,total=?,id_formato=?,id_anio=?,id_mes=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PEDIDOCOMPRAIMPOR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PEDIDOCOMPRAIMPOR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PEDIDOCOMPRAIMPOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PEDIDOCOMPRAIMPOR_SELECT(?,?)";
	
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
	
	
	protected PedidoCompraImporDataAccessAdditional pedidocompraimporDataAccessAdditional=null;
	
	public PedidoCompraImporDataAccessAdditional getPedidoCompraImporDataAccessAdditional() {
		return this.pedidocompraimporDataAccessAdditional;
	}
	
	public void setPedidoCompraImporDataAccessAdditional(PedidoCompraImporDataAccessAdditional pedidocompraimporDataAccessAdditional) {
		try {
			this.pedidocompraimporDataAccessAdditional=pedidocompraimporDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PedidoCompraImporDataAccess() {
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
		PedidoCompraImporDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PedidoCompraImporDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PedidoCompraImporDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPedidoCompraImporOriginal(PedidoCompraImpor pedidocompraimpor)throws Exception  {
		pedidocompraimpor.setPedidoCompraImporOriginal((PedidoCompraImpor)pedidocompraimpor.clone());		
	}
	
	public void setPedidoCompraImporsOriginal(List<PedidoCompraImpor> pedidocompraimpors)throws Exception  {
		
		for(PedidoCompraImpor pedidocompraimpor:pedidocompraimpors){
			pedidocompraimpor.setPedidoCompraImporOriginal((PedidoCompraImpor)pedidocompraimpor.clone());
		}
	}
	
	public static void setPedidoCompraImporOriginalStatic(PedidoCompraImpor pedidocompraimpor)throws Exception  {
		pedidocompraimpor.setPedidoCompraImporOriginal((PedidoCompraImpor)pedidocompraimpor.clone());		
	}
	
	public static void setPedidoCompraImporsOriginalStatic(List<PedidoCompraImpor> pedidocompraimpors)throws Exception  {
		
		for(PedidoCompraImpor pedidocompraimpor:pedidocompraimpors){
			pedidocompraimpor.setPedidoCompraImporOriginal((PedidoCompraImpor)pedidocompraimpor.clone());
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
	
	public  PedidoCompraImpor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PedidoCompraImpor entity = new PedidoCompraImpor();		
		
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
	
	public  PedidoCompraImpor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PedidoCompraImpor entity = new PedidoCompraImpor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoCompraImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoCompraImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Importaciones.PedidoCompraImpor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPedidoCompraImporOriginal(new PedidoCompraImpor());
      	    	entity=super.getEntity("",entity,resultSet,PedidoCompraImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPedidoCompraImpor("",entity,resultSet); 
				
				//entity.setPedidoCompraImporOriginal(super.getEntity("",entity.getPedidoCompraImporOriginal(),resultSet,PedidoCompraImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoCompraImporOriginal(this.getEntityPedidoCompraImpor("",entity.getPedidoCompraImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePedidoCompraImpor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PedidoCompraImpor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PedidoCompraImpor entity = new PedidoCompraImpor();
				
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
	
	public  PedidoCompraImpor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PedidoCompraImpor entity = new PedidoCompraImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoCompraImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoCompraImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoCompraImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.PedidoCompraImpor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPedidoCompraImporOriginal(new PedidoCompraImpor());
      	    	entity=super.getEntity("",entity,resultSet,PedidoCompraImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPedidoCompraImpor("",entity,resultSet);    
				
				//entity.setPedidoCompraImporOriginal(super.getEntity("",entity.getPedidoCompraImporOriginal(),resultSet,PedidoCompraImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoCompraImporOriginal(this.getEntityPedidoCompraImpor("",entity.getPedidoCompraImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePedidoCompraImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PedidoCompraImpor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PedidoCompraImpor entity = new PedidoCompraImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoCompraImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoCompraImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoCompraImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.PedidoCompraImpor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePedidoCompraImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PedidoCompraImpor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PedidoCompraImpor> entities = new  ArrayList<PedidoCompraImpor>();
		PedidoCompraImpor entity = new PedidoCompraImpor();		  
		
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
	
	public  List<PedidoCompraImpor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PedidoCompraImpor> entities = new  ArrayList<PedidoCompraImpor>();
		PedidoCompraImpor entity = new PedidoCompraImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoCompraImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoCompraImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoCompraImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoCompraImpor();
      	    	entity=super.getEntity("",entity,resultSet,PedidoCompraImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoCompraImpor("",entity,resultSet);
      	    	
				//entity.setPedidoCompraImporOriginal( new PedidoCompraImpor());
      	    	//entity.setPedidoCompraImporOriginal(super.getEntity("",entity.getPedidoCompraImporOriginal(),resultSet,PedidoCompraImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoCompraImporOriginal(this.getEntityPedidoCompraImpor("",entity.getPedidoCompraImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoCompraImpors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoCompraImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PedidoCompraImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PedidoCompraImpor> entities = new  ArrayList<PedidoCompraImpor>();
		PedidoCompraImpor entity = new PedidoCompraImpor();		  
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
	
	public  List<PedidoCompraImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PedidoCompraImpor> entities = new  ArrayList<PedidoCompraImpor>();
		PedidoCompraImpor entity = new PedidoCompraImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoCompraImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapPedidoCompraImpor();
					//entity.setMapPedidoCompraImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPedidoCompraImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPedidoCompraImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PedidoCompraImporDataAccess.ISWITHSCHEMA);         		
					entity=PedidoCompraImporDataAccess.getEntityPedidoCompraImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPedidoCompraImporOriginal( new PedidoCompraImpor());
					////entity.setPedidoCompraImporOriginal(super.getEntity("",entity.getPedidoCompraImporOriginal(),resultSet,PedidoCompraImporDataAccess.ISWITHSCHEMA));         		
					////entity.setPedidoCompraImporOriginal(this.getEntityPedidoCompraImpor("",entity.getPedidoCompraImporOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoCompraImpors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoCompraImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PedidoCompraImpor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PedidoCompraImpor entity = new PedidoCompraImpor();		  
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
	
	public  PedidoCompraImpor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PedidoCompraImpor entity = new PedidoCompraImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoCompraImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapPedidoCompraImpor();
					//entity.setMapPedidoCompraImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPedidoCompraImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPedidoCompraImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PedidoCompraImporDataAccess.ISWITHSCHEMA);         		
					entity=PedidoCompraImporDataAccess.getEntityPedidoCompraImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPedidoCompraImporOriginal( new PedidoCompraImpor());
					////entity.setPedidoCompraImporOriginal(super.getEntity("",entity.getPedidoCompraImporOriginal(),resultSet,PedidoCompraImporDataAccess.ISWITHSCHEMA));         		
					////entity.setPedidoCompraImporOriginal(this.getEntityPedidoCompraImpor("",entity.getPedidoCompraImporOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePedidoCompraImpor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoCompraImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PedidoCompraImpor getEntityPedidoCompraImpor(String strPrefijo,PedidoCompraImpor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PedidoCompraImpor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PedidoCompraImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PedidoCompraImporDataAccess.setFieldReflectionPedidoCompraImpor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPedidoCompraImpor=PedidoCompraImporConstantesFunciones.getTodosTiposColumnasPedidoCompraImpor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPedidoCompraImpor) {
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
							field = PedidoCompraImpor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PedidoCompraImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PedidoCompraImporDataAccess.setFieldReflectionPedidoCompraImpor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPedidoCompraImpor(Field field,String strPrefijo,String sColumn,PedidoCompraImpor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PedidoCompraImporConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDCLIENTEPROVEEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDTIPOCAMBIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDTIPOPRORRATEOIMPOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDEMBARCADOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDTIPOVIATRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDPUERTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDPUERTODESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDTIPOTERMINOSIMPOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDESTADOPEDIDOCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.FORMAPAGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.NUMERODUI:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.NUMEROORDEN:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.USOEN:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.RESPONSABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.ORDENCOMPRA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.LUGARENTREGA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoCompraImporConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoCompraImporConstantesFunciones.FECHAENTREGA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoCompraImporConstantesFunciones.FECHAENTREGACLIENTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoCompraImporConstantesFunciones.NOMBRESEGURO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.NOMBRECONSIGNATARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.PRECIOS:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.SEGURO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.GASTOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.CFR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.CIF:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraImporConstantesFunciones.IDMES:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PedidoCompraImpor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PedidoCompraImpor> entities = new  ArrayList<PedidoCompraImpor>();
		PedidoCompraImpor entity = new PedidoCompraImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoCompraImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoCompraImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoCompraImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PedidoCompraImpor();
					entity=super.getEntity("",entity,resultSet,PedidoCompraImporDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPedidoCompraImpor("",entity,resultSet);
					
					//entity.setPedidoCompraImporOriginal( new PedidoCompraImpor());
					//entity.setPedidoCompraImporOriginal(super.getEntity("",entity.getPedidoCompraImporOriginal(),resultSet,PedidoCompraImporDataAccess.ISWITHSCHEMA));         		
					//entity.setPedidoCompraImporOriginal(this.getEntityPedidoCompraImpor("",entity.getPedidoCompraImporOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePedidoCompraImpors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoCompraImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PedidoCompraImpor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PedidoCompraImpor> entities = new  ArrayList<PedidoCompraImpor>();
		PedidoCompraImpor entity = new PedidoCompraImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoCompraImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoCompraImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoCompraImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PedidoCompraImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoCompraImpor> entities = new  ArrayList<PedidoCompraImpor>();
		PedidoCompraImpor entity = new PedidoCompraImpor();		  
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
	
	public  List<PedidoCompraImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoCompraImpor> entities = new  ArrayList<PedidoCompraImpor>();
		PedidoCompraImpor entity = new PedidoCompraImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoCompraImpor();
      	    	entity=super.getEntity("",entity,resultSet,PedidoCompraImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoCompraImpor("",entity,resultSet);
      	    	
				//entity.setPedidoCompraImporOriginal( new PedidoCompraImpor());
      	    	//entity.setPedidoCompraImporOriginal(super.getEntity("",entity.getPedidoCompraImporOriginal(),resultSet,PedidoCompraImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoCompraImporOriginal(this.getEntityPedidoCompraImpor("",entity.getPedidoCompraImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePedidoCompraImpors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoCompraImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PedidoCompraImpor> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoCompraImpor> entities = new  ArrayList<PedidoCompraImpor>();
		PedidoCompraImpor entity = new PedidoCompraImpor();		  
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
	
	public  List<PedidoCompraImpor> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoCompraImpor> entities = new  ArrayList<PedidoCompraImpor>();
		PedidoCompraImpor entity = new PedidoCompraImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoCompraImpor();
      	    	entity=super.getEntity("",entity,resultSet,PedidoCompraImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoCompraImpor("",entity,resultSet);
      	    	
				//entity.setPedidoCompraImporOriginal( new PedidoCompraImpor());
      	    	//entity.setPedidoCompraImporOriginal(super.getEntity("",entity.getPedidoCompraImporOriginal(),resultSet,PedidoCompraImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoCompraImporOriginal(this.getEntityPedidoCompraImpor("",entity.getPedidoCompraImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoCompraImpors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PedidoCompraImpor getEntityPedidoCompraImpor(String strPrefijo,PedidoCompraImpor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDSUCURSAL));
				entity.setid_modulo(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDMODULO));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDPERIODO));
				entity.setid_pais(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDPAIS));
				entity.setid_cliente(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDCLIENTE));
				entity.setid_cliente_proveedor(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDCLIENTEPROVEEDOR));
				entity.setid_empleado(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDEMPLEADO));
				entity.setid_usuario(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDUSUARIO));
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
				entity.setid_moneda(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDMONEDA));
				entity.setid_tipo_prorrateo_impor(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDTIPOPRORRATEOIMPOR));
				entity.setid_embarcador(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDEMBARCADOR));
				entity.setid_tipo_via_transporte(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDTIPOVIATRANSPORTE));
				entity.setid_puerto(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDPUERTO));
				entity.setid_puerto_destino(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDPUERTODESTINO));
				entity.setid_tipo_terminos_impor(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDTIPOTERMINOSIMPOR));
				entity.setid_estado_pedido_compra(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDESTADOPEDIDOCOMPRA));
				entity.setforma_pago(resultSet.getString(strPrefijo+PedidoCompraImporConstantesFunciones.FORMAPAGO));
				entity.setnumero_dui(resultSet.getString(strPrefijo+PedidoCompraImporConstantesFunciones.NUMERODUI));
				entity.setsecuencial(resultSet.getString(strPrefijo+PedidoCompraImporConstantesFunciones.SECUENCIAL));
				entity.setnumero_orden(resultSet.getInt(strPrefijo+PedidoCompraImporConstantesFunciones.NUMEROORDEN));
				entity.setuso_en(resultSet.getString(strPrefijo+PedidoCompraImporConstantesFunciones.USOEN));
				entity.setresponsable(resultSet.getString(strPrefijo+PedidoCompraImporConstantesFunciones.RESPONSABLE));
				entity.setorden_compra(resultSet.getString(strPrefijo+PedidoCompraImporConstantesFunciones.ORDENCOMPRA));
				entity.setlugar_entrega(resultSet.getString(strPrefijo+PedidoCompraImporConstantesFunciones.LUGARENTREGA));
				entity.setdescripcion(resultSet.getString(strPrefijo+PedidoCompraImporConstantesFunciones.DESCRIPCION));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+PedidoCompraImporConstantesFunciones.FECHA).getTime()));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+PedidoCompraImporConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_entrega(new Date(resultSet.getDate(strPrefijo+PedidoCompraImporConstantesFunciones.FECHAENTREGA).getTime()));
				entity.setfecha_entrega_cliente(new Date(resultSet.getDate(strPrefijo+PedidoCompraImporConstantesFunciones.FECHAENTREGACLIENTE).getTime()));
				entity.setnombre_seguro(resultSet.getString(strPrefijo+PedidoCompraImporConstantesFunciones.NOMBRESEGURO));
				entity.setnombre_consignatario(resultSet.getString(strPrefijo+PedidoCompraImporConstantesFunciones.NOMBRECONSIGNATARIO));
				entity.setprecios(resultSet.getString(strPrefijo+PedidoCompraImporConstantesFunciones.PRECIOS));
				entity.setflete(resultSet.getDouble(strPrefijo+PedidoCompraImporConstantesFunciones.FLETE));
				entity.setseguro(resultSet.getDouble(strPrefijo+PedidoCompraImporConstantesFunciones.SEGURO));
				entity.setgastos(resultSet.getDouble(strPrefijo+PedidoCompraImporConstantesFunciones.GASTOS));
				entity.setcfr(resultSet.getDouble(strPrefijo+PedidoCompraImporConstantesFunciones.CFR));
				entity.setcif(resultSet.getDouble(strPrefijo+PedidoCompraImporConstantesFunciones.CIF));
				entity.settotal(resultSet.getDouble(strPrefijo+PedidoCompraImporConstantesFunciones.TOTAL));
				entity.setid_formato(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDFORMATO));
				entity.setid_anio(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+PedidoCompraImporConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPedidoCompraImpor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PedidoCompraImpor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PedidoCompraImporDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PedidoCompraImporDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PedidoCompraImporDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PedidoCompraImporDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PedidoCompraImporConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PedidoCompraImporDataAccess.TABLENAME,PedidoCompraImporDataAccess.ISWITHSTOREPROCEDURES);
			
			PedidoCompraImporDataAccess.setPedidoCompraImporOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpedidocompraimpor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relpedidocompraimpor.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Modulo getModulo(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relpedidocompraimpor.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Ejercicio getEjercicio(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relpedidocompraimpor.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relpedidocompraimpor.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Pais getPais(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relpedidocompraimpor.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Cliente getCliente(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relpedidocompraimpor.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Cliente getClienteProveedor(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relpedidocompraimpor.getid_cliente_proveedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Empleado getEmpleado(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relpedidocompraimpor.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Usuario getUsuario(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relpedidocompraimpor.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public TipoCambio getTipoCambio(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,relpedidocompraimpor.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}

	public Moneda getMoneda(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relpedidocompraimpor.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public TipoProrrateoImpor getTipoProrrateoImpor(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		TipoProrrateoImpor tipoprorrateoimpor= new TipoProrrateoImpor();

		try {
			TipoProrrateoImporDataAccess tipoprorrateoimporDataAccess=new TipoProrrateoImporDataAccess();

			tipoprorrateoimporDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprorrateoimporDataAccess.setConnexionType(this.connexionType);
			tipoprorrateoimporDataAccess.setParameterDbType(this.parameterDbType);

			tipoprorrateoimpor=tipoprorrateoimporDataAccess.getEntity(connexion,relpedidocompraimpor.getid_tipo_prorrateo_impor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprorrateoimpor;

	}

	public Embarcador getEmbarcador(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Embarcador embarcador= new Embarcador();

		try {
			EmbarcadorDataAccess embarcadorDataAccess=new EmbarcadorDataAccess();

			embarcadorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			embarcadorDataAccess.setConnexionType(this.connexionType);
			embarcadorDataAccess.setParameterDbType(this.parameterDbType);

			embarcador=embarcadorDataAccess.getEntity(connexion,relpedidocompraimpor.getid_embarcador());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return embarcador;

	}

	public TipoViaTransporte getTipoViaTransporte(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		TipoViaTransporte tipoviatransporte= new TipoViaTransporte();

		try {
			TipoViaTransporteDataAccess tipoviatransporteDataAccess=new TipoViaTransporteDataAccess();

			tipoviatransporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoviatransporteDataAccess.setConnexionType(this.connexionType);
			tipoviatransporteDataAccess.setParameterDbType(this.parameterDbType);

			tipoviatransporte=tipoviatransporteDataAccess.getEntity(connexion,relpedidocompraimpor.getid_tipo_via_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoviatransporte;

	}

	public Puerto getPuerto(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Puerto puerto= new Puerto();

		try {
			PuertoDataAccess puertoDataAccess=new PuertoDataAccess();

			puertoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			puertoDataAccess.setConnexionType(this.connexionType);
			puertoDataAccess.setParameterDbType(this.parameterDbType);

			puerto=puertoDataAccess.getEntity(connexion,relpedidocompraimpor.getid_puerto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return puerto;

	}

	public Puerto getPuertoDestino(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Puerto puerto= new Puerto();

		try {
			PuertoDataAccess puertoDataAccess=new PuertoDataAccess();

			puertoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			puertoDataAccess.setConnexionType(this.connexionType);
			puertoDataAccess.setParameterDbType(this.parameterDbType);

			puerto=puertoDataAccess.getEntity(connexion,relpedidocompraimpor.getid_puerto_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return puerto;

	}

	public TipoTerminosImpor getTipoTerminosImpor(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		TipoTerminosImpor tipoterminosimpor= new TipoTerminosImpor();

		try {
			TipoTerminosImporDataAccess tipoterminosimporDataAccess=new TipoTerminosImporDataAccess();

			tipoterminosimporDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoterminosimporDataAccess.setConnexionType(this.connexionType);
			tipoterminosimporDataAccess.setParameterDbType(this.parameterDbType);

			tipoterminosimpor=tipoterminosimporDataAccess.getEntity(connexion,relpedidocompraimpor.getid_tipo_terminos_impor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoterminosimpor;

	}

	public EstadoPedidoCompra getEstadoPedidoCompra(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		EstadoPedidoCompra estadopedidocompra= new EstadoPedidoCompra();

		try {
			EstadoPedidoCompraDataAccess estadopedidocompraDataAccess=new EstadoPedidoCompraDataAccess();

			estadopedidocompraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadopedidocompraDataAccess.setConnexionType(this.connexionType);
			estadopedidocompraDataAccess.setParameterDbType(this.parameterDbType);

			estadopedidocompra=estadopedidocompraDataAccess.getEntity(connexion,relpedidocompraimpor.getid_estado_pedido_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadopedidocompra;

	}

	public Formato getFormato(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relpedidocompraimpor.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Anio getAnio(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relpedidocompraimpor.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,PedidoCompraImpor relpedidocompraimpor)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relpedidocompraimpor.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
		public List<DetallePedidoCompraImpor> getDetallePedidoCompraImpors(Connexion connexion,PedidoCompraImpor pedidocompraimpor)throws SQLException,Exception {

		List<DetallePedidoCompraImpor> detallepedidocompraimpors= new ArrayList<DetallePedidoCompraImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PedidoCompraImporConstantesFunciones.SCHEMA+".pedido_compra_impor ON "+DetallePedidoCompraImporConstantesFunciones.SCHEMA+".detalle_pedido_compra_impor.id_pedido_compra_impor="+PedidoCompraImporConstantesFunciones.SCHEMA+".pedido_compra_impor.id WHERE "+PedidoCompraImporConstantesFunciones.SCHEMA+".pedido_compra_impor.id="+String.valueOf(pedidocompraimpor.getId());
			} else {
				sQuery=" INNER JOIN detallepedidocompraimpor.PedidoCompraImpor WHERE detallepedidocompraimpor.PedidoCompraImpor.id="+String.valueOf(pedidocompraimpor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetallePedidoCompraImporDataAccess detallepedidocompraimporDataAccess=new DetallePedidoCompraImporDataAccess();

			detallepedidocompraimporDataAccess.setConnexionType(this.connexionType);
			detallepedidocompraimporDataAccess.setParameterDbType(this.parameterDbType);
			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallepedidocompraimpors;

	}

	public List<LiquidacionImpuestoImpor> getLiquidacionImpuestoImpors(Connexion connexion,PedidoCompraImpor pedidocompraimpor)throws SQLException,Exception {

		List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors= new ArrayList<LiquidacionImpuestoImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PedidoCompraImporConstantesFunciones.SCHEMA+".pedido_compra_impor ON "+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+".liquidacion_impuesto_impor.id_pedido_compra_impor="+PedidoCompraImporConstantesFunciones.SCHEMA+".pedido_compra_impor.id WHERE "+PedidoCompraImporConstantesFunciones.SCHEMA+".pedido_compra_impor.id="+String.valueOf(pedidocompraimpor.getId());
			} else {
				sQuery=" INNER JOIN liquidacionimpuestoimpor.PedidoCompraImpor WHERE liquidacionimpuestoimpor.PedidoCompraImpor.id="+String.valueOf(pedidocompraimpor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			LiquidacionImpuestoImporDataAccess liquidacionimpuestoimporDataAccess=new LiquidacionImpuestoImporDataAccess();

			liquidacionimpuestoimporDataAccess.setConnexionType(this.connexionType);
			liquidacionimpuestoimporDataAccess.setParameterDbType(this.parameterDbType);
			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return liquidacionimpuestoimpors;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PedidoCompraImpor pedidocompraimpor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!pedidocompraimpor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(pedidocompraimpor.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(pedidocompraimpor.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(pedidocompraimpor.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(pedidocompraimpor.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(pedidocompraimpor.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(pedidocompraimpor.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(pedidocompraimpor.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente_proveedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente_proveedor.setValue(pedidocompraimpor.getid_cliente_proveedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente_proveedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(pedidocompraimpor.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(pedidocompraimpor.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(pedidocompraimpor.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(pedidocompraimpor.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_prorrateo_impor=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_prorrateo_impor.setValue(pedidocompraimpor.getid_tipo_prorrateo_impor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_prorrateo_impor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_embarcador=new ParameterValue<Long>();
					parameterMaintenanceValueid_embarcador.setValue(pedidocompraimpor.getid_embarcador());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_embarcador);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_via_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_via_transporte.setValue(pedidocompraimpor.getid_tipo_via_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_via_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_puerto=new ParameterValue<Long>();
					parameterMaintenanceValueid_puerto.setValue(pedidocompraimpor.getid_puerto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_puerto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_puerto_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_puerto_destino.setValue(pedidocompraimpor.getid_puerto_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_puerto_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_terminos_impor=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_terminos_impor.setValue(pedidocompraimpor.getid_tipo_terminos_impor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_terminos_impor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_pedido_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_pedido_compra.setValue(pedidocompraimpor.getid_estado_pedido_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_pedido_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueforma_pago=new ParameterValue<String>();
					parameterMaintenanceValueforma_pago.setValue(pedidocompraimpor.getforma_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueforma_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_dui=new ParameterValue<String>();
					parameterMaintenanceValuenumero_dui.setValue(pedidocompraimpor.getnumero_dui());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_dui);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial.setValue(pedidocompraimpor.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_orden=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_orden.setValue(pedidocompraimpor.getnumero_orden());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_orden);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueuso_en=new ParameterValue<String>();
					parameterMaintenanceValueuso_en.setValue(pedidocompraimpor.getuso_en());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueuso_en);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueresponsable=new ParameterValue<String>();
					parameterMaintenanceValueresponsable.setValue(pedidocompraimpor.getresponsable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueresponsable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueorden_compra=new ParameterValue<String>();
					parameterMaintenanceValueorden_compra.setValue(pedidocompraimpor.getorden_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorden_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelugar_entrega=new ParameterValue<String>();
					parameterMaintenanceValuelugar_entrega.setValue(pedidocompraimpor.getlugar_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelugar_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(pedidocompraimpor.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(pedidocompraimpor.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(pedidocompraimpor.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_entrega=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_entrega.setValue(pedidocompraimpor.getfecha_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_entrega_cliente=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_entrega_cliente.setValue(pedidocompraimpor.getfecha_entrega_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_entrega_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_seguro=new ParameterValue<String>();
					parameterMaintenanceValuenombre_seguro.setValue(pedidocompraimpor.getnombre_seguro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_seguro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_consignatario=new ParameterValue<String>();
					parameterMaintenanceValuenombre_consignatario.setValue(pedidocompraimpor.getnombre_consignatario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_consignatario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueprecios=new ParameterValue<String>();
					parameterMaintenanceValueprecios.setValue(pedidocompraimpor.getprecios());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecios);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueflete=new ParameterValue<Double>();
					parameterMaintenanceValueflete.setValue(pedidocompraimpor.getflete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueflete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueseguro=new ParameterValue<Double>();
					parameterMaintenanceValueseguro.setValue(pedidocompraimpor.getseguro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueseguro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuegastos=new ParameterValue<Double>();
					parameterMaintenanceValuegastos.setValue(pedidocompraimpor.getgastos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegastos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecfr=new ParameterValue<Double>();
					parameterMaintenanceValuecfr.setValue(pedidocompraimpor.getcfr());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecfr);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecif=new ParameterValue<Double>();
					parameterMaintenanceValuecif.setValue(pedidocompraimpor.getcif());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecif);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(pedidocompraimpor.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(pedidocompraimpor.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(pedidocompraimpor.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(pedidocompraimpor.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
						if(!pedidocompraimpor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(pedidocompraimpor.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(pedidocompraimpor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(pedidocompraimpor.getId());
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
	
	public void setIsNewIsChangedFalsePedidoCompraImpor(PedidoCompraImpor pedidocompraimpor)throws Exception  {		
		pedidocompraimpor.setIsNew(false);
		pedidocompraimpor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePedidoCompraImpors(List<PedidoCompraImpor> pedidocompraimpors)throws Exception  {				
		for(PedidoCompraImpor pedidocompraimpor:pedidocompraimpors) {
			pedidocompraimpor.setIsNew(false);
			pedidocompraimpor.setIsChanged(false);
		}
	}
	
	public void generarExportarPedidoCompraImpor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
