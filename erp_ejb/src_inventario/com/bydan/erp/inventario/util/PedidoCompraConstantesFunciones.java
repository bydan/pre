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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.PedidoCompraConstantesFunciones;
import com.bydan.erp.inventario.util.PedidoCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.PedidoCompraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PedidoCompraConstantesFunciones extends PedidoCompraConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,-10);
	
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
	public static final String SNOMBREOPCION="PedidoCompra";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PedidoCompra"+PedidoCompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PedidoCompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PedidoCompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PedidoCompraConstantesFunciones.SCHEMA+"_"+PedidoCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PedidoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PedidoCompraConstantesFunciones.SCHEMA+"_"+PedidoCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PedidoCompraConstantesFunciones.SCHEMA+"_"+PedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PedidoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PedidoCompraConstantesFunciones.SCHEMA+"_"+PedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PedidoCompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PedidoCompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PedidoCompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PedidoCompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pedido Compras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Pedido Compra";
	public static final String SCLASSWEBTITULO_LOWER="Pedido Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PedidoCompra";
	public static final String OBJECTNAME="pedidocompra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="pedido_compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select pedidocompra from "+PedidoCompraConstantesFunciones.SPERSISTENCENAME+" pedidocompra";
	public static String QUERYSELECTNATIVE="select "+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".version_row,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_empresa,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_sucursal,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_modulo,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_periodo,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_anio,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_mes,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".numero_secuencial,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_cliente,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_usuario,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_moneda,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_estado_pedido_compra,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".total,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".fecha,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_empleado,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".responsable,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".solicitado_por,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".motivo_solicitud,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".area_solicitud,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".para_uso_de,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".lugar_entrega,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".descripcion,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".fecha_emision,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".fecha_entrega,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_formato,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_tipo_cambio from "+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME;//+" as "+PedidoCompraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected PedidoCompraConstantesFuncionesAdditional pedidocompraConstantesFuncionesAdditional=null;
	
	public PedidoCompraConstantesFuncionesAdditional getPedidoCompraConstantesFuncionesAdditional() {
		return this.pedidocompraConstantesFuncionesAdditional;
	}
	
	public void setPedidoCompraConstantesFuncionesAdditional(PedidoCompraConstantesFuncionesAdditional pedidocompraConstantesFuncionesAdditional) {
		try {
			this.pedidocompraConstantesFuncionesAdditional=pedidocompraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDMODULO= "id_modulo";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String NUMEROSECUENCIAL= "numero_secuencial";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDMONEDA= "id_moneda";
    public static final String IDESTADOPEDIDOCOMPRA= "id_estado_pedido_compra";
    public static final String TOTAL= "total";
    public static final String FECHA= "fecha";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String RESPONSABLE= "responsable";
    public static final String SOLICITADOPOR= "solicitado_por";
    public static final String MOTIVOSOLICITUD= "motivo_solicitud";
    public static final String AREASOLICITUD= "area_solicitud";
    public static final String PARAUSODE= "para_uso_de";
    public static final String LUGARENTREGA= "lugar_entrega";
    public static final String DESCRIPCION= "descripcion";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAENTREGA= "fecha_entrega";
    public static final String IDFORMATO= "id_formato";
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_NUMEROSECUENCIAL= "No Secuencial";
		public static final String LABEL_NUMEROSECUENCIAL_LOWER= "Numero Secuencial";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_IDESTADOPEDIDOCOMPRA= "Estado";
		public static final String LABEL_IDESTADOPEDIDOCOMPRA_LOWER= "Estado Pedido Compra";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_RESPONSABLE= "Responsable";
		public static final String LABEL_RESPONSABLE_LOWER= "Responsable";
    	public static final String LABEL_SOLICITADOPOR= "Solicitado Por";
		public static final String LABEL_SOLICITADOPOR_LOWER= "Solicitado Por";
    	public static final String LABEL_MOTIVOSOLICITUD= "Motivo Solicitud";
		public static final String LABEL_MOTIVOSOLICITUD_LOWER= "Motivo Solicitud";
    	public static final String LABEL_AREASOLICITUD= "Area Solicitud";
		public static final String LABEL_AREASOLICITUD_LOWER= "Area Solicitud";
    	public static final String LABEL_PARAUSODE= "Para Uso De";
		public static final String LABEL_PARAUSODE_LOWER= "Para Uso De";
    	public static final String LABEL_LUGARENTREGA= "Lugar Entrega";
		public static final String LABEL_LUGARENTREGA_LOWER= "Lugar Entrega";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAENTREGA= "Fecha Entrega";
		public static final String LABEL_FECHAENTREGA_LOWER= "Fecha Entrega";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_IDTIPOCAMBIO= "Tipo Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXRESPONSABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRESPONSABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSOLICITADO_POR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSOLICITADO_POR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMOTIVO_SOLICITUD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMOTIVO_SOLICITUD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAREA_SOLICITUD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAREA_SOLICITUD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPARA_USO_DE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPARA_USO_DE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXLUGAR_ENTREGA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLUGAR_ENTREGA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getPedidoCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.IDEMPRESA)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.IDMODULO)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.IDPERIODO)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.IDANIO)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.IDMES)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.NUMEROSECUENCIAL)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_NUMEROSECUENCIAL;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.IDCLIENTE)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.IDUSUARIO)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.IDMONEDA)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.IDESTADOPEDIDOCOMPRA)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_IDESTADOPEDIDOCOMPRA;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.TOTAL)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.FECHA)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.IDEMPLEADO)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.RESPONSABLE)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_RESPONSABLE;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.SOLICITADOPOR)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_SOLICITADOPOR;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.MOTIVOSOLICITUD)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_MOTIVOSOLICITUD;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.AREASOLICITUD)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_AREASOLICITUD;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.PARAUSODE)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_PARAUSODE;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.LUGARENTREGA)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_LUGARENTREGA;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.DESCRIPCION)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.FECHAEMISION)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.FECHAENTREGA)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.IDFORMATO)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(PedidoCompraConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=PedidoCompraConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPedidoCompraDescripcion(PedidoCompra pedidocompra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(pedidocompra !=null/* && pedidocompra.getId()!=0*/) {
			if(pedidocompra.getId()!=null) {
				sDescripcion=pedidocompra.getId().toString();
			}//pedidocomprapedidocompra.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPedidoCompraDescripcionDetallado(PedidoCompra pedidocompra) {
		String sDescripcion="";
			
		sDescripcion+=PedidoCompraConstantesFunciones.ID+"=";
		sDescripcion+=pedidocompra.getId().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=pedidocompra.getVersionRow().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=pedidocompra.getid_empresa().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=pedidocompra.getid_sucursal().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.IDMODULO+"=";
		sDescripcion+=pedidocompra.getid_modulo().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=pedidocompra.getid_ejercicio().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=pedidocompra.getid_periodo().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.IDANIO+"=";
		sDescripcion+=pedidocompra.getid_anio().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.IDMES+"=";
		sDescripcion+=pedidocompra.getid_mes().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.NUMEROSECUENCIAL+"=";
		sDescripcion+=pedidocompra.getnumero_secuencial()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=pedidocompra.getid_cliente().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=pedidocompra.getid_usuario().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=pedidocompra.getid_moneda().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.IDESTADOPEDIDOCOMPRA+"=";
		sDescripcion+=pedidocompra.getid_estado_pedido_compra().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.TOTAL+"=";
		sDescripcion+=pedidocompra.gettotal().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.FECHA+"=";
		sDescripcion+=pedidocompra.getfecha().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=pedidocompra.getid_empleado().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.RESPONSABLE+"=";
		sDescripcion+=pedidocompra.getresponsable()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.SOLICITADOPOR+"=";
		sDescripcion+=pedidocompra.getsolicitado_por()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.MOTIVOSOLICITUD+"=";
		sDescripcion+=pedidocompra.getmotivo_solicitud()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.AREASOLICITUD+"=";
		sDescripcion+=pedidocompra.getarea_solicitud()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.PARAUSODE+"=";
		sDescripcion+=pedidocompra.getpara_uso_de()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.LUGARENTREGA+"=";
		sDescripcion+=pedidocompra.getlugar_entrega()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=pedidocompra.getdescripcion()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=pedidocompra.getfecha_emision().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=pedidocompra.getfecha_entrega().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=pedidocompra.getid_formato().toString()+",";
		sDescripcion+=PedidoCompraConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=pedidocompra.getid_tipo_cambio().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPedidoCompraDescripcion(PedidoCompra pedidocompra,String sValor) throws Exception {			
		if(pedidocompra !=null) {
			//pedidocomprapedidocompra.getId().toString();
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
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

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
		}

		return sDescripcion;
	}

	public static String getEstadoPedidoCompraDescripcion(EstadoPedidoCompra estadopedidocompra) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadopedidocompra!=null/*&&estadopedidocompra.getId()>0*/) {
			sDescripcion=EstadoPedidoCompraConstantesFunciones.getEstadoPedidoCompraDescripcion(estadopedidocompra);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
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

	public static String getTipoCambioDescripcion(TipoCambio tipocambio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocambio!=null/*&&tipocambio.getId()>0*/) {
			sDescripcion=TipoCambioConstantesFunciones.getTipoCambioDescripcion(tipocambio);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoPedidoCompraEstadoPedoCompra")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCambio")) {
			sNombreIndice="Tipo=  Por Tipo Cambio";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
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

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoPedidoCompraEstadoPedoCompra(Long id_estado_pedido_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_pedido_compra!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_pedido_compra.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoCambio(Long id_tipo_cambio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cambio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cambio="+id_tipo_cambio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPedidoCompra(PedidoCompra pedidocompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pedidocompra.setnumero_secuencial(pedidocompra.getnumero_secuencial().trim());
		pedidocompra.setresponsable(pedidocompra.getresponsable().trim());
		pedidocompra.setsolicitado_por(pedidocompra.getsolicitado_por().trim());
		pedidocompra.setmotivo_solicitud(pedidocompra.getmotivo_solicitud().trim());
		pedidocompra.setarea_solicitud(pedidocompra.getarea_solicitud().trim());
		pedidocompra.setpara_uso_de(pedidocompra.getpara_uso_de().trim());
		pedidocompra.setlugar_entrega(pedidocompra.getlugar_entrega().trim());
		pedidocompra.setdescripcion(pedidocompra.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPedidoCompras(List<PedidoCompra> pedidocompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PedidoCompra pedidocompra: pedidocompras) {
			pedidocompra.setnumero_secuencial(pedidocompra.getnumero_secuencial().trim());
			pedidocompra.setresponsable(pedidocompra.getresponsable().trim());
			pedidocompra.setsolicitado_por(pedidocompra.getsolicitado_por().trim());
			pedidocompra.setmotivo_solicitud(pedidocompra.getmotivo_solicitud().trim());
			pedidocompra.setarea_solicitud(pedidocompra.getarea_solicitud().trim());
			pedidocompra.setpara_uso_de(pedidocompra.getpara_uso_de().trim());
			pedidocompra.setlugar_entrega(pedidocompra.getlugar_entrega().trim());
			pedidocompra.setdescripcion(pedidocompra.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidoCompra(PedidoCompra pedidocompra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && pedidocompra.getConCambioAuxiliar()) {
			pedidocompra.setIsDeleted(pedidocompra.getIsDeletedAuxiliar());	
			pedidocompra.setIsNew(pedidocompra.getIsNewAuxiliar());	
			pedidocompra.setIsChanged(pedidocompra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			pedidocompra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			pedidocompra.setIsDeletedAuxiliar(false);	
			pedidocompra.setIsNewAuxiliar(false);	
			pedidocompra.setIsChangedAuxiliar(false);
			
			pedidocompra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidoCompras(List<PedidoCompra> pedidocompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PedidoCompra pedidocompra : pedidocompras) {
			if(conAsignarBase && pedidocompra.getConCambioAuxiliar()) {
				pedidocompra.setIsDeleted(pedidocompra.getIsDeletedAuxiliar());	
				pedidocompra.setIsNew(pedidocompra.getIsNewAuxiliar());	
				pedidocompra.setIsChanged(pedidocompra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				pedidocompra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				pedidocompra.setIsDeletedAuxiliar(false);	
				pedidocompra.setIsNewAuxiliar(false);	
				pedidocompra.setIsChangedAuxiliar(false);
				
				pedidocompra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPedidoCompra(PedidoCompra pedidocompra,Boolean conEnteros) throws Exception  {
		pedidocompra.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPedidoCompras(List<PedidoCompra> pedidocompras,Boolean conEnteros) throws Exception  {
		
		for(PedidoCompra pedidocompra: pedidocompras) {
			pedidocompra.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPedidoCompra(List<PedidoCompra> pedidocompras,PedidoCompra pedidocompraAux) throws Exception  {
		PedidoCompraConstantesFunciones.InicializarValoresPedidoCompra(pedidocompraAux,true);
		
		for(PedidoCompra pedidocompra: pedidocompras) {
			if(pedidocompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			pedidocompraAux.settotal(pedidocompraAux.gettotal()+pedidocompra.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidoCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PedidoCompraConstantesFunciones.getArrayColumnasGlobalesPedidoCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidoCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoCompraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoCompraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoCompraConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoCompraConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoCompraConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoCompraConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoCompraConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoCompraConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoCompraConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoCompraConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoCompraConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoCompraConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoCompraConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoCompraConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPedidoCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PedidoCompra> pedidocompras,PedidoCompra pedidocompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PedidoCompra pedidocompraAux: pedidocompras) {
			if(pedidocompraAux!=null && pedidocompra!=null) {
				if((pedidocompraAux.getId()==null && pedidocompra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(pedidocompraAux.getId()!=null && pedidocompra.getId()!=null){
					if(pedidocompraAux.getId().equals(pedidocompra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPedidoCompra(List<PedidoCompra> pedidocompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
	
		for(PedidoCompra pedidocompra: pedidocompras) {			
			if(pedidocompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			totalTotal+=pedidocompra.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoCompraConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPedidoCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_ID, PedidoCompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_VERSIONROW, PedidoCompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_IDEMPRESA, PedidoCompraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_IDSUCURSAL, PedidoCompraConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_IDMODULO, PedidoCompraConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_IDEJERCICIO, PedidoCompraConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_IDPERIODO, PedidoCompraConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_IDANIO, PedidoCompraConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_IDMES, PedidoCompraConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_NUMEROSECUENCIAL, PedidoCompraConstantesFunciones.NUMEROSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_IDCLIENTE, PedidoCompraConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_IDUSUARIO, PedidoCompraConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_IDMONEDA, PedidoCompraConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_IDESTADOPEDIDOCOMPRA, PedidoCompraConstantesFunciones.IDESTADOPEDIDOCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_TOTAL, PedidoCompraConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_FECHA, PedidoCompraConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_IDEMPLEADO, PedidoCompraConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_RESPONSABLE, PedidoCompraConstantesFunciones.RESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_SOLICITADOPOR, PedidoCompraConstantesFunciones.SOLICITADOPOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_MOTIVOSOLICITUD, PedidoCompraConstantesFunciones.MOTIVOSOLICITUD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_AREASOLICITUD, PedidoCompraConstantesFunciones.AREASOLICITUD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_PARAUSODE, PedidoCompraConstantesFunciones.PARAUSODE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_LUGARENTREGA, PedidoCompraConstantesFunciones.LUGARENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_DESCRIPCION, PedidoCompraConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_FECHAEMISION, PedidoCompraConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_FECHAENTREGA, PedidoCompraConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_IDFORMATO, PedidoCompraConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoCompraConstantesFunciones.LABEL_IDTIPOCAMBIO, PedidoCompraConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPedidoCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.NUMEROSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.IDESTADOPEDIDOCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.RESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.SOLICITADOPOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.MOTIVOSOLICITUD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.AREASOLICITUD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.PARAUSODE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.LUGARENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoCompraConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoCompra() throws Exception  {
		return PedidoCompraConstantesFunciones.getTiposSeleccionarPedidoCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoCompra(Boolean conFk) throws Exception  {
		return PedidoCompraConstantesFunciones.getTiposSeleccionarPedidoCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_NUMEROSECUENCIAL);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_NUMEROSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_IDESTADOPEDIDOCOMPRA);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_IDESTADOPEDIDOCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_RESPONSABLE);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_RESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_SOLICITADOPOR);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_SOLICITADOPOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_MOTIVOSOLICITUD);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_MOTIVOSOLICITUD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_AREASOLICITUD);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_AREASOLICITUD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_PARAUSODE);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_PARAUSODE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_LUGARENTREGA);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_LUGARENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoCompraConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPedidoCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPedidoCompra(PedidoCompra pedidocompraAux) throws Exception {
		
			pedidocompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidocompraAux.getEmpresa()));
			pedidocompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pedidocompraAux.getSucursal()));
			pedidocompraAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(pedidocompraAux.getModulo()));
			pedidocompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(pedidocompraAux.getEjercicio()));
			pedidocompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(pedidocompraAux.getPeriodo()));
			pedidocompraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(pedidocompraAux.getAnio()));
			pedidocompraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(pedidocompraAux.getMes()));
			pedidocompraAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(pedidocompraAux.getCliente()));
			pedidocompraAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(pedidocompraAux.getUsuario()));
			pedidocompraAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(pedidocompraAux.getMoneda()));
			pedidocompraAux.setestadopedidocompra_descripcion(EstadoPedidoCompraConstantesFunciones.getEstadoPedidoCompraDescripcion(pedidocompraAux.getEstadoPedidoCompra()));
			pedidocompraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(pedidocompraAux.getEmpleado()));
			pedidocompraAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(pedidocompraAux.getFormato()));
			pedidocompraAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(pedidocompraAux.getTipoCambio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPedidoCompra(List<PedidoCompra> pedidocomprasTemp) throws Exception {
		for(PedidoCompra pedidocompraAux:pedidocomprasTemp) {
			
			pedidocompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidocompraAux.getEmpresa()));
			pedidocompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pedidocompraAux.getSucursal()));
			pedidocompraAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(pedidocompraAux.getModulo()));
			pedidocompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(pedidocompraAux.getEjercicio()));
			pedidocompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(pedidocompraAux.getPeriodo()));
			pedidocompraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(pedidocompraAux.getAnio()));
			pedidocompraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(pedidocompraAux.getMes()));
			pedidocompraAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(pedidocompraAux.getCliente()));
			pedidocompraAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(pedidocompraAux.getUsuario()));
			pedidocompraAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(pedidocompraAux.getMoneda()));
			pedidocompraAux.setestadopedidocompra_descripcion(EstadoPedidoCompraConstantesFunciones.getEstadoPedidoCompraDescripcion(pedidocompraAux.getEstadoPedidoCompra()));
			pedidocompraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(pedidocompraAux.getEmpleado()));
			pedidocompraAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(pedidocompraAux.getFormato()));
			pedidocompraAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(pedidocompraAux.getTipoCambio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPedidoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(EstadoPedidoCompra.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(TipoCambio.class));
				
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
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
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
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPedidoCompra.class)) {
						classes.add(new Classe(EstadoPedidoCompra.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCambio.class)) {
						classes.add(new Classe(TipoCambio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPedidoCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(EstadoPedidoCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedidoCompra.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(EstadoPedidoCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedidoCompra.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidoCompraConstantesFunciones.getClassesRelationshipsOfPedidoCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Compra.class));
				classes.add(new Classe(DetallePedidoCompra.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Compra.class)) {
						classes.add(new Classe(Compra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetallePedidoCompra.class)) {
						classes.add(new Classe(DetallePedidoCompra.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedidoCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidoCompraConstantesFunciones.getClassesRelationshipsFromStringsOfPedidoCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedidoCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Compra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Compra.class)); continue;
					}

					if(DetallePedidoCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePedidoCompra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Compra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Compra.class)); continue;
					}

					if(DetallePedidoCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePedidoCompra.class)); continue;
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
	public static void actualizarLista(PedidoCompra pedidocompra,List<PedidoCompra> pedidocompras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PedidoCompra pedidocompraEncontrado=null;
			
			for(PedidoCompra pedidocompraLocal:pedidocompras) {
				if(pedidocompraLocal.getId().equals(pedidocompra.getId())) {
					pedidocompraEncontrado=pedidocompraLocal;
					
					pedidocompraLocal.setIsChanged(pedidocompra.getIsChanged());
					pedidocompraLocal.setIsNew(pedidocompra.getIsNew());
					pedidocompraLocal.setIsDeleted(pedidocompra.getIsDeleted());
					
					pedidocompraLocal.setGeneralEntityOriginal(pedidocompra.getGeneralEntityOriginal());
					
					pedidocompraLocal.setId(pedidocompra.getId());	
					pedidocompraLocal.setVersionRow(pedidocompra.getVersionRow());	
					pedidocompraLocal.setid_empresa(pedidocompra.getid_empresa());	
					pedidocompraLocal.setid_sucursal(pedidocompra.getid_sucursal());	
					pedidocompraLocal.setid_modulo(pedidocompra.getid_modulo());	
					pedidocompraLocal.setid_ejercicio(pedidocompra.getid_ejercicio());	
					pedidocompraLocal.setid_periodo(pedidocompra.getid_periodo());	
					pedidocompraLocal.setid_anio(pedidocompra.getid_anio());	
					pedidocompraLocal.setid_mes(pedidocompra.getid_mes());	
					pedidocompraLocal.setnumero_secuencial(pedidocompra.getnumero_secuencial());	
					pedidocompraLocal.setid_cliente(pedidocompra.getid_cliente());	
					pedidocompraLocal.setid_usuario(pedidocompra.getid_usuario());	
					pedidocompraLocal.setid_moneda(pedidocompra.getid_moneda());	
					pedidocompraLocal.setid_estado_pedido_compra(pedidocompra.getid_estado_pedido_compra());	
					pedidocompraLocal.settotal(pedidocompra.gettotal());	
					pedidocompraLocal.setfecha(pedidocompra.getfecha());	
					pedidocompraLocal.setid_empleado(pedidocompra.getid_empleado());	
					pedidocompraLocal.setresponsable(pedidocompra.getresponsable());	
					pedidocompraLocal.setsolicitado_por(pedidocompra.getsolicitado_por());	
					pedidocompraLocal.setmotivo_solicitud(pedidocompra.getmotivo_solicitud());	
					pedidocompraLocal.setarea_solicitud(pedidocompra.getarea_solicitud());	
					pedidocompraLocal.setpara_uso_de(pedidocompra.getpara_uso_de());	
					pedidocompraLocal.setlugar_entrega(pedidocompra.getlugar_entrega());	
					pedidocompraLocal.setdescripcion(pedidocompra.getdescripcion());	
					pedidocompraLocal.setfecha_emision(pedidocompra.getfecha_emision());	
					pedidocompraLocal.setfecha_entrega(pedidocompra.getfecha_entrega());	
					pedidocompraLocal.setid_formato(pedidocompra.getid_formato());	
					pedidocompraLocal.setid_tipo_cambio(pedidocompra.getid_tipo_cambio());	
					
					
					pedidocompraLocal.setDetallePedidoCompras(pedidocompra.getDetallePedidoCompras());
					
					existe=true;
					break;
				}
			}
			
			if(!pedidocompra.getIsDeleted()) {
				if(!existe) {
					pedidocompras.add(pedidocompra);
				}
			} else {
				if(pedidocompraEncontrado!=null && permiteQuitar)  {
					pedidocompras.remove(pedidocompraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PedidoCompra pedidocompra,List<PedidoCompra> pedidocompras) throws Exception {
		try	{			
			for(PedidoCompra pedidocompraLocal:pedidocompras) {
				if(pedidocompraLocal.getId().equals(pedidocompra.getId())) {
					pedidocompraLocal.setIsSelected(pedidocompra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPedidoCompra(List<PedidoCompra> pedidocomprasAux) throws Exception {
		//this.pedidocomprasAux=pedidocomprasAux;
		
		for(PedidoCompra pedidocompraAux:pedidocomprasAux) {
			if(pedidocompraAux.getIsChanged()) {
				pedidocompraAux.setIsChanged(false);
			}		
			
			if(pedidocompraAux.getIsNew()) {
				pedidocompraAux.setIsNew(false);
			}	
			
			if(pedidocompraAux.getIsDeleted()) {
				pedidocompraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPedidoCompra(PedidoCompra pedidocompraAux) throws Exception {
		//this.pedidocompraAux=pedidocompraAux;
		
			if(pedidocompraAux.getIsChanged()) {
				pedidocompraAux.setIsChanged(false);
			}		
			
			if(pedidocompraAux.getIsNew()) {
				pedidocompraAux.setIsNew(false);
			}	
			
			if(pedidocompraAux.getIsDeleted()) {
				pedidocompraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PedidoCompra pedidocompraAsignar,PedidoCompra pedidocompra) throws Exception {
		pedidocompraAsignar.setId(pedidocompra.getId());	
		pedidocompraAsignar.setVersionRow(pedidocompra.getVersionRow());	
		pedidocompraAsignar.setid_empresa(pedidocompra.getid_empresa());
		pedidocompraAsignar.setempresa_descripcion(pedidocompra.getempresa_descripcion());	
		pedidocompraAsignar.setid_sucursal(pedidocompra.getid_sucursal());
		pedidocompraAsignar.setsucursal_descripcion(pedidocompra.getsucursal_descripcion());	
		pedidocompraAsignar.setid_modulo(pedidocompra.getid_modulo());
		pedidocompraAsignar.setmodulo_descripcion(pedidocompra.getmodulo_descripcion());	
		pedidocompraAsignar.setid_ejercicio(pedidocompra.getid_ejercicio());
		pedidocompraAsignar.setejercicio_descripcion(pedidocompra.getejercicio_descripcion());	
		pedidocompraAsignar.setid_periodo(pedidocompra.getid_periodo());
		pedidocompraAsignar.setperiodo_descripcion(pedidocompra.getperiodo_descripcion());	
		pedidocompraAsignar.setid_anio(pedidocompra.getid_anio());
		pedidocompraAsignar.setanio_descripcion(pedidocompra.getanio_descripcion());	
		pedidocompraAsignar.setid_mes(pedidocompra.getid_mes());
		pedidocompraAsignar.setmes_descripcion(pedidocompra.getmes_descripcion());	
		pedidocompraAsignar.setnumero_secuencial(pedidocompra.getnumero_secuencial());	
		pedidocompraAsignar.setid_cliente(pedidocompra.getid_cliente());
		pedidocompraAsignar.setcliente_descripcion(pedidocompra.getcliente_descripcion());	
		pedidocompraAsignar.setid_usuario(pedidocompra.getid_usuario());
		pedidocompraAsignar.setusuario_descripcion(pedidocompra.getusuario_descripcion());	
		pedidocompraAsignar.setid_moneda(pedidocompra.getid_moneda());
		pedidocompraAsignar.setmoneda_descripcion(pedidocompra.getmoneda_descripcion());	
		pedidocompraAsignar.setid_estado_pedido_compra(pedidocompra.getid_estado_pedido_compra());
		pedidocompraAsignar.setestadopedidocompra_descripcion(pedidocompra.getestadopedidocompra_descripcion());	
		pedidocompraAsignar.settotal(pedidocompra.gettotal());	
		pedidocompraAsignar.setfecha(pedidocompra.getfecha());	
		pedidocompraAsignar.setid_empleado(pedidocompra.getid_empleado());
		pedidocompraAsignar.setempleado_descripcion(pedidocompra.getempleado_descripcion());	
		pedidocompraAsignar.setresponsable(pedidocompra.getresponsable());	
		pedidocompraAsignar.setsolicitado_por(pedidocompra.getsolicitado_por());	
		pedidocompraAsignar.setmotivo_solicitud(pedidocompra.getmotivo_solicitud());	
		pedidocompraAsignar.setarea_solicitud(pedidocompra.getarea_solicitud());	
		pedidocompraAsignar.setpara_uso_de(pedidocompra.getpara_uso_de());	
		pedidocompraAsignar.setlugar_entrega(pedidocompra.getlugar_entrega());	
		pedidocompraAsignar.setdescripcion(pedidocompra.getdescripcion());	
		pedidocompraAsignar.setfecha_emision(pedidocompra.getfecha_emision());	
		pedidocompraAsignar.setfecha_entrega(pedidocompra.getfecha_entrega());	
		pedidocompraAsignar.setid_formato(pedidocompra.getid_formato());
		pedidocompraAsignar.setformato_descripcion(pedidocompra.getformato_descripcion());	
		pedidocompraAsignar.setid_tipo_cambio(pedidocompra.getid_tipo_cambio());
		pedidocompraAsignar.settipocambio_descripcion(pedidocompra.gettipocambio_descripcion());	
	}
	
	public static void inicializarPedidoCompra(PedidoCompra pedidocompra) throws Exception {
		try {
				pedidocompra.setId(0L);	
					
				pedidocompra.setid_empresa(-1L);	
				pedidocompra.setid_sucursal(-1L);	
				pedidocompra.setid_modulo(-1L);	
				pedidocompra.setid_ejercicio(-1L);	
				pedidocompra.setid_periodo(-1L);	
				pedidocompra.setid_anio(null);	
				pedidocompra.setid_mes(null);	
				pedidocompra.setnumero_secuencial("");	
				pedidocompra.setid_cliente(-1L);	
				pedidocompra.setid_usuario(-1L);	
				pedidocompra.setid_moneda(-1L);	
				pedidocompra.setid_estado_pedido_compra(-1L);	
				pedidocompra.settotal(0.0);	
				pedidocompra.setfecha(new Date());	
				pedidocompra.setid_empleado(-1L);	
				pedidocompra.setresponsable("");	
				pedidocompra.setsolicitado_por("");	
				pedidocompra.setmotivo_solicitud("");	
				pedidocompra.setarea_solicitud("");	
				pedidocompra.setpara_uso_de("");	
				pedidocompra.setlugar_entrega("");	
				pedidocompra.setdescripcion("");	
				pedidocompra.setfecha_emision(new Date());	
				pedidocompra.setfecha_entrega(new Date());	
				pedidocompra.setid_formato(null);	
				pedidocompra.setid_tipo_cambio(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPedidoCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_NUMEROSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_IDESTADOPEDIDOCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_RESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_SOLICITADOPOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_MOTIVOSOLICITUD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_AREASOLICITUD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_PARAUSODE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_LUGARENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoCompraConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPedidoCompra(String sTipo,Row row,Workbook workbook,PedidoCompra pedidocompra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getnumero_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getestadopedidocompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getresponsable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getsolicitado_por());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getmotivo_solicitud());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getarea_solicitud());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getpara_uso_de());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getlugar_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidocompra.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPedidoCompra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPedidoCompra() {
		return this.sFinalQueryPedidoCompra;
	}
	
	public void setsFinalQueryPedidoCompra(String sFinalQueryPedidoCompra) {
		this.sFinalQueryPedidoCompra= sFinalQueryPedidoCompra;
	}
	
	public Border resaltarSeleccionarPedidoCompra=null;
	
	public Border setResaltarSeleccionarPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPedidoCompra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPedidoCompra() {
		return this.resaltarSeleccionarPedidoCompra;
	}
	
	public void setResaltarSeleccionarPedidoCompra(Border borderResaltarSeleccionarPedidoCompra) {
		this.resaltarSeleccionarPedidoCompra= borderResaltarSeleccionarPedidoCompra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPedidoCompra=null;
	public Boolean mostraridPedidoCompra=true;
	public Boolean activaridPedidoCompra=true;

	public Border resaltarid_empresaPedidoCompra=null;
	public Boolean mostrarid_empresaPedidoCompra=true;
	public Boolean activarid_empresaPedidoCompra=true;
	public Boolean cargarid_empresaPedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_sucursalPedidoCompra=null;
	public Boolean mostrarid_sucursalPedidoCompra=true;
	public Boolean activarid_sucursalPedidoCompra=true;
	public Boolean cargarid_sucursalPedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_moduloPedidoCompra=null;
	public Boolean mostrarid_moduloPedidoCompra=true;
	public Boolean activarid_moduloPedidoCompra=true;
	public Boolean cargarid_moduloPedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloPedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPedidoCompra=null;
	public Boolean mostrarid_ejercicioPedidoCompra=true;
	public Boolean activarid_ejercicioPedidoCompra=true;
	public Boolean cargarid_ejercicioPedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_periodoPedidoCompra=null;
	public Boolean mostrarid_periodoPedidoCompra=true;
	public Boolean activarid_periodoPedidoCompra=true;
	public Boolean cargarid_periodoPedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoPedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_anioPedidoCompra=null;
	public Boolean mostrarid_anioPedidoCompra=true;
	public Boolean activarid_anioPedidoCompra=false;
	public Boolean cargarid_anioPedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioPedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_mesPedidoCompra=null;
	public Boolean mostrarid_mesPedidoCompra=true;
	public Boolean activarid_mesPedidoCompra=false;
	public Boolean cargarid_mesPedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesPedidoCompra=false;//ConEventDepend=true

	public Border resaltarnumero_secuencialPedidoCompra=null;
	public Boolean mostrarnumero_secuencialPedidoCompra=true;
	public Boolean activarnumero_secuencialPedidoCompra=false;

	public Border resaltarid_clientePedidoCompra=null;
	public Boolean mostrarid_clientePedidoCompra=true;
	public Boolean activarid_clientePedidoCompra=true;
	public Boolean cargarid_clientePedidoCompra=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clientePedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_usuarioPedidoCompra=null;
	public Boolean mostrarid_usuarioPedidoCompra=true;
	public Boolean activarid_usuarioPedidoCompra=true;
	public Boolean cargarid_usuarioPedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioPedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_monedaPedidoCompra=null;
	public Boolean mostrarid_monedaPedidoCompra=true;
	public Boolean activarid_monedaPedidoCompra=false;
	public Boolean cargarid_monedaPedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaPedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_estado_pedido_compraPedidoCompra=null;
	public Boolean mostrarid_estado_pedido_compraPedidoCompra=true;
	public Boolean activarid_estado_pedido_compraPedidoCompra=false;
	public Boolean cargarid_estado_pedido_compraPedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_pedido_compraPedidoCompra=false;//ConEventDepend=true

	public Border resaltartotalPedidoCompra=null;
	public Boolean mostrartotalPedidoCompra=true;
	public Boolean activartotalPedidoCompra=false;

	public Border resaltarfechaPedidoCompra=null;
	public Boolean mostrarfechaPedidoCompra=true;
	public Boolean activarfechaPedidoCompra=false;

	public Border resaltarid_empleadoPedidoCompra=null;
	public Boolean mostrarid_empleadoPedidoCompra=true;
	public Boolean activarid_empleadoPedidoCompra=true;
	public Boolean cargarid_empleadoPedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoPedidoCompra=false;//ConEventDepend=true

	public Border resaltarresponsablePedidoCompra=null;
	public Boolean mostrarresponsablePedidoCompra=true;
	public Boolean activarresponsablePedidoCompra=true;

	public Border resaltarsolicitado_porPedidoCompra=null;
	public Boolean mostrarsolicitado_porPedidoCompra=true;
	public Boolean activarsolicitado_porPedidoCompra=true;

	public Border resaltarmotivo_solicitudPedidoCompra=null;
	public Boolean mostrarmotivo_solicitudPedidoCompra=true;
	public Boolean activarmotivo_solicitudPedidoCompra=true;

	public Border resaltararea_solicitudPedidoCompra=null;
	public Boolean mostrararea_solicitudPedidoCompra=true;
	public Boolean activararea_solicitudPedidoCompra=true;

	public Border resaltarpara_uso_dePedidoCompra=null;
	public Boolean mostrarpara_uso_dePedidoCompra=true;
	public Boolean activarpara_uso_dePedidoCompra=true;

	public Border resaltarlugar_entregaPedidoCompra=null;
	public Boolean mostrarlugar_entregaPedidoCompra=true;
	public Boolean activarlugar_entregaPedidoCompra=true;

	public Border resaltardescripcionPedidoCompra=null;
	public Boolean mostrardescripcionPedidoCompra=true;
	public Boolean activardescripcionPedidoCompra=true;

	public Border resaltarfecha_emisionPedidoCompra=null;
	public Boolean mostrarfecha_emisionPedidoCompra=true;
	public Boolean activarfecha_emisionPedidoCompra=true;

	public Border resaltarfecha_entregaPedidoCompra=null;
	public Boolean mostrarfecha_entregaPedidoCompra=true;
	public Boolean activarfecha_entregaPedidoCompra=true;

	public Border resaltarid_formatoPedidoCompra=null;
	public Boolean mostrarid_formatoPedidoCompra=true;
	public Boolean activarid_formatoPedidoCompra=true;
	public Boolean cargarid_formatoPedidoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoPedidoCompra=false;//ConEventDepend=true

	public Border resaltarid_tipo_cambioPedidoCompra=null;
	public Boolean mostrarid_tipo_cambioPedidoCompra=true;
	public Boolean activarid_tipo_cambioPedidoCompra=false;
	public Boolean cargarid_tipo_cambioPedidoCompra=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioPedidoCompra=false;//ConEventDepend=true

	
	

	public Border setResaltaridPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltaridPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPedidoCompra() {
		return this.resaltaridPedidoCompra;
	}

	public void setResaltaridPedidoCompra(Border borderResaltar) {
		this.resaltaridPedidoCompra= borderResaltar;
	}

	public Boolean getMostraridPedidoCompra() {
		return this.mostraridPedidoCompra;
	}

	public void setMostraridPedidoCompra(Boolean mostraridPedidoCompra) {
		this.mostraridPedidoCompra= mostraridPedidoCompra;
	}

	public Boolean getActivaridPedidoCompra() {
		return this.activaridPedidoCompra;
	}

	public void setActivaridPedidoCompra(Boolean activaridPedidoCompra) {
		this.activaridPedidoCompra= activaridPedidoCompra;
	}

	public Border setResaltarid_empresaPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_empresaPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPedidoCompra() {
		return this.resaltarid_empresaPedidoCompra;
	}

	public void setResaltarid_empresaPedidoCompra(Border borderResaltar) {
		this.resaltarid_empresaPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_empresaPedidoCompra() {
		return this.mostrarid_empresaPedidoCompra;
	}

	public void setMostrarid_empresaPedidoCompra(Boolean mostrarid_empresaPedidoCompra) {
		this.mostrarid_empresaPedidoCompra= mostrarid_empresaPedidoCompra;
	}

	public Boolean getActivarid_empresaPedidoCompra() {
		return this.activarid_empresaPedidoCompra;
	}

	public void setActivarid_empresaPedidoCompra(Boolean activarid_empresaPedidoCompra) {
		this.activarid_empresaPedidoCompra= activarid_empresaPedidoCompra;
	}

	public Boolean getCargarid_empresaPedidoCompra() {
		return this.cargarid_empresaPedidoCompra;
	}

	public void setCargarid_empresaPedidoCompra(Boolean cargarid_empresaPedidoCompra) {
		this.cargarid_empresaPedidoCompra= cargarid_empresaPedidoCompra;
	}

	public Border setResaltarid_sucursalPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPedidoCompra() {
		return this.resaltarid_sucursalPedidoCompra;
	}

	public void setResaltarid_sucursalPedidoCompra(Border borderResaltar) {
		this.resaltarid_sucursalPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPedidoCompra() {
		return this.mostrarid_sucursalPedidoCompra;
	}

	public void setMostrarid_sucursalPedidoCompra(Boolean mostrarid_sucursalPedidoCompra) {
		this.mostrarid_sucursalPedidoCompra= mostrarid_sucursalPedidoCompra;
	}

	public Boolean getActivarid_sucursalPedidoCompra() {
		return this.activarid_sucursalPedidoCompra;
	}

	public void setActivarid_sucursalPedidoCompra(Boolean activarid_sucursalPedidoCompra) {
		this.activarid_sucursalPedidoCompra= activarid_sucursalPedidoCompra;
	}

	public Boolean getCargarid_sucursalPedidoCompra() {
		return this.cargarid_sucursalPedidoCompra;
	}

	public void setCargarid_sucursalPedidoCompra(Boolean cargarid_sucursalPedidoCompra) {
		this.cargarid_sucursalPedidoCompra= cargarid_sucursalPedidoCompra;
	}

	public Border setResaltarid_moduloPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_moduloPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloPedidoCompra() {
		return this.resaltarid_moduloPedidoCompra;
	}

	public void setResaltarid_moduloPedidoCompra(Border borderResaltar) {
		this.resaltarid_moduloPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_moduloPedidoCompra() {
		return this.mostrarid_moduloPedidoCompra;
	}

	public void setMostrarid_moduloPedidoCompra(Boolean mostrarid_moduloPedidoCompra) {
		this.mostrarid_moduloPedidoCompra= mostrarid_moduloPedidoCompra;
	}

	public Boolean getActivarid_moduloPedidoCompra() {
		return this.activarid_moduloPedidoCompra;
	}

	public void setActivarid_moduloPedidoCompra(Boolean activarid_moduloPedidoCompra) {
		this.activarid_moduloPedidoCompra= activarid_moduloPedidoCompra;
	}

	public Boolean getCargarid_moduloPedidoCompra() {
		return this.cargarid_moduloPedidoCompra;
	}

	public void setCargarid_moduloPedidoCompra(Boolean cargarid_moduloPedidoCompra) {
		this.cargarid_moduloPedidoCompra= cargarid_moduloPedidoCompra;
	}

	public Border setResaltarid_ejercicioPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPedidoCompra() {
		return this.resaltarid_ejercicioPedidoCompra;
	}

	public void setResaltarid_ejercicioPedidoCompra(Border borderResaltar) {
		this.resaltarid_ejercicioPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPedidoCompra() {
		return this.mostrarid_ejercicioPedidoCompra;
	}

	public void setMostrarid_ejercicioPedidoCompra(Boolean mostrarid_ejercicioPedidoCompra) {
		this.mostrarid_ejercicioPedidoCompra= mostrarid_ejercicioPedidoCompra;
	}

	public Boolean getActivarid_ejercicioPedidoCompra() {
		return this.activarid_ejercicioPedidoCompra;
	}

	public void setActivarid_ejercicioPedidoCompra(Boolean activarid_ejercicioPedidoCompra) {
		this.activarid_ejercicioPedidoCompra= activarid_ejercicioPedidoCompra;
	}

	public Boolean getCargarid_ejercicioPedidoCompra() {
		return this.cargarid_ejercicioPedidoCompra;
	}

	public void setCargarid_ejercicioPedidoCompra(Boolean cargarid_ejercicioPedidoCompra) {
		this.cargarid_ejercicioPedidoCompra= cargarid_ejercicioPedidoCompra;
	}

	public Border setResaltarid_periodoPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_periodoPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoPedidoCompra() {
		return this.resaltarid_periodoPedidoCompra;
	}

	public void setResaltarid_periodoPedidoCompra(Border borderResaltar) {
		this.resaltarid_periodoPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_periodoPedidoCompra() {
		return this.mostrarid_periodoPedidoCompra;
	}

	public void setMostrarid_periodoPedidoCompra(Boolean mostrarid_periodoPedidoCompra) {
		this.mostrarid_periodoPedidoCompra= mostrarid_periodoPedidoCompra;
	}

	public Boolean getActivarid_periodoPedidoCompra() {
		return this.activarid_periodoPedidoCompra;
	}

	public void setActivarid_periodoPedidoCompra(Boolean activarid_periodoPedidoCompra) {
		this.activarid_periodoPedidoCompra= activarid_periodoPedidoCompra;
	}

	public Boolean getCargarid_periodoPedidoCompra() {
		return this.cargarid_periodoPedidoCompra;
	}

	public void setCargarid_periodoPedidoCompra(Boolean cargarid_periodoPedidoCompra) {
		this.cargarid_periodoPedidoCompra= cargarid_periodoPedidoCompra;
	}

	public Border setResaltarid_anioPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_anioPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioPedidoCompra() {
		return this.resaltarid_anioPedidoCompra;
	}

	public void setResaltarid_anioPedidoCompra(Border borderResaltar) {
		this.resaltarid_anioPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_anioPedidoCompra() {
		return this.mostrarid_anioPedidoCompra;
	}

	public void setMostrarid_anioPedidoCompra(Boolean mostrarid_anioPedidoCompra) {
		this.mostrarid_anioPedidoCompra= mostrarid_anioPedidoCompra;
	}

	public Boolean getActivarid_anioPedidoCompra() {
		return this.activarid_anioPedidoCompra;
	}

	public void setActivarid_anioPedidoCompra(Boolean activarid_anioPedidoCompra) {
		this.activarid_anioPedidoCompra= activarid_anioPedidoCompra;
	}

	public Boolean getCargarid_anioPedidoCompra() {
		return this.cargarid_anioPedidoCompra;
	}

	public void setCargarid_anioPedidoCompra(Boolean cargarid_anioPedidoCompra) {
		this.cargarid_anioPedidoCompra= cargarid_anioPedidoCompra;
	}

	public Border setResaltarid_mesPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_mesPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesPedidoCompra() {
		return this.resaltarid_mesPedidoCompra;
	}

	public void setResaltarid_mesPedidoCompra(Border borderResaltar) {
		this.resaltarid_mesPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_mesPedidoCompra() {
		return this.mostrarid_mesPedidoCompra;
	}

	public void setMostrarid_mesPedidoCompra(Boolean mostrarid_mesPedidoCompra) {
		this.mostrarid_mesPedidoCompra= mostrarid_mesPedidoCompra;
	}

	public Boolean getActivarid_mesPedidoCompra() {
		return this.activarid_mesPedidoCompra;
	}

	public void setActivarid_mesPedidoCompra(Boolean activarid_mesPedidoCompra) {
		this.activarid_mesPedidoCompra= activarid_mesPedidoCompra;
	}

	public Boolean getCargarid_mesPedidoCompra() {
		return this.cargarid_mesPedidoCompra;
	}

	public void setCargarid_mesPedidoCompra(Boolean cargarid_mesPedidoCompra) {
		this.cargarid_mesPedidoCompra= cargarid_mesPedidoCompra;
	}

	public Border setResaltarnumero_secuencialPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarnumero_secuencialPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialPedidoCompra() {
		return this.resaltarnumero_secuencialPedidoCompra;
	}

	public void setResaltarnumero_secuencialPedidoCompra(Border borderResaltar) {
		this.resaltarnumero_secuencialPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialPedidoCompra() {
		return this.mostrarnumero_secuencialPedidoCompra;
	}

	public void setMostrarnumero_secuencialPedidoCompra(Boolean mostrarnumero_secuencialPedidoCompra) {
		this.mostrarnumero_secuencialPedidoCompra= mostrarnumero_secuencialPedidoCompra;
	}

	public Boolean getActivarnumero_secuencialPedidoCompra() {
		return this.activarnumero_secuencialPedidoCompra;
	}

	public void setActivarnumero_secuencialPedidoCompra(Boolean activarnumero_secuencialPedidoCompra) {
		this.activarnumero_secuencialPedidoCompra= activarnumero_secuencialPedidoCompra;
	}

	public Border setResaltarid_clientePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_clientePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clientePedidoCompra() {
		return this.resaltarid_clientePedidoCompra;
	}

	public void setResaltarid_clientePedidoCompra(Border borderResaltar) {
		this.resaltarid_clientePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_clientePedidoCompra() {
		return this.mostrarid_clientePedidoCompra;
	}

	public void setMostrarid_clientePedidoCompra(Boolean mostrarid_clientePedidoCompra) {
		this.mostrarid_clientePedidoCompra= mostrarid_clientePedidoCompra;
	}

	public Boolean getActivarid_clientePedidoCompra() {
		return this.activarid_clientePedidoCompra;
	}

	public void setActivarid_clientePedidoCompra(Boolean activarid_clientePedidoCompra) {
		this.activarid_clientePedidoCompra= activarid_clientePedidoCompra;
	}

	public Boolean getCargarid_clientePedidoCompra() {
		return this.cargarid_clientePedidoCompra;
	}

	public void setCargarid_clientePedidoCompra(Boolean cargarid_clientePedidoCompra) {
		this.cargarid_clientePedidoCompra= cargarid_clientePedidoCompra;
	}

	public Border setResaltarid_usuarioPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_usuarioPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioPedidoCompra() {
		return this.resaltarid_usuarioPedidoCompra;
	}

	public void setResaltarid_usuarioPedidoCompra(Border borderResaltar) {
		this.resaltarid_usuarioPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_usuarioPedidoCompra() {
		return this.mostrarid_usuarioPedidoCompra;
	}

	public void setMostrarid_usuarioPedidoCompra(Boolean mostrarid_usuarioPedidoCompra) {
		this.mostrarid_usuarioPedidoCompra= mostrarid_usuarioPedidoCompra;
	}

	public Boolean getActivarid_usuarioPedidoCompra() {
		return this.activarid_usuarioPedidoCompra;
	}

	public void setActivarid_usuarioPedidoCompra(Boolean activarid_usuarioPedidoCompra) {
		this.activarid_usuarioPedidoCompra= activarid_usuarioPedidoCompra;
	}

	public Boolean getCargarid_usuarioPedidoCompra() {
		return this.cargarid_usuarioPedidoCompra;
	}

	public void setCargarid_usuarioPedidoCompra(Boolean cargarid_usuarioPedidoCompra) {
		this.cargarid_usuarioPedidoCompra= cargarid_usuarioPedidoCompra;
	}

	public Border setResaltarid_monedaPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_monedaPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaPedidoCompra() {
		return this.resaltarid_monedaPedidoCompra;
	}

	public void setResaltarid_monedaPedidoCompra(Border borderResaltar) {
		this.resaltarid_monedaPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_monedaPedidoCompra() {
		return this.mostrarid_monedaPedidoCompra;
	}

	public void setMostrarid_monedaPedidoCompra(Boolean mostrarid_monedaPedidoCompra) {
		this.mostrarid_monedaPedidoCompra= mostrarid_monedaPedidoCompra;
	}

	public Boolean getActivarid_monedaPedidoCompra() {
		return this.activarid_monedaPedidoCompra;
	}

	public void setActivarid_monedaPedidoCompra(Boolean activarid_monedaPedidoCompra) {
		this.activarid_monedaPedidoCompra= activarid_monedaPedidoCompra;
	}

	public Boolean getCargarid_monedaPedidoCompra() {
		return this.cargarid_monedaPedidoCompra;
	}

	public void setCargarid_monedaPedidoCompra(Boolean cargarid_monedaPedidoCompra) {
		this.cargarid_monedaPedidoCompra= cargarid_monedaPedidoCompra;
	}

	public Border setResaltarid_estado_pedido_compraPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_estado_pedido_compraPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_pedido_compraPedidoCompra() {
		return this.resaltarid_estado_pedido_compraPedidoCompra;
	}

	public void setResaltarid_estado_pedido_compraPedidoCompra(Border borderResaltar) {
		this.resaltarid_estado_pedido_compraPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_estado_pedido_compraPedidoCompra() {
		return this.mostrarid_estado_pedido_compraPedidoCompra;
	}

	public void setMostrarid_estado_pedido_compraPedidoCompra(Boolean mostrarid_estado_pedido_compraPedidoCompra) {
		this.mostrarid_estado_pedido_compraPedidoCompra= mostrarid_estado_pedido_compraPedidoCompra;
	}

	public Boolean getActivarid_estado_pedido_compraPedidoCompra() {
		return this.activarid_estado_pedido_compraPedidoCompra;
	}

	public void setActivarid_estado_pedido_compraPedidoCompra(Boolean activarid_estado_pedido_compraPedidoCompra) {
		this.activarid_estado_pedido_compraPedidoCompra= activarid_estado_pedido_compraPedidoCompra;
	}

	public Boolean getCargarid_estado_pedido_compraPedidoCompra() {
		return this.cargarid_estado_pedido_compraPedidoCompra;
	}

	public void setCargarid_estado_pedido_compraPedidoCompra(Boolean cargarid_estado_pedido_compraPedidoCompra) {
		this.cargarid_estado_pedido_compraPedidoCompra= cargarid_estado_pedido_compraPedidoCompra;
	}

	public Border setResaltartotalPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltartotalPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalPedidoCompra() {
		return this.resaltartotalPedidoCompra;
	}

	public void setResaltartotalPedidoCompra(Border borderResaltar) {
		this.resaltartotalPedidoCompra= borderResaltar;
	}

	public Boolean getMostrartotalPedidoCompra() {
		return this.mostrartotalPedidoCompra;
	}

	public void setMostrartotalPedidoCompra(Boolean mostrartotalPedidoCompra) {
		this.mostrartotalPedidoCompra= mostrartotalPedidoCompra;
	}

	public Boolean getActivartotalPedidoCompra() {
		return this.activartotalPedidoCompra;
	}

	public void setActivartotalPedidoCompra(Boolean activartotalPedidoCompra) {
		this.activartotalPedidoCompra= activartotalPedidoCompra;
	}

	public Border setResaltarfechaPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarfechaPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPedidoCompra() {
		return this.resaltarfechaPedidoCompra;
	}

	public void setResaltarfechaPedidoCompra(Border borderResaltar) {
		this.resaltarfechaPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarfechaPedidoCompra() {
		return this.mostrarfechaPedidoCompra;
	}

	public void setMostrarfechaPedidoCompra(Boolean mostrarfechaPedidoCompra) {
		this.mostrarfechaPedidoCompra= mostrarfechaPedidoCompra;
	}

	public Boolean getActivarfechaPedidoCompra() {
		return this.activarfechaPedidoCompra;
	}

	public void setActivarfechaPedidoCompra(Boolean activarfechaPedidoCompra) {
		this.activarfechaPedidoCompra= activarfechaPedidoCompra;
	}

	public Border setResaltarid_empleadoPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_empleadoPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoPedidoCompra() {
		return this.resaltarid_empleadoPedidoCompra;
	}

	public void setResaltarid_empleadoPedidoCompra(Border borderResaltar) {
		this.resaltarid_empleadoPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_empleadoPedidoCompra() {
		return this.mostrarid_empleadoPedidoCompra;
	}

	public void setMostrarid_empleadoPedidoCompra(Boolean mostrarid_empleadoPedidoCompra) {
		this.mostrarid_empleadoPedidoCompra= mostrarid_empleadoPedidoCompra;
	}

	public Boolean getActivarid_empleadoPedidoCompra() {
		return this.activarid_empleadoPedidoCompra;
	}

	public void setActivarid_empleadoPedidoCompra(Boolean activarid_empleadoPedidoCompra) {
		this.activarid_empleadoPedidoCompra= activarid_empleadoPedidoCompra;
	}

	public Boolean getCargarid_empleadoPedidoCompra() {
		return this.cargarid_empleadoPedidoCompra;
	}

	public void setCargarid_empleadoPedidoCompra(Boolean cargarid_empleadoPedidoCompra) {
		this.cargarid_empleadoPedidoCompra= cargarid_empleadoPedidoCompra;
	}

	public Border setResaltarresponsablePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarresponsablePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarresponsablePedidoCompra() {
		return this.resaltarresponsablePedidoCompra;
	}

	public void setResaltarresponsablePedidoCompra(Border borderResaltar) {
		this.resaltarresponsablePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarresponsablePedidoCompra() {
		return this.mostrarresponsablePedidoCompra;
	}

	public void setMostrarresponsablePedidoCompra(Boolean mostrarresponsablePedidoCompra) {
		this.mostrarresponsablePedidoCompra= mostrarresponsablePedidoCompra;
	}

	public Boolean getActivarresponsablePedidoCompra() {
		return this.activarresponsablePedidoCompra;
	}

	public void setActivarresponsablePedidoCompra(Boolean activarresponsablePedidoCompra) {
		this.activarresponsablePedidoCompra= activarresponsablePedidoCompra;
	}

	public Border setResaltarsolicitado_porPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarsolicitado_porPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsolicitado_porPedidoCompra() {
		return this.resaltarsolicitado_porPedidoCompra;
	}

	public void setResaltarsolicitado_porPedidoCompra(Border borderResaltar) {
		this.resaltarsolicitado_porPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarsolicitado_porPedidoCompra() {
		return this.mostrarsolicitado_porPedidoCompra;
	}

	public void setMostrarsolicitado_porPedidoCompra(Boolean mostrarsolicitado_porPedidoCompra) {
		this.mostrarsolicitado_porPedidoCompra= mostrarsolicitado_porPedidoCompra;
	}

	public Boolean getActivarsolicitado_porPedidoCompra() {
		return this.activarsolicitado_porPedidoCompra;
	}

	public void setActivarsolicitado_porPedidoCompra(Boolean activarsolicitado_porPedidoCompra) {
		this.activarsolicitado_porPedidoCompra= activarsolicitado_porPedidoCompra;
	}

	public Border setResaltarmotivo_solicitudPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarmotivo_solicitudPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmotivo_solicitudPedidoCompra() {
		return this.resaltarmotivo_solicitudPedidoCompra;
	}

	public void setResaltarmotivo_solicitudPedidoCompra(Border borderResaltar) {
		this.resaltarmotivo_solicitudPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarmotivo_solicitudPedidoCompra() {
		return this.mostrarmotivo_solicitudPedidoCompra;
	}

	public void setMostrarmotivo_solicitudPedidoCompra(Boolean mostrarmotivo_solicitudPedidoCompra) {
		this.mostrarmotivo_solicitudPedidoCompra= mostrarmotivo_solicitudPedidoCompra;
	}

	public Boolean getActivarmotivo_solicitudPedidoCompra() {
		return this.activarmotivo_solicitudPedidoCompra;
	}

	public void setActivarmotivo_solicitudPedidoCompra(Boolean activarmotivo_solicitudPedidoCompra) {
		this.activarmotivo_solicitudPedidoCompra= activarmotivo_solicitudPedidoCompra;
	}

	public Border setResaltararea_solicitudPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltararea_solicitudPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltararea_solicitudPedidoCompra() {
		return this.resaltararea_solicitudPedidoCompra;
	}

	public void setResaltararea_solicitudPedidoCompra(Border borderResaltar) {
		this.resaltararea_solicitudPedidoCompra= borderResaltar;
	}

	public Boolean getMostrararea_solicitudPedidoCompra() {
		return this.mostrararea_solicitudPedidoCompra;
	}

	public void setMostrararea_solicitudPedidoCompra(Boolean mostrararea_solicitudPedidoCompra) {
		this.mostrararea_solicitudPedidoCompra= mostrararea_solicitudPedidoCompra;
	}

	public Boolean getActivararea_solicitudPedidoCompra() {
		return this.activararea_solicitudPedidoCompra;
	}

	public void setActivararea_solicitudPedidoCompra(Boolean activararea_solicitudPedidoCompra) {
		this.activararea_solicitudPedidoCompra= activararea_solicitudPedidoCompra;
	}

	public Border setResaltarpara_uso_dePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarpara_uso_dePedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpara_uso_dePedidoCompra() {
		return this.resaltarpara_uso_dePedidoCompra;
	}

	public void setResaltarpara_uso_dePedidoCompra(Border borderResaltar) {
		this.resaltarpara_uso_dePedidoCompra= borderResaltar;
	}

	public Boolean getMostrarpara_uso_dePedidoCompra() {
		return this.mostrarpara_uso_dePedidoCompra;
	}

	public void setMostrarpara_uso_dePedidoCompra(Boolean mostrarpara_uso_dePedidoCompra) {
		this.mostrarpara_uso_dePedidoCompra= mostrarpara_uso_dePedidoCompra;
	}

	public Boolean getActivarpara_uso_dePedidoCompra() {
		return this.activarpara_uso_dePedidoCompra;
	}

	public void setActivarpara_uso_dePedidoCompra(Boolean activarpara_uso_dePedidoCompra) {
		this.activarpara_uso_dePedidoCompra= activarpara_uso_dePedidoCompra;
	}

	public Border setResaltarlugar_entregaPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarlugar_entregaPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlugar_entregaPedidoCompra() {
		return this.resaltarlugar_entregaPedidoCompra;
	}

	public void setResaltarlugar_entregaPedidoCompra(Border borderResaltar) {
		this.resaltarlugar_entregaPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarlugar_entregaPedidoCompra() {
		return this.mostrarlugar_entregaPedidoCompra;
	}

	public void setMostrarlugar_entregaPedidoCompra(Boolean mostrarlugar_entregaPedidoCompra) {
		this.mostrarlugar_entregaPedidoCompra= mostrarlugar_entregaPedidoCompra;
	}

	public Boolean getActivarlugar_entregaPedidoCompra() {
		return this.activarlugar_entregaPedidoCompra;
	}

	public void setActivarlugar_entregaPedidoCompra(Boolean activarlugar_entregaPedidoCompra) {
		this.activarlugar_entregaPedidoCompra= activarlugar_entregaPedidoCompra;
	}

	public Border setResaltardescripcionPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltardescripcionPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPedidoCompra() {
		return this.resaltardescripcionPedidoCompra;
	}

	public void setResaltardescripcionPedidoCompra(Border borderResaltar) {
		this.resaltardescripcionPedidoCompra= borderResaltar;
	}

	public Boolean getMostrardescripcionPedidoCompra() {
		return this.mostrardescripcionPedidoCompra;
	}

	public void setMostrardescripcionPedidoCompra(Boolean mostrardescripcionPedidoCompra) {
		this.mostrardescripcionPedidoCompra= mostrardescripcionPedidoCompra;
	}

	public Boolean getActivardescripcionPedidoCompra() {
		return this.activardescripcionPedidoCompra;
	}

	public void setActivardescripcionPedidoCompra(Boolean activardescripcionPedidoCompra) {
		this.activardescripcionPedidoCompra= activardescripcionPedidoCompra;
	}

	public Border setResaltarfecha_emisionPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionPedidoCompra() {
		return this.resaltarfecha_emisionPedidoCompra;
	}

	public void setResaltarfecha_emisionPedidoCompra(Border borderResaltar) {
		this.resaltarfecha_emisionPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionPedidoCompra() {
		return this.mostrarfecha_emisionPedidoCompra;
	}

	public void setMostrarfecha_emisionPedidoCompra(Boolean mostrarfecha_emisionPedidoCompra) {
		this.mostrarfecha_emisionPedidoCompra= mostrarfecha_emisionPedidoCompra;
	}

	public Boolean getActivarfecha_emisionPedidoCompra() {
		return this.activarfecha_emisionPedidoCompra;
	}

	public void setActivarfecha_emisionPedidoCompra(Boolean activarfecha_emisionPedidoCompra) {
		this.activarfecha_emisionPedidoCompra= activarfecha_emisionPedidoCompra;
	}

	public Border setResaltarfecha_entregaPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaPedidoCompra() {
		return this.resaltarfecha_entregaPedidoCompra;
	}

	public void setResaltarfecha_entregaPedidoCompra(Border borderResaltar) {
		this.resaltarfecha_entregaPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaPedidoCompra() {
		return this.mostrarfecha_entregaPedidoCompra;
	}

	public void setMostrarfecha_entregaPedidoCompra(Boolean mostrarfecha_entregaPedidoCompra) {
		this.mostrarfecha_entregaPedidoCompra= mostrarfecha_entregaPedidoCompra;
	}

	public Boolean getActivarfecha_entregaPedidoCompra() {
		return this.activarfecha_entregaPedidoCompra;
	}

	public void setActivarfecha_entregaPedidoCompra(Boolean activarfecha_entregaPedidoCompra) {
		this.activarfecha_entregaPedidoCompra= activarfecha_entregaPedidoCompra;
	}

	public Border setResaltarid_formatoPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_formatoPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoPedidoCompra() {
		return this.resaltarid_formatoPedidoCompra;
	}

	public void setResaltarid_formatoPedidoCompra(Border borderResaltar) {
		this.resaltarid_formatoPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_formatoPedidoCompra() {
		return this.mostrarid_formatoPedidoCompra;
	}

	public void setMostrarid_formatoPedidoCompra(Boolean mostrarid_formatoPedidoCompra) {
		this.mostrarid_formatoPedidoCompra= mostrarid_formatoPedidoCompra;
	}

	public Boolean getActivarid_formatoPedidoCompra() {
		return this.activarid_formatoPedidoCompra;
	}

	public void setActivarid_formatoPedidoCompra(Boolean activarid_formatoPedidoCompra) {
		this.activarid_formatoPedidoCompra= activarid_formatoPedidoCompra;
	}

	public Boolean getCargarid_formatoPedidoCompra() {
		return this.cargarid_formatoPedidoCompra;
	}

	public void setCargarid_formatoPedidoCompra(Boolean cargarid_formatoPedidoCompra) {
		this.cargarid_formatoPedidoCompra= cargarid_formatoPedidoCompra;
	}

	public Border setResaltarid_tipo_cambioPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioPedidoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioPedidoCompra() {
		return this.resaltarid_tipo_cambioPedidoCompra;
	}

	public void setResaltarid_tipo_cambioPedidoCompra(Border borderResaltar) {
		this.resaltarid_tipo_cambioPedidoCompra= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioPedidoCompra() {
		return this.mostrarid_tipo_cambioPedidoCompra;
	}

	public void setMostrarid_tipo_cambioPedidoCompra(Boolean mostrarid_tipo_cambioPedidoCompra) {
		this.mostrarid_tipo_cambioPedidoCompra= mostrarid_tipo_cambioPedidoCompra;
	}

	public Boolean getActivarid_tipo_cambioPedidoCompra() {
		return this.activarid_tipo_cambioPedidoCompra;
	}

	public void setActivarid_tipo_cambioPedidoCompra(Boolean activarid_tipo_cambioPedidoCompra) {
		this.activarid_tipo_cambioPedidoCompra= activarid_tipo_cambioPedidoCompra;
	}

	public Boolean getCargarid_tipo_cambioPedidoCompra() {
		return this.cargarid_tipo_cambioPedidoCompra;
	}

	public void setCargarid_tipo_cambioPedidoCompra(Boolean cargarid_tipo_cambioPedidoCompra) {
		this.cargarid_tipo_cambioPedidoCompra= cargarid_tipo_cambioPedidoCompra;
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
		
		
		this.setMostraridPedidoCompra(esInicial);
		this.setMostrarid_empresaPedidoCompra(esInicial);
		this.setMostrarid_sucursalPedidoCompra(esInicial);
		this.setMostrarid_moduloPedidoCompra(esInicial);
		this.setMostrarid_ejercicioPedidoCompra(esInicial);
		this.setMostrarid_periodoPedidoCompra(esInicial);
		this.setMostrarid_anioPedidoCompra(esInicial);
		this.setMostrarid_mesPedidoCompra(esInicial);
		this.setMostrarnumero_secuencialPedidoCompra(esInicial);
		this.setMostrarid_clientePedidoCompra(esInicial);
		this.setMostrarid_usuarioPedidoCompra(esInicial);
		this.setMostrarid_monedaPedidoCompra(esInicial);
		this.setMostrarid_estado_pedido_compraPedidoCompra(esInicial);
		this.setMostrartotalPedidoCompra(esInicial);
		this.setMostrarfechaPedidoCompra(esInicial);
		this.setMostrarid_empleadoPedidoCompra(esInicial);
		this.setMostrarresponsablePedidoCompra(esInicial);
		this.setMostrarsolicitado_porPedidoCompra(esInicial);
		this.setMostrarmotivo_solicitudPedidoCompra(esInicial);
		this.setMostrararea_solicitudPedidoCompra(esInicial);
		this.setMostrarpara_uso_dePedidoCompra(esInicial);
		this.setMostrarlugar_entregaPedidoCompra(esInicial);
		this.setMostrardescripcionPedidoCompra(esInicial);
		this.setMostrarfecha_emisionPedidoCompra(esInicial);
		this.setMostrarfecha_entregaPedidoCompra(esInicial);
		this.setMostrarid_formatoPedidoCompra(esInicial);
		this.setMostrarid_tipo_cambioPedidoCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoCompraConstantesFunciones.ID)) {
				this.setMostraridPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDMES)) {
				this.setMostrarid_mesPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setMostrarnumero_secuencialPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clientePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDESTADOPEDIDOCOMPRA)) {
				this.setMostrarid_estado_pedido_compraPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.TOTAL)) {
				this.setMostrartotalPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.FECHA)) {
				this.setMostrarfechaPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.RESPONSABLE)) {
				this.setMostrarresponsablePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.SOLICITADOPOR)) {
				this.setMostrarsolicitado_porPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.MOTIVOSOLICITUD)) {
				this.setMostrarmotivo_solicitudPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.AREASOLICITUD)) {
				this.setMostrararea_solicitudPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.PARAUSODE)) {
				this.setMostrarpara_uso_dePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.LUGARENTREGA)) {
				this.setMostrarlugar_entregaPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioPedidoCompra(esAsigna);
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
		
		
		this.setActivaridPedidoCompra(esInicial);
		this.setActivarid_empresaPedidoCompra(esInicial);
		this.setActivarid_sucursalPedidoCompra(esInicial);
		this.setActivarid_moduloPedidoCompra(esInicial);
		this.setActivarid_ejercicioPedidoCompra(esInicial);
		this.setActivarid_periodoPedidoCompra(esInicial);
		this.setActivarid_anioPedidoCompra(esInicial);
		this.setActivarid_mesPedidoCompra(esInicial);
		this.setActivarnumero_secuencialPedidoCompra(esInicial);
		this.setActivarid_clientePedidoCompra(esInicial);
		this.setActivarid_usuarioPedidoCompra(esInicial);
		this.setActivarid_monedaPedidoCompra(esInicial);
		this.setActivarid_estado_pedido_compraPedidoCompra(esInicial);
		this.setActivartotalPedidoCompra(esInicial);
		this.setActivarfechaPedidoCompra(esInicial);
		this.setActivarid_empleadoPedidoCompra(esInicial);
		this.setActivarresponsablePedidoCompra(esInicial);
		this.setActivarsolicitado_porPedidoCompra(esInicial);
		this.setActivarmotivo_solicitudPedidoCompra(esInicial);
		this.setActivararea_solicitudPedidoCompra(esInicial);
		this.setActivarpara_uso_dePedidoCompra(esInicial);
		this.setActivarlugar_entregaPedidoCompra(esInicial);
		this.setActivardescripcionPedidoCompra(esInicial);
		this.setActivarfecha_emisionPedidoCompra(esInicial);
		this.setActivarfecha_entregaPedidoCompra(esInicial);
		this.setActivarid_formatoPedidoCompra(esInicial);
		this.setActivarid_tipo_cambioPedidoCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoCompraConstantesFunciones.ID)) {
				this.setActivaridPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDANIO)) {
				this.setActivarid_anioPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDMES)) {
				this.setActivarid_mesPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setActivarnumero_secuencialPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clientePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDESTADOPEDIDOCOMPRA)) {
				this.setActivarid_estado_pedido_compraPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.TOTAL)) {
				this.setActivartotalPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.FECHA)) {
				this.setActivarfechaPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.RESPONSABLE)) {
				this.setActivarresponsablePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.SOLICITADOPOR)) {
				this.setActivarsolicitado_porPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.MOTIVOSOLICITUD)) {
				this.setActivarmotivo_solicitudPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.AREASOLICITUD)) {
				this.setActivararea_solicitudPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.PARAUSODE)) {
				this.setActivarpara_uso_dePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.LUGARENTREGA)) {
				this.setActivarlugar_entregaPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioPedidoCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPedidoCompra(esInicial);
		this.setResaltarid_empresaPedidoCompra(esInicial);
		this.setResaltarid_sucursalPedidoCompra(esInicial);
		this.setResaltarid_moduloPedidoCompra(esInicial);
		this.setResaltarid_ejercicioPedidoCompra(esInicial);
		this.setResaltarid_periodoPedidoCompra(esInicial);
		this.setResaltarid_anioPedidoCompra(esInicial);
		this.setResaltarid_mesPedidoCompra(esInicial);
		this.setResaltarnumero_secuencialPedidoCompra(esInicial);
		this.setResaltarid_clientePedidoCompra(esInicial);
		this.setResaltarid_usuarioPedidoCompra(esInicial);
		this.setResaltarid_monedaPedidoCompra(esInicial);
		this.setResaltarid_estado_pedido_compraPedidoCompra(esInicial);
		this.setResaltartotalPedidoCompra(esInicial);
		this.setResaltarfechaPedidoCompra(esInicial);
		this.setResaltarid_empleadoPedidoCompra(esInicial);
		this.setResaltarresponsablePedidoCompra(esInicial);
		this.setResaltarsolicitado_porPedidoCompra(esInicial);
		this.setResaltarmotivo_solicitudPedidoCompra(esInicial);
		this.setResaltararea_solicitudPedidoCompra(esInicial);
		this.setResaltarpara_uso_dePedidoCompra(esInicial);
		this.setResaltarlugar_entregaPedidoCompra(esInicial);
		this.setResaltardescripcionPedidoCompra(esInicial);
		this.setResaltarfecha_emisionPedidoCompra(esInicial);
		this.setResaltarfecha_entregaPedidoCompra(esInicial);
		this.setResaltarid_formatoPedidoCompra(esInicial);
		this.setResaltarid_tipo_cambioPedidoCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoCompraConstantesFunciones.ID)) {
				this.setResaltaridPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDMES)) {
				this.setResaltarid_mesPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setResaltarnumero_secuencialPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clientePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDESTADOPEDIDOCOMPRA)) {
				this.setResaltarid_estado_pedido_compraPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.TOTAL)) {
				this.setResaltartotalPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.FECHA)) {
				this.setResaltarfechaPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.RESPONSABLE)) {
				this.setResaltarresponsablePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.SOLICITADOPOR)) {
				this.setResaltarsolicitado_porPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.MOTIVOSOLICITUD)) {
				this.setResaltarmotivo_solicitudPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.AREASOLICITUD)) {
				this.setResaltararea_solicitudPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.PARAUSODE)) {
				this.setResaltarpara_uso_dePedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.LUGARENTREGA)) {
				this.setResaltarlugar_entregaPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoPedidoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoCompraConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioPedidoCompra(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetallePedidoCompraPedidoCompra=null;

	public Border getResaltarDetallePedidoCompraPedidoCompra() {
		return this.resaltarDetallePedidoCompraPedidoCompra;
	}

	public void setResaltarDetallePedidoCompraPedidoCompra(Border borderResaltarDetallePedidoCompra) {
		if(borderResaltarDetallePedidoCompra!=null) {
			this.resaltarDetallePedidoCompraPedidoCompra= borderResaltarDetallePedidoCompra;
		}
	}

	public Border setResaltarDetallePedidoCompraPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltarDetallePedidoCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//pedidocompraBeanSwingJInternalFrame.jTtoolBarPedidoCompra.setBorder(borderResaltarDetallePedidoCompra);
			
		this.resaltarDetallePedidoCompraPedidoCompra= borderResaltarDetallePedidoCompra;

		 return borderResaltarDetallePedidoCompra;
	}



	public Boolean mostrarDetallePedidoCompraPedidoCompra=true;

	public Boolean getMostrarDetallePedidoCompraPedidoCompra() {
		return this.mostrarDetallePedidoCompraPedidoCompra;
	}

	public void setMostrarDetallePedidoCompraPedidoCompra(Boolean visibilidadResaltarDetallePedidoCompra) {
		this.mostrarDetallePedidoCompraPedidoCompra= visibilidadResaltarDetallePedidoCompra;
	}



	public Boolean activarDetallePedidoCompraPedidoCompra=true;

	public Boolean gethabilitarResaltarDetallePedidoCompraPedidoCompra() {
		return this.activarDetallePedidoCompraPedidoCompra;
	}

	public void setActivarDetallePedidoCompraPedidoCompra(Boolean habilitarResaltarDetallePedidoCompra) {
		this.activarDetallePedidoCompraPedidoCompra= habilitarResaltarDetallePedidoCompra;
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

		this.setMostrarDetallePedidoCompraPedidoCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePedidoCompra.class)) {
				this.setMostrarDetallePedidoCompraPedidoCompra(esAsigna);
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

		this.setActivarDetallePedidoCompraPedidoCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePedidoCompra.class)) {
				this.setActivarDetallePedidoCompraPedidoCompra(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetallePedidoCompraPedidoCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePedidoCompra.class)) {
				this.setResaltarDetallePedidoCompraPedidoCompra(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdClientePedidoCompra=true;

	public Boolean getMostrarFK_IdClientePedidoCompra() {
		return this.mostrarFK_IdClientePedidoCompra;
	}

	public void setMostrarFK_IdClientePedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClientePedidoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioPedidoCompra=true;

	public Boolean getMostrarFK_IdEjercicioPedidoCompra() {
		return this.mostrarFK_IdEjercicioPedidoCompra;
	}

	public void setMostrarFK_IdEjercicioPedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioPedidoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoPedidoCompra=true;

	public Boolean getMostrarFK_IdEmpleadoPedidoCompra() {
		return this.mostrarFK_IdEmpleadoPedidoCompra;
	}

	public void setMostrarFK_IdEmpleadoPedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoPedidoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPedidoCompra=true;

	public Boolean getMostrarFK_IdEmpresaPedidoCompra() {
		return this.mostrarFK_IdEmpresaPedidoCompra;
	}

	public void setMostrarFK_IdEmpresaPedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPedidoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra=true;

	public Boolean getMostrarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra() {
		return this.mostrarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra;
	}

	public void setMostrarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloPedidoCompra=true;

	public Boolean getMostrarFK_IdModuloPedidoCompra() {
		return this.mostrarFK_IdModuloPedidoCompra;
	}

	public void setMostrarFK_IdModuloPedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloPedidoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoPedidoCompra=true;

	public Boolean getMostrarFK_IdPeriodoPedidoCompra() {
		return this.mostrarFK_IdPeriodoPedidoCompra;
	}

	public void setMostrarFK_IdPeriodoPedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoPedidoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPedidoCompra=true;

	public Boolean getMostrarFK_IdSucursalPedidoCompra() {
		return this.mostrarFK_IdSucursalPedidoCompra;
	}

	public void setMostrarFK_IdSucursalPedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPedidoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioPedidoCompra=true;

	public Boolean getMostrarFK_IdUsuarioPedidoCompra() {
		return this.mostrarFK_IdUsuarioPedidoCompra;
	}

	public void setMostrarFK_IdUsuarioPedidoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioPedidoCompra= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClientePedidoCompra=true;

	public Boolean getActivarFK_IdClientePedidoCompra() {
		return this.activarFK_IdClientePedidoCompra;
	}

	public void setActivarFK_IdClientePedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdClientePedidoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioPedidoCompra=true;

	public Boolean getActivarFK_IdEjercicioPedidoCompra() {
		return this.activarFK_IdEjercicioPedidoCompra;
	}

	public void setActivarFK_IdEjercicioPedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioPedidoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoPedidoCompra=true;

	public Boolean getActivarFK_IdEmpleadoPedidoCompra() {
		return this.activarFK_IdEmpleadoPedidoCompra;
	}

	public void setActivarFK_IdEmpleadoPedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoPedidoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPedidoCompra=true;

	public Boolean getActivarFK_IdEmpresaPedidoCompra() {
		return this.activarFK_IdEmpresaPedidoCompra;
	}

	public void setActivarFK_IdEmpresaPedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPedidoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra=true;

	public Boolean getActivarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra() {
		return this.activarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra;
	}

	public void setActivarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloPedidoCompra=true;

	public Boolean getActivarFK_IdModuloPedidoCompra() {
		return this.activarFK_IdModuloPedidoCompra;
	}

	public void setActivarFK_IdModuloPedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdModuloPedidoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoPedidoCompra=true;

	public Boolean getActivarFK_IdPeriodoPedidoCompra() {
		return this.activarFK_IdPeriodoPedidoCompra;
	}

	public void setActivarFK_IdPeriodoPedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoPedidoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPedidoCompra=true;

	public Boolean getActivarFK_IdSucursalPedidoCompra() {
		return this.activarFK_IdSucursalPedidoCompra;
	}

	public void setActivarFK_IdSucursalPedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPedidoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioPedidoCompra=true;

	public Boolean getActivarFK_IdUsuarioPedidoCompra() {
		return this.activarFK_IdUsuarioPedidoCompra;
	}

	public void setActivarFK_IdUsuarioPedidoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioPedidoCompra= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClientePedidoCompra=null;

	public Border getResaltarFK_IdClientePedidoCompra() {
		return this.resaltarFK_IdClientePedidoCompra;
	}

	public void setResaltarFK_IdClientePedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdClientePedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdClientePedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClientePedidoCompra= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioPedidoCompra=null;

	public Border getResaltarFK_IdEjercicioPedidoCompra() {
		return this.resaltarFK_IdEjercicioPedidoCompra;
	}

	public void setResaltarFK_IdEjercicioPedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdEjercicioPedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioPedidoCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoPedidoCompra=null;

	public Border getResaltarFK_IdEmpleadoPedidoCompra() {
		return this.resaltarFK_IdEmpleadoPedidoCompra;
	}

	public void setResaltarFK_IdEmpleadoPedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoPedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoPedidoCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPedidoCompra=null;

	public Border getResaltarFK_IdEmpresaPedidoCompra() {
		return this.resaltarFK_IdEmpresaPedidoCompra;
	}

	public void setResaltarFK_IdEmpresaPedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPedidoCompra= borderResaltar;
	}

	public Border resaltarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra=null;

	public Border getResaltarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra() {
		return this.resaltarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra;
	}

	public void setResaltarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoPedidoCompraEstadoPedoCompraPedidoCompra= borderResaltar;
	}

	public Border resaltarFK_IdModuloPedidoCompra=null;

	public Border getResaltarFK_IdModuloPedidoCompra() {
		return this.resaltarFK_IdModuloPedidoCompra;
	}

	public void setResaltarFK_IdModuloPedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdModuloPedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdModuloPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloPedidoCompra= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoPedidoCompra=null;

	public Border getResaltarFK_IdPeriodoPedidoCompra() {
		return this.resaltarFK_IdPeriodoPedidoCompra;
	}

	public void setResaltarFK_IdPeriodoPedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdPeriodoPedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoPedidoCompra= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPedidoCompra=null;

	public Border getResaltarFK_IdSucursalPedidoCompra() {
		return this.resaltarFK_IdSucursalPedidoCompra;
	}

	public void setResaltarFK_IdSucursalPedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdSucursalPedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPedidoCompra= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioPedidoCompra=null;

	public Border getResaltarFK_IdUsuarioPedidoCompra() {
		return this.resaltarFK_IdUsuarioPedidoCompra;
	}

	public void setResaltarFK_IdUsuarioPedidoCompra(Border borderResaltar) {
		this.resaltarFK_IdUsuarioPedidoCompra= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioPedidoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoCompraBeanSwingJInternalFrame pedidocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioPedidoCompra= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}