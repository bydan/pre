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
package com.bydan.erp.produccion.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.produccion.util.OrdenProduConstantesFunciones;
import com.bydan.erp.produccion.util.OrdenProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.OrdenProduParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class OrdenProduConstantesFunciones extends OrdenProduConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="OrdenProdu";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="OrdenProdu"+OrdenProduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="OrdenProduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="OrdenProduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=OrdenProduConstantesFunciones.SCHEMA+"_"+OrdenProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/OrdenProduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=OrdenProduConstantesFunciones.SCHEMA+"_"+OrdenProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=OrdenProduConstantesFunciones.SCHEMA+"_"+OrdenProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/OrdenProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=OrdenProduConstantesFunciones.SCHEMA+"_"+OrdenProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+OrdenProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/OrdenProduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+OrdenProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+OrdenProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/OrdenProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+OrdenProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=OrdenProduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+OrdenProduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=OrdenProduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+OrdenProduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Orden Producciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Orden Produccion";
	public static final String SCLASSWEBTITULO_LOWER="Orden Produ";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="OrdenProdu";
	public static final String OBJECTNAME="ordenprodu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="orden_produ";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ordenprodu from "+OrdenProduConstantesFunciones.SPERSISTENCENAME+" ordenprodu";
	public static String QUERYSELECTNATIVE="select "+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".version_row,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_empresa,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_sucursal,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_ejercicio,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_periodo,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_formato,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_tipo_prioridad_empresa_produ,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_empleado_responsable,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".secuencial,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_cliente,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".direccion_cliente,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".telefono_cliente,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".ruc_cliente,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".lote,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".fecha_pedido,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".fecha_entrega,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".es_uso_interno,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".fecha,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".descripcion,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_estado_orden_produ from "+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME;//+" as "+OrdenProduConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected OrdenProduConstantesFuncionesAdditional ordenproduConstantesFuncionesAdditional=null;
	
	public OrdenProduConstantesFuncionesAdditional getOrdenProduConstantesFuncionesAdditional() {
		return this.ordenproduConstantesFuncionesAdditional;
	}
	
	public void setOrdenProduConstantesFuncionesAdditional(OrdenProduConstantesFuncionesAdditional ordenproduConstantesFuncionesAdditional) {
		try {
			this.ordenproduConstantesFuncionesAdditional=ordenproduConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDFORMATO= "id_formato";
    public static final String IDTIPOPRIORIDADEMPRESAPRODU= "id_tipo_prioridad_empresa_produ";
    public static final String IDEMPLEADORESPONSABLE= "id_empleado_responsable";
    public static final String SECUENCIAL= "secuencial";
    public static final String IDCLIENTE= "id_cliente";
    public static final String DIRECCIONCLIENTE= "direccion_cliente";
    public static final String TELEFONOCLIENTE= "telefono_cliente";
    public static final String RUCCLIENTE= "ruc_cliente";
    public static final String LOTE= "lote";
    public static final String FECHAPEDIDO= "fecha_pedido";
    public static final String FECHAENTREGA= "fecha_entrega";
    public static final String ESUSOINTERNO= "es_uso_interno";
    public static final String FECHA= "fecha";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDESTADOORDENPRODU= "id_estado_orden_produ";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_IDTIPOPRIORIDADEMPRESAPRODU= "Tipo Priorad Empresa Produ";
		public static final String LABEL_IDTIPOPRIORIDADEMPRESAPRODU_LOWER= "Tipo Prioridad Empresa Produ";
    	public static final String LABEL_IDEMPLEADORESPONSABLE= "Empleado Responsable";
		public static final String LABEL_IDEMPLEADORESPONSABLE_LOWER= "Empleado Responsable";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_DIRECCIONCLIENTE= "Direccion Cliente";
		public static final String LABEL_DIRECCIONCLIENTE_LOWER= "Direccion Cliente";
    	public static final String LABEL_TELEFONOCLIENTE= "Telefono Cliente";
		public static final String LABEL_TELEFONOCLIENTE_LOWER= "Telefono Cliente";
    	public static final String LABEL_RUCCLIENTE= "Ruc Cliente";
		public static final String LABEL_RUCCLIENTE_LOWER= "Ruc Cliente";
    	public static final String LABEL_LOTE= "Lote";
		public static final String LABEL_LOTE_LOWER= "Lote";
    	public static final String LABEL_FECHAPEDIDO= "Fecha Pedo";
		public static final String LABEL_FECHAPEDIDO_LOWER= "Fecha Pedido";
    	public static final String LABEL_FECHAENTREGA= "Fecha Entrega";
		public static final String LABEL_FECHAENTREGA_LOWER= "Fecha Entrega";
    	public static final String LABEL_ESUSOINTERNO= "Es Uso Interno";
		public static final String LABEL_ESUSOINTERNO_LOWER= "Es Uso Interno";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDESTADOORDENPRODU= "Estado Orden Produ";
		public static final String LABEL_IDESTADOORDENPRODU_LOWER= "Estado Orden Produ";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDIRECCION_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO_CLIENTE=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXRUC_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXLOTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getOrdenProduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.IDEMPRESA)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.IDSUCURSAL)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.IDEJERCICIO)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.IDPERIODO)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.IDFORMATO)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_IDTIPOPRIORIDADEMPRESAPRODU;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.IDEMPLEADORESPONSABLE)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_IDEMPLEADORESPONSABLE;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.SECUENCIAL)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.IDCLIENTE)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.DIRECCIONCLIENTE)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_DIRECCIONCLIENTE;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.TELEFONOCLIENTE)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_TELEFONOCLIENTE;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.RUCCLIENTE)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_RUCCLIENTE;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.LOTE)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_LOTE;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.FECHAPEDIDO)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_FECHAPEDIDO;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.FECHAENTREGA)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.ESUSOINTERNO)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_ESUSOINTERNO;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.FECHA)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.DESCRIPCION)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(OrdenProduConstantesFunciones.IDESTADOORDENPRODU)) {sLabelColumna=OrdenProduConstantesFunciones.LABEL_IDESTADOORDENPRODU;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_uso_internoDescripcion(OrdenProdu ordenprodu) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!ordenprodu.getes_uso_interno()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_uso_internoHtmlDescripcion(OrdenProdu ordenprodu) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(ordenprodu.getId(),ordenprodu.getes_uso_interno());

		return sDescripcion;
	}	
			
			
			
	
	public static String getOrdenProduDescripcion(OrdenProdu ordenprodu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ordenprodu !=null/* && ordenprodu.getId()!=0*/) {
			sDescripcion=ordenprodu.getsecuencial();//ordenproduordenprodu.getsecuencial().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getOrdenProduDescripcionDetallado(OrdenProdu ordenprodu) {
		String sDescripcion="";
			
		sDescripcion+=OrdenProduConstantesFunciones.ID+"=";
		sDescripcion+=ordenprodu.getId().toString()+",";
		sDescripcion+=OrdenProduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ordenprodu.getVersionRow().toString()+",";
		sDescripcion+=OrdenProduConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ordenprodu.getid_empresa().toString()+",";
		sDescripcion+=OrdenProduConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=ordenprodu.getid_sucursal().toString()+",";
		sDescripcion+=OrdenProduConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=ordenprodu.getid_ejercicio().toString()+",";
		sDescripcion+=OrdenProduConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=ordenprodu.getid_periodo().toString()+",";
		sDescripcion+=OrdenProduConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=ordenprodu.getid_formato().toString()+",";
		sDescripcion+=OrdenProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU+"=";
		sDescripcion+=ordenprodu.getid_tipo_prioridad_empresa_produ().toString()+",";
		sDescripcion+=OrdenProduConstantesFunciones.IDEMPLEADORESPONSABLE+"=";
		sDescripcion+=ordenprodu.getid_empleado_responsable().toString()+",";
		sDescripcion+=OrdenProduConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=ordenprodu.getsecuencial()+",";
		sDescripcion+=OrdenProduConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=ordenprodu.getid_cliente().toString()+",";
		sDescripcion+=OrdenProduConstantesFunciones.DIRECCIONCLIENTE+"=";
		sDescripcion+=ordenprodu.getdireccion_cliente()+",";
		sDescripcion+=OrdenProduConstantesFunciones.TELEFONOCLIENTE+"=";
		sDescripcion+=ordenprodu.gettelefono_cliente()+",";
		sDescripcion+=OrdenProduConstantesFunciones.RUCCLIENTE+"=";
		sDescripcion+=ordenprodu.getruc_cliente()+",";
		sDescripcion+=OrdenProduConstantesFunciones.LOTE+"=";
		sDescripcion+=ordenprodu.getlote()+",";
		sDescripcion+=OrdenProduConstantesFunciones.FECHAPEDIDO+"=";
		sDescripcion+=ordenprodu.getfecha_pedido().toString()+",";
		sDescripcion+=OrdenProduConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=ordenprodu.getfecha_entrega().toString()+",";
		sDescripcion+=OrdenProduConstantesFunciones.ESUSOINTERNO+"=";
		sDescripcion+=ordenprodu.getes_uso_interno().toString()+",";
		sDescripcion+=OrdenProduConstantesFunciones.FECHA+"=";
		sDescripcion+=ordenprodu.getfecha().toString()+",";
		sDescripcion+=OrdenProduConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=ordenprodu.getdescripcion()+",";
		sDescripcion+=OrdenProduConstantesFunciones.IDESTADOORDENPRODU+"=";
		sDescripcion+=ordenprodu.getid_estado_orden_produ().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setOrdenProduDescripcion(OrdenProdu ordenprodu,String sValor) throws Exception {			
		if(ordenprodu !=null) {
			ordenprodu.setsecuencial(sValor);;//ordenproduordenprodu.getsecuencial().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getTipoPrioridadEmpresaProduDescripcion(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprioridadempresaprodu!=null/*&&tipoprioridadempresaprodu.getId()>0*/) {
			sDescripcion=TipoPrioridadEmpresaProduConstantesFunciones.getTipoPrioridadEmpresaProduDescripcion(tipoprioridadempresaprodu);
		}

		return sDescripcion;
	}

	public static String getEmpleadoResponsableDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getEstadoOrdenProduDescripcion(EstadoOrdenProdu estadoordenprodu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoordenprodu!=null/*&&estadoordenprodu.getId()>0*/) {
			sDescripcion=EstadoOrdenProduConstantesFunciones.getEstadoOrdenProduDescripcion(estadoordenprodu);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleadoResponsable")) {
			sNombreIndice="Tipo=  Por Empleado Responsable";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoOrdenProdu")) {
			sNombreIndice="Tipo=  Por Estado Orden Produ";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoPrioridadEmpresaProdu")) {
			sNombreIndice="Tipo=  Por Tipo Priorad Empresa Produ";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleadoResponsable(Long id_empleado_responsable) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado_responsable!=null) {sDetalleIndice+=" Codigo Unico De Empleado Responsable="+id_empleado_responsable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoOrdenProdu(Long id_estado_orden_produ) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_orden_produ!=null) {sDetalleIndice+=" Codigo Unico De Estado Orden Produ="+id_estado_orden_produ.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPrioridadEmpresaProdu(Long id_tipo_prioridad_empresa_produ) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_prioridad_empresa_produ!=null) {sDetalleIndice+=" Codigo Unico De Tipo Priorad Empresa Produ="+id_tipo_prioridad_empresa_produ.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosOrdenProdu(OrdenProdu ordenprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ordenprodu.setsecuencial(ordenprodu.getsecuencial().trim());
		ordenprodu.setdireccion_cliente(ordenprodu.getdireccion_cliente().trim());
		ordenprodu.settelefono_cliente(ordenprodu.gettelefono_cliente().trim());
		ordenprodu.setruc_cliente(ordenprodu.getruc_cliente().trim());
		ordenprodu.setlote(ordenprodu.getlote().trim());
		ordenprodu.setdescripcion(ordenprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosOrdenProdus(List<OrdenProdu> ordenprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(OrdenProdu ordenprodu: ordenprodus) {
			ordenprodu.setsecuencial(ordenprodu.getsecuencial().trim());
			ordenprodu.setdireccion_cliente(ordenprodu.getdireccion_cliente().trim());
			ordenprodu.settelefono_cliente(ordenprodu.gettelefono_cliente().trim());
			ordenprodu.setruc_cliente(ordenprodu.getruc_cliente().trim());
			ordenprodu.setlote(ordenprodu.getlote().trim());
			ordenprodu.setdescripcion(ordenprodu.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresOrdenProdu(OrdenProdu ordenprodu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ordenprodu.getConCambioAuxiliar()) {
			ordenprodu.setIsDeleted(ordenprodu.getIsDeletedAuxiliar());	
			ordenprodu.setIsNew(ordenprodu.getIsNewAuxiliar());	
			ordenprodu.setIsChanged(ordenprodu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ordenprodu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ordenprodu.setIsDeletedAuxiliar(false);	
			ordenprodu.setIsNewAuxiliar(false);	
			ordenprodu.setIsChangedAuxiliar(false);
			
			ordenprodu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresOrdenProdus(List<OrdenProdu> ordenprodus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(OrdenProdu ordenprodu : ordenprodus) {
			if(conAsignarBase && ordenprodu.getConCambioAuxiliar()) {
				ordenprodu.setIsDeleted(ordenprodu.getIsDeletedAuxiliar());	
				ordenprodu.setIsNew(ordenprodu.getIsNewAuxiliar());	
				ordenprodu.setIsChanged(ordenprodu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ordenprodu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ordenprodu.setIsDeletedAuxiliar(false);	
				ordenprodu.setIsNewAuxiliar(false);	
				ordenprodu.setIsChangedAuxiliar(false);
				
				ordenprodu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresOrdenProdu(OrdenProdu ordenprodu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresOrdenProdus(List<OrdenProdu> ordenprodus,Boolean conEnteros) throws Exception  {
		
		for(OrdenProdu ordenprodu: ordenprodus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaOrdenProdu(List<OrdenProdu> ordenprodus,OrdenProdu ordenproduAux) throws Exception  {
		OrdenProduConstantesFunciones.InicializarValoresOrdenProdu(ordenproduAux,true);
		
		for(OrdenProdu ordenprodu: ordenprodus) {
			if(ordenprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesOrdenProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=OrdenProduConstantesFunciones.getArrayColumnasGlobalesOrdenProdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesOrdenProdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(OrdenProduConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(OrdenProduConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(OrdenProduConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(OrdenProduConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(OrdenProduConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(OrdenProduConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(OrdenProduConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(OrdenProduConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoOrdenProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<OrdenProdu> ordenprodus,OrdenProdu ordenprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(OrdenProdu ordenproduAux: ordenprodus) {
			if(ordenproduAux!=null && ordenprodu!=null) {
				if((ordenproduAux.getId()==null && ordenprodu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ordenproduAux.getId()!=null && ordenprodu.getId()!=null){
					if(ordenproduAux.getId().equals(ordenprodu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaOrdenProdu(List<OrdenProdu> ordenprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(OrdenProdu ordenprodu: ordenprodus) {			
			if(ordenprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaOrdenProdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_ID, OrdenProduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_VERSIONROW, OrdenProduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_IDEMPRESA, OrdenProduConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_IDSUCURSAL, OrdenProduConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_IDEJERCICIO, OrdenProduConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_IDPERIODO, OrdenProduConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_IDFORMATO, OrdenProduConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_IDTIPOPRIORIDADEMPRESAPRODU, OrdenProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_IDEMPLEADORESPONSABLE, OrdenProduConstantesFunciones.IDEMPLEADORESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_SECUENCIAL, OrdenProduConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_IDCLIENTE, OrdenProduConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_DIRECCIONCLIENTE, OrdenProduConstantesFunciones.DIRECCIONCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_TELEFONOCLIENTE, OrdenProduConstantesFunciones.TELEFONOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_RUCCLIENTE, OrdenProduConstantesFunciones.RUCCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_LOTE, OrdenProduConstantesFunciones.LOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_FECHAPEDIDO, OrdenProduConstantesFunciones.FECHAPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_FECHAENTREGA, OrdenProduConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_ESUSOINTERNO, OrdenProduConstantesFunciones.ESUSOINTERNO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_FECHA, OrdenProduConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_DESCRIPCION, OrdenProduConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenProduConstantesFunciones.LABEL_IDESTADOORDENPRODU, OrdenProduConstantesFunciones.IDESTADOORDENPRODU,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasOrdenProdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.IDEMPLEADORESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.DIRECCIONCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.TELEFONOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.RUCCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.LOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.FECHAPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.ESUSOINTERNO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenProduConstantesFunciones.IDESTADOORDENPRODU;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarOrdenProdu() throws Exception  {
		return OrdenProduConstantesFunciones.getTiposSeleccionarOrdenProdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarOrdenProdu(Boolean conFk) throws Exception  {
		return OrdenProduConstantesFunciones.getTiposSeleccionarOrdenProdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarOrdenProdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_IDTIPOPRIORIDADEMPRESAPRODU);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_IDTIPOPRIORIDADEMPRESAPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_IDEMPLEADORESPONSABLE);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_IDEMPLEADORESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_DIRECCIONCLIENTE);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_DIRECCIONCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_TELEFONOCLIENTE);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_TELEFONOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_RUCCLIENTE);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_RUCCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_LOTE);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_LOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_FECHAPEDIDO);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_FECHAPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_ESUSOINTERNO);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_ESUSOINTERNO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenProduConstantesFunciones.LABEL_IDESTADOORDENPRODU);
			reporte.setsDescripcion(OrdenProduConstantesFunciones.LABEL_IDESTADOORDENPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesOrdenProdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesOrdenProdu(OrdenProdu ordenproduAux) throws Exception {
		
			ordenproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ordenproduAux.getEmpresa()));
			ordenproduAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ordenproduAux.getSucursal()));
			ordenproduAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(ordenproduAux.getEjercicio()));
			ordenproduAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(ordenproduAux.getPeriodo()));
			ordenproduAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(ordenproduAux.getFormato()));
			ordenproduAux.settipoprioridadempresaprodu_descripcion(TipoPrioridadEmpresaProduConstantesFunciones.getTipoPrioridadEmpresaProduDescripcion(ordenproduAux.getTipoPrioridadEmpresaProdu()));
			ordenproduAux.setempleadoresponsable_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(ordenproduAux.getEmpleadoResponsable()));
			ordenproduAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(ordenproduAux.getCliente()));
			ordenproduAux.setestadoordenprodu_descripcion(EstadoOrdenProduConstantesFunciones.getEstadoOrdenProduDescripcion(ordenproduAux.getEstadoOrdenProdu()));		
	}
	
	public static void refrescarForeignKeysDescripcionesOrdenProdu(List<OrdenProdu> ordenprodusTemp) throws Exception {
		for(OrdenProdu ordenproduAux:ordenprodusTemp) {
			
			ordenproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ordenproduAux.getEmpresa()));
			ordenproduAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ordenproduAux.getSucursal()));
			ordenproduAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(ordenproduAux.getEjercicio()));
			ordenproduAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(ordenproduAux.getPeriodo()));
			ordenproduAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(ordenproduAux.getFormato()));
			ordenproduAux.settipoprioridadempresaprodu_descripcion(TipoPrioridadEmpresaProduConstantesFunciones.getTipoPrioridadEmpresaProduDescripcion(ordenproduAux.getTipoPrioridadEmpresaProdu()));
			ordenproduAux.setempleadoresponsable_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(ordenproduAux.getEmpleadoResponsable()));
			ordenproduAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(ordenproduAux.getCliente()));
			ordenproduAux.setestadoordenprodu_descripcion(EstadoOrdenProduConstantesFunciones.getEstadoOrdenProduDescripcion(ordenproduAux.getEstadoOrdenProdu()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfOrdenProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(TipoPrioridadEmpresaProdu.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(EstadoOrdenProdu.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrioridadEmpresaProdu.class)) {
						classes.add(new Classe(TipoPrioridadEmpresaProdu.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoOrdenProdu.class)) {
						classes.add(new Classe(EstadoOrdenProdu.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfOrdenProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(TipoPrioridadEmpresaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrioridadEmpresaProdu.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(EstadoOrdenProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoOrdenProdu.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(TipoPrioridadEmpresaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrioridadEmpresaProdu.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(EstadoOrdenProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoOrdenProdu.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfOrdenProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return OrdenProduConstantesFunciones.getClassesRelationshipsOfOrdenProdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfOrdenProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(OrdenDetaProdu.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenDetaProdu.class)) {
						classes.add(new Classe(OrdenDetaProdu.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfOrdenProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return OrdenProduConstantesFunciones.getClassesRelationshipsFromStringsOfOrdenProdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfOrdenProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenDetaProdu.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(OrdenDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenDetaProdu.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(OrdenProdu ordenprodu,List<OrdenProdu> ordenprodus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			OrdenProdu ordenproduEncontrado=null;
			
			for(OrdenProdu ordenproduLocal:ordenprodus) {
				if(ordenproduLocal.getId().equals(ordenprodu.getId())) {
					ordenproduEncontrado=ordenproduLocal;
					
					ordenproduLocal.setIsChanged(ordenprodu.getIsChanged());
					ordenproduLocal.setIsNew(ordenprodu.getIsNew());
					ordenproduLocal.setIsDeleted(ordenprodu.getIsDeleted());
					
					ordenproduLocal.setGeneralEntityOriginal(ordenprodu.getGeneralEntityOriginal());
					
					ordenproduLocal.setId(ordenprodu.getId());	
					ordenproduLocal.setVersionRow(ordenprodu.getVersionRow());	
					ordenproduLocal.setid_empresa(ordenprodu.getid_empresa());	
					ordenproduLocal.setid_sucursal(ordenprodu.getid_sucursal());	
					ordenproduLocal.setid_ejercicio(ordenprodu.getid_ejercicio());	
					ordenproduLocal.setid_periodo(ordenprodu.getid_periodo());	
					ordenproduLocal.setid_formato(ordenprodu.getid_formato());	
					ordenproduLocal.setid_tipo_prioridad_empresa_produ(ordenprodu.getid_tipo_prioridad_empresa_produ());	
					ordenproduLocal.setid_empleado_responsable(ordenprodu.getid_empleado_responsable());	
					ordenproduLocal.setsecuencial(ordenprodu.getsecuencial());	
					ordenproduLocal.setid_cliente(ordenprodu.getid_cliente());	
					ordenproduLocal.setdireccion_cliente(ordenprodu.getdireccion_cliente());	
					ordenproduLocal.settelefono_cliente(ordenprodu.gettelefono_cliente());	
					ordenproduLocal.setruc_cliente(ordenprodu.getruc_cliente());	
					ordenproduLocal.setlote(ordenprodu.getlote());	
					ordenproduLocal.setfecha_pedido(ordenprodu.getfecha_pedido());	
					ordenproduLocal.setfecha_entrega(ordenprodu.getfecha_entrega());	
					ordenproduLocal.setes_uso_interno(ordenprodu.getes_uso_interno());	
					ordenproduLocal.setfecha(ordenprodu.getfecha());	
					ordenproduLocal.setdescripcion(ordenprodu.getdescripcion());	
					ordenproduLocal.setid_estado_orden_produ(ordenprodu.getid_estado_orden_produ());	
					
					
					ordenproduLocal.setOrdenDetaProdus(ordenprodu.getOrdenDetaProdus());
					
					existe=true;
					break;
				}
			}
			
			if(!ordenprodu.getIsDeleted()) {
				if(!existe) {
					ordenprodus.add(ordenprodu);
				}
			} else {
				if(ordenproduEncontrado!=null && permiteQuitar)  {
					ordenprodus.remove(ordenproduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(OrdenProdu ordenprodu,List<OrdenProdu> ordenprodus) throws Exception {
		try	{			
			for(OrdenProdu ordenproduLocal:ordenprodus) {
				if(ordenproduLocal.getId().equals(ordenprodu.getId())) {
					ordenproduLocal.setIsSelected(ordenprodu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesOrdenProdu(List<OrdenProdu> ordenprodusAux) throws Exception {
		//this.ordenprodusAux=ordenprodusAux;
		
		for(OrdenProdu ordenproduAux:ordenprodusAux) {
			if(ordenproduAux.getIsChanged()) {
				ordenproduAux.setIsChanged(false);
			}		
			
			if(ordenproduAux.getIsNew()) {
				ordenproduAux.setIsNew(false);
			}	
			
			if(ordenproduAux.getIsDeleted()) {
				ordenproduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesOrdenProdu(OrdenProdu ordenproduAux) throws Exception {
		//this.ordenproduAux=ordenproduAux;
		
			if(ordenproduAux.getIsChanged()) {
				ordenproduAux.setIsChanged(false);
			}		
			
			if(ordenproduAux.getIsNew()) {
				ordenproduAux.setIsNew(false);
			}	
			
			if(ordenproduAux.getIsDeleted()) {
				ordenproduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(OrdenProdu ordenproduAsignar,OrdenProdu ordenprodu) throws Exception {
		ordenproduAsignar.setId(ordenprodu.getId());	
		ordenproduAsignar.setVersionRow(ordenprodu.getVersionRow());	
		ordenproduAsignar.setid_empresa(ordenprodu.getid_empresa());
		ordenproduAsignar.setempresa_descripcion(ordenprodu.getempresa_descripcion());	
		ordenproduAsignar.setid_sucursal(ordenprodu.getid_sucursal());
		ordenproduAsignar.setsucursal_descripcion(ordenprodu.getsucursal_descripcion());	
		ordenproduAsignar.setid_ejercicio(ordenprodu.getid_ejercicio());
		ordenproduAsignar.setejercicio_descripcion(ordenprodu.getejercicio_descripcion());	
		ordenproduAsignar.setid_periodo(ordenprodu.getid_periodo());
		ordenproduAsignar.setperiodo_descripcion(ordenprodu.getperiodo_descripcion());	
		ordenproduAsignar.setid_formato(ordenprodu.getid_formato());
		ordenproduAsignar.setformato_descripcion(ordenprodu.getformato_descripcion());	
		ordenproduAsignar.setid_tipo_prioridad_empresa_produ(ordenprodu.getid_tipo_prioridad_empresa_produ());
		ordenproduAsignar.settipoprioridadempresaprodu_descripcion(ordenprodu.gettipoprioridadempresaprodu_descripcion());	
		ordenproduAsignar.setid_empleado_responsable(ordenprodu.getid_empleado_responsable());
		ordenproduAsignar.setempleadoresponsable_descripcion(ordenprodu.getempleadoresponsable_descripcion());	
		ordenproduAsignar.setsecuencial(ordenprodu.getsecuencial());	
		ordenproduAsignar.setid_cliente(ordenprodu.getid_cliente());
		ordenproduAsignar.setcliente_descripcion(ordenprodu.getcliente_descripcion());	
		ordenproduAsignar.setdireccion_cliente(ordenprodu.getdireccion_cliente());	
		ordenproduAsignar.settelefono_cliente(ordenprodu.gettelefono_cliente());	
		ordenproduAsignar.setruc_cliente(ordenprodu.getruc_cliente());	
		ordenproduAsignar.setlote(ordenprodu.getlote());	
		ordenproduAsignar.setfecha_pedido(ordenprodu.getfecha_pedido());	
		ordenproduAsignar.setfecha_entrega(ordenprodu.getfecha_entrega());	
		ordenproduAsignar.setes_uso_interno(ordenprodu.getes_uso_interno());	
		ordenproduAsignar.setfecha(ordenprodu.getfecha());	
		ordenproduAsignar.setdescripcion(ordenprodu.getdescripcion());	
		ordenproduAsignar.setid_estado_orden_produ(ordenprodu.getid_estado_orden_produ());
		ordenproduAsignar.setestadoordenprodu_descripcion(ordenprodu.getestadoordenprodu_descripcion());	
	}
	
	public static void inicializarOrdenProdu(OrdenProdu ordenprodu) throws Exception {
		try {
				ordenprodu.setId(0L);	
					
				ordenprodu.setid_empresa(-1L);	
				ordenprodu.setid_sucursal(-1L);	
				ordenprodu.setid_ejercicio(-1L);	
				ordenprodu.setid_periodo(-1L);	
				ordenprodu.setid_formato(null);	
				ordenprodu.setid_tipo_prioridad_empresa_produ(-1L);	
				ordenprodu.setid_empleado_responsable(-1L);	
				ordenprodu.setsecuencial("");	
				ordenprodu.setid_cliente(-1L);	
				ordenprodu.setdireccion_cliente("");	
				ordenprodu.settelefono_cliente("");	
				ordenprodu.setruc_cliente("");	
				ordenprodu.setlote("");	
				ordenprodu.setfecha_pedido(new Date());	
				ordenprodu.setfecha_entrega(new Date());	
				ordenprodu.setes_uso_interno(false);	
				ordenprodu.setfecha(new Date());	
				ordenprodu.setdescripcion("");	
				ordenprodu.setid_estado_orden_produ(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderOrdenProdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_IDTIPOPRIORIDADEMPRESAPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_IDEMPLEADORESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_DIRECCIONCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_TELEFONOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_RUCCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_LOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_FECHAPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_ESUSOINTERNO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenProduConstantesFunciones.LABEL_IDESTADOORDENPRODU);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataOrdenProdu(String sTipo,Row row,Workbook workbook,OrdenProdu ordenprodu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.gettipoprioridadempresaprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.getempleadoresponsable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.getdireccion_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.gettelefono_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.getruc_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.getlote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.getfecha_pedido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(ordenprodu.getes_uso_interno()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordenprodu.getestadoordenprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryOrdenProdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryOrdenProdu() {
		return this.sFinalQueryOrdenProdu;
	}
	
	public void setsFinalQueryOrdenProdu(String sFinalQueryOrdenProdu) {
		this.sFinalQueryOrdenProdu= sFinalQueryOrdenProdu;
	}
	
	public Border resaltarSeleccionarOrdenProdu=null;
	
	public Border setResaltarSeleccionarOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarOrdenProdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarOrdenProdu() {
		return this.resaltarSeleccionarOrdenProdu;
	}
	
	public void setResaltarSeleccionarOrdenProdu(Border borderResaltarSeleccionarOrdenProdu) {
		this.resaltarSeleccionarOrdenProdu= borderResaltarSeleccionarOrdenProdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridOrdenProdu=null;
	public Boolean mostraridOrdenProdu=true;
	public Boolean activaridOrdenProdu=true;

	public Border resaltarid_empresaOrdenProdu=null;
	public Boolean mostrarid_empresaOrdenProdu=true;
	public Boolean activarid_empresaOrdenProdu=true;
	public Boolean cargarid_empresaOrdenProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaOrdenProdu=false;//ConEventDepend=true

	public Border resaltarid_sucursalOrdenProdu=null;
	public Boolean mostrarid_sucursalOrdenProdu=true;
	public Boolean activarid_sucursalOrdenProdu=true;
	public Boolean cargarid_sucursalOrdenProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalOrdenProdu=false;//ConEventDepend=true

	public Border resaltarid_ejercicioOrdenProdu=null;
	public Boolean mostrarid_ejercicioOrdenProdu=true;
	public Boolean activarid_ejercicioOrdenProdu=true;
	public Boolean cargarid_ejercicioOrdenProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioOrdenProdu=false;//ConEventDepend=true

	public Border resaltarid_periodoOrdenProdu=null;
	public Boolean mostrarid_periodoOrdenProdu=true;
	public Boolean activarid_periodoOrdenProdu=true;
	public Boolean cargarid_periodoOrdenProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoOrdenProdu=false;//ConEventDepend=true

	public Border resaltarid_formatoOrdenProdu=null;
	public Boolean mostrarid_formatoOrdenProdu=true;
	public Boolean activarid_formatoOrdenProdu=true;
	public Boolean cargarid_formatoOrdenProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoOrdenProdu=false;//ConEventDepend=true

	public Border resaltarid_tipo_prioridad_empresa_produOrdenProdu=null;
	public Boolean mostrarid_tipo_prioridad_empresa_produOrdenProdu=true;
	public Boolean activarid_tipo_prioridad_empresa_produOrdenProdu=true;
	public Boolean cargarid_tipo_prioridad_empresa_produOrdenProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_prioridad_empresa_produOrdenProdu=false;//ConEventDepend=true

	public Border resaltarid_empleado_responsableOrdenProdu=null;
	public Boolean mostrarid_empleado_responsableOrdenProdu=true;
	public Boolean activarid_empleado_responsableOrdenProdu=true;
	public Boolean cargarid_empleado_responsableOrdenProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleado_responsableOrdenProdu=false;//ConEventDepend=true

	public Border resaltarsecuencialOrdenProdu=null;
	public Boolean mostrarsecuencialOrdenProdu=true;
	public Boolean activarsecuencialOrdenProdu=true;

	public Border resaltarid_clienteOrdenProdu=null;
	public Boolean mostrarid_clienteOrdenProdu=true;
	public Boolean activarid_clienteOrdenProdu=true;
	public Boolean cargarid_clienteOrdenProdu=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteOrdenProdu=false;//ConEventDepend=true

	public Border resaltardireccion_clienteOrdenProdu=null;
	public Boolean mostrardireccion_clienteOrdenProdu=true;
	public Boolean activardireccion_clienteOrdenProdu=true;

	public Border resaltartelefono_clienteOrdenProdu=null;
	public Boolean mostrartelefono_clienteOrdenProdu=true;
	public Boolean activartelefono_clienteOrdenProdu=true;

	public Border resaltarruc_clienteOrdenProdu=null;
	public Boolean mostrarruc_clienteOrdenProdu=true;
	public Boolean activarruc_clienteOrdenProdu=true;

	public Border resaltarloteOrdenProdu=null;
	public Boolean mostrarloteOrdenProdu=true;
	public Boolean activarloteOrdenProdu=true;

	public Border resaltarfecha_pedidoOrdenProdu=null;
	public Boolean mostrarfecha_pedidoOrdenProdu=true;
	public Boolean activarfecha_pedidoOrdenProdu=false;

	public Border resaltarfecha_entregaOrdenProdu=null;
	public Boolean mostrarfecha_entregaOrdenProdu=true;
	public Boolean activarfecha_entregaOrdenProdu=false;

	public Border resaltares_uso_internoOrdenProdu=null;
	public Boolean mostrares_uso_internoOrdenProdu=true;
	public Boolean activares_uso_internoOrdenProdu=true;

	public Border resaltarfechaOrdenProdu=null;
	public Boolean mostrarfechaOrdenProdu=true;
	public Boolean activarfechaOrdenProdu=false;

	public Border resaltardescripcionOrdenProdu=null;
	public Boolean mostrardescripcionOrdenProdu=true;
	public Boolean activardescripcionOrdenProdu=true;

	public Border resaltarid_estado_orden_produOrdenProdu=null;
	public Boolean mostrarid_estado_orden_produOrdenProdu=true;
	public Boolean activarid_estado_orden_produOrdenProdu=true;
	public Boolean cargarid_estado_orden_produOrdenProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_orden_produOrdenProdu=false;//ConEventDepend=true

	
	

	public Border setResaltaridOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltaridOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridOrdenProdu() {
		return this.resaltaridOrdenProdu;
	}

	public void setResaltaridOrdenProdu(Border borderResaltar) {
		this.resaltaridOrdenProdu= borderResaltar;
	}

	public Boolean getMostraridOrdenProdu() {
		return this.mostraridOrdenProdu;
	}

	public void setMostraridOrdenProdu(Boolean mostraridOrdenProdu) {
		this.mostraridOrdenProdu= mostraridOrdenProdu;
	}

	public Boolean getActivaridOrdenProdu() {
		return this.activaridOrdenProdu;
	}

	public void setActivaridOrdenProdu(Boolean activaridOrdenProdu) {
		this.activaridOrdenProdu= activaridOrdenProdu;
	}

	public Border setResaltarid_empresaOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarid_empresaOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaOrdenProdu() {
		return this.resaltarid_empresaOrdenProdu;
	}

	public void setResaltarid_empresaOrdenProdu(Border borderResaltar) {
		this.resaltarid_empresaOrdenProdu= borderResaltar;
	}

	public Boolean getMostrarid_empresaOrdenProdu() {
		return this.mostrarid_empresaOrdenProdu;
	}

	public void setMostrarid_empresaOrdenProdu(Boolean mostrarid_empresaOrdenProdu) {
		this.mostrarid_empresaOrdenProdu= mostrarid_empresaOrdenProdu;
	}

	public Boolean getActivarid_empresaOrdenProdu() {
		return this.activarid_empresaOrdenProdu;
	}

	public void setActivarid_empresaOrdenProdu(Boolean activarid_empresaOrdenProdu) {
		this.activarid_empresaOrdenProdu= activarid_empresaOrdenProdu;
	}

	public Boolean getCargarid_empresaOrdenProdu() {
		return this.cargarid_empresaOrdenProdu;
	}

	public void setCargarid_empresaOrdenProdu(Boolean cargarid_empresaOrdenProdu) {
		this.cargarid_empresaOrdenProdu= cargarid_empresaOrdenProdu;
	}

	public Border setResaltarid_sucursalOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarid_sucursalOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalOrdenProdu() {
		return this.resaltarid_sucursalOrdenProdu;
	}

	public void setResaltarid_sucursalOrdenProdu(Border borderResaltar) {
		this.resaltarid_sucursalOrdenProdu= borderResaltar;
	}

	public Boolean getMostrarid_sucursalOrdenProdu() {
		return this.mostrarid_sucursalOrdenProdu;
	}

	public void setMostrarid_sucursalOrdenProdu(Boolean mostrarid_sucursalOrdenProdu) {
		this.mostrarid_sucursalOrdenProdu= mostrarid_sucursalOrdenProdu;
	}

	public Boolean getActivarid_sucursalOrdenProdu() {
		return this.activarid_sucursalOrdenProdu;
	}

	public void setActivarid_sucursalOrdenProdu(Boolean activarid_sucursalOrdenProdu) {
		this.activarid_sucursalOrdenProdu= activarid_sucursalOrdenProdu;
	}

	public Boolean getCargarid_sucursalOrdenProdu() {
		return this.cargarid_sucursalOrdenProdu;
	}

	public void setCargarid_sucursalOrdenProdu(Boolean cargarid_sucursalOrdenProdu) {
		this.cargarid_sucursalOrdenProdu= cargarid_sucursalOrdenProdu;
	}

	public Border setResaltarid_ejercicioOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioOrdenProdu() {
		return this.resaltarid_ejercicioOrdenProdu;
	}

	public void setResaltarid_ejercicioOrdenProdu(Border borderResaltar) {
		this.resaltarid_ejercicioOrdenProdu= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioOrdenProdu() {
		return this.mostrarid_ejercicioOrdenProdu;
	}

	public void setMostrarid_ejercicioOrdenProdu(Boolean mostrarid_ejercicioOrdenProdu) {
		this.mostrarid_ejercicioOrdenProdu= mostrarid_ejercicioOrdenProdu;
	}

	public Boolean getActivarid_ejercicioOrdenProdu() {
		return this.activarid_ejercicioOrdenProdu;
	}

	public void setActivarid_ejercicioOrdenProdu(Boolean activarid_ejercicioOrdenProdu) {
		this.activarid_ejercicioOrdenProdu= activarid_ejercicioOrdenProdu;
	}

	public Boolean getCargarid_ejercicioOrdenProdu() {
		return this.cargarid_ejercicioOrdenProdu;
	}

	public void setCargarid_ejercicioOrdenProdu(Boolean cargarid_ejercicioOrdenProdu) {
		this.cargarid_ejercicioOrdenProdu= cargarid_ejercicioOrdenProdu;
	}

	public Border setResaltarid_periodoOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarid_periodoOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoOrdenProdu() {
		return this.resaltarid_periodoOrdenProdu;
	}

	public void setResaltarid_periodoOrdenProdu(Border borderResaltar) {
		this.resaltarid_periodoOrdenProdu= borderResaltar;
	}

	public Boolean getMostrarid_periodoOrdenProdu() {
		return this.mostrarid_periodoOrdenProdu;
	}

	public void setMostrarid_periodoOrdenProdu(Boolean mostrarid_periodoOrdenProdu) {
		this.mostrarid_periodoOrdenProdu= mostrarid_periodoOrdenProdu;
	}

	public Boolean getActivarid_periodoOrdenProdu() {
		return this.activarid_periodoOrdenProdu;
	}

	public void setActivarid_periodoOrdenProdu(Boolean activarid_periodoOrdenProdu) {
		this.activarid_periodoOrdenProdu= activarid_periodoOrdenProdu;
	}

	public Boolean getCargarid_periodoOrdenProdu() {
		return this.cargarid_periodoOrdenProdu;
	}

	public void setCargarid_periodoOrdenProdu(Boolean cargarid_periodoOrdenProdu) {
		this.cargarid_periodoOrdenProdu= cargarid_periodoOrdenProdu;
	}

	public Border setResaltarid_formatoOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarid_formatoOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoOrdenProdu() {
		return this.resaltarid_formatoOrdenProdu;
	}

	public void setResaltarid_formatoOrdenProdu(Border borderResaltar) {
		this.resaltarid_formatoOrdenProdu= borderResaltar;
	}

	public Boolean getMostrarid_formatoOrdenProdu() {
		return this.mostrarid_formatoOrdenProdu;
	}

	public void setMostrarid_formatoOrdenProdu(Boolean mostrarid_formatoOrdenProdu) {
		this.mostrarid_formatoOrdenProdu= mostrarid_formatoOrdenProdu;
	}

	public Boolean getActivarid_formatoOrdenProdu() {
		return this.activarid_formatoOrdenProdu;
	}

	public void setActivarid_formatoOrdenProdu(Boolean activarid_formatoOrdenProdu) {
		this.activarid_formatoOrdenProdu= activarid_formatoOrdenProdu;
	}

	public Boolean getCargarid_formatoOrdenProdu() {
		return this.cargarid_formatoOrdenProdu;
	}

	public void setCargarid_formatoOrdenProdu(Boolean cargarid_formatoOrdenProdu) {
		this.cargarid_formatoOrdenProdu= cargarid_formatoOrdenProdu;
	}

	public Border setResaltarid_tipo_prioridad_empresa_produOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarid_tipo_prioridad_empresa_produOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_prioridad_empresa_produOrdenProdu() {
		return this.resaltarid_tipo_prioridad_empresa_produOrdenProdu;
	}

	public void setResaltarid_tipo_prioridad_empresa_produOrdenProdu(Border borderResaltar) {
		this.resaltarid_tipo_prioridad_empresa_produOrdenProdu= borderResaltar;
	}

	public Boolean getMostrarid_tipo_prioridad_empresa_produOrdenProdu() {
		return this.mostrarid_tipo_prioridad_empresa_produOrdenProdu;
	}

	public void setMostrarid_tipo_prioridad_empresa_produOrdenProdu(Boolean mostrarid_tipo_prioridad_empresa_produOrdenProdu) {
		this.mostrarid_tipo_prioridad_empresa_produOrdenProdu= mostrarid_tipo_prioridad_empresa_produOrdenProdu;
	}

	public Boolean getActivarid_tipo_prioridad_empresa_produOrdenProdu() {
		return this.activarid_tipo_prioridad_empresa_produOrdenProdu;
	}

	public void setActivarid_tipo_prioridad_empresa_produOrdenProdu(Boolean activarid_tipo_prioridad_empresa_produOrdenProdu) {
		this.activarid_tipo_prioridad_empresa_produOrdenProdu= activarid_tipo_prioridad_empresa_produOrdenProdu;
	}

	public Boolean getCargarid_tipo_prioridad_empresa_produOrdenProdu() {
		return this.cargarid_tipo_prioridad_empresa_produOrdenProdu;
	}

	public void setCargarid_tipo_prioridad_empresa_produOrdenProdu(Boolean cargarid_tipo_prioridad_empresa_produOrdenProdu) {
		this.cargarid_tipo_prioridad_empresa_produOrdenProdu= cargarid_tipo_prioridad_empresa_produOrdenProdu;
	}

	public Border setResaltarid_empleado_responsableOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarid_empleado_responsableOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleado_responsableOrdenProdu() {
		return this.resaltarid_empleado_responsableOrdenProdu;
	}

	public void setResaltarid_empleado_responsableOrdenProdu(Border borderResaltar) {
		this.resaltarid_empleado_responsableOrdenProdu= borderResaltar;
	}

	public Boolean getMostrarid_empleado_responsableOrdenProdu() {
		return this.mostrarid_empleado_responsableOrdenProdu;
	}

	public void setMostrarid_empleado_responsableOrdenProdu(Boolean mostrarid_empleado_responsableOrdenProdu) {
		this.mostrarid_empleado_responsableOrdenProdu= mostrarid_empleado_responsableOrdenProdu;
	}

	public Boolean getActivarid_empleado_responsableOrdenProdu() {
		return this.activarid_empleado_responsableOrdenProdu;
	}

	public void setActivarid_empleado_responsableOrdenProdu(Boolean activarid_empleado_responsableOrdenProdu) {
		this.activarid_empleado_responsableOrdenProdu= activarid_empleado_responsableOrdenProdu;
	}

	public Boolean getCargarid_empleado_responsableOrdenProdu() {
		return this.cargarid_empleado_responsableOrdenProdu;
	}

	public void setCargarid_empleado_responsableOrdenProdu(Boolean cargarid_empleado_responsableOrdenProdu) {
		this.cargarid_empleado_responsableOrdenProdu= cargarid_empleado_responsableOrdenProdu;
	}

	public Border setResaltarsecuencialOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarsecuencialOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialOrdenProdu() {
		return this.resaltarsecuencialOrdenProdu;
	}

	public void setResaltarsecuencialOrdenProdu(Border borderResaltar) {
		this.resaltarsecuencialOrdenProdu= borderResaltar;
	}

	public Boolean getMostrarsecuencialOrdenProdu() {
		return this.mostrarsecuencialOrdenProdu;
	}

	public void setMostrarsecuencialOrdenProdu(Boolean mostrarsecuencialOrdenProdu) {
		this.mostrarsecuencialOrdenProdu= mostrarsecuencialOrdenProdu;
	}

	public Boolean getActivarsecuencialOrdenProdu() {
		return this.activarsecuencialOrdenProdu;
	}

	public void setActivarsecuencialOrdenProdu(Boolean activarsecuencialOrdenProdu) {
		this.activarsecuencialOrdenProdu= activarsecuencialOrdenProdu;
	}

	public Border setResaltarid_clienteOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarid_clienteOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteOrdenProdu() {
		return this.resaltarid_clienteOrdenProdu;
	}

	public void setResaltarid_clienteOrdenProdu(Border borderResaltar) {
		this.resaltarid_clienteOrdenProdu= borderResaltar;
	}

	public Boolean getMostrarid_clienteOrdenProdu() {
		return this.mostrarid_clienteOrdenProdu;
	}

	public void setMostrarid_clienteOrdenProdu(Boolean mostrarid_clienteOrdenProdu) {
		this.mostrarid_clienteOrdenProdu= mostrarid_clienteOrdenProdu;
	}

	public Boolean getActivarid_clienteOrdenProdu() {
		return this.activarid_clienteOrdenProdu;
	}

	public void setActivarid_clienteOrdenProdu(Boolean activarid_clienteOrdenProdu) {
		this.activarid_clienteOrdenProdu= activarid_clienteOrdenProdu;
	}

	public Boolean getCargarid_clienteOrdenProdu() {
		return this.cargarid_clienteOrdenProdu;
	}

	public void setCargarid_clienteOrdenProdu(Boolean cargarid_clienteOrdenProdu) {
		this.cargarid_clienteOrdenProdu= cargarid_clienteOrdenProdu;
	}

	public Border setResaltardireccion_clienteOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltardireccion_clienteOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_clienteOrdenProdu() {
		return this.resaltardireccion_clienteOrdenProdu;
	}

	public void setResaltardireccion_clienteOrdenProdu(Border borderResaltar) {
		this.resaltardireccion_clienteOrdenProdu= borderResaltar;
	}

	public Boolean getMostrardireccion_clienteOrdenProdu() {
		return this.mostrardireccion_clienteOrdenProdu;
	}

	public void setMostrardireccion_clienteOrdenProdu(Boolean mostrardireccion_clienteOrdenProdu) {
		this.mostrardireccion_clienteOrdenProdu= mostrardireccion_clienteOrdenProdu;
	}

	public Boolean getActivardireccion_clienteOrdenProdu() {
		return this.activardireccion_clienteOrdenProdu;
	}

	public void setActivardireccion_clienteOrdenProdu(Boolean activardireccion_clienteOrdenProdu) {
		this.activardireccion_clienteOrdenProdu= activardireccion_clienteOrdenProdu;
	}

	public Border setResaltartelefono_clienteOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltartelefono_clienteOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_clienteOrdenProdu() {
		return this.resaltartelefono_clienteOrdenProdu;
	}

	public void setResaltartelefono_clienteOrdenProdu(Border borderResaltar) {
		this.resaltartelefono_clienteOrdenProdu= borderResaltar;
	}

	public Boolean getMostrartelefono_clienteOrdenProdu() {
		return this.mostrartelefono_clienteOrdenProdu;
	}

	public void setMostrartelefono_clienteOrdenProdu(Boolean mostrartelefono_clienteOrdenProdu) {
		this.mostrartelefono_clienteOrdenProdu= mostrartelefono_clienteOrdenProdu;
	}

	public Boolean getActivartelefono_clienteOrdenProdu() {
		return this.activartelefono_clienteOrdenProdu;
	}

	public void setActivartelefono_clienteOrdenProdu(Boolean activartelefono_clienteOrdenProdu) {
		this.activartelefono_clienteOrdenProdu= activartelefono_clienteOrdenProdu;
	}

	public Border setResaltarruc_clienteOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarruc_clienteOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_clienteOrdenProdu() {
		return this.resaltarruc_clienteOrdenProdu;
	}

	public void setResaltarruc_clienteOrdenProdu(Border borderResaltar) {
		this.resaltarruc_clienteOrdenProdu= borderResaltar;
	}

	public Boolean getMostrarruc_clienteOrdenProdu() {
		return this.mostrarruc_clienteOrdenProdu;
	}

	public void setMostrarruc_clienteOrdenProdu(Boolean mostrarruc_clienteOrdenProdu) {
		this.mostrarruc_clienteOrdenProdu= mostrarruc_clienteOrdenProdu;
	}

	public Boolean getActivarruc_clienteOrdenProdu() {
		return this.activarruc_clienteOrdenProdu;
	}

	public void setActivarruc_clienteOrdenProdu(Boolean activarruc_clienteOrdenProdu) {
		this.activarruc_clienteOrdenProdu= activarruc_clienteOrdenProdu;
	}

	public Border setResaltarloteOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarloteOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarloteOrdenProdu() {
		return this.resaltarloteOrdenProdu;
	}

	public void setResaltarloteOrdenProdu(Border borderResaltar) {
		this.resaltarloteOrdenProdu= borderResaltar;
	}

	public Boolean getMostrarloteOrdenProdu() {
		return this.mostrarloteOrdenProdu;
	}

	public void setMostrarloteOrdenProdu(Boolean mostrarloteOrdenProdu) {
		this.mostrarloteOrdenProdu= mostrarloteOrdenProdu;
	}

	public Boolean getActivarloteOrdenProdu() {
		return this.activarloteOrdenProdu;
	}

	public void setActivarloteOrdenProdu(Boolean activarloteOrdenProdu) {
		this.activarloteOrdenProdu= activarloteOrdenProdu;
	}

	public Border setResaltarfecha_pedidoOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarfecha_pedidoOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_pedidoOrdenProdu() {
		return this.resaltarfecha_pedidoOrdenProdu;
	}

	public void setResaltarfecha_pedidoOrdenProdu(Border borderResaltar) {
		this.resaltarfecha_pedidoOrdenProdu= borderResaltar;
	}

	public Boolean getMostrarfecha_pedidoOrdenProdu() {
		return this.mostrarfecha_pedidoOrdenProdu;
	}

	public void setMostrarfecha_pedidoOrdenProdu(Boolean mostrarfecha_pedidoOrdenProdu) {
		this.mostrarfecha_pedidoOrdenProdu= mostrarfecha_pedidoOrdenProdu;
	}

	public Boolean getActivarfecha_pedidoOrdenProdu() {
		return this.activarfecha_pedidoOrdenProdu;
	}

	public void setActivarfecha_pedidoOrdenProdu(Boolean activarfecha_pedidoOrdenProdu) {
		this.activarfecha_pedidoOrdenProdu= activarfecha_pedidoOrdenProdu;
	}

	public Border setResaltarfecha_entregaOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaOrdenProdu() {
		return this.resaltarfecha_entregaOrdenProdu;
	}

	public void setResaltarfecha_entregaOrdenProdu(Border borderResaltar) {
		this.resaltarfecha_entregaOrdenProdu= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaOrdenProdu() {
		return this.mostrarfecha_entregaOrdenProdu;
	}

	public void setMostrarfecha_entregaOrdenProdu(Boolean mostrarfecha_entregaOrdenProdu) {
		this.mostrarfecha_entregaOrdenProdu= mostrarfecha_entregaOrdenProdu;
	}

	public Boolean getActivarfecha_entregaOrdenProdu() {
		return this.activarfecha_entregaOrdenProdu;
	}

	public void setActivarfecha_entregaOrdenProdu(Boolean activarfecha_entregaOrdenProdu) {
		this.activarfecha_entregaOrdenProdu= activarfecha_entregaOrdenProdu;
	}

	public Border setResaltares_uso_internoOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltares_uso_internoOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_uso_internoOrdenProdu() {
		return this.resaltares_uso_internoOrdenProdu;
	}

	public void setResaltares_uso_internoOrdenProdu(Border borderResaltar) {
		this.resaltares_uso_internoOrdenProdu= borderResaltar;
	}

	public Boolean getMostrares_uso_internoOrdenProdu() {
		return this.mostrares_uso_internoOrdenProdu;
	}

	public void setMostrares_uso_internoOrdenProdu(Boolean mostrares_uso_internoOrdenProdu) {
		this.mostrares_uso_internoOrdenProdu= mostrares_uso_internoOrdenProdu;
	}

	public Boolean getActivares_uso_internoOrdenProdu() {
		return this.activares_uso_internoOrdenProdu;
	}

	public void setActivares_uso_internoOrdenProdu(Boolean activares_uso_internoOrdenProdu) {
		this.activares_uso_internoOrdenProdu= activares_uso_internoOrdenProdu;
	}

	public Border setResaltarfechaOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarfechaOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaOrdenProdu() {
		return this.resaltarfechaOrdenProdu;
	}

	public void setResaltarfechaOrdenProdu(Border borderResaltar) {
		this.resaltarfechaOrdenProdu= borderResaltar;
	}

	public Boolean getMostrarfechaOrdenProdu() {
		return this.mostrarfechaOrdenProdu;
	}

	public void setMostrarfechaOrdenProdu(Boolean mostrarfechaOrdenProdu) {
		this.mostrarfechaOrdenProdu= mostrarfechaOrdenProdu;
	}

	public Boolean getActivarfechaOrdenProdu() {
		return this.activarfechaOrdenProdu;
	}

	public void setActivarfechaOrdenProdu(Boolean activarfechaOrdenProdu) {
		this.activarfechaOrdenProdu= activarfechaOrdenProdu;
	}

	public Border setResaltardescripcionOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltardescripcionOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionOrdenProdu() {
		return this.resaltardescripcionOrdenProdu;
	}

	public void setResaltardescripcionOrdenProdu(Border borderResaltar) {
		this.resaltardescripcionOrdenProdu= borderResaltar;
	}

	public Boolean getMostrardescripcionOrdenProdu() {
		return this.mostrardescripcionOrdenProdu;
	}

	public void setMostrardescripcionOrdenProdu(Boolean mostrardescripcionOrdenProdu) {
		this.mostrardescripcionOrdenProdu= mostrardescripcionOrdenProdu;
	}

	public Boolean getActivardescripcionOrdenProdu() {
		return this.activardescripcionOrdenProdu;
	}

	public void setActivardescripcionOrdenProdu(Boolean activardescripcionOrdenProdu) {
		this.activardescripcionOrdenProdu= activardescripcionOrdenProdu;
	}

	public Border setResaltarid_estado_orden_produOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltar);
		
		this.resaltarid_estado_orden_produOrdenProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_orden_produOrdenProdu() {
		return this.resaltarid_estado_orden_produOrdenProdu;
	}

	public void setResaltarid_estado_orden_produOrdenProdu(Border borderResaltar) {
		this.resaltarid_estado_orden_produOrdenProdu= borderResaltar;
	}

	public Boolean getMostrarid_estado_orden_produOrdenProdu() {
		return this.mostrarid_estado_orden_produOrdenProdu;
	}

	public void setMostrarid_estado_orden_produOrdenProdu(Boolean mostrarid_estado_orden_produOrdenProdu) {
		this.mostrarid_estado_orden_produOrdenProdu= mostrarid_estado_orden_produOrdenProdu;
	}

	public Boolean getActivarid_estado_orden_produOrdenProdu() {
		return this.activarid_estado_orden_produOrdenProdu;
	}

	public void setActivarid_estado_orden_produOrdenProdu(Boolean activarid_estado_orden_produOrdenProdu) {
		this.activarid_estado_orden_produOrdenProdu= activarid_estado_orden_produOrdenProdu;
	}

	public Boolean getCargarid_estado_orden_produOrdenProdu() {
		return this.cargarid_estado_orden_produOrdenProdu;
	}

	public void setCargarid_estado_orden_produOrdenProdu(Boolean cargarid_estado_orden_produOrdenProdu) {
		this.cargarid_estado_orden_produOrdenProdu= cargarid_estado_orden_produOrdenProdu;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridOrdenProdu(esInicial);
		this.setMostrarid_empresaOrdenProdu(esInicial);
		this.setMostrarid_sucursalOrdenProdu(esInicial);
		this.setMostrarid_ejercicioOrdenProdu(esInicial);
		this.setMostrarid_periodoOrdenProdu(esInicial);
		this.setMostrarid_formatoOrdenProdu(esInicial);
		this.setMostrarid_tipo_prioridad_empresa_produOrdenProdu(esInicial);
		this.setMostrarid_empleado_responsableOrdenProdu(esInicial);
		this.setMostrarsecuencialOrdenProdu(esInicial);
		this.setMostrarid_clienteOrdenProdu(esInicial);
		this.setMostrardireccion_clienteOrdenProdu(esInicial);
		this.setMostrartelefono_clienteOrdenProdu(esInicial);
		this.setMostrarruc_clienteOrdenProdu(esInicial);
		this.setMostrarloteOrdenProdu(esInicial);
		this.setMostrarfecha_pedidoOrdenProdu(esInicial);
		this.setMostrarfecha_entregaOrdenProdu(esInicial);
		this.setMostrares_uso_internoOrdenProdu(esInicial);
		this.setMostrarfechaOrdenProdu(esInicial);
		this.setMostrardescripcionOrdenProdu(esInicial);
		this.setMostrarid_estado_orden_produOrdenProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(OrdenProduConstantesFunciones.ID)) {
				this.setMostraridOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU)) {
				this.setMostrarid_tipo_prioridad_empresa_produOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDEMPLEADORESPONSABLE)) {
				this.setMostrarid_empleado_responsableOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setMostrardireccion_clienteOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.TELEFONOCLIENTE)) {
				this.setMostrartelefono_clienteOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.RUCCLIENTE)) {
				this.setMostrarruc_clienteOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.LOTE)) {
				this.setMostrarloteOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.FECHAPEDIDO)) {
				this.setMostrarfecha_pedidoOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.ESUSOINTERNO)) {
				this.setMostrares_uso_internoOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.FECHA)) {
				this.setMostrarfechaOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDESTADOORDENPRODU)) {
				this.setMostrarid_estado_orden_produOrdenProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridOrdenProdu(esInicial);
		this.setActivarid_empresaOrdenProdu(esInicial);
		this.setActivarid_sucursalOrdenProdu(esInicial);
		this.setActivarid_ejercicioOrdenProdu(esInicial);
		this.setActivarid_periodoOrdenProdu(esInicial);
		this.setActivarid_formatoOrdenProdu(esInicial);
		this.setActivarid_tipo_prioridad_empresa_produOrdenProdu(esInicial);
		this.setActivarid_empleado_responsableOrdenProdu(esInicial);
		this.setActivarsecuencialOrdenProdu(esInicial);
		this.setActivarid_clienteOrdenProdu(esInicial);
		this.setActivardireccion_clienteOrdenProdu(esInicial);
		this.setActivartelefono_clienteOrdenProdu(esInicial);
		this.setActivarruc_clienteOrdenProdu(esInicial);
		this.setActivarloteOrdenProdu(esInicial);
		this.setActivarfecha_pedidoOrdenProdu(esInicial);
		this.setActivarfecha_entregaOrdenProdu(esInicial);
		this.setActivares_uso_internoOrdenProdu(esInicial);
		this.setActivarfechaOrdenProdu(esInicial);
		this.setActivardescripcionOrdenProdu(esInicial);
		this.setActivarid_estado_orden_produOrdenProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(OrdenProduConstantesFunciones.ID)) {
				this.setActivaridOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU)) {
				this.setActivarid_tipo_prioridad_empresa_produOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDEMPLEADORESPONSABLE)) {
				this.setActivarid_empleado_responsableOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setActivardireccion_clienteOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.TELEFONOCLIENTE)) {
				this.setActivartelefono_clienteOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.RUCCLIENTE)) {
				this.setActivarruc_clienteOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.LOTE)) {
				this.setActivarloteOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.FECHAPEDIDO)) {
				this.setActivarfecha_pedidoOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.ESUSOINTERNO)) {
				this.setActivares_uso_internoOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.FECHA)) {
				this.setActivarfechaOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDESTADOORDENPRODU)) {
				this.setActivarid_estado_orden_produOrdenProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridOrdenProdu(esInicial);
		this.setResaltarid_empresaOrdenProdu(esInicial);
		this.setResaltarid_sucursalOrdenProdu(esInicial);
		this.setResaltarid_ejercicioOrdenProdu(esInicial);
		this.setResaltarid_periodoOrdenProdu(esInicial);
		this.setResaltarid_formatoOrdenProdu(esInicial);
		this.setResaltarid_tipo_prioridad_empresa_produOrdenProdu(esInicial);
		this.setResaltarid_empleado_responsableOrdenProdu(esInicial);
		this.setResaltarsecuencialOrdenProdu(esInicial);
		this.setResaltarid_clienteOrdenProdu(esInicial);
		this.setResaltardireccion_clienteOrdenProdu(esInicial);
		this.setResaltartelefono_clienteOrdenProdu(esInicial);
		this.setResaltarruc_clienteOrdenProdu(esInicial);
		this.setResaltarloteOrdenProdu(esInicial);
		this.setResaltarfecha_pedidoOrdenProdu(esInicial);
		this.setResaltarfecha_entregaOrdenProdu(esInicial);
		this.setResaltares_uso_internoOrdenProdu(esInicial);
		this.setResaltarfechaOrdenProdu(esInicial);
		this.setResaltardescripcionOrdenProdu(esInicial);
		this.setResaltarid_estado_orden_produOrdenProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(OrdenProduConstantesFunciones.ID)) {
				this.setResaltaridOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU)) {
				this.setResaltarid_tipo_prioridad_empresa_produOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDEMPLEADORESPONSABLE)) {
				this.setResaltarid_empleado_responsableOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setResaltardireccion_clienteOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.TELEFONOCLIENTE)) {
				this.setResaltartelefono_clienteOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.RUCCLIENTE)) {
				this.setResaltarruc_clienteOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.LOTE)) {
				this.setResaltarloteOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.FECHAPEDIDO)) {
				this.setResaltarfecha_pedidoOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.ESUSOINTERNO)) {
				this.setResaltares_uso_internoOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.FECHA)) {
				this.setResaltarfechaOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionOrdenProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenProduConstantesFunciones.IDESTADOORDENPRODU)) {
				this.setResaltarid_estado_orden_produOrdenProdu(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarOrdenDetaProduOrdenProdu=null;

	public Border getResaltarOrdenDetaProduOrdenProdu() {
		return this.resaltarOrdenDetaProduOrdenProdu;
	}

	public void setResaltarOrdenDetaProduOrdenProdu(Border borderResaltarOrdenDetaProdu) {
		if(borderResaltarOrdenDetaProdu!=null) {
			this.resaltarOrdenDetaProduOrdenProdu= borderResaltarOrdenDetaProdu;
		}
	}

	public Border setResaltarOrdenDetaProduOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltarOrdenDetaProdu=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//ordenproduBeanSwingJInternalFrame.jTtoolBarOrdenProdu.setBorder(borderResaltarOrdenDetaProdu);
			
		this.resaltarOrdenDetaProduOrdenProdu= borderResaltarOrdenDetaProdu;

		 return borderResaltarOrdenDetaProdu;
	}



	public Boolean mostrarOrdenDetaProduOrdenProdu=true;

	public Boolean getMostrarOrdenDetaProduOrdenProdu() {
		return this.mostrarOrdenDetaProduOrdenProdu;
	}

	public void setMostrarOrdenDetaProduOrdenProdu(Boolean visibilidadResaltarOrdenDetaProdu) {
		this.mostrarOrdenDetaProduOrdenProdu= visibilidadResaltarOrdenDetaProdu;
	}



	public Boolean activarOrdenDetaProduOrdenProdu=true;

	public Boolean gethabilitarResaltarOrdenDetaProduOrdenProdu() {
		return this.activarOrdenDetaProduOrdenProdu;
	}

	public void setActivarOrdenDetaProduOrdenProdu(Boolean habilitarResaltarOrdenDetaProdu) {
		this.activarOrdenDetaProduOrdenProdu= habilitarResaltarOrdenDetaProdu;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarOrdenDetaProduOrdenProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(OrdenDetaProdu.class)) {
				this.setMostrarOrdenDetaProduOrdenProdu(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarOrdenDetaProduOrdenProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(OrdenDetaProdu.class)) {
				this.setActivarOrdenDetaProduOrdenProdu(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarOrdenDetaProduOrdenProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(OrdenDetaProdu.class)) {
				this.setResaltarOrdenDetaProduOrdenProdu(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdClienteOrdenProdu=true;

	public Boolean getMostrarFK_IdClienteOrdenProdu() {
		return this.mostrarFK_IdClienteOrdenProdu;
	}

	public void setMostrarFK_IdClienteOrdenProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteOrdenProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioOrdenProdu=true;

	public Boolean getMostrarFK_IdEjercicioOrdenProdu() {
		return this.mostrarFK_IdEjercicioOrdenProdu;
	}

	public void setMostrarFK_IdEjercicioOrdenProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioOrdenProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoResponsableOrdenProdu=true;

	public Boolean getMostrarFK_IdEmpleadoResponsableOrdenProdu() {
		return this.mostrarFK_IdEmpleadoResponsableOrdenProdu;
	}

	public void setMostrarFK_IdEmpleadoResponsableOrdenProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoResponsableOrdenProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaOrdenProdu=true;

	public Boolean getMostrarFK_IdEmpresaOrdenProdu() {
		return this.mostrarFK_IdEmpresaOrdenProdu;
	}

	public void setMostrarFK_IdEmpresaOrdenProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaOrdenProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoOrdenProduOrdenProdu=true;

	public Boolean getMostrarFK_IdEstadoOrdenProduOrdenProdu() {
		return this.mostrarFK_IdEstadoOrdenProduOrdenProdu;
	}

	public void setMostrarFK_IdEstadoOrdenProduOrdenProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoOrdenProduOrdenProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoOrdenProdu=true;

	public Boolean getMostrarFK_IdFormatoOrdenProdu() {
		return this.mostrarFK_IdFormatoOrdenProdu;
	}

	public void setMostrarFK_IdFormatoOrdenProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoOrdenProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoOrdenProdu=true;

	public Boolean getMostrarFK_IdPeriodoOrdenProdu() {
		return this.mostrarFK_IdPeriodoOrdenProdu;
	}

	public void setMostrarFK_IdPeriodoOrdenProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoOrdenProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalOrdenProdu=true;

	public Boolean getMostrarFK_IdSucursalOrdenProdu() {
		return this.mostrarFK_IdSucursalOrdenProdu;
	}

	public void setMostrarFK_IdSucursalOrdenProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalOrdenProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrioridadEmpresaProduOrdenProdu=true;

	public Boolean getMostrarFK_IdTipoPrioridadEmpresaProduOrdenProdu() {
		return this.mostrarFK_IdTipoPrioridadEmpresaProduOrdenProdu;
	}

	public void setMostrarFK_IdTipoPrioridadEmpresaProduOrdenProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrioridadEmpresaProduOrdenProdu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteOrdenProdu=true;

	public Boolean getActivarFK_IdClienteOrdenProdu() {
		return this.activarFK_IdClienteOrdenProdu;
	}

	public void setActivarFK_IdClienteOrdenProdu(Boolean habilitarResaltar) {
		this.activarFK_IdClienteOrdenProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioOrdenProdu=true;

	public Boolean getActivarFK_IdEjercicioOrdenProdu() {
		return this.activarFK_IdEjercicioOrdenProdu;
	}

	public void setActivarFK_IdEjercicioOrdenProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioOrdenProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoResponsableOrdenProdu=true;

	public Boolean getActivarFK_IdEmpleadoResponsableOrdenProdu() {
		return this.activarFK_IdEmpleadoResponsableOrdenProdu;
	}

	public void setActivarFK_IdEmpleadoResponsableOrdenProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoResponsableOrdenProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaOrdenProdu=true;

	public Boolean getActivarFK_IdEmpresaOrdenProdu() {
		return this.activarFK_IdEmpresaOrdenProdu;
	}

	public void setActivarFK_IdEmpresaOrdenProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaOrdenProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoOrdenProduOrdenProdu=true;

	public Boolean getActivarFK_IdEstadoOrdenProduOrdenProdu() {
		return this.activarFK_IdEstadoOrdenProduOrdenProdu;
	}

	public void setActivarFK_IdEstadoOrdenProduOrdenProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoOrdenProduOrdenProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoOrdenProdu=true;

	public Boolean getActivarFK_IdFormatoOrdenProdu() {
		return this.activarFK_IdFormatoOrdenProdu;
	}

	public void setActivarFK_IdFormatoOrdenProdu(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoOrdenProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoOrdenProdu=true;

	public Boolean getActivarFK_IdPeriodoOrdenProdu() {
		return this.activarFK_IdPeriodoOrdenProdu;
	}

	public void setActivarFK_IdPeriodoOrdenProdu(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoOrdenProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalOrdenProdu=true;

	public Boolean getActivarFK_IdSucursalOrdenProdu() {
		return this.activarFK_IdSucursalOrdenProdu;
	}

	public void setActivarFK_IdSucursalOrdenProdu(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalOrdenProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrioridadEmpresaProduOrdenProdu=true;

	public Boolean getActivarFK_IdTipoPrioridadEmpresaProduOrdenProdu() {
		return this.activarFK_IdTipoPrioridadEmpresaProduOrdenProdu;
	}

	public void setActivarFK_IdTipoPrioridadEmpresaProduOrdenProdu(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrioridadEmpresaProduOrdenProdu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteOrdenProdu=null;

	public Border getResaltarFK_IdClienteOrdenProdu() {
		return this.resaltarFK_IdClienteOrdenProdu;
	}

	public void setResaltarFK_IdClienteOrdenProdu(Border borderResaltar) {
		this.resaltarFK_IdClienteOrdenProdu= borderResaltar;
	}

	public void setResaltarFK_IdClienteOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteOrdenProdu= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioOrdenProdu=null;

	public Border getResaltarFK_IdEjercicioOrdenProdu() {
		return this.resaltarFK_IdEjercicioOrdenProdu;
	}

	public void setResaltarFK_IdEjercicioOrdenProdu(Border borderResaltar) {
		this.resaltarFK_IdEjercicioOrdenProdu= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioOrdenProdu= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoResponsableOrdenProdu=null;

	public Border getResaltarFK_IdEmpleadoResponsableOrdenProdu() {
		return this.resaltarFK_IdEmpleadoResponsableOrdenProdu;
	}

	public void setResaltarFK_IdEmpleadoResponsableOrdenProdu(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoResponsableOrdenProdu= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoResponsableOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoResponsableOrdenProdu= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaOrdenProdu=null;

	public Border getResaltarFK_IdEmpresaOrdenProdu() {
		return this.resaltarFK_IdEmpresaOrdenProdu;
	}

	public void setResaltarFK_IdEmpresaOrdenProdu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaOrdenProdu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaOrdenProdu= borderResaltar;
	}

	public Border resaltarFK_IdEstadoOrdenProduOrdenProdu=null;

	public Border getResaltarFK_IdEstadoOrdenProduOrdenProdu() {
		return this.resaltarFK_IdEstadoOrdenProduOrdenProdu;
	}

	public void setResaltarFK_IdEstadoOrdenProduOrdenProdu(Border borderResaltar) {
		this.resaltarFK_IdEstadoOrdenProduOrdenProdu= borderResaltar;
	}

	public void setResaltarFK_IdEstadoOrdenProduOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoOrdenProduOrdenProdu= borderResaltar;
	}

	public Border resaltarFK_IdFormatoOrdenProdu=null;

	public Border getResaltarFK_IdFormatoOrdenProdu() {
		return this.resaltarFK_IdFormatoOrdenProdu;
	}

	public void setResaltarFK_IdFormatoOrdenProdu(Border borderResaltar) {
		this.resaltarFK_IdFormatoOrdenProdu= borderResaltar;
	}

	public void setResaltarFK_IdFormatoOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoOrdenProdu= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoOrdenProdu=null;

	public Border getResaltarFK_IdPeriodoOrdenProdu() {
		return this.resaltarFK_IdPeriodoOrdenProdu;
	}

	public void setResaltarFK_IdPeriodoOrdenProdu(Border borderResaltar) {
		this.resaltarFK_IdPeriodoOrdenProdu= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoOrdenProdu= borderResaltar;
	}

	public Border resaltarFK_IdSucursalOrdenProdu=null;

	public Border getResaltarFK_IdSucursalOrdenProdu() {
		return this.resaltarFK_IdSucursalOrdenProdu;
	}

	public void setResaltarFK_IdSucursalOrdenProdu(Border borderResaltar) {
		this.resaltarFK_IdSucursalOrdenProdu= borderResaltar;
	}

	public void setResaltarFK_IdSucursalOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalOrdenProdu= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrioridadEmpresaProduOrdenProdu=null;

	public Border getResaltarFK_IdTipoPrioridadEmpresaProduOrdenProdu() {
		return this.resaltarFK_IdTipoPrioridadEmpresaProduOrdenProdu;
	}

	public void setResaltarFK_IdTipoPrioridadEmpresaProduOrdenProdu(Border borderResaltar) {
		this.resaltarFK_IdTipoPrioridadEmpresaProduOrdenProdu= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrioridadEmpresaProduOrdenProdu(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenProduBeanSwingJInternalFrame ordenproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrioridadEmpresaProduOrdenProdu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}