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
package com.bydan.erp.facturacion.util.report;

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


import com.bydan.erp.facturacion.util.report.PedidosConstantesFunciones;
import com.bydan.erp.facturacion.util.report.PedidosParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.PedidosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PedidosConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="Pedidos";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Pedidos"+PedidosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PedidosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PedidosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PedidosConstantesFunciones.SCHEMA+"_"+PedidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PedidosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PedidosConstantesFunciones.SCHEMA+"_"+PedidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PedidosConstantesFunciones.SCHEMA+"_"+PedidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PedidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PedidosConstantesFunciones.SCHEMA+"_"+PedidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PedidosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PedidosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PedidosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PedidosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pedidoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Pedidos";
	public static final String SCLASSWEBTITULO_LOWER="Pedidos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Pedidos";
	public static final String OBJECTNAME="pedidos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="pedidos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select pedidos from "+PedidosConstantesFunciones.SPERSISTENCENAME+" pedidos";
	public static String QUERYSELECTNATIVE="select "+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME+".id,"+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME+".version_row,"+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME+".id_empresa,"+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME+".id_estado_pedido,"+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME+".fecha_emision_desde,"+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME+".nombre_moneda,"+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME+".nombre_zona,"+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME+".numero,"+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME+".iva,"+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME+".descuento_valor,"+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME+".otro,"+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME+".total,"+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME+".fecha_vencimiento,"+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME+".fecha_emision from "+PedidosConstantesFunciones.SCHEMA+"."+PedidosConstantesFunciones.TABLENAME;//+" as "+PedidosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDESTADOPEDIDO= "id_estado_pedido";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String NOMBREMONEDA= "nombre_moneda";
    public static final String NOMBREZONA= "nombre_zona";
    public static final String NUMERO= "numero";
    public static final String IVA= "iva";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String OTRO= "otro";
    public static final String TOTAL= "total";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String FECHAEMISION= "fecha_emision";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDESTADOPEDIDO= "Estado Pedo";
		public static final String LABEL_IDESTADOPEDIDO_LOWER= "Estado Pedido";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_NOMBREMONEDA= "Nombre Moneda";
		public static final String LABEL_NOMBREMONEDA_LOWER= "Nombre Moneda";
    	public static final String LABEL_NOMBREZONA= "Nombre Zona";
		public static final String LABEL_NOMBREZONA_LOWER= "Nombre Zona";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_DESCUENTOVALOR= "Descuento Valor";
		public static final String LABEL_DESCUENTOVALOR_LOWER= "Descuento Valor";
    	public static final String LABEL_OTRO= "Otro";
		public static final String LABEL_OTRO_LOWER= "Otro";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_MONEDA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_MONEDA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_ZONA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_ZONA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	
	public static String getPedidosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PedidosConstantesFunciones.IDEMPRESA)) {sLabelColumna=PedidosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PedidosConstantesFunciones.IDESTADOPEDIDO)) {sLabelColumna=PedidosConstantesFunciones.LABEL_IDESTADOPEDIDO;}
		if(sNombreColumna.equals(PedidosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=PedidosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(PedidosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=PedidosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(PedidosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=PedidosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(PedidosConstantesFunciones.NOMBREMONEDA)) {sLabelColumna=PedidosConstantesFunciones.LABEL_NOMBREMONEDA;}
		if(sNombreColumna.equals(PedidosConstantesFunciones.NOMBREZONA)) {sLabelColumna=PedidosConstantesFunciones.LABEL_NOMBREZONA;}
		if(sNombreColumna.equals(PedidosConstantesFunciones.NUMERO)) {sLabelColumna=PedidosConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(PedidosConstantesFunciones.IVA)) {sLabelColumna=PedidosConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(PedidosConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=PedidosConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(PedidosConstantesFunciones.OTRO)) {sLabelColumna=PedidosConstantesFunciones.LABEL_OTRO;}
		if(sNombreColumna.equals(PedidosConstantesFunciones.TOTAL)) {sLabelColumna=PedidosConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(PedidosConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=PedidosConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(PedidosConstantesFunciones.FECHAEMISION)) {sLabelColumna=PedidosConstantesFunciones.LABEL_FECHAEMISION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPedidosDescripcion(Pedidos pedidos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(pedidos !=null/* && pedidos.getId()!=0*/) {
			sDescripcion=pedidos.getfecha_emision_desde().toString();//pedidospedidos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPedidosDescripcionDetallado(Pedidos pedidos) {
		String sDescripcion="";
			
		sDescripcion+=PedidosConstantesFunciones.ID+"=";
		sDescripcion+=pedidos.getId().toString()+",";
		sDescripcion+=PedidosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=pedidos.getVersionRow().toString()+",";
		sDescripcion+=PedidosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=pedidos.getid_empresa().toString()+",";
		sDescripcion+=PedidosConstantesFunciones.IDESTADOPEDIDO+"=";
		sDescripcion+=pedidos.getid_estado_pedido().toString()+",";
		sDescripcion+=PedidosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=pedidos.getfecha_emision_desde().toString()+",";
		sDescripcion+=PedidosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=pedidos.getfecha_emision_hasta().toString()+",";
		sDescripcion+=PedidosConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=pedidos.getnombre_completo_cliente()+",";
		sDescripcion+=PedidosConstantesFunciones.NOMBREMONEDA+"=";
		sDescripcion+=pedidos.getnombre_moneda()+",";
		sDescripcion+=PedidosConstantesFunciones.NOMBREZONA+"=";
		sDescripcion+=pedidos.getnombre_zona()+",";
		sDescripcion+=PedidosConstantesFunciones.NUMERO+"=";
		sDescripcion+=pedidos.getnumero()+",";
		sDescripcion+=PedidosConstantesFunciones.IVA+"=";
		sDescripcion+=pedidos.getiva().toString()+",";
		sDescripcion+=PedidosConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=pedidos.getdescuento_valor().toString()+",";
		sDescripcion+=PedidosConstantesFunciones.OTRO+"=";
		sDescripcion+=pedidos.getotro().toString()+",";
		sDescripcion+=PedidosConstantesFunciones.TOTAL+"=";
		sDescripcion+=pedidos.gettotal().toString()+",";
		sDescripcion+=PedidosConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=pedidos.getfecha_vencimiento().toString()+",";
		sDescripcion+=PedidosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=pedidos.getfecha_emision().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPedidosDescripcion(Pedidos pedidos,String sValor) throws Exception {			
		if(pedidos !=null) {
			//pedidospedidos.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEstadoPedidoDescripcion(EstadoPedido estadopedido) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadopedido!=null/*&&estadopedido.getId()>0*/) {
			sDescripcion=EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(estadopedido);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPedidos")) {
			sNombreIndice="Tipo=  Por Estado Pedo Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoPedido")) {
			sNombreIndice="Tipo=  Por Estado Pedo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPedidos(Long id_estado_pedido,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_pedido!=null) {sDetalleIndice+=" Codigo Unico De Estado Pedo="+id_estado_pedido.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoPedido(Long id_estado_pedido) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_pedido!=null) {sDetalleIndice+=" Codigo Unico De Estado Pedo="+id_estado_pedido.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPedidos(Pedidos pedidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pedidos.setnombre_completo_cliente(pedidos.getnombre_completo_cliente().trim());
		pedidos.setnombre_moneda(pedidos.getnombre_moneda().trim());
		pedidos.setnombre_zona(pedidos.getnombre_zona().trim());
		pedidos.setnumero(pedidos.getnumero().trim());
	}
	
	public static void quitarEspaciosPedidoss(List<Pedidos> pedidoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Pedidos pedidos: pedidoss) {
			pedidos.setnombre_completo_cliente(pedidos.getnombre_completo_cliente().trim());
			pedidos.setnombre_moneda(pedidos.getnombre_moneda().trim());
			pedidos.setnombre_zona(pedidos.getnombre_zona().trim());
			pedidos.setnumero(pedidos.getnumero().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidos(Pedidos pedidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && pedidos.getConCambioAuxiliar()) {
			pedidos.setIsDeleted(pedidos.getIsDeletedAuxiliar());	
			pedidos.setIsNew(pedidos.getIsNewAuxiliar());	
			pedidos.setIsChanged(pedidos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			pedidos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			pedidos.setIsDeletedAuxiliar(false);	
			pedidos.setIsNewAuxiliar(false);	
			pedidos.setIsChangedAuxiliar(false);
			
			pedidos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidoss(List<Pedidos> pedidoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Pedidos pedidos : pedidoss) {
			if(conAsignarBase && pedidos.getConCambioAuxiliar()) {
				pedidos.setIsDeleted(pedidos.getIsDeletedAuxiliar());	
				pedidos.setIsNew(pedidos.getIsNewAuxiliar());	
				pedidos.setIsChanged(pedidos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				pedidos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				pedidos.setIsDeletedAuxiliar(false);	
				pedidos.setIsNewAuxiliar(false);	
				pedidos.setIsChangedAuxiliar(false);
				
				pedidos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPedidos(Pedidos pedidos,Boolean conEnteros) throws Exception  {
		pedidos.setiva(0.0);
		pedidos.setdescuento_valor(0.0);
		pedidos.setotro(0.0);
		pedidos.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPedidoss(List<Pedidos> pedidoss,Boolean conEnteros) throws Exception  {
		
		for(Pedidos pedidos: pedidoss) {
			pedidos.setiva(0.0);
			pedidos.setdescuento_valor(0.0);
			pedidos.setotro(0.0);
			pedidos.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPedidos(List<Pedidos> pedidoss,Pedidos pedidosAux) throws Exception  {
		PedidosConstantesFunciones.InicializarValoresPedidos(pedidosAux,true);
		
		for(Pedidos pedidos: pedidoss) {
			if(pedidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			pedidosAux.setiva(pedidosAux.getiva()+pedidos.getiva());			
			pedidosAux.setdescuento_valor(pedidosAux.getdescuento_valor()+pedidos.getdescuento_valor());			
			pedidosAux.setotro(pedidosAux.getotro()+pedidos.getotro());			
			pedidosAux.settotal(pedidosAux.gettotal()+pedidos.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PedidosConstantesFunciones.getArrayColumnasGlobalesPedidos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPedidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Pedidos> pedidoss,Pedidos pedidos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Pedidos pedidosAux: pedidoss) {
			if(pedidosAux!=null && pedidos!=null) {
				if((pedidosAux.getId()==null && pedidos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(pedidosAux.getId()!=null && pedidos.getId()!=null){
					if(pedidosAux.getId().equals(pedidos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPedidos(List<Pedidos> pedidoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ivaTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double otroTotal=0.0;
		Double totalTotal=0.0;
	
		for(Pedidos pedidos: pedidoss) {			
			if(pedidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ivaTotal+=pedidos.getiva();
			descuento_valorTotal+=pedidos.getdescuento_valor();
			otroTotal+=pedidos.getotro();
			totalTotal+=pedidos.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidosConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(PedidosConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidosConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(PedidosConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidosConstantesFunciones.OTRO);
		datoGeneral.setsDescripcion(PedidosConstantesFunciones.LABEL_OTRO);
		datoGeneral.setdValorDouble(otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(PedidosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPedidos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PedidosConstantesFunciones.LABEL_ID, PedidosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosConstantesFunciones.LABEL_VERSIONROW, PedidosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, PedidosConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosConstantesFunciones.LABEL_NOMBREMONEDA, PedidosConstantesFunciones.NOMBREMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosConstantesFunciones.LABEL_NOMBREZONA, PedidosConstantesFunciones.NOMBREZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosConstantesFunciones.LABEL_NUMERO, PedidosConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosConstantesFunciones.LABEL_IVA, PedidosConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosConstantesFunciones.LABEL_DESCUENTOVALOR, PedidosConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosConstantesFunciones.LABEL_OTRO, PedidosConstantesFunciones.OTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosConstantesFunciones.LABEL_TOTAL, PedidosConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosConstantesFunciones.LABEL_FECHAVENCIMIENTO, PedidosConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosConstantesFunciones.LABEL_FECHAEMISION, PedidosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPedidos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PedidosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosConstantesFunciones.NOMBREMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosConstantesFunciones.NOMBREZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosConstantesFunciones.OTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidos() throws Exception  {
		return PedidosConstantesFunciones.getTiposSeleccionarPedidos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidos(Boolean conFk) throws Exception  {
		return PedidosConstantesFunciones.getTiposSeleccionarPedidos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PedidosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosConstantesFunciones.LABEL_IDESTADOPEDIDO);
			reporte.setsDescripcion(PedidosConstantesFunciones.LABEL_IDESTADOPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(PedidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(PedidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(PedidosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosConstantesFunciones.LABEL_NOMBREMONEDA);
			reporte.setsDescripcion(PedidosConstantesFunciones.LABEL_NOMBREMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosConstantesFunciones.LABEL_NOMBREZONA);
			reporte.setsDescripcion(PedidosConstantesFunciones.LABEL_NOMBREZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(PedidosConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(PedidosConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(PedidosConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosConstantesFunciones.LABEL_OTRO);
			reporte.setsDescripcion(PedidosConstantesFunciones.LABEL_OTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(PedidosConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(PedidosConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(PedidosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPedidos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPedidos(Pedidos pedidosAux) throws Exception {
		
			pedidosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidosAux.getEmpresa()));
			pedidosAux.setestadopedido_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(pedidosAux.getEstadoPedido()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPedidos(List<Pedidos> pedidossTemp) throws Exception {
		for(Pedidos pedidosAux:pedidossTemp) {
			
			pedidosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidosAux.getEmpresa()));
			pedidosAux.setestadopedido_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(pedidosAux.getEstadoPedido()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPedidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(EstadoPedido.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPedido.class)) {
						classes.add(new Classe(EstadoPedido.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPedidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidosConstantesFunciones.getClassesRelationshipsOfPedidos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidosConstantesFunciones.getClassesRelationshipsFromStringsOfPedidos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(Pedidos pedidos,List<Pedidos> pedidoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(Pedidos pedidos,List<Pedidos> pedidoss) throws Exception {
		try	{			
			for(Pedidos pedidosLocal:pedidoss) {
				if(pedidosLocal.getId().equals(pedidos.getId())) {
					pedidosLocal.setIsSelected(pedidos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPedidos(List<Pedidos> pedidossAux) throws Exception {
		//this.pedidossAux=pedidossAux;
		
		for(Pedidos pedidosAux:pedidossAux) {
			if(pedidosAux.getIsChanged()) {
				pedidosAux.setIsChanged(false);
			}		
			
			if(pedidosAux.getIsNew()) {
				pedidosAux.setIsNew(false);
			}	
			
			if(pedidosAux.getIsDeleted()) {
				pedidosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPedidos(Pedidos pedidosAux) throws Exception {
		//this.pedidosAux=pedidosAux;
		
			if(pedidosAux.getIsChanged()) {
				pedidosAux.setIsChanged(false);
			}		
			
			if(pedidosAux.getIsNew()) {
				pedidosAux.setIsNew(false);
			}	
			
			if(pedidosAux.getIsDeleted()) {
				pedidosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Pedidos pedidosAsignar,Pedidos pedidos) throws Exception {
		pedidosAsignar.setId(pedidos.getId());	
		pedidosAsignar.setVersionRow(pedidos.getVersionRow());	
		pedidosAsignar.setnombre_completo_cliente(pedidos.getnombre_completo_cliente());	
		pedidosAsignar.setnombre_moneda(pedidos.getnombre_moneda());	
		pedidosAsignar.setnombre_zona(pedidos.getnombre_zona());	
		pedidosAsignar.setnumero(pedidos.getnumero());	
		pedidosAsignar.setiva(pedidos.getiva());	
		pedidosAsignar.setdescuento_valor(pedidos.getdescuento_valor());	
		pedidosAsignar.setotro(pedidos.getotro());	
		pedidosAsignar.settotal(pedidos.gettotal());	
		pedidosAsignar.setfecha_vencimiento(pedidos.getfecha_vencimiento());	
		pedidosAsignar.setfecha_emision(pedidos.getfecha_emision());	
	}
	
	public static void inicializarPedidos(Pedidos pedidos) throws Exception {
		try {
				pedidos.setId(0L);	
					
				pedidos.setnombre_completo_cliente("");	
				pedidos.setnombre_moneda("");	
				pedidos.setnombre_zona("");	
				pedidos.setnumero("");	
				pedidos.setiva(0.0);	
				pedidos.setdescuento_valor(0.0);	
				pedidos.setotro(0.0);	
				pedidos.settotal(0.0);	
				pedidos.setfecha_vencimiento(new Date());	
				pedidos.setfecha_emision(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPedidos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosConstantesFunciones.LABEL_IDESTADOPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosConstantesFunciones.LABEL_NOMBREMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosConstantesFunciones.LABEL_NOMBREZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosConstantesFunciones.LABEL_OTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPedidos(String sTipo,Row row,Workbook workbook,Pedidos pedidos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidos.getestadopedido_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidos.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidos.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidos.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidos.getnombre_moneda());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidos.getnombre_zona());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidos.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidos.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidos.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidos.getotro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidos.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidos.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidos.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPedidos="";
	
	public String getsFinalQueryPedidos() {
		return this.sFinalQueryPedidos;
	}
	
	public void setsFinalQueryPedidos(String sFinalQueryPedidos) {
		this.sFinalQueryPedidos= sFinalQueryPedidos;
	}
	
	public Border resaltarSeleccionarPedidos=null;
	
	public Border setResaltarSeleccionarPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//pedidosBeanSwingJInternalFrame.jTtoolBarPedidos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPedidos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPedidos() {
		return this.resaltarSeleccionarPedidos;
	}
	
	public void setResaltarSeleccionarPedidos(Border borderResaltarSeleccionarPedidos) {
		this.resaltarSeleccionarPedidos= borderResaltarSeleccionarPedidos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPedidos=null;
	public Boolean mostraridPedidos=true;
	public Boolean activaridPedidos=true;

	public Border resaltarid_empresaPedidos=null;
	public Boolean mostrarid_empresaPedidos=true;
	public Boolean activarid_empresaPedidos=true;
	public Boolean cargarid_empresaPedidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPedidos=false;//ConEventDepend=true

	public Border resaltarid_estado_pedidoPedidos=null;
	public Boolean mostrarid_estado_pedidoPedidos=true;
	public Boolean activarid_estado_pedidoPedidos=true;
	public Boolean cargarid_estado_pedidoPedidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_pedidoPedidos=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdePedidos=null;
	public Boolean mostrarfecha_emision_desdePedidos=true;
	public Boolean activarfecha_emision_desdePedidos=true;

	public Border resaltarfecha_emision_hastaPedidos=null;
	public Boolean mostrarfecha_emision_hastaPedidos=true;
	public Boolean activarfecha_emision_hastaPedidos=true;

	public Border resaltarnombre_completo_clientePedidos=null;
	public Boolean mostrarnombre_completo_clientePedidos=true;
	public Boolean activarnombre_completo_clientePedidos=true;

	public Border resaltarnombre_monedaPedidos=null;
	public Boolean mostrarnombre_monedaPedidos=true;
	public Boolean activarnombre_monedaPedidos=true;

	public Border resaltarnombre_zonaPedidos=null;
	public Boolean mostrarnombre_zonaPedidos=true;
	public Boolean activarnombre_zonaPedidos=true;

	public Border resaltarnumeroPedidos=null;
	public Boolean mostrarnumeroPedidos=true;
	public Boolean activarnumeroPedidos=true;

	public Border resaltarivaPedidos=null;
	public Boolean mostrarivaPedidos=true;
	public Boolean activarivaPedidos=true;

	public Border resaltardescuento_valorPedidos=null;
	public Boolean mostrardescuento_valorPedidos=true;
	public Boolean activardescuento_valorPedidos=true;

	public Border resaltarotroPedidos=null;
	public Boolean mostrarotroPedidos=true;
	public Boolean activarotroPedidos=true;

	public Border resaltartotalPedidos=null;
	public Boolean mostrartotalPedidos=true;
	public Boolean activartotalPedidos=true;

	public Border resaltarfecha_vencimientoPedidos=null;
	public Boolean mostrarfecha_vencimientoPedidos=true;
	public Boolean activarfecha_vencimientoPedidos=true;

	public Border resaltarfecha_emisionPedidos=null;
	public Boolean mostrarfecha_emisionPedidos=true;
	public Boolean activarfecha_emisionPedidos=true;

	
	

	public Border setResaltaridPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidosBeanSwingJInternalFrame.jTtoolBarPedidos.setBorder(borderResaltar);
		
		this.resaltaridPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPedidos() {
		return this.resaltaridPedidos;
	}

	public void setResaltaridPedidos(Border borderResaltar) {
		this.resaltaridPedidos= borderResaltar;
	}

	public Boolean getMostraridPedidos() {
		return this.mostraridPedidos;
	}

	public void setMostraridPedidos(Boolean mostraridPedidos) {
		this.mostraridPedidos= mostraridPedidos;
	}

	public Boolean getActivaridPedidos() {
		return this.activaridPedidos;
	}

	public void setActivaridPedidos(Boolean activaridPedidos) {
		this.activaridPedidos= activaridPedidos;
	}

	public Border setResaltarid_empresaPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidosBeanSwingJInternalFrame.jTtoolBarPedidos.setBorder(borderResaltar);
		
		this.resaltarid_empresaPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPedidos() {
		return this.resaltarid_empresaPedidos;
	}

	public void setResaltarid_empresaPedidos(Border borderResaltar) {
		this.resaltarid_empresaPedidos= borderResaltar;
	}

	public Boolean getMostrarid_empresaPedidos() {
		return this.mostrarid_empresaPedidos;
	}

	public void setMostrarid_empresaPedidos(Boolean mostrarid_empresaPedidos) {
		this.mostrarid_empresaPedidos= mostrarid_empresaPedidos;
	}

	public Boolean getActivarid_empresaPedidos() {
		return this.activarid_empresaPedidos;
	}

	public void setActivarid_empresaPedidos(Boolean activarid_empresaPedidos) {
		this.activarid_empresaPedidos= activarid_empresaPedidos;
	}

	public Boolean getCargarid_empresaPedidos() {
		return this.cargarid_empresaPedidos;
	}

	public void setCargarid_empresaPedidos(Boolean cargarid_empresaPedidos) {
		this.cargarid_empresaPedidos= cargarid_empresaPedidos;
	}

	public Border setResaltarid_estado_pedidoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidosBeanSwingJInternalFrame.jTtoolBarPedidos.setBorder(borderResaltar);
		
		this.resaltarid_estado_pedidoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_pedidoPedidos() {
		return this.resaltarid_estado_pedidoPedidos;
	}

	public void setResaltarid_estado_pedidoPedidos(Border borderResaltar) {
		this.resaltarid_estado_pedidoPedidos= borderResaltar;
	}

	public Boolean getMostrarid_estado_pedidoPedidos() {
		return this.mostrarid_estado_pedidoPedidos;
	}

	public void setMostrarid_estado_pedidoPedidos(Boolean mostrarid_estado_pedidoPedidos) {
		this.mostrarid_estado_pedidoPedidos= mostrarid_estado_pedidoPedidos;
	}

	public Boolean getActivarid_estado_pedidoPedidos() {
		return this.activarid_estado_pedidoPedidos;
	}

	public void setActivarid_estado_pedidoPedidos(Boolean activarid_estado_pedidoPedidos) {
		this.activarid_estado_pedidoPedidos= activarid_estado_pedidoPedidos;
	}

	public Boolean getCargarid_estado_pedidoPedidos() {
		return this.cargarid_estado_pedidoPedidos;
	}

	public void setCargarid_estado_pedidoPedidos(Boolean cargarid_estado_pedidoPedidos) {
		this.cargarid_estado_pedidoPedidos= cargarid_estado_pedidoPedidos;
	}

	public Border setResaltarfecha_emision_desdePedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidosBeanSwingJInternalFrame.jTtoolBarPedidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdePedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdePedidos() {
		return this.resaltarfecha_emision_desdePedidos;
	}

	public void setResaltarfecha_emision_desdePedidos(Border borderResaltar) {
		this.resaltarfecha_emision_desdePedidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdePedidos() {
		return this.mostrarfecha_emision_desdePedidos;
	}

	public void setMostrarfecha_emision_desdePedidos(Boolean mostrarfecha_emision_desdePedidos) {
		this.mostrarfecha_emision_desdePedidos= mostrarfecha_emision_desdePedidos;
	}

	public Boolean getActivarfecha_emision_desdePedidos() {
		return this.activarfecha_emision_desdePedidos;
	}

	public void setActivarfecha_emision_desdePedidos(Boolean activarfecha_emision_desdePedidos) {
		this.activarfecha_emision_desdePedidos= activarfecha_emision_desdePedidos;
	}

	public Border setResaltarfecha_emision_hastaPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidosBeanSwingJInternalFrame.jTtoolBarPedidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaPedidos() {
		return this.resaltarfecha_emision_hastaPedidos;
	}

	public void setResaltarfecha_emision_hastaPedidos(Border borderResaltar) {
		this.resaltarfecha_emision_hastaPedidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaPedidos() {
		return this.mostrarfecha_emision_hastaPedidos;
	}

	public void setMostrarfecha_emision_hastaPedidos(Boolean mostrarfecha_emision_hastaPedidos) {
		this.mostrarfecha_emision_hastaPedidos= mostrarfecha_emision_hastaPedidos;
	}

	public Boolean getActivarfecha_emision_hastaPedidos() {
		return this.activarfecha_emision_hastaPedidos;
	}

	public void setActivarfecha_emision_hastaPedidos(Boolean activarfecha_emision_hastaPedidos) {
		this.activarfecha_emision_hastaPedidos= activarfecha_emision_hastaPedidos;
	}

	public Border setResaltarnombre_completo_clientePedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidosBeanSwingJInternalFrame.jTtoolBarPedidos.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clientePedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clientePedidos() {
		return this.resaltarnombre_completo_clientePedidos;
	}

	public void setResaltarnombre_completo_clientePedidos(Border borderResaltar) {
		this.resaltarnombre_completo_clientePedidos= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clientePedidos() {
		return this.mostrarnombre_completo_clientePedidos;
	}

	public void setMostrarnombre_completo_clientePedidos(Boolean mostrarnombre_completo_clientePedidos) {
		this.mostrarnombre_completo_clientePedidos= mostrarnombre_completo_clientePedidos;
	}

	public Boolean getActivarnombre_completo_clientePedidos() {
		return this.activarnombre_completo_clientePedidos;
	}

	public void setActivarnombre_completo_clientePedidos(Boolean activarnombre_completo_clientePedidos) {
		this.activarnombre_completo_clientePedidos= activarnombre_completo_clientePedidos;
	}

	public Border setResaltarnombre_monedaPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidosBeanSwingJInternalFrame.jTtoolBarPedidos.setBorder(borderResaltar);
		
		this.resaltarnombre_monedaPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_monedaPedidos() {
		return this.resaltarnombre_monedaPedidos;
	}

	public void setResaltarnombre_monedaPedidos(Border borderResaltar) {
		this.resaltarnombre_monedaPedidos= borderResaltar;
	}

	public Boolean getMostrarnombre_monedaPedidos() {
		return this.mostrarnombre_monedaPedidos;
	}

	public void setMostrarnombre_monedaPedidos(Boolean mostrarnombre_monedaPedidos) {
		this.mostrarnombre_monedaPedidos= mostrarnombre_monedaPedidos;
	}

	public Boolean getActivarnombre_monedaPedidos() {
		return this.activarnombre_monedaPedidos;
	}

	public void setActivarnombre_monedaPedidos(Boolean activarnombre_monedaPedidos) {
		this.activarnombre_monedaPedidos= activarnombre_monedaPedidos;
	}

	public Border setResaltarnombre_zonaPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidosBeanSwingJInternalFrame.jTtoolBarPedidos.setBorder(borderResaltar);
		
		this.resaltarnombre_zonaPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_zonaPedidos() {
		return this.resaltarnombre_zonaPedidos;
	}

	public void setResaltarnombre_zonaPedidos(Border borderResaltar) {
		this.resaltarnombre_zonaPedidos= borderResaltar;
	}

	public Boolean getMostrarnombre_zonaPedidos() {
		return this.mostrarnombre_zonaPedidos;
	}

	public void setMostrarnombre_zonaPedidos(Boolean mostrarnombre_zonaPedidos) {
		this.mostrarnombre_zonaPedidos= mostrarnombre_zonaPedidos;
	}

	public Boolean getActivarnombre_zonaPedidos() {
		return this.activarnombre_zonaPedidos;
	}

	public void setActivarnombre_zonaPedidos(Boolean activarnombre_zonaPedidos) {
		this.activarnombre_zonaPedidos= activarnombre_zonaPedidos;
	}

	public Border setResaltarnumeroPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidosBeanSwingJInternalFrame.jTtoolBarPedidos.setBorder(borderResaltar);
		
		this.resaltarnumeroPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroPedidos() {
		return this.resaltarnumeroPedidos;
	}

	public void setResaltarnumeroPedidos(Border borderResaltar) {
		this.resaltarnumeroPedidos= borderResaltar;
	}

	public Boolean getMostrarnumeroPedidos() {
		return this.mostrarnumeroPedidos;
	}

	public void setMostrarnumeroPedidos(Boolean mostrarnumeroPedidos) {
		this.mostrarnumeroPedidos= mostrarnumeroPedidos;
	}

	public Boolean getActivarnumeroPedidos() {
		return this.activarnumeroPedidos;
	}

	public void setActivarnumeroPedidos(Boolean activarnumeroPedidos) {
		this.activarnumeroPedidos= activarnumeroPedidos;
	}

	public Border setResaltarivaPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidosBeanSwingJInternalFrame.jTtoolBarPedidos.setBorder(borderResaltar);
		
		this.resaltarivaPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaPedidos() {
		return this.resaltarivaPedidos;
	}

	public void setResaltarivaPedidos(Border borderResaltar) {
		this.resaltarivaPedidos= borderResaltar;
	}

	public Boolean getMostrarivaPedidos() {
		return this.mostrarivaPedidos;
	}

	public void setMostrarivaPedidos(Boolean mostrarivaPedidos) {
		this.mostrarivaPedidos= mostrarivaPedidos;
	}

	public Boolean getActivarivaPedidos() {
		return this.activarivaPedidos;
	}

	public void setActivarivaPedidos(Boolean activarivaPedidos) {
		this.activarivaPedidos= activarivaPedidos;
	}

	public Border setResaltardescuento_valorPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidosBeanSwingJInternalFrame.jTtoolBarPedidos.setBorder(borderResaltar);
		
		this.resaltardescuento_valorPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorPedidos() {
		return this.resaltardescuento_valorPedidos;
	}

	public void setResaltardescuento_valorPedidos(Border borderResaltar) {
		this.resaltardescuento_valorPedidos= borderResaltar;
	}

	public Boolean getMostrardescuento_valorPedidos() {
		return this.mostrardescuento_valorPedidos;
	}

	public void setMostrardescuento_valorPedidos(Boolean mostrardescuento_valorPedidos) {
		this.mostrardescuento_valorPedidos= mostrardescuento_valorPedidos;
	}

	public Boolean getActivardescuento_valorPedidos() {
		return this.activardescuento_valorPedidos;
	}

	public void setActivardescuento_valorPedidos(Boolean activardescuento_valorPedidos) {
		this.activardescuento_valorPedidos= activardescuento_valorPedidos;
	}

	public Border setResaltarotroPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidosBeanSwingJInternalFrame.jTtoolBarPedidos.setBorder(borderResaltar);
		
		this.resaltarotroPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotroPedidos() {
		return this.resaltarotroPedidos;
	}

	public void setResaltarotroPedidos(Border borderResaltar) {
		this.resaltarotroPedidos= borderResaltar;
	}

	public Boolean getMostrarotroPedidos() {
		return this.mostrarotroPedidos;
	}

	public void setMostrarotroPedidos(Boolean mostrarotroPedidos) {
		this.mostrarotroPedidos= mostrarotroPedidos;
	}

	public Boolean getActivarotroPedidos() {
		return this.activarotroPedidos;
	}

	public void setActivarotroPedidos(Boolean activarotroPedidos) {
		this.activarotroPedidos= activarotroPedidos;
	}

	public Border setResaltartotalPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidosBeanSwingJInternalFrame.jTtoolBarPedidos.setBorder(borderResaltar);
		
		this.resaltartotalPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalPedidos() {
		return this.resaltartotalPedidos;
	}

	public void setResaltartotalPedidos(Border borderResaltar) {
		this.resaltartotalPedidos= borderResaltar;
	}

	public Boolean getMostrartotalPedidos() {
		return this.mostrartotalPedidos;
	}

	public void setMostrartotalPedidos(Boolean mostrartotalPedidos) {
		this.mostrartotalPedidos= mostrartotalPedidos;
	}

	public Boolean getActivartotalPedidos() {
		return this.activartotalPedidos;
	}

	public void setActivartotalPedidos(Boolean activartotalPedidos) {
		this.activartotalPedidos= activartotalPedidos;
	}

	public Border setResaltarfecha_vencimientoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidosBeanSwingJInternalFrame.jTtoolBarPedidos.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoPedidos() {
		return this.resaltarfecha_vencimientoPedidos;
	}

	public void setResaltarfecha_vencimientoPedidos(Border borderResaltar) {
		this.resaltarfecha_vencimientoPedidos= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoPedidos() {
		return this.mostrarfecha_vencimientoPedidos;
	}

	public void setMostrarfecha_vencimientoPedidos(Boolean mostrarfecha_vencimientoPedidos) {
		this.mostrarfecha_vencimientoPedidos= mostrarfecha_vencimientoPedidos;
	}

	public Boolean getActivarfecha_vencimientoPedidos() {
		return this.activarfecha_vencimientoPedidos;
	}

	public void setActivarfecha_vencimientoPedidos(Boolean activarfecha_vencimientoPedidos) {
		this.activarfecha_vencimientoPedidos= activarfecha_vencimientoPedidos;
	}

	public Border setResaltarfecha_emisionPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidosBeanSwingJInternalFrame.jTtoolBarPedidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionPedidos() {
		return this.resaltarfecha_emisionPedidos;
	}

	public void setResaltarfecha_emisionPedidos(Border borderResaltar) {
		this.resaltarfecha_emisionPedidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionPedidos() {
		return this.mostrarfecha_emisionPedidos;
	}

	public void setMostrarfecha_emisionPedidos(Boolean mostrarfecha_emisionPedidos) {
		this.mostrarfecha_emisionPedidos= mostrarfecha_emisionPedidos;
	}

	public Boolean getActivarfecha_emisionPedidos() {
		return this.activarfecha_emisionPedidos;
	}

	public void setActivarfecha_emisionPedidos(Boolean activarfecha_emisionPedidos) {
		this.activarfecha_emisionPedidos= activarfecha_emisionPedidos;
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
		
		
		this.setMostraridPedidos(esInicial);
		this.setMostrarid_empresaPedidos(esInicial);
		this.setMostrarid_estado_pedidoPedidos(esInicial);
		this.setMostrarfecha_emision_desdePedidos(esInicial);
		this.setMostrarfecha_emision_hastaPedidos(esInicial);
		this.setMostrarnombre_completo_clientePedidos(esInicial);
		this.setMostrarnombre_monedaPedidos(esInicial);
		this.setMostrarnombre_zonaPedidos(esInicial);
		this.setMostrarnumeroPedidos(esInicial);
		this.setMostrarivaPedidos(esInicial);
		this.setMostrardescuento_valorPedidos(esInicial);
		this.setMostrarotroPedidos(esInicial);
		this.setMostrartotalPedidos(esInicial);
		this.setMostrarfecha_vencimientoPedidos(esInicial);
		this.setMostrarfecha_emisionPedidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidosConstantesFunciones.ID)) {
				this.setMostraridPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.IDESTADOPEDIDO)) {
				this.setMostrarid_estado_pedidoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdePedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clientePedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.NOMBREMONEDA)) {
				this.setMostrarnombre_monedaPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.NOMBREZONA)) {
				this.setMostrarnombre_zonaPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.IVA)) {
				this.setMostrarivaPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.OTRO)) {
				this.setMostrarotroPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.TOTAL)) {
				this.setMostrartotalPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionPedidos(esAsigna);
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
		
		
		this.setActivaridPedidos(esInicial);
		this.setActivarid_empresaPedidos(esInicial);
		this.setActivarid_estado_pedidoPedidos(esInicial);
		this.setActivarfecha_emision_desdePedidos(esInicial);
		this.setActivarfecha_emision_hastaPedidos(esInicial);
		this.setActivarnombre_completo_clientePedidos(esInicial);
		this.setActivarnombre_monedaPedidos(esInicial);
		this.setActivarnombre_zonaPedidos(esInicial);
		this.setActivarnumeroPedidos(esInicial);
		this.setActivarivaPedidos(esInicial);
		this.setActivardescuento_valorPedidos(esInicial);
		this.setActivarotroPedidos(esInicial);
		this.setActivartotalPedidos(esInicial);
		this.setActivarfecha_vencimientoPedidos(esInicial);
		this.setActivarfecha_emisionPedidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidosConstantesFunciones.ID)) {
				this.setActivaridPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.IDESTADOPEDIDO)) {
				this.setActivarid_estado_pedidoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdePedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clientePedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.NOMBREMONEDA)) {
				this.setActivarnombre_monedaPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.NOMBREZONA)) {
				this.setActivarnombre_zonaPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.NUMERO)) {
				this.setActivarnumeroPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.IVA)) {
				this.setActivarivaPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.OTRO)) {
				this.setActivarotroPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.TOTAL)) {
				this.setActivartotalPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionPedidos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPedidos(esInicial);
		this.setResaltarid_empresaPedidos(esInicial);
		this.setResaltarid_estado_pedidoPedidos(esInicial);
		this.setResaltarfecha_emision_desdePedidos(esInicial);
		this.setResaltarfecha_emision_hastaPedidos(esInicial);
		this.setResaltarnombre_completo_clientePedidos(esInicial);
		this.setResaltarnombre_monedaPedidos(esInicial);
		this.setResaltarnombre_zonaPedidos(esInicial);
		this.setResaltarnumeroPedidos(esInicial);
		this.setResaltarivaPedidos(esInicial);
		this.setResaltardescuento_valorPedidos(esInicial);
		this.setResaltarotroPedidos(esInicial);
		this.setResaltartotalPedidos(esInicial);
		this.setResaltarfecha_vencimientoPedidos(esInicial);
		this.setResaltarfecha_emisionPedidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidosConstantesFunciones.ID)) {
				this.setResaltaridPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.IDESTADOPEDIDO)) {
				this.setResaltarid_estado_pedidoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdePedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clientePedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.NOMBREMONEDA)) {
				this.setResaltarnombre_monedaPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.NOMBREZONA)) {
				this.setResaltarnombre_zonaPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.IVA)) {
				this.setResaltarivaPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.OTRO)) {
				this.setResaltarotroPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.TOTAL)) {
				this.setResaltartotalPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionPedidos(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaPedidosPedidos=true;

	public Boolean getMostrarBusquedaPedidosPedidos() {
		return this.mostrarBusquedaPedidosPedidos;
	}

	public void setMostrarBusquedaPedidosPedidos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPedidosPedidos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPedidosPedidos=true;

	public Boolean getActivarBusquedaPedidosPedidos() {
		return this.activarBusquedaPedidosPedidos;
	}

	public void setActivarBusquedaPedidosPedidos(Boolean habilitarResaltar) {
		this.activarBusquedaPedidosPedidos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPedidosPedidos=null;

	public Border getResaltarBusquedaPedidosPedidos() {
		return this.resaltarBusquedaPedidosPedidos;
	}

	public void setResaltarBusquedaPedidosPedidos(Border borderResaltar) {
		this.resaltarBusquedaPedidosPedidos= borderResaltar;
	}

	public void setResaltarBusquedaPedidosPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosBeanSwingJInternalFrame pedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPedidosPedidos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}