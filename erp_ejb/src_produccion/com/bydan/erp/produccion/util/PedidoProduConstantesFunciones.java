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


import com.bydan.erp.produccion.util.PedidoProduConstantesFunciones;
import com.bydan.erp.produccion.util.PedidoProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.PedidoProduParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PedidoProduConstantesFunciones extends PedidoProduConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PedidoProdu";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PedidoProdu"+PedidoProduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PedidoProduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PedidoProduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PedidoProduConstantesFunciones.SCHEMA+"_"+PedidoProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PedidoProduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PedidoProduConstantesFunciones.SCHEMA+"_"+PedidoProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PedidoProduConstantesFunciones.SCHEMA+"_"+PedidoProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PedidoProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PedidoProduConstantesFunciones.SCHEMA+"_"+PedidoProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidoProduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidoProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PedidoProduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PedidoProduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PedidoProduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PedidoProduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pedido Producciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Pedido Produccion";
	public static final String SCLASSWEBTITULO_LOWER="Pedido Produ";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PedidoProdu";
	public static final String OBJECTNAME="pedidoprodu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="pedido_produ";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select pedidoprodu from "+PedidoProduConstantesFunciones.SPERSISTENCENAME+" pedidoprodu";
	public static String QUERYSELECTNATIVE="select "+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".version_row,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_empresa,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_sucursal,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_ejercicio,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_periodo,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_formato,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_tipo_prioridad_empresa_produ,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_empleado_responsable,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".secuencial,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_cliente,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".direccion_cliente,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".telefono_cliente,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".ruc_cliente,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".lote,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".fecha_pedido,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".fecha_entrega,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".es_uso_interno,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".fecha,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".descripcion,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_estado_orden_produ from "+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME;//+" as "+PedidoProduConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PedidoProduConstantesFuncionesAdditional pedidoproduConstantesFuncionesAdditional=null;
	
	public PedidoProduConstantesFuncionesAdditional getPedidoProduConstantesFuncionesAdditional() {
		return this.pedidoproduConstantesFuncionesAdditional;
	}
	
	public void setPedidoProduConstantesFuncionesAdditional(PedidoProduConstantesFuncionesAdditional pedidoproduConstantesFuncionesAdditional) {
		try {
			this.pedidoproduConstantesFuncionesAdditional=pedidoproduConstantesFuncionesAdditional;
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
		
	
	public static String getPedidoProduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.IDEMPRESA)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.IDPERIODO)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.IDFORMATO)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_IDTIPOPRIORIDADEMPRESAPRODU;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.IDEMPLEADORESPONSABLE)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_IDEMPLEADORESPONSABLE;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.SECUENCIAL)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.IDCLIENTE)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.DIRECCIONCLIENTE)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_DIRECCIONCLIENTE;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.TELEFONOCLIENTE)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_TELEFONOCLIENTE;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.RUCCLIENTE)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_RUCCLIENTE;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.LOTE)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_LOTE;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.FECHAPEDIDO)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_FECHAPEDIDO;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.FECHAENTREGA)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.ESUSOINTERNO)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_ESUSOINTERNO;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.FECHA)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.DESCRIPCION)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(PedidoProduConstantesFunciones.IDESTADOORDENPRODU)) {sLabelColumna=PedidoProduConstantesFunciones.LABEL_IDESTADOORDENPRODU;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_uso_internoDescripcion(PedidoProdu pedidoprodu) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!pedidoprodu.getes_uso_interno()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_uso_internoHtmlDescripcion(PedidoProdu pedidoprodu) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(pedidoprodu.getId(),pedidoprodu.getes_uso_interno());

		return sDescripcion;
	}	
			
			
			
	
	public static String getPedidoProduDescripcion(PedidoProdu pedidoprodu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(pedidoprodu !=null/* && pedidoprodu.getId()!=0*/) {
			sDescripcion=pedidoprodu.getsecuencial();//pedidoprodupedidoprodu.getsecuencial().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPedidoProduDescripcionDetallado(PedidoProdu pedidoprodu) {
		String sDescripcion="";
			
		sDescripcion+=PedidoProduConstantesFunciones.ID+"=";
		sDescripcion+=pedidoprodu.getId().toString()+",";
		sDescripcion+=PedidoProduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=pedidoprodu.getVersionRow().toString()+",";
		sDescripcion+=PedidoProduConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=pedidoprodu.getid_empresa().toString()+",";
		sDescripcion+=PedidoProduConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=pedidoprodu.getid_sucursal().toString()+",";
		sDescripcion+=PedidoProduConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=pedidoprodu.getid_ejercicio().toString()+",";
		sDescripcion+=PedidoProduConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=pedidoprodu.getid_periodo().toString()+",";
		sDescripcion+=PedidoProduConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=pedidoprodu.getid_formato().toString()+",";
		sDescripcion+=PedidoProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU+"=";
		sDescripcion+=pedidoprodu.getid_tipo_prioridad_empresa_produ().toString()+",";
		sDescripcion+=PedidoProduConstantesFunciones.IDEMPLEADORESPONSABLE+"=";
		sDescripcion+=pedidoprodu.getid_empleado_responsable().toString()+",";
		sDescripcion+=PedidoProduConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=pedidoprodu.getsecuencial()+",";
		sDescripcion+=PedidoProduConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=pedidoprodu.getid_cliente().toString()+",";
		sDescripcion+=PedidoProduConstantesFunciones.DIRECCIONCLIENTE+"=";
		sDescripcion+=pedidoprodu.getdireccion_cliente()+",";
		sDescripcion+=PedidoProduConstantesFunciones.TELEFONOCLIENTE+"=";
		sDescripcion+=pedidoprodu.gettelefono_cliente()+",";
		sDescripcion+=PedidoProduConstantesFunciones.RUCCLIENTE+"=";
		sDescripcion+=pedidoprodu.getruc_cliente()+",";
		sDescripcion+=PedidoProduConstantesFunciones.LOTE+"=";
		sDescripcion+=pedidoprodu.getlote()+",";
		sDescripcion+=PedidoProduConstantesFunciones.FECHAPEDIDO+"=";
		sDescripcion+=pedidoprodu.getfecha_pedido().toString()+",";
		sDescripcion+=PedidoProduConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=pedidoprodu.getfecha_entrega().toString()+",";
		sDescripcion+=PedidoProduConstantesFunciones.ESUSOINTERNO+"=";
		sDescripcion+=pedidoprodu.getes_uso_interno().toString()+",";
		sDescripcion+=PedidoProduConstantesFunciones.FECHA+"=";
		sDescripcion+=pedidoprodu.getfecha().toString()+",";
		sDescripcion+=PedidoProduConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=pedidoprodu.getdescripcion()+",";
		sDescripcion+=PedidoProduConstantesFunciones.IDESTADOORDENPRODU+"=";
		sDescripcion+=pedidoprodu.getid_estado_orden_produ().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPedidoProduDescripcion(PedidoProdu pedidoprodu,String sValor) throws Exception {			
		if(pedidoprodu !=null) {
			pedidoprodu.setsecuencial(sValor);;//pedidoprodupedidoprodu.getsecuencial().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosPedidoProdu(PedidoProdu pedidoprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pedidoprodu.setsecuencial(pedidoprodu.getsecuencial().trim());
		pedidoprodu.setdireccion_cliente(pedidoprodu.getdireccion_cliente().trim());
		pedidoprodu.settelefono_cliente(pedidoprodu.gettelefono_cliente().trim());
		pedidoprodu.setruc_cliente(pedidoprodu.getruc_cliente().trim());
		pedidoprodu.setlote(pedidoprodu.getlote().trim());
		pedidoprodu.setdescripcion(pedidoprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPedidoProdus(List<PedidoProdu> pedidoprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PedidoProdu pedidoprodu: pedidoprodus) {
			pedidoprodu.setsecuencial(pedidoprodu.getsecuencial().trim());
			pedidoprodu.setdireccion_cliente(pedidoprodu.getdireccion_cliente().trim());
			pedidoprodu.settelefono_cliente(pedidoprodu.gettelefono_cliente().trim());
			pedidoprodu.setruc_cliente(pedidoprodu.getruc_cliente().trim());
			pedidoprodu.setlote(pedidoprodu.getlote().trim());
			pedidoprodu.setdescripcion(pedidoprodu.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidoProdu(PedidoProdu pedidoprodu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && pedidoprodu.getConCambioAuxiliar()) {
			pedidoprodu.setIsDeleted(pedidoprodu.getIsDeletedAuxiliar());	
			pedidoprodu.setIsNew(pedidoprodu.getIsNewAuxiliar());	
			pedidoprodu.setIsChanged(pedidoprodu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			pedidoprodu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			pedidoprodu.setIsDeletedAuxiliar(false);	
			pedidoprodu.setIsNewAuxiliar(false);	
			pedidoprodu.setIsChangedAuxiliar(false);
			
			pedidoprodu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidoProdus(List<PedidoProdu> pedidoprodus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PedidoProdu pedidoprodu : pedidoprodus) {
			if(conAsignarBase && pedidoprodu.getConCambioAuxiliar()) {
				pedidoprodu.setIsDeleted(pedidoprodu.getIsDeletedAuxiliar());	
				pedidoprodu.setIsNew(pedidoprodu.getIsNewAuxiliar());	
				pedidoprodu.setIsChanged(pedidoprodu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				pedidoprodu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				pedidoprodu.setIsDeletedAuxiliar(false);	
				pedidoprodu.setIsNewAuxiliar(false);	
				pedidoprodu.setIsChangedAuxiliar(false);
				
				pedidoprodu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPedidoProdu(PedidoProdu pedidoprodu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPedidoProdus(List<PedidoProdu> pedidoprodus,Boolean conEnteros) throws Exception  {
		
		for(PedidoProdu pedidoprodu: pedidoprodus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPedidoProdu(List<PedidoProdu> pedidoprodus,PedidoProdu pedidoproduAux) throws Exception  {
		PedidoProduConstantesFunciones.InicializarValoresPedidoProdu(pedidoproduAux,true);
		
		for(PedidoProdu pedidoprodu: pedidoprodus) {
			if(pedidoprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidoProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PedidoProduConstantesFunciones.getArrayColumnasGlobalesPedidoProdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidoProdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoProduConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoProduConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoProduConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoProduConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoProduConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoProduConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoProduConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoProduConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPedidoProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PedidoProdu> pedidoprodus,PedidoProdu pedidoprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PedidoProdu pedidoproduAux: pedidoprodus) {
			if(pedidoproduAux!=null && pedidoprodu!=null) {
				if((pedidoproduAux.getId()==null && pedidoprodu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(pedidoproduAux.getId()!=null && pedidoprodu.getId()!=null){
					if(pedidoproduAux.getId().equals(pedidoprodu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPedidoProdu(List<PedidoProdu> pedidoprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PedidoProdu pedidoprodu: pedidoprodus) {			
			if(pedidoprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPedidoProdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_ID, PedidoProduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_VERSIONROW, PedidoProduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_IDEMPRESA, PedidoProduConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_IDSUCURSAL, PedidoProduConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_IDEJERCICIO, PedidoProduConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_IDPERIODO, PedidoProduConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_IDFORMATO, PedidoProduConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_IDTIPOPRIORIDADEMPRESAPRODU, PedidoProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_IDEMPLEADORESPONSABLE, PedidoProduConstantesFunciones.IDEMPLEADORESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_SECUENCIAL, PedidoProduConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_IDCLIENTE, PedidoProduConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_DIRECCIONCLIENTE, PedidoProduConstantesFunciones.DIRECCIONCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_TELEFONOCLIENTE, PedidoProduConstantesFunciones.TELEFONOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_RUCCLIENTE, PedidoProduConstantesFunciones.RUCCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_LOTE, PedidoProduConstantesFunciones.LOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_FECHAPEDIDO, PedidoProduConstantesFunciones.FECHAPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_FECHAENTREGA, PedidoProduConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_ESUSOINTERNO, PedidoProduConstantesFunciones.ESUSOINTERNO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_FECHA, PedidoProduConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_DESCRIPCION, PedidoProduConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoProduConstantesFunciones.LABEL_IDESTADOORDENPRODU, PedidoProduConstantesFunciones.IDESTADOORDENPRODU,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPedidoProdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.IDEMPLEADORESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.DIRECCIONCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.TELEFONOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.RUCCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.LOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.FECHAPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.ESUSOINTERNO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoProduConstantesFunciones.IDESTADOORDENPRODU;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoProdu() throws Exception  {
		return PedidoProduConstantesFunciones.getTiposSeleccionarPedidoProdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoProdu(Boolean conFk) throws Exception  {
		return PedidoProduConstantesFunciones.getTiposSeleccionarPedidoProdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoProdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_IDTIPOPRIORIDADEMPRESAPRODU);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_IDTIPOPRIORIDADEMPRESAPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_IDEMPLEADORESPONSABLE);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_IDEMPLEADORESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_DIRECCIONCLIENTE);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_DIRECCIONCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_TELEFONOCLIENTE);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_TELEFONOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_RUCCLIENTE);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_RUCCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_LOTE);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_LOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_FECHAPEDIDO);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_FECHAPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_ESUSOINTERNO);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_ESUSOINTERNO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoProduConstantesFunciones.LABEL_IDESTADOORDENPRODU);
			reporte.setsDescripcion(PedidoProduConstantesFunciones.LABEL_IDESTADOORDENPRODU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPedidoProdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPedidoProdu(PedidoProdu pedidoproduAux) throws Exception {
		
			pedidoproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidoproduAux.getEmpresa()));
			pedidoproduAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pedidoproduAux.getSucursal()));
			pedidoproduAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(pedidoproduAux.getEjercicio()));
			pedidoproduAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(pedidoproduAux.getPeriodo()));
			pedidoproduAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(pedidoproduAux.getFormato()));
			pedidoproduAux.settipoprioridadempresaprodu_descripcion(TipoPrioridadEmpresaProduConstantesFunciones.getTipoPrioridadEmpresaProduDescripcion(pedidoproduAux.getTipoPrioridadEmpresaProdu()));
			pedidoproduAux.setempleadoresponsable_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(pedidoproduAux.getEmpleadoResponsable()));
			pedidoproduAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(pedidoproduAux.getCliente()));
			pedidoproduAux.setestadoordenprodu_descripcion(EstadoOrdenProduConstantesFunciones.getEstadoOrdenProduDescripcion(pedidoproduAux.getEstadoOrdenProdu()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPedidoProdu(List<PedidoProdu> pedidoprodusTemp) throws Exception {
		for(PedidoProdu pedidoproduAux:pedidoprodusTemp) {
			
			pedidoproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidoproduAux.getEmpresa()));
			pedidoproduAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pedidoproduAux.getSucursal()));
			pedidoproduAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(pedidoproduAux.getEjercicio()));
			pedidoproduAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(pedidoproduAux.getPeriodo()));
			pedidoproduAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(pedidoproduAux.getFormato()));
			pedidoproduAux.settipoprioridadempresaprodu_descripcion(TipoPrioridadEmpresaProduConstantesFunciones.getTipoPrioridadEmpresaProduDescripcion(pedidoproduAux.getTipoPrioridadEmpresaProdu()));
			pedidoproduAux.setempleadoresponsable_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(pedidoproduAux.getEmpleadoResponsable()));
			pedidoproduAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(pedidoproduAux.getCliente()));
			pedidoproduAux.setestadoordenprodu_descripcion(EstadoOrdenProduConstantesFunciones.getEstadoOrdenProduDescripcion(pedidoproduAux.getEstadoOrdenProdu()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPedidoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPedidoProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidoProduConstantesFunciones.getClassesRelationshipsOfPedidoProdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PedidoDetaProdu.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoDetaProdu.class)) {
						classes.add(new Classe(PedidoDetaProdu.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedidoProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidoProduConstantesFunciones.getClassesRelationshipsFromStringsOfPedidoProdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedidoProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PedidoDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoDetaProdu.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PedidoDetaProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoDetaProdu.class)); continue;
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
	public static void actualizarLista(PedidoProdu pedidoprodu,List<PedidoProdu> pedidoprodus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PedidoProdu pedidoproduEncontrado=null;
			
			for(PedidoProdu pedidoproduLocal:pedidoprodus) {
				if(pedidoproduLocal.getId().equals(pedidoprodu.getId())) {
					pedidoproduEncontrado=pedidoproduLocal;
					
					pedidoproduLocal.setIsChanged(pedidoprodu.getIsChanged());
					pedidoproduLocal.setIsNew(pedidoprodu.getIsNew());
					pedidoproduLocal.setIsDeleted(pedidoprodu.getIsDeleted());
					
					pedidoproduLocal.setGeneralEntityOriginal(pedidoprodu.getGeneralEntityOriginal());
					
					pedidoproduLocal.setId(pedidoprodu.getId());	
					pedidoproduLocal.setVersionRow(pedidoprodu.getVersionRow());	
					pedidoproduLocal.setid_empresa(pedidoprodu.getid_empresa());	
					pedidoproduLocal.setid_sucursal(pedidoprodu.getid_sucursal());	
					pedidoproduLocal.setid_ejercicio(pedidoprodu.getid_ejercicio());	
					pedidoproduLocal.setid_periodo(pedidoprodu.getid_periodo());	
					pedidoproduLocal.setid_formato(pedidoprodu.getid_formato());	
					pedidoproduLocal.setid_tipo_prioridad_empresa_produ(pedidoprodu.getid_tipo_prioridad_empresa_produ());	
					pedidoproduLocal.setid_empleado_responsable(pedidoprodu.getid_empleado_responsable());	
					pedidoproduLocal.setsecuencial(pedidoprodu.getsecuencial());	
					pedidoproduLocal.setid_cliente(pedidoprodu.getid_cliente());	
					pedidoproduLocal.setdireccion_cliente(pedidoprodu.getdireccion_cliente());	
					pedidoproduLocal.settelefono_cliente(pedidoprodu.gettelefono_cliente());	
					pedidoproduLocal.setruc_cliente(pedidoprodu.getruc_cliente());	
					pedidoproduLocal.setlote(pedidoprodu.getlote());	
					pedidoproduLocal.setfecha_pedido(pedidoprodu.getfecha_pedido());	
					pedidoproduLocal.setfecha_entrega(pedidoprodu.getfecha_entrega());	
					pedidoproduLocal.setes_uso_interno(pedidoprodu.getes_uso_interno());	
					pedidoproduLocal.setfecha(pedidoprodu.getfecha());	
					pedidoproduLocal.setdescripcion(pedidoprodu.getdescripcion());	
					pedidoproduLocal.setid_estado_orden_produ(pedidoprodu.getid_estado_orden_produ());	
					
					
					pedidoproduLocal.setPedidoDetaProdus(pedidoprodu.getPedidoDetaProdus());
					
					existe=true;
					break;
				}
			}
			
			if(!pedidoprodu.getIsDeleted()) {
				if(!existe) {
					pedidoprodus.add(pedidoprodu);
				}
			} else {
				if(pedidoproduEncontrado!=null && permiteQuitar)  {
					pedidoprodus.remove(pedidoproduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PedidoProdu pedidoprodu,List<PedidoProdu> pedidoprodus) throws Exception {
		try	{			
			for(PedidoProdu pedidoproduLocal:pedidoprodus) {
				if(pedidoproduLocal.getId().equals(pedidoprodu.getId())) {
					pedidoproduLocal.setIsSelected(pedidoprodu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPedidoProdu(List<PedidoProdu> pedidoprodusAux) throws Exception {
		//this.pedidoprodusAux=pedidoprodusAux;
		
		for(PedidoProdu pedidoproduAux:pedidoprodusAux) {
			if(pedidoproduAux.getIsChanged()) {
				pedidoproduAux.setIsChanged(false);
			}		
			
			if(pedidoproduAux.getIsNew()) {
				pedidoproduAux.setIsNew(false);
			}	
			
			if(pedidoproduAux.getIsDeleted()) {
				pedidoproduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPedidoProdu(PedidoProdu pedidoproduAux) throws Exception {
		//this.pedidoproduAux=pedidoproduAux;
		
			if(pedidoproduAux.getIsChanged()) {
				pedidoproduAux.setIsChanged(false);
			}		
			
			if(pedidoproduAux.getIsNew()) {
				pedidoproduAux.setIsNew(false);
			}	
			
			if(pedidoproduAux.getIsDeleted()) {
				pedidoproduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PedidoProdu pedidoproduAsignar,PedidoProdu pedidoprodu) throws Exception {
		pedidoproduAsignar.setId(pedidoprodu.getId());	
		pedidoproduAsignar.setVersionRow(pedidoprodu.getVersionRow());	
		pedidoproduAsignar.setid_empresa(pedidoprodu.getid_empresa());
		pedidoproduAsignar.setempresa_descripcion(pedidoprodu.getempresa_descripcion());	
		pedidoproduAsignar.setid_sucursal(pedidoprodu.getid_sucursal());
		pedidoproduAsignar.setsucursal_descripcion(pedidoprodu.getsucursal_descripcion());	
		pedidoproduAsignar.setid_ejercicio(pedidoprodu.getid_ejercicio());
		pedidoproduAsignar.setejercicio_descripcion(pedidoprodu.getejercicio_descripcion());	
		pedidoproduAsignar.setid_periodo(pedidoprodu.getid_periodo());
		pedidoproduAsignar.setperiodo_descripcion(pedidoprodu.getperiodo_descripcion());	
		pedidoproduAsignar.setid_formato(pedidoprodu.getid_formato());
		pedidoproduAsignar.setformato_descripcion(pedidoprodu.getformato_descripcion());	
		pedidoproduAsignar.setid_tipo_prioridad_empresa_produ(pedidoprodu.getid_tipo_prioridad_empresa_produ());
		pedidoproduAsignar.settipoprioridadempresaprodu_descripcion(pedidoprodu.gettipoprioridadempresaprodu_descripcion());	
		pedidoproduAsignar.setid_empleado_responsable(pedidoprodu.getid_empleado_responsable());
		pedidoproduAsignar.setempleadoresponsable_descripcion(pedidoprodu.getempleadoresponsable_descripcion());	
		pedidoproduAsignar.setsecuencial(pedidoprodu.getsecuencial());	
		pedidoproduAsignar.setid_cliente(pedidoprodu.getid_cliente());
		pedidoproduAsignar.setcliente_descripcion(pedidoprodu.getcliente_descripcion());	
		pedidoproduAsignar.setdireccion_cliente(pedidoprodu.getdireccion_cliente());	
		pedidoproduAsignar.settelefono_cliente(pedidoprodu.gettelefono_cliente());	
		pedidoproduAsignar.setruc_cliente(pedidoprodu.getruc_cliente());	
		pedidoproduAsignar.setlote(pedidoprodu.getlote());	
		pedidoproduAsignar.setfecha_pedido(pedidoprodu.getfecha_pedido());	
		pedidoproduAsignar.setfecha_entrega(pedidoprodu.getfecha_entrega());	
		pedidoproduAsignar.setes_uso_interno(pedidoprodu.getes_uso_interno());	
		pedidoproduAsignar.setfecha(pedidoprodu.getfecha());	
		pedidoproduAsignar.setdescripcion(pedidoprodu.getdescripcion());	
		pedidoproduAsignar.setid_estado_orden_produ(pedidoprodu.getid_estado_orden_produ());
		pedidoproduAsignar.setestadoordenprodu_descripcion(pedidoprodu.getestadoordenprodu_descripcion());	
	}
	
	public static void inicializarPedidoProdu(PedidoProdu pedidoprodu) throws Exception {
		try {
				pedidoprodu.setId(0L);	
					
				pedidoprodu.setid_empresa(-1L);	
				pedidoprodu.setid_sucursal(-1L);	
				pedidoprodu.setid_ejercicio(-1L);	
				pedidoprodu.setid_periodo(-1L);	
				pedidoprodu.setid_formato(null);	
				pedidoprodu.setid_tipo_prioridad_empresa_produ(-1L);	
				pedidoprodu.setid_empleado_responsable(-1L);	
				pedidoprodu.setsecuencial("");	
				pedidoprodu.setid_cliente(-1L);	
				pedidoprodu.setdireccion_cliente("");	
				pedidoprodu.settelefono_cliente("");	
				pedidoprodu.setruc_cliente("");	
				pedidoprodu.setlote("");	
				pedidoprodu.setfecha_pedido(new Date());	
				pedidoprodu.setfecha_entrega(new Date());	
				pedidoprodu.setes_uso_interno(false);	
				pedidoprodu.setfecha(new Date());	
				pedidoprodu.setdescripcion("");	
				pedidoprodu.setid_estado_orden_produ(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPedidoProdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_IDTIPOPRIORIDADEMPRESAPRODU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_IDEMPLEADORESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_DIRECCIONCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_TELEFONOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_RUCCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_LOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_FECHAPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_ESUSOINTERNO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoProduConstantesFunciones.LABEL_IDESTADOORDENPRODU);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPedidoProdu(String sTipo,Row row,Workbook workbook,PedidoProdu pedidoprodu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.gettipoprioridadempresaprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.getempleadoresponsable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.getdireccion_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.gettelefono_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.getruc_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.getlote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.getfecha_pedido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(pedidoprodu.getes_uso_interno()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoprodu.getestadoordenprodu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPedidoProdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPedidoProdu() {
		return this.sFinalQueryPedidoProdu;
	}
	
	public void setsFinalQueryPedidoProdu(String sFinalQueryPedidoProdu) {
		this.sFinalQueryPedidoProdu= sFinalQueryPedidoProdu;
	}
	
	public Border resaltarSeleccionarPedidoProdu=null;
	
	public Border setResaltarSeleccionarPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPedidoProdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPedidoProdu() {
		return this.resaltarSeleccionarPedidoProdu;
	}
	
	public void setResaltarSeleccionarPedidoProdu(Border borderResaltarSeleccionarPedidoProdu) {
		this.resaltarSeleccionarPedidoProdu= borderResaltarSeleccionarPedidoProdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPedidoProdu=null;
	public Boolean mostraridPedidoProdu=true;
	public Boolean activaridPedidoProdu=true;

	public Border resaltarid_empresaPedidoProdu=null;
	public Boolean mostrarid_empresaPedidoProdu=true;
	public Boolean activarid_empresaPedidoProdu=true;
	public Boolean cargarid_empresaPedidoProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPedidoProdu=false;//ConEventDepend=true

	public Border resaltarid_sucursalPedidoProdu=null;
	public Boolean mostrarid_sucursalPedidoProdu=true;
	public Boolean activarid_sucursalPedidoProdu=true;
	public Boolean cargarid_sucursalPedidoProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPedidoProdu=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPedidoProdu=null;
	public Boolean mostrarid_ejercicioPedidoProdu=true;
	public Boolean activarid_ejercicioPedidoProdu=true;
	public Boolean cargarid_ejercicioPedidoProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPedidoProdu=false;//ConEventDepend=true

	public Border resaltarid_periodoPedidoProdu=null;
	public Boolean mostrarid_periodoPedidoProdu=true;
	public Boolean activarid_periodoPedidoProdu=true;
	public Boolean cargarid_periodoPedidoProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoPedidoProdu=false;//ConEventDepend=true

	public Border resaltarid_formatoPedidoProdu=null;
	public Boolean mostrarid_formatoPedidoProdu=true;
	public Boolean activarid_formatoPedidoProdu=true;
	public Boolean cargarid_formatoPedidoProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoPedidoProdu=false;//ConEventDepend=true

	public Border resaltarid_tipo_prioridad_empresa_produPedidoProdu=null;
	public Boolean mostrarid_tipo_prioridad_empresa_produPedidoProdu=true;
	public Boolean activarid_tipo_prioridad_empresa_produPedidoProdu=true;
	public Boolean cargarid_tipo_prioridad_empresa_produPedidoProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_prioridad_empresa_produPedidoProdu=false;//ConEventDepend=true

	public Border resaltarid_empleado_responsablePedidoProdu=null;
	public Boolean mostrarid_empleado_responsablePedidoProdu=true;
	public Boolean activarid_empleado_responsablePedidoProdu=true;
	public Boolean cargarid_empleado_responsablePedidoProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleado_responsablePedidoProdu=false;//ConEventDepend=true

	public Border resaltarsecuencialPedidoProdu=null;
	public Boolean mostrarsecuencialPedidoProdu=true;
	public Boolean activarsecuencialPedidoProdu=true;

	public Border resaltarid_clientePedidoProdu=null;
	public Boolean mostrarid_clientePedidoProdu=true;
	public Boolean activarid_clientePedidoProdu=true;
	public Boolean cargarid_clientePedidoProdu=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clientePedidoProdu=false;//ConEventDepend=true

	public Border resaltardireccion_clientePedidoProdu=null;
	public Boolean mostrardireccion_clientePedidoProdu=true;
	public Boolean activardireccion_clientePedidoProdu=true;

	public Border resaltartelefono_clientePedidoProdu=null;
	public Boolean mostrartelefono_clientePedidoProdu=true;
	public Boolean activartelefono_clientePedidoProdu=true;

	public Border resaltarruc_clientePedidoProdu=null;
	public Boolean mostrarruc_clientePedidoProdu=true;
	public Boolean activarruc_clientePedidoProdu=true;

	public Border resaltarlotePedidoProdu=null;
	public Boolean mostrarlotePedidoProdu=true;
	public Boolean activarlotePedidoProdu=true;

	public Border resaltarfecha_pedidoPedidoProdu=null;
	public Boolean mostrarfecha_pedidoPedidoProdu=true;
	public Boolean activarfecha_pedidoPedidoProdu=false;

	public Border resaltarfecha_entregaPedidoProdu=null;
	public Boolean mostrarfecha_entregaPedidoProdu=true;
	public Boolean activarfecha_entregaPedidoProdu=false;

	public Border resaltares_uso_internoPedidoProdu=null;
	public Boolean mostrares_uso_internoPedidoProdu=true;
	public Boolean activares_uso_internoPedidoProdu=true;

	public Border resaltarfechaPedidoProdu=null;
	public Boolean mostrarfechaPedidoProdu=true;
	public Boolean activarfechaPedidoProdu=false;

	public Border resaltardescripcionPedidoProdu=null;
	public Boolean mostrardescripcionPedidoProdu=true;
	public Boolean activardescripcionPedidoProdu=true;

	public Border resaltarid_estado_orden_produPedidoProdu=null;
	public Boolean mostrarid_estado_orden_produPedidoProdu=true;
	public Boolean activarid_estado_orden_produPedidoProdu=true;
	public Boolean cargarid_estado_orden_produPedidoProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_orden_produPedidoProdu=false;//ConEventDepend=true

	
	

	public Border setResaltaridPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltaridPedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPedidoProdu() {
		return this.resaltaridPedidoProdu;
	}

	public void setResaltaridPedidoProdu(Border borderResaltar) {
		this.resaltaridPedidoProdu= borderResaltar;
	}

	public Boolean getMostraridPedidoProdu() {
		return this.mostraridPedidoProdu;
	}

	public void setMostraridPedidoProdu(Boolean mostraridPedidoProdu) {
		this.mostraridPedidoProdu= mostraridPedidoProdu;
	}

	public Boolean getActivaridPedidoProdu() {
		return this.activaridPedidoProdu;
	}

	public void setActivaridPedidoProdu(Boolean activaridPedidoProdu) {
		this.activaridPedidoProdu= activaridPedidoProdu;
	}

	public Border setResaltarid_empresaPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltarid_empresaPedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPedidoProdu() {
		return this.resaltarid_empresaPedidoProdu;
	}

	public void setResaltarid_empresaPedidoProdu(Border borderResaltar) {
		this.resaltarid_empresaPedidoProdu= borderResaltar;
	}

	public Boolean getMostrarid_empresaPedidoProdu() {
		return this.mostrarid_empresaPedidoProdu;
	}

	public void setMostrarid_empresaPedidoProdu(Boolean mostrarid_empresaPedidoProdu) {
		this.mostrarid_empresaPedidoProdu= mostrarid_empresaPedidoProdu;
	}

	public Boolean getActivarid_empresaPedidoProdu() {
		return this.activarid_empresaPedidoProdu;
	}

	public void setActivarid_empresaPedidoProdu(Boolean activarid_empresaPedidoProdu) {
		this.activarid_empresaPedidoProdu= activarid_empresaPedidoProdu;
	}

	public Boolean getCargarid_empresaPedidoProdu() {
		return this.cargarid_empresaPedidoProdu;
	}

	public void setCargarid_empresaPedidoProdu(Boolean cargarid_empresaPedidoProdu) {
		this.cargarid_empresaPedidoProdu= cargarid_empresaPedidoProdu;
	}

	public Border setResaltarid_sucursalPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPedidoProdu() {
		return this.resaltarid_sucursalPedidoProdu;
	}

	public void setResaltarid_sucursalPedidoProdu(Border borderResaltar) {
		this.resaltarid_sucursalPedidoProdu= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPedidoProdu() {
		return this.mostrarid_sucursalPedidoProdu;
	}

	public void setMostrarid_sucursalPedidoProdu(Boolean mostrarid_sucursalPedidoProdu) {
		this.mostrarid_sucursalPedidoProdu= mostrarid_sucursalPedidoProdu;
	}

	public Boolean getActivarid_sucursalPedidoProdu() {
		return this.activarid_sucursalPedidoProdu;
	}

	public void setActivarid_sucursalPedidoProdu(Boolean activarid_sucursalPedidoProdu) {
		this.activarid_sucursalPedidoProdu= activarid_sucursalPedidoProdu;
	}

	public Boolean getCargarid_sucursalPedidoProdu() {
		return this.cargarid_sucursalPedidoProdu;
	}

	public void setCargarid_sucursalPedidoProdu(Boolean cargarid_sucursalPedidoProdu) {
		this.cargarid_sucursalPedidoProdu= cargarid_sucursalPedidoProdu;
	}

	public Border setResaltarid_ejercicioPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPedidoProdu() {
		return this.resaltarid_ejercicioPedidoProdu;
	}

	public void setResaltarid_ejercicioPedidoProdu(Border borderResaltar) {
		this.resaltarid_ejercicioPedidoProdu= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPedidoProdu() {
		return this.mostrarid_ejercicioPedidoProdu;
	}

	public void setMostrarid_ejercicioPedidoProdu(Boolean mostrarid_ejercicioPedidoProdu) {
		this.mostrarid_ejercicioPedidoProdu= mostrarid_ejercicioPedidoProdu;
	}

	public Boolean getActivarid_ejercicioPedidoProdu() {
		return this.activarid_ejercicioPedidoProdu;
	}

	public void setActivarid_ejercicioPedidoProdu(Boolean activarid_ejercicioPedidoProdu) {
		this.activarid_ejercicioPedidoProdu= activarid_ejercicioPedidoProdu;
	}

	public Boolean getCargarid_ejercicioPedidoProdu() {
		return this.cargarid_ejercicioPedidoProdu;
	}

	public void setCargarid_ejercicioPedidoProdu(Boolean cargarid_ejercicioPedidoProdu) {
		this.cargarid_ejercicioPedidoProdu= cargarid_ejercicioPedidoProdu;
	}

	public Border setResaltarid_periodoPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltarid_periodoPedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoPedidoProdu() {
		return this.resaltarid_periodoPedidoProdu;
	}

	public void setResaltarid_periodoPedidoProdu(Border borderResaltar) {
		this.resaltarid_periodoPedidoProdu= borderResaltar;
	}

	public Boolean getMostrarid_periodoPedidoProdu() {
		return this.mostrarid_periodoPedidoProdu;
	}

	public void setMostrarid_periodoPedidoProdu(Boolean mostrarid_periodoPedidoProdu) {
		this.mostrarid_periodoPedidoProdu= mostrarid_periodoPedidoProdu;
	}

	public Boolean getActivarid_periodoPedidoProdu() {
		return this.activarid_periodoPedidoProdu;
	}

	public void setActivarid_periodoPedidoProdu(Boolean activarid_periodoPedidoProdu) {
		this.activarid_periodoPedidoProdu= activarid_periodoPedidoProdu;
	}

	public Boolean getCargarid_periodoPedidoProdu() {
		return this.cargarid_periodoPedidoProdu;
	}

	public void setCargarid_periodoPedidoProdu(Boolean cargarid_periodoPedidoProdu) {
		this.cargarid_periodoPedidoProdu= cargarid_periodoPedidoProdu;
	}

	public Border setResaltarid_formatoPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltarid_formatoPedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoPedidoProdu() {
		return this.resaltarid_formatoPedidoProdu;
	}

	public void setResaltarid_formatoPedidoProdu(Border borderResaltar) {
		this.resaltarid_formatoPedidoProdu= borderResaltar;
	}

	public Boolean getMostrarid_formatoPedidoProdu() {
		return this.mostrarid_formatoPedidoProdu;
	}

	public void setMostrarid_formatoPedidoProdu(Boolean mostrarid_formatoPedidoProdu) {
		this.mostrarid_formatoPedidoProdu= mostrarid_formatoPedidoProdu;
	}

	public Boolean getActivarid_formatoPedidoProdu() {
		return this.activarid_formatoPedidoProdu;
	}

	public void setActivarid_formatoPedidoProdu(Boolean activarid_formatoPedidoProdu) {
		this.activarid_formatoPedidoProdu= activarid_formatoPedidoProdu;
	}

	public Boolean getCargarid_formatoPedidoProdu() {
		return this.cargarid_formatoPedidoProdu;
	}

	public void setCargarid_formatoPedidoProdu(Boolean cargarid_formatoPedidoProdu) {
		this.cargarid_formatoPedidoProdu= cargarid_formatoPedidoProdu;
	}

	public Border setResaltarid_tipo_prioridad_empresa_produPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltarid_tipo_prioridad_empresa_produPedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_prioridad_empresa_produPedidoProdu() {
		return this.resaltarid_tipo_prioridad_empresa_produPedidoProdu;
	}

	public void setResaltarid_tipo_prioridad_empresa_produPedidoProdu(Border borderResaltar) {
		this.resaltarid_tipo_prioridad_empresa_produPedidoProdu= borderResaltar;
	}

	public Boolean getMostrarid_tipo_prioridad_empresa_produPedidoProdu() {
		return this.mostrarid_tipo_prioridad_empresa_produPedidoProdu;
	}

	public void setMostrarid_tipo_prioridad_empresa_produPedidoProdu(Boolean mostrarid_tipo_prioridad_empresa_produPedidoProdu) {
		this.mostrarid_tipo_prioridad_empresa_produPedidoProdu= mostrarid_tipo_prioridad_empresa_produPedidoProdu;
	}

	public Boolean getActivarid_tipo_prioridad_empresa_produPedidoProdu() {
		return this.activarid_tipo_prioridad_empresa_produPedidoProdu;
	}

	public void setActivarid_tipo_prioridad_empresa_produPedidoProdu(Boolean activarid_tipo_prioridad_empresa_produPedidoProdu) {
		this.activarid_tipo_prioridad_empresa_produPedidoProdu= activarid_tipo_prioridad_empresa_produPedidoProdu;
	}

	public Boolean getCargarid_tipo_prioridad_empresa_produPedidoProdu() {
		return this.cargarid_tipo_prioridad_empresa_produPedidoProdu;
	}

	public void setCargarid_tipo_prioridad_empresa_produPedidoProdu(Boolean cargarid_tipo_prioridad_empresa_produPedidoProdu) {
		this.cargarid_tipo_prioridad_empresa_produPedidoProdu= cargarid_tipo_prioridad_empresa_produPedidoProdu;
	}

	public Border setResaltarid_empleado_responsablePedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltarid_empleado_responsablePedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleado_responsablePedidoProdu() {
		return this.resaltarid_empleado_responsablePedidoProdu;
	}

	public void setResaltarid_empleado_responsablePedidoProdu(Border borderResaltar) {
		this.resaltarid_empleado_responsablePedidoProdu= borderResaltar;
	}

	public Boolean getMostrarid_empleado_responsablePedidoProdu() {
		return this.mostrarid_empleado_responsablePedidoProdu;
	}

	public void setMostrarid_empleado_responsablePedidoProdu(Boolean mostrarid_empleado_responsablePedidoProdu) {
		this.mostrarid_empleado_responsablePedidoProdu= mostrarid_empleado_responsablePedidoProdu;
	}

	public Boolean getActivarid_empleado_responsablePedidoProdu() {
		return this.activarid_empleado_responsablePedidoProdu;
	}

	public void setActivarid_empleado_responsablePedidoProdu(Boolean activarid_empleado_responsablePedidoProdu) {
		this.activarid_empleado_responsablePedidoProdu= activarid_empleado_responsablePedidoProdu;
	}

	public Boolean getCargarid_empleado_responsablePedidoProdu() {
		return this.cargarid_empleado_responsablePedidoProdu;
	}

	public void setCargarid_empleado_responsablePedidoProdu(Boolean cargarid_empleado_responsablePedidoProdu) {
		this.cargarid_empleado_responsablePedidoProdu= cargarid_empleado_responsablePedidoProdu;
	}

	public Border setResaltarsecuencialPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltarsecuencialPedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialPedidoProdu() {
		return this.resaltarsecuencialPedidoProdu;
	}

	public void setResaltarsecuencialPedidoProdu(Border borderResaltar) {
		this.resaltarsecuencialPedidoProdu= borderResaltar;
	}

	public Boolean getMostrarsecuencialPedidoProdu() {
		return this.mostrarsecuencialPedidoProdu;
	}

	public void setMostrarsecuencialPedidoProdu(Boolean mostrarsecuencialPedidoProdu) {
		this.mostrarsecuencialPedidoProdu= mostrarsecuencialPedidoProdu;
	}

	public Boolean getActivarsecuencialPedidoProdu() {
		return this.activarsecuencialPedidoProdu;
	}

	public void setActivarsecuencialPedidoProdu(Boolean activarsecuencialPedidoProdu) {
		this.activarsecuencialPedidoProdu= activarsecuencialPedidoProdu;
	}

	public Border setResaltarid_clientePedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltarid_clientePedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clientePedidoProdu() {
		return this.resaltarid_clientePedidoProdu;
	}

	public void setResaltarid_clientePedidoProdu(Border borderResaltar) {
		this.resaltarid_clientePedidoProdu= borderResaltar;
	}

	public Boolean getMostrarid_clientePedidoProdu() {
		return this.mostrarid_clientePedidoProdu;
	}

	public void setMostrarid_clientePedidoProdu(Boolean mostrarid_clientePedidoProdu) {
		this.mostrarid_clientePedidoProdu= mostrarid_clientePedidoProdu;
	}

	public Boolean getActivarid_clientePedidoProdu() {
		return this.activarid_clientePedidoProdu;
	}

	public void setActivarid_clientePedidoProdu(Boolean activarid_clientePedidoProdu) {
		this.activarid_clientePedidoProdu= activarid_clientePedidoProdu;
	}

	public Boolean getCargarid_clientePedidoProdu() {
		return this.cargarid_clientePedidoProdu;
	}

	public void setCargarid_clientePedidoProdu(Boolean cargarid_clientePedidoProdu) {
		this.cargarid_clientePedidoProdu= cargarid_clientePedidoProdu;
	}

	public Border setResaltardireccion_clientePedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltardireccion_clientePedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_clientePedidoProdu() {
		return this.resaltardireccion_clientePedidoProdu;
	}

	public void setResaltardireccion_clientePedidoProdu(Border borderResaltar) {
		this.resaltardireccion_clientePedidoProdu= borderResaltar;
	}

	public Boolean getMostrardireccion_clientePedidoProdu() {
		return this.mostrardireccion_clientePedidoProdu;
	}

	public void setMostrardireccion_clientePedidoProdu(Boolean mostrardireccion_clientePedidoProdu) {
		this.mostrardireccion_clientePedidoProdu= mostrardireccion_clientePedidoProdu;
	}

	public Boolean getActivardireccion_clientePedidoProdu() {
		return this.activardireccion_clientePedidoProdu;
	}

	public void setActivardireccion_clientePedidoProdu(Boolean activardireccion_clientePedidoProdu) {
		this.activardireccion_clientePedidoProdu= activardireccion_clientePedidoProdu;
	}

	public Border setResaltartelefono_clientePedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltartelefono_clientePedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_clientePedidoProdu() {
		return this.resaltartelefono_clientePedidoProdu;
	}

	public void setResaltartelefono_clientePedidoProdu(Border borderResaltar) {
		this.resaltartelefono_clientePedidoProdu= borderResaltar;
	}

	public Boolean getMostrartelefono_clientePedidoProdu() {
		return this.mostrartelefono_clientePedidoProdu;
	}

	public void setMostrartelefono_clientePedidoProdu(Boolean mostrartelefono_clientePedidoProdu) {
		this.mostrartelefono_clientePedidoProdu= mostrartelefono_clientePedidoProdu;
	}

	public Boolean getActivartelefono_clientePedidoProdu() {
		return this.activartelefono_clientePedidoProdu;
	}

	public void setActivartelefono_clientePedidoProdu(Boolean activartelefono_clientePedidoProdu) {
		this.activartelefono_clientePedidoProdu= activartelefono_clientePedidoProdu;
	}

	public Border setResaltarruc_clientePedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltarruc_clientePedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_clientePedidoProdu() {
		return this.resaltarruc_clientePedidoProdu;
	}

	public void setResaltarruc_clientePedidoProdu(Border borderResaltar) {
		this.resaltarruc_clientePedidoProdu= borderResaltar;
	}

	public Boolean getMostrarruc_clientePedidoProdu() {
		return this.mostrarruc_clientePedidoProdu;
	}

	public void setMostrarruc_clientePedidoProdu(Boolean mostrarruc_clientePedidoProdu) {
		this.mostrarruc_clientePedidoProdu= mostrarruc_clientePedidoProdu;
	}

	public Boolean getActivarruc_clientePedidoProdu() {
		return this.activarruc_clientePedidoProdu;
	}

	public void setActivarruc_clientePedidoProdu(Boolean activarruc_clientePedidoProdu) {
		this.activarruc_clientePedidoProdu= activarruc_clientePedidoProdu;
	}

	public Border setResaltarlotePedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltarlotePedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlotePedidoProdu() {
		return this.resaltarlotePedidoProdu;
	}

	public void setResaltarlotePedidoProdu(Border borderResaltar) {
		this.resaltarlotePedidoProdu= borderResaltar;
	}

	public Boolean getMostrarlotePedidoProdu() {
		return this.mostrarlotePedidoProdu;
	}

	public void setMostrarlotePedidoProdu(Boolean mostrarlotePedidoProdu) {
		this.mostrarlotePedidoProdu= mostrarlotePedidoProdu;
	}

	public Boolean getActivarlotePedidoProdu() {
		return this.activarlotePedidoProdu;
	}

	public void setActivarlotePedidoProdu(Boolean activarlotePedidoProdu) {
		this.activarlotePedidoProdu= activarlotePedidoProdu;
	}

	public Border setResaltarfecha_pedidoPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltarfecha_pedidoPedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_pedidoPedidoProdu() {
		return this.resaltarfecha_pedidoPedidoProdu;
	}

	public void setResaltarfecha_pedidoPedidoProdu(Border borderResaltar) {
		this.resaltarfecha_pedidoPedidoProdu= borderResaltar;
	}

	public Boolean getMostrarfecha_pedidoPedidoProdu() {
		return this.mostrarfecha_pedidoPedidoProdu;
	}

	public void setMostrarfecha_pedidoPedidoProdu(Boolean mostrarfecha_pedidoPedidoProdu) {
		this.mostrarfecha_pedidoPedidoProdu= mostrarfecha_pedidoPedidoProdu;
	}

	public Boolean getActivarfecha_pedidoPedidoProdu() {
		return this.activarfecha_pedidoPedidoProdu;
	}

	public void setActivarfecha_pedidoPedidoProdu(Boolean activarfecha_pedidoPedidoProdu) {
		this.activarfecha_pedidoPedidoProdu= activarfecha_pedidoPedidoProdu;
	}

	public Border setResaltarfecha_entregaPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaPedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaPedidoProdu() {
		return this.resaltarfecha_entregaPedidoProdu;
	}

	public void setResaltarfecha_entregaPedidoProdu(Border borderResaltar) {
		this.resaltarfecha_entregaPedidoProdu= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaPedidoProdu() {
		return this.mostrarfecha_entregaPedidoProdu;
	}

	public void setMostrarfecha_entregaPedidoProdu(Boolean mostrarfecha_entregaPedidoProdu) {
		this.mostrarfecha_entregaPedidoProdu= mostrarfecha_entregaPedidoProdu;
	}

	public Boolean getActivarfecha_entregaPedidoProdu() {
		return this.activarfecha_entregaPedidoProdu;
	}

	public void setActivarfecha_entregaPedidoProdu(Boolean activarfecha_entregaPedidoProdu) {
		this.activarfecha_entregaPedidoProdu= activarfecha_entregaPedidoProdu;
	}

	public Border setResaltares_uso_internoPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltares_uso_internoPedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_uso_internoPedidoProdu() {
		return this.resaltares_uso_internoPedidoProdu;
	}

	public void setResaltares_uso_internoPedidoProdu(Border borderResaltar) {
		this.resaltares_uso_internoPedidoProdu= borderResaltar;
	}

	public Boolean getMostrares_uso_internoPedidoProdu() {
		return this.mostrares_uso_internoPedidoProdu;
	}

	public void setMostrares_uso_internoPedidoProdu(Boolean mostrares_uso_internoPedidoProdu) {
		this.mostrares_uso_internoPedidoProdu= mostrares_uso_internoPedidoProdu;
	}

	public Boolean getActivares_uso_internoPedidoProdu() {
		return this.activares_uso_internoPedidoProdu;
	}

	public void setActivares_uso_internoPedidoProdu(Boolean activares_uso_internoPedidoProdu) {
		this.activares_uso_internoPedidoProdu= activares_uso_internoPedidoProdu;
	}

	public Border setResaltarfechaPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltarfechaPedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPedidoProdu() {
		return this.resaltarfechaPedidoProdu;
	}

	public void setResaltarfechaPedidoProdu(Border borderResaltar) {
		this.resaltarfechaPedidoProdu= borderResaltar;
	}

	public Boolean getMostrarfechaPedidoProdu() {
		return this.mostrarfechaPedidoProdu;
	}

	public void setMostrarfechaPedidoProdu(Boolean mostrarfechaPedidoProdu) {
		this.mostrarfechaPedidoProdu= mostrarfechaPedidoProdu;
	}

	public Boolean getActivarfechaPedidoProdu() {
		return this.activarfechaPedidoProdu;
	}

	public void setActivarfechaPedidoProdu(Boolean activarfechaPedidoProdu) {
		this.activarfechaPedidoProdu= activarfechaPedidoProdu;
	}

	public Border setResaltardescripcionPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltardescripcionPedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPedidoProdu() {
		return this.resaltardescripcionPedidoProdu;
	}

	public void setResaltardescripcionPedidoProdu(Border borderResaltar) {
		this.resaltardescripcionPedidoProdu= borderResaltar;
	}

	public Boolean getMostrardescripcionPedidoProdu() {
		return this.mostrardescripcionPedidoProdu;
	}

	public void setMostrardescripcionPedidoProdu(Boolean mostrardescripcionPedidoProdu) {
		this.mostrardescripcionPedidoProdu= mostrardescripcionPedidoProdu;
	}

	public Boolean getActivardescripcionPedidoProdu() {
		return this.activardescripcionPedidoProdu;
	}

	public void setActivardescripcionPedidoProdu(Boolean activardescripcionPedidoProdu) {
		this.activardescripcionPedidoProdu= activardescripcionPedidoProdu;
	}

	public Border setResaltarid_estado_orden_produPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltar);
		
		this.resaltarid_estado_orden_produPedidoProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_orden_produPedidoProdu() {
		return this.resaltarid_estado_orden_produPedidoProdu;
	}

	public void setResaltarid_estado_orden_produPedidoProdu(Border borderResaltar) {
		this.resaltarid_estado_orden_produPedidoProdu= borderResaltar;
	}

	public Boolean getMostrarid_estado_orden_produPedidoProdu() {
		return this.mostrarid_estado_orden_produPedidoProdu;
	}

	public void setMostrarid_estado_orden_produPedidoProdu(Boolean mostrarid_estado_orden_produPedidoProdu) {
		this.mostrarid_estado_orden_produPedidoProdu= mostrarid_estado_orden_produPedidoProdu;
	}

	public Boolean getActivarid_estado_orden_produPedidoProdu() {
		return this.activarid_estado_orden_produPedidoProdu;
	}

	public void setActivarid_estado_orden_produPedidoProdu(Boolean activarid_estado_orden_produPedidoProdu) {
		this.activarid_estado_orden_produPedidoProdu= activarid_estado_orden_produPedidoProdu;
	}

	public Boolean getCargarid_estado_orden_produPedidoProdu() {
		return this.cargarid_estado_orden_produPedidoProdu;
	}

	public void setCargarid_estado_orden_produPedidoProdu(Boolean cargarid_estado_orden_produPedidoProdu) {
		this.cargarid_estado_orden_produPedidoProdu= cargarid_estado_orden_produPedidoProdu;
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
		
		
		this.setMostraridPedidoProdu(esInicial);
		this.setMostrarid_empresaPedidoProdu(esInicial);
		this.setMostrarid_sucursalPedidoProdu(esInicial);
		this.setMostrarid_ejercicioPedidoProdu(esInicial);
		this.setMostrarid_periodoPedidoProdu(esInicial);
		this.setMostrarid_formatoPedidoProdu(esInicial);
		this.setMostrarid_tipo_prioridad_empresa_produPedidoProdu(esInicial);
		this.setMostrarid_empleado_responsablePedidoProdu(esInicial);
		this.setMostrarsecuencialPedidoProdu(esInicial);
		this.setMostrarid_clientePedidoProdu(esInicial);
		this.setMostrardireccion_clientePedidoProdu(esInicial);
		this.setMostrartelefono_clientePedidoProdu(esInicial);
		this.setMostrarruc_clientePedidoProdu(esInicial);
		this.setMostrarlotePedidoProdu(esInicial);
		this.setMostrarfecha_pedidoPedidoProdu(esInicial);
		this.setMostrarfecha_entregaPedidoProdu(esInicial);
		this.setMostrares_uso_internoPedidoProdu(esInicial);
		this.setMostrarfechaPedidoProdu(esInicial);
		this.setMostrardescripcionPedidoProdu(esInicial);
		this.setMostrarid_estado_orden_produPedidoProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoProduConstantesFunciones.ID)) {
				this.setMostraridPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU)) {
				this.setMostrarid_tipo_prioridad_empresa_produPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDEMPLEADORESPONSABLE)) {
				this.setMostrarid_empleado_responsablePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clientePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setMostrardireccion_clientePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.TELEFONOCLIENTE)) {
				this.setMostrartelefono_clientePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.RUCCLIENTE)) {
				this.setMostrarruc_clientePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.LOTE)) {
				this.setMostrarlotePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.FECHAPEDIDO)) {
				this.setMostrarfecha_pedidoPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.ESUSOINTERNO)) {
				this.setMostrares_uso_internoPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.FECHA)) {
				this.setMostrarfechaPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDESTADOORDENPRODU)) {
				this.setMostrarid_estado_orden_produPedidoProdu(esAsigna);
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
		
		
		this.setActivaridPedidoProdu(esInicial);
		this.setActivarid_empresaPedidoProdu(esInicial);
		this.setActivarid_sucursalPedidoProdu(esInicial);
		this.setActivarid_ejercicioPedidoProdu(esInicial);
		this.setActivarid_periodoPedidoProdu(esInicial);
		this.setActivarid_formatoPedidoProdu(esInicial);
		this.setActivarid_tipo_prioridad_empresa_produPedidoProdu(esInicial);
		this.setActivarid_empleado_responsablePedidoProdu(esInicial);
		this.setActivarsecuencialPedidoProdu(esInicial);
		this.setActivarid_clientePedidoProdu(esInicial);
		this.setActivardireccion_clientePedidoProdu(esInicial);
		this.setActivartelefono_clientePedidoProdu(esInicial);
		this.setActivarruc_clientePedidoProdu(esInicial);
		this.setActivarlotePedidoProdu(esInicial);
		this.setActivarfecha_pedidoPedidoProdu(esInicial);
		this.setActivarfecha_entregaPedidoProdu(esInicial);
		this.setActivares_uso_internoPedidoProdu(esInicial);
		this.setActivarfechaPedidoProdu(esInicial);
		this.setActivardescripcionPedidoProdu(esInicial);
		this.setActivarid_estado_orden_produPedidoProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoProduConstantesFunciones.ID)) {
				this.setActivaridPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU)) {
				this.setActivarid_tipo_prioridad_empresa_produPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDEMPLEADORESPONSABLE)) {
				this.setActivarid_empleado_responsablePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clientePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setActivardireccion_clientePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.TELEFONOCLIENTE)) {
				this.setActivartelefono_clientePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.RUCCLIENTE)) {
				this.setActivarruc_clientePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.LOTE)) {
				this.setActivarlotePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.FECHAPEDIDO)) {
				this.setActivarfecha_pedidoPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.ESUSOINTERNO)) {
				this.setActivares_uso_internoPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.FECHA)) {
				this.setActivarfechaPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDESTADOORDENPRODU)) {
				this.setActivarid_estado_orden_produPedidoProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPedidoProdu(esInicial);
		this.setResaltarid_empresaPedidoProdu(esInicial);
		this.setResaltarid_sucursalPedidoProdu(esInicial);
		this.setResaltarid_ejercicioPedidoProdu(esInicial);
		this.setResaltarid_periodoPedidoProdu(esInicial);
		this.setResaltarid_formatoPedidoProdu(esInicial);
		this.setResaltarid_tipo_prioridad_empresa_produPedidoProdu(esInicial);
		this.setResaltarid_empleado_responsablePedidoProdu(esInicial);
		this.setResaltarsecuencialPedidoProdu(esInicial);
		this.setResaltarid_clientePedidoProdu(esInicial);
		this.setResaltardireccion_clientePedidoProdu(esInicial);
		this.setResaltartelefono_clientePedidoProdu(esInicial);
		this.setResaltarruc_clientePedidoProdu(esInicial);
		this.setResaltarlotePedidoProdu(esInicial);
		this.setResaltarfecha_pedidoPedidoProdu(esInicial);
		this.setResaltarfecha_entregaPedidoProdu(esInicial);
		this.setResaltares_uso_internoPedidoProdu(esInicial);
		this.setResaltarfechaPedidoProdu(esInicial);
		this.setResaltardescripcionPedidoProdu(esInicial);
		this.setResaltarid_estado_orden_produPedidoProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoProduConstantesFunciones.ID)) {
				this.setResaltaridPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU)) {
				this.setResaltarid_tipo_prioridad_empresa_produPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDEMPLEADORESPONSABLE)) {
				this.setResaltarid_empleado_responsablePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clientePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setResaltardireccion_clientePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.TELEFONOCLIENTE)) {
				this.setResaltartelefono_clientePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.RUCCLIENTE)) {
				this.setResaltarruc_clientePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.LOTE)) {
				this.setResaltarlotePedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.FECHAPEDIDO)) {
				this.setResaltarfecha_pedidoPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.ESUSOINTERNO)) {
				this.setResaltares_uso_internoPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.FECHA)) {
				this.setResaltarfechaPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPedidoProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoProduConstantesFunciones.IDESTADOORDENPRODU)) {
				this.setResaltarid_estado_orden_produPedidoProdu(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPedidoDetaProduPedidoProdu=null;

	public Border getResaltarPedidoDetaProduPedidoProdu() {
		return this.resaltarPedidoDetaProduPedidoProdu;
	}

	public void setResaltarPedidoDetaProduPedidoProdu(Border borderResaltarPedidoDetaProdu) {
		if(borderResaltarPedidoDetaProdu!=null) {
			this.resaltarPedidoDetaProduPedidoProdu= borderResaltarPedidoDetaProdu;
		}
	}

	public Border setResaltarPedidoDetaProduPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoDetaProdu=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//pedidoproduBeanSwingJInternalFrame.jTtoolBarPedidoProdu.setBorder(borderResaltarPedidoDetaProdu);
			
		this.resaltarPedidoDetaProduPedidoProdu= borderResaltarPedidoDetaProdu;

		 return borderResaltarPedidoDetaProdu;
	}



	public Boolean mostrarPedidoDetaProduPedidoProdu=true;

	public Boolean getMostrarPedidoDetaProduPedidoProdu() {
		return this.mostrarPedidoDetaProduPedidoProdu;
	}

	public void setMostrarPedidoDetaProduPedidoProdu(Boolean visibilidadResaltarPedidoDetaProdu) {
		this.mostrarPedidoDetaProduPedidoProdu= visibilidadResaltarPedidoDetaProdu;
	}



	public Boolean activarPedidoDetaProduPedidoProdu=true;

	public Boolean gethabilitarResaltarPedidoDetaProduPedidoProdu() {
		return this.activarPedidoDetaProduPedidoProdu;
	}

	public void setActivarPedidoDetaProduPedidoProdu(Boolean habilitarResaltarPedidoDetaProdu) {
		this.activarPedidoDetaProduPedidoProdu= habilitarResaltarPedidoDetaProdu;
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

		this.setMostrarPedidoDetaProduPedidoProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoDetaProdu.class)) {
				this.setMostrarPedidoDetaProduPedidoProdu(esAsigna);
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

		this.setActivarPedidoDetaProduPedidoProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoDetaProdu.class)) {
				this.setActivarPedidoDetaProduPedidoProdu(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPedidoDetaProduPedidoProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoDetaProdu.class)) {
				this.setResaltarPedidoDetaProduPedidoProdu(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdClientePedidoProdu=true;

	public Boolean getMostrarFK_IdClientePedidoProdu() {
		return this.mostrarFK_IdClientePedidoProdu;
	}

	public void setMostrarFK_IdClientePedidoProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClientePedidoProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioPedidoProdu=true;

	public Boolean getMostrarFK_IdEjercicioPedidoProdu() {
		return this.mostrarFK_IdEjercicioPedidoProdu;
	}

	public void setMostrarFK_IdEjercicioPedidoProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioPedidoProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoResponsablePedidoProdu=true;

	public Boolean getMostrarFK_IdEmpleadoResponsablePedidoProdu() {
		return this.mostrarFK_IdEmpleadoResponsablePedidoProdu;
	}

	public void setMostrarFK_IdEmpleadoResponsablePedidoProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoResponsablePedidoProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPedidoProdu=true;

	public Boolean getMostrarFK_IdEmpresaPedidoProdu() {
		return this.mostrarFK_IdEmpresaPedidoProdu;
	}

	public void setMostrarFK_IdEmpresaPedidoProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPedidoProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoOrdenProduPedidoProdu=true;

	public Boolean getMostrarFK_IdEstadoOrdenProduPedidoProdu() {
		return this.mostrarFK_IdEstadoOrdenProduPedidoProdu;
	}

	public void setMostrarFK_IdEstadoOrdenProduPedidoProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoOrdenProduPedidoProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoPedidoProdu=true;

	public Boolean getMostrarFK_IdFormatoPedidoProdu() {
		return this.mostrarFK_IdFormatoPedidoProdu;
	}

	public void setMostrarFK_IdFormatoPedidoProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoPedidoProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoPedidoProdu=true;

	public Boolean getMostrarFK_IdPeriodoPedidoProdu() {
		return this.mostrarFK_IdPeriodoPedidoProdu;
	}

	public void setMostrarFK_IdPeriodoPedidoProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoPedidoProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPedidoProdu=true;

	public Boolean getMostrarFK_IdSucursalPedidoProdu() {
		return this.mostrarFK_IdSucursalPedidoProdu;
	}

	public void setMostrarFK_IdSucursalPedidoProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPedidoProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrioridadEmpresaProduPedidoProdu=true;

	public Boolean getMostrarFK_IdTipoPrioridadEmpresaProduPedidoProdu() {
		return this.mostrarFK_IdTipoPrioridadEmpresaProduPedidoProdu;
	}

	public void setMostrarFK_IdTipoPrioridadEmpresaProduPedidoProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrioridadEmpresaProduPedidoProdu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClientePedidoProdu=true;

	public Boolean getActivarFK_IdClientePedidoProdu() {
		return this.activarFK_IdClientePedidoProdu;
	}

	public void setActivarFK_IdClientePedidoProdu(Boolean habilitarResaltar) {
		this.activarFK_IdClientePedidoProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioPedidoProdu=true;

	public Boolean getActivarFK_IdEjercicioPedidoProdu() {
		return this.activarFK_IdEjercicioPedidoProdu;
	}

	public void setActivarFK_IdEjercicioPedidoProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioPedidoProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoResponsablePedidoProdu=true;

	public Boolean getActivarFK_IdEmpleadoResponsablePedidoProdu() {
		return this.activarFK_IdEmpleadoResponsablePedidoProdu;
	}

	public void setActivarFK_IdEmpleadoResponsablePedidoProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoResponsablePedidoProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPedidoProdu=true;

	public Boolean getActivarFK_IdEmpresaPedidoProdu() {
		return this.activarFK_IdEmpresaPedidoProdu;
	}

	public void setActivarFK_IdEmpresaPedidoProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPedidoProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoOrdenProduPedidoProdu=true;

	public Boolean getActivarFK_IdEstadoOrdenProduPedidoProdu() {
		return this.activarFK_IdEstadoOrdenProduPedidoProdu;
	}

	public void setActivarFK_IdEstadoOrdenProduPedidoProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoOrdenProduPedidoProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoPedidoProdu=true;

	public Boolean getActivarFK_IdFormatoPedidoProdu() {
		return this.activarFK_IdFormatoPedidoProdu;
	}

	public void setActivarFK_IdFormatoPedidoProdu(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoPedidoProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoPedidoProdu=true;

	public Boolean getActivarFK_IdPeriodoPedidoProdu() {
		return this.activarFK_IdPeriodoPedidoProdu;
	}

	public void setActivarFK_IdPeriodoPedidoProdu(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoPedidoProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPedidoProdu=true;

	public Boolean getActivarFK_IdSucursalPedidoProdu() {
		return this.activarFK_IdSucursalPedidoProdu;
	}

	public void setActivarFK_IdSucursalPedidoProdu(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPedidoProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrioridadEmpresaProduPedidoProdu=true;

	public Boolean getActivarFK_IdTipoPrioridadEmpresaProduPedidoProdu() {
		return this.activarFK_IdTipoPrioridadEmpresaProduPedidoProdu;
	}

	public void setActivarFK_IdTipoPrioridadEmpresaProduPedidoProdu(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrioridadEmpresaProduPedidoProdu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClientePedidoProdu=null;

	public Border getResaltarFK_IdClientePedidoProdu() {
		return this.resaltarFK_IdClientePedidoProdu;
	}

	public void setResaltarFK_IdClientePedidoProdu(Border borderResaltar) {
		this.resaltarFK_IdClientePedidoProdu= borderResaltar;
	}

	public void setResaltarFK_IdClientePedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClientePedidoProdu= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioPedidoProdu=null;

	public Border getResaltarFK_IdEjercicioPedidoProdu() {
		return this.resaltarFK_IdEjercicioPedidoProdu;
	}

	public void setResaltarFK_IdEjercicioPedidoProdu(Border borderResaltar) {
		this.resaltarFK_IdEjercicioPedidoProdu= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioPedidoProdu= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoResponsablePedidoProdu=null;

	public Border getResaltarFK_IdEmpleadoResponsablePedidoProdu() {
		return this.resaltarFK_IdEmpleadoResponsablePedidoProdu;
	}

	public void setResaltarFK_IdEmpleadoResponsablePedidoProdu(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoResponsablePedidoProdu= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoResponsablePedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoResponsablePedidoProdu= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPedidoProdu=null;

	public Border getResaltarFK_IdEmpresaPedidoProdu() {
		return this.resaltarFK_IdEmpresaPedidoProdu;
	}

	public void setResaltarFK_IdEmpresaPedidoProdu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPedidoProdu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPedidoProdu= borderResaltar;
	}

	public Border resaltarFK_IdEstadoOrdenProduPedidoProdu=null;

	public Border getResaltarFK_IdEstadoOrdenProduPedidoProdu() {
		return this.resaltarFK_IdEstadoOrdenProduPedidoProdu;
	}

	public void setResaltarFK_IdEstadoOrdenProduPedidoProdu(Border borderResaltar) {
		this.resaltarFK_IdEstadoOrdenProduPedidoProdu= borderResaltar;
	}

	public void setResaltarFK_IdEstadoOrdenProduPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoOrdenProduPedidoProdu= borderResaltar;
	}

	public Border resaltarFK_IdFormatoPedidoProdu=null;

	public Border getResaltarFK_IdFormatoPedidoProdu() {
		return this.resaltarFK_IdFormatoPedidoProdu;
	}

	public void setResaltarFK_IdFormatoPedidoProdu(Border borderResaltar) {
		this.resaltarFK_IdFormatoPedidoProdu= borderResaltar;
	}

	public void setResaltarFK_IdFormatoPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoPedidoProdu= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoPedidoProdu=null;

	public Border getResaltarFK_IdPeriodoPedidoProdu() {
		return this.resaltarFK_IdPeriodoPedidoProdu;
	}

	public void setResaltarFK_IdPeriodoPedidoProdu(Border borderResaltar) {
		this.resaltarFK_IdPeriodoPedidoProdu= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoPedidoProdu= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPedidoProdu=null;

	public Border getResaltarFK_IdSucursalPedidoProdu() {
		return this.resaltarFK_IdSucursalPedidoProdu;
	}

	public void setResaltarFK_IdSucursalPedidoProdu(Border borderResaltar) {
		this.resaltarFK_IdSucursalPedidoProdu= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPedidoProdu= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrioridadEmpresaProduPedidoProdu=null;

	public Border getResaltarFK_IdTipoPrioridadEmpresaProduPedidoProdu() {
		return this.resaltarFK_IdTipoPrioridadEmpresaProduPedidoProdu;
	}

	public void setResaltarFK_IdTipoPrioridadEmpresaProduPedidoProdu(Border borderResaltar) {
		this.resaltarFK_IdTipoPrioridadEmpresaProduPedidoProdu= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrioridadEmpresaProduPedidoProdu(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoProduBeanSwingJInternalFrame pedidoproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrioridadEmpresaProduPedidoProdu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}