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
package com.bydan.erp.cartera.util.report;

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


import com.bydan.erp.cartera.util.report.PlaneacionPagosConstantesFunciones;
import com.bydan.erp.cartera.util.report.PlaneacionPagosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.PlaneacionPagosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PlaneacionPagosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="PlaneacionPagos";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PlaneacionPagos"+PlaneacionPagosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PlaneacionPagosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PlaneacionPagosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PlaneacionPagosConstantesFunciones.SCHEMA+"_"+PlaneacionPagosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PlaneacionPagosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PlaneacionPagosConstantesFunciones.SCHEMA+"_"+PlaneacionPagosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PlaneacionPagosConstantesFunciones.SCHEMA+"_"+PlaneacionPagosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PlaneacionPagosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PlaneacionPagosConstantesFunciones.SCHEMA+"_"+PlaneacionPagosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlaneacionPagosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PlaneacionPagosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlaneacionPagosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlaneacionPagosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PlaneacionPagosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlaneacionPagosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PlaneacionPagosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PlaneacionPagosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PlaneacionPagosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PlaneacionPagosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Planeacion Pagoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Planeacion Pagos";
	public static final String SCLASSWEBTITULO_LOWER="Planeacion Pagos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PlaneacionPagos";
	public static final String OBJECTNAME="planeacionpagos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="planeacion_pagos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select planeacionpagos from "+PlaneacionPagosConstantesFunciones.SPERSISTENCENAME+" planeacionpagos";
	public static String QUERYSELECTNATIVE="select "+PlaneacionPagosConstantesFunciones.SCHEMA+"."+PlaneacionPagosConstantesFunciones.TABLENAME+".id,"+PlaneacionPagosConstantesFunciones.SCHEMA+"."+PlaneacionPagosConstantesFunciones.TABLENAME+".version_row,"+PlaneacionPagosConstantesFunciones.SCHEMA+"."+PlaneacionPagosConstantesFunciones.TABLENAME+".id_empresa,"+PlaneacionPagosConstantesFunciones.SCHEMA+"."+PlaneacionPagosConstantesFunciones.TABLENAME+".id_grupo_cliente,"+PlaneacionPagosConstantesFunciones.SCHEMA+"."+PlaneacionPagosConstantesFunciones.TABLENAME+".fecha_pago_inicio,"+PlaneacionPagosConstantesFunciones.SCHEMA+"."+PlaneacionPagosConstantesFunciones.TABLENAME+".fecha_pago_fin,"+PlaneacionPagosConstantesFunciones.SCHEMA+"."+PlaneacionPagosConstantesFunciones.TABLENAME+".id_factura,"+PlaneacionPagosConstantesFunciones.SCHEMA+"."+PlaneacionPagosConstantesFunciones.TABLENAME+".id_cliente,"+PlaneacionPagosConstantesFunciones.SCHEMA+"."+PlaneacionPagosConstantesFunciones.TABLENAME+".nombre_cliente,"+PlaneacionPagosConstantesFunciones.SCHEMA+"."+PlaneacionPagosConstantesFunciones.TABLENAME+".numero_factura,"+PlaneacionPagosConstantesFunciones.SCHEMA+"."+PlaneacionPagosConstantesFunciones.TABLENAME+".fecha_emision,"+PlaneacionPagosConstantesFunciones.SCHEMA+"."+PlaneacionPagosConstantesFunciones.TABLENAME+".fecha_venta,"+PlaneacionPagosConstantesFunciones.SCHEMA+"."+PlaneacionPagosConstantesFunciones.TABLENAME+".fecha_pago,"+PlaneacionPagosConstantesFunciones.SCHEMA+"."+PlaneacionPagosConstantesFunciones.TABLENAME+".saldo from "+PlaneacionPagosConstantesFunciones.SCHEMA+"."+PlaneacionPagosConstantesFunciones.TABLENAME;//+" as "+PlaneacionPagosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDGRUPOCLIENTE= "id_grupo_cliente";
    public static final String FECHAPAGOINICIO= "fecha_pago_inicio";
    public static final String FECHAPAGOFIN= "fecha_pago_fin";
    public static final String IDFACTURA= "id_factura";
    public static final String IDCLIENTE= "id_cliente";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENTA= "fecha_venta";
    public static final String FECHAPAGO= "fecha_pago";
    public static final String SALDO= "saldo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDGRUPOCLIENTE= "Grupo Cliente";
		public static final String LABEL_IDGRUPOCLIENTE_LOWER= "Grupo Cliente";
    	public static final String LABEL_FECHAPAGOINICIO= "Fecha Pago Inicio";
		public static final String LABEL_FECHAPAGOINICIO_LOWER= "Fecha Pago Inicio";
    	public static final String LABEL_FECHAPAGOFIN= "Fecha Pago Fin";
		public static final String LABEL_FECHAPAGOFIN_LOWER= "Fecha Pago Fin";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENTA= "Fecha Venta";
		public static final String LABEL_FECHAVENTA_LOWER= "Fecha Venta";
    	public static final String LABEL_FECHAPAGO= "Fecha Pago";
		public static final String LABEL_FECHAPAGO_LOWER= "Fecha Pago";
    	public static final String LABEL_SALDO= "Saldo";
		public static final String LABEL_SALDO_LOWER= "Saldo";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getPlaneacionPagosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PlaneacionPagosConstantesFunciones.IDEMPRESA)) {sLabelColumna=PlaneacionPagosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PlaneacionPagosConstantesFunciones.IDGRUPOCLIENTE)) {sLabelColumna=PlaneacionPagosConstantesFunciones.LABEL_IDGRUPOCLIENTE;}
		if(sNombreColumna.equals(PlaneacionPagosConstantesFunciones.FECHAPAGOINICIO)) {sLabelColumna=PlaneacionPagosConstantesFunciones.LABEL_FECHAPAGOINICIO;}
		if(sNombreColumna.equals(PlaneacionPagosConstantesFunciones.FECHAPAGOFIN)) {sLabelColumna=PlaneacionPagosConstantesFunciones.LABEL_FECHAPAGOFIN;}
		if(sNombreColumna.equals(PlaneacionPagosConstantesFunciones.IDFACTURA)) {sLabelColumna=PlaneacionPagosConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(PlaneacionPagosConstantesFunciones.IDCLIENTE)) {sLabelColumna=PlaneacionPagosConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(PlaneacionPagosConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=PlaneacionPagosConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(PlaneacionPagosConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=PlaneacionPagosConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(PlaneacionPagosConstantesFunciones.FECHAEMISION)) {sLabelColumna=PlaneacionPagosConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(PlaneacionPagosConstantesFunciones.FECHAVENTA)) {sLabelColumna=PlaneacionPagosConstantesFunciones.LABEL_FECHAVENTA;}
		if(sNombreColumna.equals(PlaneacionPagosConstantesFunciones.FECHAPAGO)) {sLabelColumna=PlaneacionPagosConstantesFunciones.LABEL_FECHAPAGO;}
		if(sNombreColumna.equals(PlaneacionPagosConstantesFunciones.SALDO)) {sLabelColumna=PlaneacionPagosConstantesFunciones.LABEL_SALDO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPlaneacionPagosDescripcion(PlaneacionPagos planeacionpagos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(planeacionpagos !=null/* && planeacionpagos.getId()!=0*/) {
			sDescripcion=planeacionpagos.getfecha_pago_inicio().toString();//planeacionpagosplaneacionpagos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPlaneacionPagosDescripcionDetallado(PlaneacionPagos planeacionpagos) {
		String sDescripcion="";
			
		sDescripcion+=PlaneacionPagosConstantesFunciones.ID+"=";
		sDescripcion+=planeacionpagos.getId().toString()+",";
		sDescripcion+=PlaneacionPagosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=planeacionpagos.getVersionRow().toString()+",";
		sDescripcion+=PlaneacionPagosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=planeacionpagos.getid_empresa().toString()+",";
		sDescripcion+=PlaneacionPagosConstantesFunciones.IDGRUPOCLIENTE+"=";
		sDescripcion+=planeacionpagos.getid_grupo_cliente().toString()+",";
		sDescripcion+=PlaneacionPagosConstantesFunciones.FECHAPAGOINICIO+"=";
		sDescripcion+=planeacionpagos.getfecha_pago_inicio().toString()+",";
		sDescripcion+=PlaneacionPagosConstantesFunciones.FECHAPAGOFIN+"=";
		sDescripcion+=planeacionpagos.getfecha_pago_fin().toString()+",";
		sDescripcion+=PlaneacionPagosConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=planeacionpagos.getid_factura().toString()+",";
		sDescripcion+=PlaneacionPagosConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=planeacionpagos.getid_cliente().toString()+",";
		sDescripcion+=PlaneacionPagosConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=planeacionpagos.getnombre_cliente()+",";
		sDescripcion+=PlaneacionPagosConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=planeacionpagos.getnumero_factura()+",";
		sDescripcion+=PlaneacionPagosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=planeacionpagos.getfecha_emision().toString()+",";
		sDescripcion+=PlaneacionPagosConstantesFunciones.FECHAVENTA+"=";
		sDescripcion+=planeacionpagos.getfecha_venta().toString()+",";
		sDescripcion+=PlaneacionPagosConstantesFunciones.FECHAPAGO+"=";
		sDescripcion+=planeacionpagos.getfecha_pago().toString()+",";
		sDescripcion+=PlaneacionPagosConstantesFunciones.SALDO+"=";
		sDescripcion+=planeacionpagos.getsaldo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPlaneacionPagosDescripcion(PlaneacionPagos planeacionpagos,String sValor) throws Exception {			
		if(planeacionpagos !=null) {
			//planeacionpagosplaneacionpagos.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getGrupoClienteDescripcion(GrupoCliente grupocliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(grupocliente!=null/*&&grupocliente.getId()>0*/) {
			sDescripcion=GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(grupocliente);
		}

		return sDescripcion;
	}

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPlaneacionPagos")) {
			sNombreIndice="Tipo=  Por Grupo Cliente Por Fecha Pago Inicio Por Fecha Pago Fin";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdGrupoCliente")) {
			sNombreIndice="Tipo=  Por Grupo Cliente";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPlaneacionPagos(Long id_grupo_cliente,Date fecha_pago_inicio,Date fecha_pago_fin) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();}
		if(fecha_pago_inicio!=null) {sDetalleIndice+=" Fecha Pago Inicio="+fecha_pago_inicio.toString();}
		if(fecha_pago_fin!=null) {sDetalleIndice+=" Fecha Pago Fin="+fecha_pago_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdGrupoCliente(Long id_grupo_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPlaneacionPagos(PlaneacionPagos planeacionpagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		planeacionpagos.setnombre_cliente(planeacionpagos.getnombre_cliente().trim());
		planeacionpagos.setnumero_factura(planeacionpagos.getnumero_factura().trim());
	}
	
	public static void quitarEspaciosPlaneacionPagoss(List<PlaneacionPagos> planeacionpagoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PlaneacionPagos planeacionpagos: planeacionpagoss) {
			planeacionpagos.setnombre_cliente(planeacionpagos.getnombre_cliente().trim());
			planeacionpagos.setnumero_factura(planeacionpagos.getnumero_factura().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPlaneacionPagos(PlaneacionPagos planeacionpagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && planeacionpagos.getConCambioAuxiliar()) {
			planeacionpagos.setIsDeleted(planeacionpagos.getIsDeletedAuxiliar());	
			planeacionpagos.setIsNew(planeacionpagos.getIsNewAuxiliar());	
			planeacionpagos.setIsChanged(planeacionpagos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			planeacionpagos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			planeacionpagos.setIsDeletedAuxiliar(false);	
			planeacionpagos.setIsNewAuxiliar(false);	
			planeacionpagos.setIsChangedAuxiliar(false);
			
			planeacionpagos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPlaneacionPagoss(List<PlaneacionPagos> planeacionpagoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PlaneacionPagos planeacionpagos : planeacionpagoss) {
			if(conAsignarBase && planeacionpagos.getConCambioAuxiliar()) {
				planeacionpagos.setIsDeleted(planeacionpagos.getIsDeletedAuxiliar());	
				planeacionpagos.setIsNew(planeacionpagos.getIsNewAuxiliar());	
				planeacionpagos.setIsChanged(planeacionpagos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				planeacionpagos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				planeacionpagos.setIsDeletedAuxiliar(false);	
				planeacionpagos.setIsNewAuxiliar(false);	
				planeacionpagos.setIsChangedAuxiliar(false);
				
				planeacionpagos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPlaneacionPagos(PlaneacionPagos planeacionpagos,Boolean conEnteros) throws Exception  {
		planeacionpagos.setsaldo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPlaneacionPagoss(List<PlaneacionPagos> planeacionpagoss,Boolean conEnteros) throws Exception  {
		
		for(PlaneacionPagos planeacionpagos: planeacionpagoss) {
			planeacionpagos.setsaldo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPlaneacionPagos(List<PlaneacionPagos> planeacionpagoss,PlaneacionPagos planeacionpagosAux) throws Exception  {
		PlaneacionPagosConstantesFunciones.InicializarValoresPlaneacionPagos(planeacionpagosAux,true);
		
		for(PlaneacionPagos planeacionpagos: planeacionpagoss) {
			if(planeacionpagos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			planeacionpagosAux.setsaldo(planeacionpagosAux.getsaldo()+planeacionpagos.getsaldo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPlaneacionPagos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PlaneacionPagosConstantesFunciones.getArrayColumnasGlobalesPlaneacionPagos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPlaneacionPagos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PlaneacionPagosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PlaneacionPagosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPlaneacionPagos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PlaneacionPagos> planeacionpagoss,PlaneacionPagos planeacionpagos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PlaneacionPagos planeacionpagosAux: planeacionpagoss) {
			if(planeacionpagosAux!=null && planeacionpagos!=null) {
				if((planeacionpagosAux.getId()==null && planeacionpagos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(planeacionpagosAux.getId()!=null && planeacionpagos.getId()!=null){
					if(planeacionpagosAux.getId().equals(planeacionpagos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPlaneacionPagos(List<PlaneacionPagos> planeacionpagoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldoTotal=0.0;
	
		for(PlaneacionPagos planeacionpagos: planeacionpagoss) {			
			if(planeacionpagos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			saldoTotal+=planeacionpagos.getsaldo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PlaneacionPagosConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(PlaneacionPagosConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPlaneacionPagos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PlaneacionPagosConstantesFunciones.LABEL_ID, PlaneacionPagosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionPagosConstantesFunciones.LABEL_VERSIONROW, PlaneacionPagosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionPagosConstantesFunciones.LABEL_IDFACTURA, PlaneacionPagosConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionPagosConstantesFunciones.LABEL_IDCLIENTE, PlaneacionPagosConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionPagosConstantesFunciones.LABEL_NOMBRECLIENTE, PlaneacionPagosConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionPagosConstantesFunciones.LABEL_NUMEROFACTURA, PlaneacionPagosConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionPagosConstantesFunciones.LABEL_FECHAEMISION, PlaneacionPagosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionPagosConstantesFunciones.LABEL_FECHAVENTA, PlaneacionPagosConstantesFunciones.FECHAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionPagosConstantesFunciones.LABEL_FECHAPAGO, PlaneacionPagosConstantesFunciones.FECHAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionPagosConstantesFunciones.LABEL_SALDO, PlaneacionPagosConstantesFunciones.SALDO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPlaneacionPagos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PlaneacionPagosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionPagosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionPagosConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionPagosConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionPagosConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionPagosConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionPagosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionPagosConstantesFunciones.FECHAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionPagosConstantesFunciones.FECHAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionPagosConstantesFunciones.SALDO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPlaneacionPagos() throws Exception  {
		return PlaneacionPagosConstantesFunciones.getTiposSeleccionarPlaneacionPagos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPlaneacionPagos(Boolean conFk) throws Exception  {
		return PlaneacionPagosConstantesFunciones.getTiposSeleccionarPlaneacionPagos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPlaneacionPagos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionPagosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PlaneacionPagosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionPagosConstantesFunciones.LABEL_IDGRUPOCLIENTE);
			reporte.setsDescripcion(PlaneacionPagosConstantesFunciones.LABEL_IDGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionPagosConstantesFunciones.LABEL_FECHAPAGOINICIO);
			reporte.setsDescripcion(PlaneacionPagosConstantesFunciones.LABEL_FECHAPAGOINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionPagosConstantesFunciones.LABEL_FECHAPAGOFIN);
			reporte.setsDescripcion(PlaneacionPagosConstantesFunciones.LABEL_FECHAPAGOFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionPagosConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(PlaneacionPagosConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionPagosConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(PlaneacionPagosConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionPagosConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(PlaneacionPagosConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionPagosConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(PlaneacionPagosConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionPagosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(PlaneacionPagosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionPagosConstantesFunciones.LABEL_FECHAVENTA);
			reporte.setsDescripcion(PlaneacionPagosConstantesFunciones.LABEL_FECHAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionPagosConstantesFunciones.LABEL_FECHAPAGO);
			reporte.setsDescripcion(PlaneacionPagosConstantesFunciones.LABEL_FECHAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionPagosConstantesFunciones.LABEL_SALDO);
			reporte.setsDescripcion(PlaneacionPagosConstantesFunciones.LABEL_SALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPlaneacionPagos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPlaneacionPagos(PlaneacionPagos planeacionpagosAux) throws Exception {
		
			planeacionpagosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(planeacionpagosAux.getEmpresa()));
			planeacionpagosAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(planeacionpagosAux.getGrupoCliente()));
			planeacionpagosAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(planeacionpagosAux.getFactura()));
			planeacionpagosAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(planeacionpagosAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPlaneacionPagos(List<PlaneacionPagos> planeacionpagossTemp) throws Exception {
		for(PlaneacionPagos planeacionpagosAux:planeacionpagossTemp) {
			
			planeacionpagosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(planeacionpagosAux.getEmpresa()));
			planeacionpagosAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(planeacionpagosAux.getGrupoCliente()));
			planeacionpagosAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(planeacionpagosAux.getFactura()));
			planeacionpagosAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(planeacionpagosAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPlaneacionPagos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(GrupoCliente.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(Cliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoCliente.class)) {
						classes.add(new Classe(GrupoCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPlaneacionPagos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPlaneacionPagos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PlaneacionPagosConstantesFunciones.getClassesRelationshipsOfPlaneacionPagos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPlaneacionPagos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPlaneacionPagos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PlaneacionPagosConstantesFunciones.getClassesRelationshipsFromStringsOfPlaneacionPagos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPlaneacionPagos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PlaneacionPagos planeacionpagos,List<PlaneacionPagos> planeacionpagoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(PlaneacionPagos planeacionpagos,List<PlaneacionPagos> planeacionpagoss) throws Exception {
		try	{			
			for(PlaneacionPagos planeacionpagosLocal:planeacionpagoss) {
				if(planeacionpagosLocal.getId().equals(planeacionpagos.getId())) {
					planeacionpagosLocal.setIsSelected(planeacionpagos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPlaneacionPagos(List<PlaneacionPagos> planeacionpagossAux) throws Exception {
		//this.planeacionpagossAux=planeacionpagossAux;
		
		for(PlaneacionPagos planeacionpagosAux:planeacionpagossAux) {
			if(planeacionpagosAux.getIsChanged()) {
				planeacionpagosAux.setIsChanged(false);
			}		
			
			if(planeacionpagosAux.getIsNew()) {
				planeacionpagosAux.setIsNew(false);
			}	
			
			if(planeacionpagosAux.getIsDeleted()) {
				planeacionpagosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPlaneacionPagos(PlaneacionPagos planeacionpagosAux) throws Exception {
		//this.planeacionpagosAux=planeacionpagosAux;
		
			if(planeacionpagosAux.getIsChanged()) {
				planeacionpagosAux.setIsChanged(false);
			}		
			
			if(planeacionpagosAux.getIsNew()) {
				planeacionpagosAux.setIsNew(false);
			}	
			
			if(planeacionpagosAux.getIsDeleted()) {
				planeacionpagosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PlaneacionPagos planeacionpagosAsignar,PlaneacionPagos planeacionpagos) throws Exception {
		planeacionpagosAsignar.setId(planeacionpagos.getId());	
		planeacionpagosAsignar.setVersionRow(planeacionpagos.getVersionRow());	
		planeacionpagosAsignar.setid_factura(planeacionpagos.getid_factura());
		planeacionpagosAsignar.setfactura_descripcion(planeacionpagos.getfactura_descripcion());	
		planeacionpagosAsignar.setid_cliente(planeacionpagos.getid_cliente());
		planeacionpagosAsignar.setcliente_descripcion(planeacionpagos.getcliente_descripcion());	
		planeacionpagosAsignar.setnombre_cliente(planeacionpagos.getnombre_cliente());	
		planeacionpagosAsignar.setnumero_factura(planeacionpagos.getnumero_factura());	
		planeacionpagosAsignar.setfecha_emision(planeacionpagos.getfecha_emision());	
		planeacionpagosAsignar.setfecha_venta(planeacionpagos.getfecha_venta());	
		planeacionpagosAsignar.setfecha_pago(planeacionpagos.getfecha_pago());	
		planeacionpagosAsignar.setsaldo(planeacionpagos.getsaldo());	
	}
	
	public static void inicializarPlaneacionPagos(PlaneacionPagos planeacionpagos) throws Exception {
		try {
				planeacionpagos.setId(0L);	
					
				planeacionpagos.setid_factura(-1L);	
				planeacionpagos.setid_cliente(-1L);	
				planeacionpagos.setnombre_cliente("");	
				planeacionpagos.setnumero_factura("");	
				planeacionpagos.setfecha_emision(new Date());	
				planeacionpagos.setfecha_venta(new Date());	
				planeacionpagos.setfecha_pago(new Date());	
				planeacionpagos.setsaldo(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPlaneacionPagos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionPagosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionPagosConstantesFunciones.LABEL_IDGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionPagosConstantesFunciones.LABEL_FECHAPAGOINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionPagosConstantesFunciones.LABEL_FECHAPAGOFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionPagosConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionPagosConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionPagosConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionPagosConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionPagosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionPagosConstantesFunciones.LABEL_FECHAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionPagosConstantesFunciones.LABEL_FECHAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionPagosConstantesFunciones.LABEL_SALDO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPlaneacionPagos(String sTipo,Row row,Workbook workbook,PlaneacionPagos planeacionpagos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacionpagos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacionpagos.getgrupocliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacionpagos.getfecha_pago_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacionpagos.getfecha_pago_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacionpagos.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacionpagos.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacionpagos.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacionpagos.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacionpagos.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacionpagos.getfecha_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacionpagos.getfecha_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacionpagos.getsaldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPlaneacionPagos="";
	
	public String getsFinalQueryPlaneacionPagos() {
		return this.sFinalQueryPlaneacionPagos;
	}
	
	public void setsFinalQueryPlaneacionPagos(String sFinalQueryPlaneacionPagos) {
		this.sFinalQueryPlaneacionPagos= sFinalQueryPlaneacionPagos;
	}
	
	public Border resaltarSeleccionarPlaneacionPagos=null;
	
	public Border setResaltarSeleccionarPlaneacionPagos(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//planeacionpagosBeanSwingJInternalFrame.jTtoolBarPlaneacionPagos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPlaneacionPagos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPlaneacionPagos() {
		return this.resaltarSeleccionarPlaneacionPagos;
	}
	
	public void setResaltarSeleccionarPlaneacionPagos(Border borderResaltarSeleccionarPlaneacionPagos) {
		this.resaltarSeleccionarPlaneacionPagos= borderResaltarSeleccionarPlaneacionPagos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPlaneacionPagos=null;
	public Boolean mostraridPlaneacionPagos=true;
	public Boolean activaridPlaneacionPagos=true;

	public Border resaltarid_empresaPlaneacionPagos=null;
	public Boolean mostrarid_empresaPlaneacionPagos=true;
	public Boolean activarid_empresaPlaneacionPagos=true;
	public Boolean cargarid_empresaPlaneacionPagos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPlaneacionPagos=false;//ConEventDepend=true

	public Border resaltarid_grupo_clientePlaneacionPagos=null;
	public Boolean mostrarid_grupo_clientePlaneacionPagos=true;
	public Boolean activarid_grupo_clientePlaneacionPagos=true;
	public Boolean cargarid_grupo_clientePlaneacionPagos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_clientePlaneacionPagos=false;//ConEventDepend=true

	public Border resaltarfecha_pago_inicioPlaneacionPagos=null;
	public Boolean mostrarfecha_pago_inicioPlaneacionPagos=true;
	public Boolean activarfecha_pago_inicioPlaneacionPagos=true;

	public Border resaltarfecha_pago_finPlaneacionPagos=null;
	public Boolean mostrarfecha_pago_finPlaneacionPagos=true;
	public Boolean activarfecha_pago_finPlaneacionPagos=true;

	public Border resaltarid_facturaPlaneacionPagos=null;
	public Boolean mostrarid_facturaPlaneacionPagos=true;
	public Boolean activarid_facturaPlaneacionPagos=true;
	public Boolean cargarid_facturaPlaneacionPagos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaPlaneacionPagos=false;//ConEventDepend=true

	public Border resaltarid_clientePlaneacionPagos=null;
	public Boolean mostrarid_clientePlaneacionPagos=true;
	public Boolean activarid_clientePlaneacionPagos=true;
	public Boolean cargarid_clientePlaneacionPagos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clientePlaneacionPagos=false;//ConEventDepend=true

	public Border resaltarnombre_clientePlaneacionPagos=null;
	public Boolean mostrarnombre_clientePlaneacionPagos=true;
	public Boolean activarnombre_clientePlaneacionPagos=true;

	public Border resaltarnumero_facturaPlaneacionPagos=null;
	public Boolean mostrarnumero_facturaPlaneacionPagos=true;
	public Boolean activarnumero_facturaPlaneacionPagos=true;

	public Border resaltarfecha_emisionPlaneacionPagos=null;
	public Boolean mostrarfecha_emisionPlaneacionPagos=true;
	public Boolean activarfecha_emisionPlaneacionPagos=true;

	public Border resaltarfecha_ventaPlaneacionPagos=null;
	public Boolean mostrarfecha_ventaPlaneacionPagos=true;
	public Boolean activarfecha_ventaPlaneacionPagos=true;

	public Border resaltarfecha_pagoPlaneacionPagos=null;
	public Boolean mostrarfecha_pagoPlaneacionPagos=true;
	public Boolean activarfecha_pagoPlaneacionPagos=true;

	public Border resaltarsaldoPlaneacionPagos=null;
	public Boolean mostrarsaldoPlaneacionPagos=true;
	public Boolean activarsaldoPlaneacionPagos=true;

	
	

	public Border setResaltaridPlaneacionPagos(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacionpagosBeanSwingJInternalFrame.jTtoolBarPlaneacionPagos.setBorder(borderResaltar);
		
		this.resaltaridPlaneacionPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPlaneacionPagos() {
		return this.resaltaridPlaneacionPagos;
	}

	public void setResaltaridPlaneacionPagos(Border borderResaltar) {
		this.resaltaridPlaneacionPagos= borderResaltar;
	}

	public Boolean getMostraridPlaneacionPagos() {
		return this.mostraridPlaneacionPagos;
	}

	public void setMostraridPlaneacionPagos(Boolean mostraridPlaneacionPagos) {
		this.mostraridPlaneacionPagos= mostraridPlaneacionPagos;
	}

	public Boolean getActivaridPlaneacionPagos() {
		return this.activaridPlaneacionPagos;
	}

	public void setActivaridPlaneacionPagos(Boolean activaridPlaneacionPagos) {
		this.activaridPlaneacionPagos= activaridPlaneacionPagos;
	}

	public Border setResaltarid_empresaPlaneacionPagos(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacionpagosBeanSwingJInternalFrame.jTtoolBarPlaneacionPagos.setBorder(borderResaltar);
		
		this.resaltarid_empresaPlaneacionPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPlaneacionPagos() {
		return this.resaltarid_empresaPlaneacionPagos;
	}

	public void setResaltarid_empresaPlaneacionPagos(Border borderResaltar) {
		this.resaltarid_empresaPlaneacionPagos= borderResaltar;
	}

	public Boolean getMostrarid_empresaPlaneacionPagos() {
		return this.mostrarid_empresaPlaneacionPagos;
	}

	public void setMostrarid_empresaPlaneacionPagos(Boolean mostrarid_empresaPlaneacionPagos) {
		this.mostrarid_empresaPlaneacionPagos= mostrarid_empresaPlaneacionPagos;
	}

	public Boolean getActivarid_empresaPlaneacionPagos() {
		return this.activarid_empresaPlaneacionPagos;
	}

	public void setActivarid_empresaPlaneacionPagos(Boolean activarid_empresaPlaneacionPagos) {
		this.activarid_empresaPlaneacionPagos= activarid_empresaPlaneacionPagos;
	}

	public Boolean getCargarid_empresaPlaneacionPagos() {
		return this.cargarid_empresaPlaneacionPagos;
	}

	public void setCargarid_empresaPlaneacionPagos(Boolean cargarid_empresaPlaneacionPagos) {
		this.cargarid_empresaPlaneacionPagos= cargarid_empresaPlaneacionPagos;
	}

	public Border setResaltarid_grupo_clientePlaneacionPagos(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacionpagosBeanSwingJInternalFrame.jTtoolBarPlaneacionPagos.setBorder(borderResaltar);
		
		this.resaltarid_grupo_clientePlaneacionPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_clientePlaneacionPagos() {
		return this.resaltarid_grupo_clientePlaneacionPagos;
	}

	public void setResaltarid_grupo_clientePlaneacionPagos(Border borderResaltar) {
		this.resaltarid_grupo_clientePlaneacionPagos= borderResaltar;
	}

	public Boolean getMostrarid_grupo_clientePlaneacionPagos() {
		return this.mostrarid_grupo_clientePlaneacionPagos;
	}

	public void setMostrarid_grupo_clientePlaneacionPagos(Boolean mostrarid_grupo_clientePlaneacionPagos) {
		this.mostrarid_grupo_clientePlaneacionPagos= mostrarid_grupo_clientePlaneacionPagos;
	}

	public Boolean getActivarid_grupo_clientePlaneacionPagos() {
		return this.activarid_grupo_clientePlaneacionPagos;
	}

	public void setActivarid_grupo_clientePlaneacionPagos(Boolean activarid_grupo_clientePlaneacionPagos) {
		this.activarid_grupo_clientePlaneacionPagos= activarid_grupo_clientePlaneacionPagos;
	}

	public Boolean getCargarid_grupo_clientePlaneacionPagos() {
		return this.cargarid_grupo_clientePlaneacionPagos;
	}

	public void setCargarid_grupo_clientePlaneacionPagos(Boolean cargarid_grupo_clientePlaneacionPagos) {
		this.cargarid_grupo_clientePlaneacionPagos= cargarid_grupo_clientePlaneacionPagos;
	}

	public Border setResaltarfecha_pago_inicioPlaneacionPagos(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacionpagosBeanSwingJInternalFrame.jTtoolBarPlaneacionPagos.setBorder(borderResaltar);
		
		this.resaltarfecha_pago_inicioPlaneacionPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_pago_inicioPlaneacionPagos() {
		return this.resaltarfecha_pago_inicioPlaneacionPagos;
	}

	public void setResaltarfecha_pago_inicioPlaneacionPagos(Border borderResaltar) {
		this.resaltarfecha_pago_inicioPlaneacionPagos= borderResaltar;
	}

	public Boolean getMostrarfecha_pago_inicioPlaneacionPagos() {
		return this.mostrarfecha_pago_inicioPlaneacionPagos;
	}

	public void setMostrarfecha_pago_inicioPlaneacionPagos(Boolean mostrarfecha_pago_inicioPlaneacionPagos) {
		this.mostrarfecha_pago_inicioPlaneacionPagos= mostrarfecha_pago_inicioPlaneacionPagos;
	}

	public Boolean getActivarfecha_pago_inicioPlaneacionPagos() {
		return this.activarfecha_pago_inicioPlaneacionPagos;
	}

	public void setActivarfecha_pago_inicioPlaneacionPagos(Boolean activarfecha_pago_inicioPlaneacionPagos) {
		this.activarfecha_pago_inicioPlaneacionPagos= activarfecha_pago_inicioPlaneacionPagos;
	}

	public Border setResaltarfecha_pago_finPlaneacionPagos(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacionpagosBeanSwingJInternalFrame.jTtoolBarPlaneacionPagos.setBorder(borderResaltar);
		
		this.resaltarfecha_pago_finPlaneacionPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_pago_finPlaneacionPagos() {
		return this.resaltarfecha_pago_finPlaneacionPagos;
	}

	public void setResaltarfecha_pago_finPlaneacionPagos(Border borderResaltar) {
		this.resaltarfecha_pago_finPlaneacionPagos= borderResaltar;
	}

	public Boolean getMostrarfecha_pago_finPlaneacionPagos() {
		return this.mostrarfecha_pago_finPlaneacionPagos;
	}

	public void setMostrarfecha_pago_finPlaneacionPagos(Boolean mostrarfecha_pago_finPlaneacionPagos) {
		this.mostrarfecha_pago_finPlaneacionPagos= mostrarfecha_pago_finPlaneacionPagos;
	}

	public Boolean getActivarfecha_pago_finPlaneacionPagos() {
		return this.activarfecha_pago_finPlaneacionPagos;
	}

	public void setActivarfecha_pago_finPlaneacionPagos(Boolean activarfecha_pago_finPlaneacionPagos) {
		this.activarfecha_pago_finPlaneacionPagos= activarfecha_pago_finPlaneacionPagos;
	}

	public Border setResaltarid_facturaPlaneacionPagos(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacionpagosBeanSwingJInternalFrame.jTtoolBarPlaneacionPagos.setBorder(borderResaltar);
		
		this.resaltarid_facturaPlaneacionPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaPlaneacionPagos() {
		return this.resaltarid_facturaPlaneacionPagos;
	}

	public void setResaltarid_facturaPlaneacionPagos(Border borderResaltar) {
		this.resaltarid_facturaPlaneacionPagos= borderResaltar;
	}

	public Boolean getMostrarid_facturaPlaneacionPagos() {
		return this.mostrarid_facturaPlaneacionPagos;
	}

	public void setMostrarid_facturaPlaneacionPagos(Boolean mostrarid_facturaPlaneacionPagos) {
		this.mostrarid_facturaPlaneacionPagos= mostrarid_facturaPlaneacionPagos;
	}

	public Boolean getActivarid_facturaPlaneacionPagos() {
		return this.activarid_facturaPlaneacionPagos;
	}

	public void setActivarid_facturaPlaneacionPagos(Boolean activarid_facturaPlaneacionPagos) {
		this.activarid_facturaPlaneacionPagos= activarid_facturaPlaneacionPagos;
	}

	public Boolean getCargarid_facturaPlaneacionPagos() {
		return this.cargarid_facturaPlaneacionPagos;
	}

	public void setCargarid_facturaPlaneacionPagos(Boolean cargarid_facturaPlaneacionPagos) {
		this.cargarid_facturaPlaneacionPagos= cargarid_facturaPlaneacionPagos;
	}

	public Border setResaltarid_clientePlaneacionPagos(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacionpagosBeanSwingJInternalFrame.jTtoolBarPlaneacionPagos.setBorder(borderResaltar);
		
		this.resaltarid_clientePlaneacionPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clientePlaneacionPagos() {
		return this.resaltarid_clientePlaneacionPagos;
	}

	public void setResaltarid_clientePlaneacionPagos(Border borderResaltar) {
		this.resaltarid_clientePlaneacionPagos= borderResaltar;
	}

	public Boolean getMostrarid_clientePlaneacionPagos() {
		return this.mostrarid_clientePlaneacionPagos;
	}

	public void setMostrarid_clientePlaneacionPagos(Boolean mostrarid_clientePlaneacionPagos) {
		this.mostrarid_clientePlaneacionPagos= mostrarid_clientePlaneacionPagos;
	}

	public Boolean getActivarid_clientePlaneacionPagos() {
		return this.activarid_clientePlaneacionPagos;
	}

	public void setActivarid_clientePlaneacionPagos(Boolean activarid_clientePlaneacionPagos) {
		this.activarid_clientePlaneacionPagos= activarid_clientePlaneacionPagos;
	}

	public Boolean getCargarid_clientePlaneacionPagos() {
		return this.cargarid_clientePlaneacionPagos;
	}

	public void setCargarid_clientePlaneacionPagos(Boolean cargarid_clientePlaneacionPagos) {
		this.cargarid_clientePlaneacionPagos= cargarid_clientePlaneacionPagos;
	}

	public Border setResaltarnombre_clientePlaneacionPagos(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacionpagosBeanSwingJInternalFrame.jTtoolBarPlaneacionPagos.setBorder(borderResaltar);
		
		this.resaltarnombre_clientePlaneacionPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clientePlaneacionPagos() {
		return this.resaltarnombre_clientePlaneacionPagos;
	}

	public void setResaltarnombre_clientePlaneacionPagos(Border borderResaltar) {
		this.resaltarnombre_clientePlaneacionPagos= borderResaltar;
	}

	public Boolean getMostrarnombre_clientePlaneacionPagos() {
		return this.mostrarnombre_clientePlaneacionPagos;
	}

	public void setMostrarnombre_clientePlaneacionPagos(Boolean mostrarnombre_clientePlaneacionPagos) {
		this.mostrarnombre_clientePlaneacionPagos= mostrarnombre_clientePlaneacionPagos;
	}

	public Boolean getActivarnombre_clientePlaneacionPagos() {
		return this.activarnombre_clientePlaneacionPagos;
	}

	public void setActivarnombre_clientePlaneacionPagos(Boolean activarnombre_clientePlaneacionPagos) {
		this.activarnombre_clientePlaneacionPagos= activarnombre_clientePlaneacionPagos;
	}

	public Border setResaltarnumero_facturaPlaneacionPagos(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacionpagosBeanSwingJInternalFrame.jTtoolBarPlaneacionPagos.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaPlaneacionPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaPlaneacionPagos() {
		return this.resaltarnumero_facturaPlaneacionPagos;
	}

	public void setResaltarnumero_facturaPlaneacionPagos(Border borderResaltar) {
		this.resaltarnumero_facturaPlaneacionPagos= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaPlaneacionPagos() {
		return this.mostrarnumero_facturaPlaneacionPagos;
	}

	public void setMostrarnumero_facturaPlaneacionPagos(Boolean mostrarnumero_facturaPlaneacionPagos) {
		this.mostrarnumero_facturaPlaneacionPagos= mostrarnumero_facturaPlaneacionPagos;
	}

	public Boolean getActivarnumero_facturaPlaneacionPagos() {
		return this.activarnumero_facturaPlaneacionPagos;
	}

	public void setActivarnumero_facturaPlaneacionPagos(Boolean activarnumero_facturaPlaneacionPagos) {
		this.activarnumero_facturaPlaneacionPagos= activarnumero_facturaPlaneacionPagos;
	}

	public Border setResaltarfecha_emisionPlaneacionPagos(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacionpagosBeanSwingJInternalFrame.jTtoolBarPlaneacionPagos.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionPlaneacionPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionPlaneacionPagos() {
		return this.resaltarfecha_emisionPlaneacionPagos;
	}

	public void setResaltarfecha_emisionPlaneacionPagos(Border borderResaltar) {
		this.resaltarfecha_emisionPlaneacionPagos= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionPlaneacionPagos() {
		return this.mostrarfecha_emisionPlaneacionPagos;
	}

	public void setMostrarfecha_emisionPlaneacionPagos(Boolean mostrarfecha_emisionPlaneacionPagos) {
		this.mostrarfecha_emisionPlaneacionPagos= mostrarfecha_emisionPlaneacionPagos;
	}

	public Boolean getActivarfecha_emisionPlaneacionPagos() {
		return this.activarfecha_emisionPlaneacionPagos;
	}

	public void setActivarfecha_emisionPlaneacionPagos(Boolean activarfecha_emisionPlaneacionPagos) {
		this.activarfecha_emisionPlaneacionPagos= activarfecha_emisionPlaneacionPagos;
	}

	public Border setResaltarfecha_ventaPlaneacionPagos(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacionpagosBeanSwingJInternalFrame.jTtoolBarPlaneacionPagos.setBorder(borderResaltar);
		
		this.resaltarfecha_ventaPlaneacionPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ventaPlaneacionPagos() {
		return this.resaltarfecha_ventaPlaneacionPagos;
	}

	public void setResaltarfecha_ventaPlaneacionPagos(Border borderResaltar) {
		this.resaltarfecha_ventaPlaneacionPagos= borderResaltar;
	}

	public Boolean getMostrarfecha_ventaPlaneacionPagos() {
		return this.mostrarfecha_ventaPlaneacionPagos;
	}

	public void setMostrarfecha_ventaPlaneacionPagos(Boolean mostrarfecha_ventaPlaneacionPagos) {
		this.mostrarfecha_ventaPlaneacionPagos= mostrarfecha_ventaPlaneacionPagos;
	}

	public Boolean getActivarfecha_ventaPlaneacionPagos() {
		return this.activarfecha_ventaPlaneacionPagos;
	}

	public void setActivarfecha_ventaPlaneacionPagos(Boolean activarfecha_ventaPlaneacionPagos) {
		this.activarfecha_ventaPlaneacionPagos= activarfecha_ventaPlaneacionPagos;
	}

	public Border setResaltarfecha_pagoPlaneacionPagos(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacionpagosBeanSwingJInternalFrame.jTtoolBarPlaneacionPagos.setBorder(borderResaltar);
		
		this.resaltarfecha_pagoPlaneacionPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_pagoPlaneacionPagos() {
		return this.resaltarfecha_pagoPlaneacionPagos;
	}

	public void setResaltarfecha_pagoPlaneacionPagos(Border borderResaltar) {
		this.resaltarfecha_pagoPlaneacionPagos= borderResaltar;
	}

	public Boolean getMostrarfecha_pagoPlaneacionPagos() {
		return this.mostrarfecha_pagoPlaneacionPagos;
	}

	public void setMostrarfecha_pagoPlaneacionPagos(Boolean mostrarfecha_pagoPlaneacionPagos) {
		this.mostrarfecha_pagoPlaneacionPagos= mostrarfecha_pagoPlaneacionPagos;
	}

	public Boolean getActivarfecha_pagoPlaneacionPagos() {
		return this.activarfecha_pagoPlaneacionPagos;
	}

	public void setActivarfecha_pagoPlaneacionPagos(Boolean activarfecha_pagoPlaneacionPagos) {
		this.activarfecha_pagoPlaneacionPagos= activarfecha_pagoPlaneacionPagos;
	}

	public Border setResaltarsaldoPlaneacionPagos(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacionpagosBeanSwingJInternalFrame.jTtoolBarPlaneacionPagos.setBorder(borderResaltar);
		
		this.resaltarsaldoPlaneacionPagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldoPlaneacionPagos() {
		return this.resaltarsaldoPlaneacionPagos;
	}

	public void setResaltarsaldoPlaneacionPagos(Border borderResaltar) {
		this.resaltarsaldoPlaneacionPagos= borderResaltar;
	}

	public Boolean getMostrarsaldoPlaneacionPagos() {
		return this.mostrarsaldoPlaneacionPagos;
	}

	public void setMostrarsaldoPlaneacionPagos(Boolean mostrarsaldoPlaneacionPagos) {
		this.mostrarsaldoPlaneacionPagos= mostrarsaldoPlaneacionPagos;
	}

	public Boolean getActivarsaldoPlaneacionPagos() {
		return this.activarsaldoPlaneacionPagos;
	}

	public void setActivarsaldoPlaneacionPagos(Boolean activarsaldoPlaneacionPagos) {
		this.activarsaldoPlaneacionPagos= activarsaldoPlaneacionPagos;
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
		
		
		this.setMostraridPlaneacionPagos(esInicial);
		this.setMostrarid_empresaPlaneacionPagos(esInicial);
		this.setMostrarid_grupo_clientePlaneacionPagos(esInicial);
		this.setMostrarfecha_pago_inicioPlaneacionPagos(esInicial);
		this.setMostrarfecha_pago_finPlaneacionPagos(esInicial);
		this.setMostrarid_facturaPlaneacionPagos(esInicial);
		this.setMostrarid_clientePlaneacionPagos(esInicial);
		this.setMostrarnombre_clientePlaneacionPagos(esInicial);
		this.setMostrarnumero_facturaPlaneacionPagos(esInicial);
		this.setMostrarfecha_emisionPlaneacionPagos(esInicial);
		this.setMostrarfecha_ventaPlaneacionPagos(esInicial);
		this.setMostrarfecha_pagoPlaneacionPagos(esInicial);
		this.setMostrarsaldoPlaneacionPagos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.ID)) {
				this.setMostraridPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setMostrarid_grupo_clientePlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.FECHAPAGOINICIO)) {
				this.setMostrarfecha_pago_inicioPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.FECHAPAGOFIN)) {
				this.setMostrarfecha_pago_finPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clientePlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clientePlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.FECHAVENTA)) {
				this.setMostrarfecha_ventaPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.FECHAPAGO)) {
				this.setMostrarfecha_pagoPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.SALDO)) {
				this.setMostrarsaldoPlaneacionPagos(esAsigna);
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
		
		
		this.setActivaridPlaneacionPagos(esInicial);
		this.setActivarid_empresaPlaneacionPagos(esInicial);
		this.setActivarid_grupo_clientePlaneacionPagos(esInicial);
		this.setActivarfecha_pago_inicioPlaneacionPagos(esInicial);
		this.setActivarfecha_pago_finPlaneacionPagos(esInicial);
		this.setActivarid_facturaPlaneacionPagos(esInicial);
		this.setActivarid_clientePlaneacionPagos(esInicial);
		this.setActivarnombre_clientePlaneacionPagos(esInicial);
		this.setActivarnumero_facturaPlaneacionPagos(esInicial);
		this.setActivarfecha_emisionPlaneacionPagos(esInicial);
		this.setActivarfecha_ventaPlaneacionPagos(esInicial);
		this.setActivarfecha_pagoPlaneacionPagos(esInicial);
		this.setActivarsaldoPlaneacionPagos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.ID)) {
				this.setActivaridPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setActivarid_grupo_clientePlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.FECHAPAGOINICIO)) {
				this.setActivarfecha_pago_inicioPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.FECHAPAGOFIN)) {
				this.setActivarfecha_pago_finPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clientePlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clientePlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.FECHAVENTA)) {
				this.setActivarfecha_ventaPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.FECHAPAGO)) {
				this.setActivarfecha_pagoPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.SALDO)) {
				this.setActivarsaldoPlaneacionPagos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPlaneacionPagos(esInicial);
		this.setResaltarid_empresaPlaneacionPagos(esInicial);
		this.setResaltarid_grupo_clientePlaneacionPagos(esInicial);
		this.setResaltarfecha_pago_inicioPlaneacionPagos(esInicial);
		this.setResaltarfecha_pago_finPlaneacionPagos(esInicial);
		this.setResaltarid_facturaPlaneacionPagos(esInicial);
		this.setResaltarid_clientePlaneacionPagos(esInicial);
		this.setResaltarnombre_clientePlaneacionPagos(esInicial);
		this.setResaltarnumero_facturaPlaneacionPagos(esInicial);
		this.setResaltarfecha_emisionPlaneacionPagos(esInicial);
		this.setResaltarfecha_ventaPlaneacionPagos(esInicial);
		this.setResaltarfecha_pagoPlaneacionPagos(esInicial);
		this.setResaltarsaldoPlaneacionPagos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.ID)) {
				this.setResaltaridPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setResaltarid_grupo_clientePlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.FECHAPAGOINICIO)) {
				this.setResaltarfecha_pago_inicioPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.FECHAPAGOFIN)) {
				this.setResaltarfecha_pago_finPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clientePlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clientePlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.FECHAVENTA)) {
				this.setResaltarfecha_ventaPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.FECHAPAGO)) {
				this.setResaltarfecha_pagoPlaneacionPagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionPagosConstantesFunciones.SALDO)) {
				this.setResaltarsaldoPlaneacionPagos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPlaneacionPagosPlaneacionPagos=true;

	public Boolean getMostrarBusquedaPlaneacionPagosPlaneacionPagos() {
		return this.mostrarBusquedaPlaneacionPagosPlaneacionPagos;
	}

	public void setMostrarBusquedaPlaneacionPagosPlaneacionPagos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPlaneacionPagosPlaneacionPagos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPlaneacionPagosPlaneacionPagos=true;

	public Boolean getActivarBusquedaPlaneacionPagosPlaneacionPagos() {
		return this.activarBusquedaPlaneacionPagosPlaneacionPagos;
	}

	public void setActivarBusquedaPlaneacionPagosPlaneacionPagos(Boolean habilitarResaltar) {
		this.activarBusquedaPlaneacionPagosPlaneacionPagos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPlaneacionPagosPlaneacionPagos=null;

	public Border getResaltarBusquedaPlaneacionPagosPlaneacionPagos() {
		return this.resaltarBusquedaPlaneacionPagosPlaneacionPagos;
	}

	public void setResaltarBusquedaPlaneacionPagosPlaneacionPagos(Border borderResaltar) {
		this.resaltarBusquedaPlaneacionPagosPlaneacionPagos= borderResaltar;
	}

	public void setResaltarBusquedaPlaneacionPagosPlaneacionPagos(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionPagosBeanSwingJInternalFrame planeacionpagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPlaneacionPagosPlaneacionPagos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}