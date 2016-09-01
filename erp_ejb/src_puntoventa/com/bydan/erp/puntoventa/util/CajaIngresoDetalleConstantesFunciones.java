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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.CajaIngresoDetalleConstantesFunciones;
import com.bydan.erp.puntoventa.util.CajaIngresoDetalleParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CajaIngresoDetalleParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CajaIngresoDetalleConstantesFunciones extends CajaIngresoDetalleConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CajaIngresoDetalle";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CajaIngresoDetalle"+CajaIngresoDetalleConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CajaIngresoDetalleHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CajaIngresoDetalleHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CajaIngresoDetalleConstantesFunciones.SCHEMA+"_"+CajaIngresoDetalleConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CajaIngresoDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CajaIngresoDetalleConstantesFunciones.SCHEMA+"_"+CajaIngresoDetalleConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CajaIngresoDetalleConstantesFunciones.SCHEMA+"_"+CajaIngresoDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CajaIngresoDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CajaIngresoDetalleConstantesFunciones.SCHEMA+"_"+CajaIngresoDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaIngresoDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajaIngresoDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaIngresoDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaIngresoDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajaIngresoDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaIngresoDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CajaIngresoDetalleConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CajaIngresoDetalleConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CajaIngresoDetalleConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CajaIngresoDetalleConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Caja Ingreso Detalles";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Caja Ingreso Detalle";
	public static final String SCLASSWEBTITULO_LOWER="Caja Ingreso Detalle";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CajaIngresoDetalle";
	public static final String OBJECTNAME="cajaingresodetalle";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="caja_ingreso_detalle";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cajaingresodetalle from "+CajaIngresoDetalleConstantesFunciones.SPERSISTENCENAME+" cajaingresodetalle";
	public static String QUERYSELECTNATIVE="select "+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".id,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".version_row,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".id_caja_ingreso,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".id_empresa,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".id_sucursal,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".id_cliente,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".id_factura,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".concepto,"+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME+".valor from "+CajaIngresoDetalleConstantesFunciones.SCHEMA+"."+CajaIngresoDetalleConstantesFunciones.TABLENAME;//+" as "+CajaIngresoDetalleConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CajaIngresoDetalleConstantesFuncionesAdditional cajaingresodetalleConstantesFuncionesAdditional=null;
	
	public CajaIngresoDetalleConstantesFuncionesAdditional getCajaIngresoDetalleConstantesFuncionesAdditional() {
		return this.cajaingresodetalleConstantesFuncionesAdditional;
	}
	
	public void setCajaIngresoDetalleConstantesFuncionesAdditional(CajaIngresoDetalleConstantesFuncionesAdditional cajaingresodetalleConstantesFuncionesAdditional) {
		try {
			this.cajaingresodetalleConstantesFuncionesAdditional=cajaingresodetalleConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCAJAINGRESO= "id_caja_ingreso";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDFACTURA= "id_factura";
    public static final String CONCEPTO= "concepto";
    public static final String VALOR= "valor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCAJAINGRESO= "Caja Ingreso";
		public static final String LABEL_IDCAJAINGRESO_LOWER= "Caja Ingreso";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_CONCEPTO= "Concepto";
		public static final String LABEL_CONCEPTO_LOWER= "Concepto";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
		
		
		
	public static final String SREGEXCONCEPTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCONCEPTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getCajaIngresoDetalleLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CajaIngresoDetalleConstantesFunciones.IDCAJAINGRESO)) {sLabelColumna=CajaIngresoDetalleConstantesFunciones.LABEL_IDCAJAINGRESO;}
		if(sNombreColumna.equals(CajaIngresoDetalleConstantesFunciones.IDEMPRESA)) {sLabelColumna=CajaIngresoDetalleConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CajaIngresoDetalleConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CajaIngresoDetalleConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CajaIngresoDetalleConstantesFunciones.IDCLIENTE)) {sLabelColumna=CajaIngresoDetalleConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(CajaIngresoDetalleConstantesFunciones.IDFACTURA)) {sLabelColumna=CajaIngresoDetalleConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(CajaIngresoDetalleConstantesFunciones.CONCEPTO)) {sLabelColumna=CajaIngresoDetalleConstantesFunciones.LABEL_CONCEPTO;}
		if(sNombreColumna.equals(CajaIngresoDetalleConstantesFunciones.VALOR)) {sLabelColumna=CajaIngresoDetalleConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getCajaIngresoDetalleDescripcion(CajaIngresoDetalle cajaingresodetalle) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cajaingresodetalle !=null/* && cajaingresodetalle.getId()!=0*/) {
			if(cajaingresodetalle.getId()!=null) {
				sDescripcion=cajaingresodetalle.getId().toString();
			}//cajaingresodetallecajaingresodetalle.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCajaIngresoDetalleDescripcionDetallado(CajaIngresoDetalle cajaingresodetalle) {
		String sDescripcion="";
			
		sDescripcion+=CajaIngresoDetalleConstantesFunciones.ID+"=";
		sDescripcion+=cajaingresodetalle.getId().toString()+",";
		sDescripcion+=CajaIngresoDetalleConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cajaingresodetalle.getVersionRow().toString()+",";
		sDescripcion+=CajaIngresoDetalleConstantesFunciones.IDCAJAINGRESO+"=";
		sDescripcion+=cajaingresodetalle.getid_caja_ingreso().toString()+",";
		sDescripcion+=CajaIngresoDetalleConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cajaingresodetalle.getid_empresa().toString()+",";
		sDescripcion+=CajaIngresoDetalleConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cajaingresodetalle.getid_sucursal().toString()+",";
		sDescripcion+=CajaIngresoDetalleConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=cajaingresodetalle.getid_cliente().toString()+",";
		sDescripcion+=CajaIngresoDetalleConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=cajaingresodetalle.getid_factura().toString()+",";
		sDescripcion+=CajaIngresoDetalleConstantesFunciones.CONCEPTO+"=";
		sDescripcion+=cajaingresodetalle.getconcepto()+",";
		sDescripcion+=CajaIngresoDetalleConstantesFunciones.VALOR+"=";
		sDescripcion+=cajaingresodetalle.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCajaIngresoDetalleDescripcion(CajaIngresoDetalle cajaingresodetalle,String sValor) throws Exception {			
		if(cajaingresodetalle !=null) {
			//cajaingresodetallecajaingresodetalle.getId().toString();
		}		
	}
	
		

	public static String getCajaIngresoDescripcion(CajaIngreso cajaingreso) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cajaingreso!=null/*&&cajaingreso.getId()>0*/) {
			sDescripcion=CajaIngresoConstantesFunciones.getCajaIngresoDescripcion(cajaingreso);
		}

		return sDescripcion;
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCajaIngreso")) {
			sNombreIndice="Tipo=  Por Caja Ingreso";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCajaIngreso(Long id_caja_ingreso) {
		String sDetalleIndice=" Parametros->";
		if(id_caja_ingreso!=null) {sDetalleIndice+=" Codigo Unico De Caja Ingreso="+id_caja_ingreso.toString();} 

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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCajaIngresoDetalle(CajaIngresoDetalle cajaingresodetalle,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cajaingresodetalle.setconcepto(cajaingresodetalle.getconcepto().trim());
	}
	
	public static void quitarEspaciosCajaIngresoDetalles(List<CajaIngresoDetalle> cajaingresodetalles,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CajaIngresoDetalle cajaingresodetalle: cajaingresodetalles) {
			cajaingresodetalle.setconcepto(cajaingresodetalle.getconcepto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajaIngresoDetalle(CajaIngresoDetalle cajaingresodetalle,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cajaingresodetalle.getConCambioAuxiliar()) {
			cajaingresodetalle.setIsDeleted(cajaingresodetalle.getIsDeletedAuxiliar());	
			cajaingresodetalle.setIsNew(cajaingresodetalle.getIsNewAuxiliar());	
			cajaingresodetalle.setIsChanged(cajaingresodetalle.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cajaingresodetalle.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cajaingresodetalle.setIsDeletedAuxiliar(false);	
			cajaingresodetalle.setIsNewAuxiliar(false);	
			cajaingresodetalle.setIsChangedAuxiliar(false);
			
			cajaingresodetalle.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajaIngresoDetalles(List<CajaIngresoDetalle> cajaingresodetalles,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CajaIngresoDetalle cajaingresodetalle : cajaingresodetalles) {
			if(conAsignarBase && cajaingresodetalle.getConCambioAuxiliar()) {
				cajaingresodetalle.setIsDeleted(cajaingresodetalle.getIsDeletedAuxiliar());	
				cajaingresodetalle.setIsNew(cajaingresodetalle.getIsNewAuxiliar());	
				cajaingresodetalle.setIsChanged(cajaingresodetalle.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cajaingresodetalle.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cajaingresodetalle.setIsDeletedAuxiliar(false);	
				cajaingresodetalle.setIsNewAuxiliar(false);	
				cajaingresodetalle.setIsChangedAuxiliar(false);
				
				cajaingresodetalle.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCajaIngresoDetalle(CajaIngresoDetalle cajaingresodetalle,Boolean conEnteros) throws Exception  {
		cajaingresodetalle.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCajaIngresoDetalles(List<CajaIngresoDetalle> cajaingresodetalles,Boolean conEnteros) throws Exception  {
		
		for(CajaIngresoDetalle cajaingresodetalle: cajaingresodetalles) {
			cajaingresodetalle.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCajaIngresoDetalle(List<CajaIngresoDetalle> cajaingresodetalles,CajaIngresoDetalle cajaingresodetalleAux) throws Exception  {
		CajaIngresoDetalleConstantesFunciones.InicializarValoresCajaIngresoDetalle(cajaingresodetalleAux,true);
		
		for(CajaIngresoDetalle cajaingresodetalle: cajaingresodetalles) {
			if(cajaingresodetalle.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cajaingresodetalleAux.setvalor(cajaingresodetalleAux.getvalor()+cajaingresodetalle.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaIngresoDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CajaIngresoDetalleConstantesFunciones.getArrayColumnasGlobalesCajaIngresoDetalle(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaIngresoDetalle(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaIngresoDetalleConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaIngresoDetalleConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaIngresoDetalleConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaIngresoDetalleConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCajaIngresoDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CajaIngresoDetalle> cajaingresodetalles,CajaIngresoDetalle cajaingresodetalle,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CajaIngresoDetalle cajaingresodetalleAux: cajaingresodetalles) {
			if(cajaingresodetalleAux!=null && cajaingresodetalle!=null) {
				if((cajaingresodetalleAux.getId()==null && cajaingresodetalle.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cajaingresodetalleAux.getId()!=null && cajaingresodetalle.getId()!=null){
					if(cajaingresodetalleAux.getId().equals(cajaingresodetalle.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCajaIngresoDetalle(List<CajaIngresoDetalle> cajaingresodetalles) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(CajaIngresoDetalle cajaingresodetalle: cajaingresodetalles) {			
			if(cajaingresodetalle.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=cajaingresodetalle.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaIngresoDetalleConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(CajaIngresoDetalleConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCajaIngresoDetalle() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CajaIngresoDetalleConstantesFunciones.LABEL_ID, CajaIngresoDetalleConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoDetalleConstantesFunciones.LABEL_VERSIONROW, CajaIngresoDetalleConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoDetalleConstantesFunciones.LABEL_IDCAJAINGRESO, CajaIngresoDetalleConstantesFunciones.IDCAJAINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoDetalleConstantesFunciones.LABEL_IDEMPRESA, CajaIngresoDetalleConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoDetalleConstantesFunciones.LABEL_IDSUCURSAL, CajaIngresoDetalleConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoDetalleConstantesFunciones.LABEL_IDCLIENTE, CajaIngresoDetalleConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoDetalleConstantesFunciones.LABEL_IDFACTURA, CajaIngresoDetalleConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoDetalleConstantesFunciones.LABEL_CONCEPTO, CajaIngresoDetalleConstantesFunciones.CONCEPTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoDetalleConstantesFunciones.LABEL_VALOR, CajaIngresoDetalleConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCajaIngresoDetalle() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoDetalleConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoDetalleConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoDetalleConstantesFunciones.IDCAJAINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoDetalleConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoDetalleConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoDetalleConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoDetalleConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoDetalleConstantesFunciones.CONCEPTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoDetalleConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaIngresoDetalle() throws Exception  {
		return CajaIngresoDetalleConstantesFunciones.getTiposSeleccionarCajaIngresoDetalle(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaIngresoDetalle(Boolean conFk) throws Exception  {
		return CajaIngresoDetalleConstantesFunciones.getTiposSeleccionarCajaIngresoDetalle(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaIngresoDetalle(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaIngresoDetalleConstantesFunciones.LABEL_IDCAJAINGRESO);
			reporte.setsDescripcion(CajaIngresoDetalleConstantesFunciones.LABEL_IDCAJAINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaIngresoDetalleConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CajaIngresoDetalleConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaIngresoDetalleConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CajaIngresoDetalleConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaIngresoDetalleConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(CajaIngresoDetalleConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaIngresoDetalleConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(CajaIngresoDetalleConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaIngresoDetalleConstantesFunciones.LABEL_CONCEPTO);
			reporte.setsDescripcion(CajaIngresoDetalleConstantesFunciones.LABEL_CONCEPTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaIngresoDetalleConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(CajaIngresoDetalleConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCajaIngresoDetalle(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCajaIngresoDetalle(CajaIngresoDetalle cajaingresodetalleAux) throws Exception {
		
			cajaingresodetalleAux.setcajaingreso_descripcion(CajaIngresoConstantesFunciones.getCajaIngresoDescripcion(cajaingresodetalleAux.getCajaIngreso()));
			cajaingresodetalleAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajaingresodetalleAux.getEmpresa()));
			cajaingresodetalleAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cajaingresodetalleAux.getSucursal()));
			cajaingresodetalleAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(cajaingresodetalleAux.getCliente()));
			cajaingresodetalleAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(cajaingresodetalleAux.getFactura()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCajaIngresoDetalle(List<CajaIngresoDetalle> cajaingresodetallesTemp) throws Exception {
		for(CajaIngresoDetalle cajaingresodetalleAux:cajaingresodetallesTemp) {
			
			cajaingresodetalleAux.setcajaingreso_descripcion(CajaIngresoConstantesFunciones.getCajaIngresoDescripcion(cajaingresodetalleAux.getCajaIngreso()));
			cajaingresodetalleAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajaingresodetalleAux.getEmpresa()));
			cajaingresodetalleAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cajaingresodetalleAux.getSucursal()));
			cajaingresodetalleAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(cajaingresodetalleAux.getCliente()));
			cajaingresodetalleAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(cajaingresodetalleAux.getFactura()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCajaIngresoDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CajaIngreso.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Factura.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CajaIngreso.class)) {
						classes.add(new Classe(CajaIngreso.class));
					}
				}

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
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCajaIngresoDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CajaIngreso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaIngreso.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CajaIngreso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaIngreso.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaIngresoDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajaIngresoDetalleConstantesFunciones.getClassesRelationshipsOfCajaIngresoDetalle(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaIngresoDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajaIngresoDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajaIngresoDetalleConstantesFunciones.getClassesRelationshipsFromStringsOfCajaIngresoDetalle(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajaIngresoDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CajaIngresoDetalle cajaingresodetalle,List<CajaIngresoDetalle> cajaingresodetalles,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CajaIngresoDetalle cajaingresodetalleEncontrado=null;
			
			for(CajaIngresoDetalle cajaingresodetalleLocal:cajaingresodetalles) {
				if(cajaingresodetalleLocal.getId().equals(cajaingresodetalle.getId())) {
					cajaingresodetalleEncontrado=cajaingresodetalleLocal;
					
					cajaingresodetalleLocal.setIsChanged(cajaingresodetalle.getIsChanged());
					cajaingresodetalleLocal.setIsNew(cajaingresodetalle.getIsNew());
					cajaingresodetalleLocal.setIsDeleted(cajaingresodetalle.getIsDeleted());
					
					cajaingresodetalleLocal.setGeneralEntityOriginal(cajaingresodetalle.getGeneralEntityOriginal());
					
					cajaingresodetalleLocal.setId(cajaingresodetalle.getId());	
					cajaingresodetalleLocal.setVersionRow(cajaingresodetalle.getVersionRow());	
					cajaingresodetalleLocal.setid_caja_ingreso(cajaingresodetalle.getid_caja_ingreso());	
					cajaingresodetalleLocal.setid_empresa(cajaingresodetalle.getid_empresa());	
					cajaingresodetalleLocal.setid_sucursal(cajaingresodetalle.getid_sucursal());	
					cajaingresodetalleLocal.setid_cliente(cajaingresodetalle.getid_cliente());	
					cajaingresodetalleLocal.setid_factura(cajaingresodetalle.getid_factura());	
					cajaingresodetalleLocal.setconcepto(cajaingresodetalle.getconcepto());	
					cajaingresodetalleLocal.setvalor(cajaingresodetalle.getvalor());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cajaingresodetalle.getIsDeleted()) {
				if(!existe) {
					cajaingresodetalles.add(cajaingresodetalle);
				}
			} else {
				if(cajaingresodetalleEncontrado!=null && permiteQuitar)  {
					cajaingresodetalles.remove(cajaingresodetalleEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CajaIngresoDetalle cajaingresodetalle,List<CajaIngresoDetalle> cajaingresodetalles) throws Exception {
		try	{			
			for(CajaIngresoDetalle cajaingresodetalleLocal:cajaingresodetalles) {
				if(cajaingresodetalleLocal.getId().equals(cajaingresodetalle.getId())) {
					cajaingresodetalleLocal.setIsSelected(cajaingresodetalle.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCajaIngresoDetalle(List<CajaIngresoDetalle> cajaingresodetallesAux) throws Exception {
		//this.cajaingresodetallesAux=cajaingresodetallesAux;
		
		for(CajaIngresoDetalle cajaingresodetalleAux:cajaingresodetallesAux) {
			if(cajaingresodetalleAux.getIsChanged()) {
				cajaingresodetalleAux.setIsChanged(false);
			}		
			
			if(cajaingresodetalleAux.getIsNew()) {
				cajaingresodetalleAux.setIsNew(false);
			}	
			
			if(cajaingresodetalleAux.getIsDeleted()) {
				cajaingresodetalleAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCajaIngresoDetalle(CajaIngresoDetalle cajaingresodetalleAux) throws Exception {
		//this.cajaingresodetalleAux=cajaingresodetalleAux;
		
			if(cajaingresodetalleAux.getIsChanged()) {
				cajaingresodetalleAux.setIsChanged(false);
			}		
			
			if(cajaingresodetalleAux.getIsNew()) {
				cajaingresodetalleAux.setIsNew(false);
			}	
			
			if(cajaingresodetalleAux.getIsDeleted()) {
				cajaingresodetalleAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CajaIngresoDetalle cajaingresodetalleAsignar,CajaIngresoDetalle cajaingresodetalle) throws Exception {
		cajaingresodetalleAsignar.setId(cajaingresodetalle.getId());	
		cajaingresodetalleAsignar.setVersionRow(cajaingresodetalle.getVersionRow());	
		cajaingresodetalleAsignar.setid_caja_ingreso(cajaingresodetalle.getid_caja_ingreso());
		cajaingresodetalleAsignar.setcajaingreso_descripcion(cajaingresodetalle.getcajaingreso_descripcion());	
		cajaingresodetalleAsignar.setid_empresa(cajaingresodetalle.getid_empresa());
		cajaingresodetalleAsignar.setempresa_descripcion(cajaingresodetalle.getempresa_descripcion());	
		cajaingresodetalleAsignar.setid_sucursal(cajaingresodetalle.getid_sucursal());
		cajaingresodetalleAsignar.setsucursal_descripcion(cajaingresodetalle.getsucursal_descripcion());	
		cajaingresodetalleAsignar.setid_cliente(cajaingresodetalle.getid_cliente());
		cajaingresodetalleAsignar.setcliente_descripcion(cajaingresodetalle.getcliente_descripcion());	
		cajaingresodetalleAsignar.setid_factura(cajaingresodetalle.getid_factura());
		cajaingresodetalleAsignar.setfactura_descripcion(cajaingresodetalle.getfactura_descripcion());	
		cajaingresodetalleAsignar.setconcepto(cajaingresodetalle.getconcepto());	
		cajaingresodetalleAsignar.setvalor(cajaingresodetalle.getvalor());	
	}
	
	public static void inicializarCajaIngresoDetalle(CajaIngresoDetalle cajaingresodetalle) throws Exception {
		try {
				cajaingresodetalle.setId(0L);	
					
				cajaingresodetalle.setid_caja_ingreso(-1L);	
				cajaingresodetalle.setid_empresa(-1L);	
				cajaingresodetalle.setid_sucursal(-1L);	
				cajaingresodetalle.setid_cliente(-1L);	
				cajaingresodetalle.setid_factura(-1L);	
				cajaingresodetalle.setconcepto("");	
				cajaingresodetalle.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCajaIngresoDetalle(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaIngresoDetalleConstantesFunciones.LABEL_IDCAJAINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaIngresoDetalleConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaIngresoDetalleConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaIngresoDetalleConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaIngresoDetalleConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaIngresoDetalleConstantesFunciones.LABEL_CONCEPTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaIngresoDetalleConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCajaIngresoDetalle(String sTipo,Row row,Workbook workbook,CajaIngresoDetalle cajaingresodetalle,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaingresodetalle.getcajaingreso_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaingresodetalle.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaingresodetalle.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaingresodetalle.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaingresodetalle.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaingresodetalle.getconcepto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaingresodetalle.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCajaIngresoDetalle=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCajaIngresoDetalle() {
		return this.sFinalQueryCajaIngresoDetalle;
	}
	
	public void setsFinalQueryCajaIngresoDetalle(String sFinalQueryCajaIngresoDetalle) {
		this.sFinalQueryCajaIngresoDetalle= sFinalQueryCajaIngresoDetalle;
	}
	
	public Border resaltarSeleccionarCajaIngresoDetalle=null;
	
	public Border setResaltarSeleccionarCajaIngresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoDetalleBeanSwingJInternalFrame cajaingresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cajaingresodetalleBeanSwingJInternalFrame.jTtoolBarCajaIngresoDetalle.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCajaIngresoDetalle= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCajaIngresoDetalle() {
		return this.resaltarSeleccionarCajaIngresoDetalle;
	}
	
	public void setResaltarSeleccionarCajaIngresoDetalle(Border borderResaltarSeleccionarCajaIngresoDetalle) {
		this.resaltarSeleccionarCajaIngresoDetalle= borderResaltarSeleccionarCajaIngresoDetalle;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCajaIngresoDetalle=null;
	public Boolean mostraridCajaIngresoDetalle=true;
	public Boolean activaridCajaIngresoDetalle=true;

	public Border resaltarid_caja_ingresoCajaIngresoDetalle=null;
	public Boolean mostrarid_caja_ingresoCajaIngresoDetalle=true;
	public Boolean activarid_caja_ingresoCajaIngresoDetalle=true;
	public Boolean cargarid_caja_ingresoCajaIngresoDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_caja_ingresoCajaIngresoDetalle=false;//ConEventDepend=true

	public Border resaltarid_empresaCajaIngresoDetalle=null;
	public Boolean mostrarid_empresaCajaIngresoDetalle=true;
	public Boolean activarid_empresaCajaIngresoDetalle=true;
	public Boolean cargarid_empresaCajaIngresoDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCajaIngresoDetalle=false;//ConEventDepend=true

	public Border resaltarid_sucursalCajaIngresoDetalle=null;
	public Boolean mostrarid_sucursalCajaIngresoDetalle=true;
	public Boolean activarid_sucursalCajaIngresoDetalle=true;
	public Boolean cargarid_sucursalCajaIngresoDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCajaIngresoDetalle=false;//ConEventDepend=true

	public Border resaltarid_clienteCajaIngresoDetalle=null;
	public Boolean mostrarid_clienteCajaIngresoDetalle=true;
	public Boolean activarid_clienteCajaIngresoDetalle=true;
	public Boolean cargarid_clienteCajaIngresoDetalle=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteCajaIngresoDetalle=false;//ConEventDepend=true

	public Border resaltarid_facturaCajaIngresoDetalle=null;
	public Boolean mostrarid_facturaCajaIngresoDetalle=true;
	public Boolean activarid_facturaCajaIngresoDetalle=true;
	public Boolean cargarid_facturaCajaIngresoDetalle=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaCajaIngresoDetalle=false;//ConEventDepend=true

	public Border resaltarconceptoCajaIngresoDetalle=null;
	public Boolean mostrarconceptoCajaIngresoDetalle=true;
	public Boolean activarconceptoCajaIngresoDetalle=true;

	public Border resaltarvalorCajaIngresoDetalle=null;
	public Boolean mostrarvalorCajaIngresoDetalle=true;
	public Boolean activarvalorCajaIngresoDetalle=true;

	
	

	public Border setResaltaridCajaIngresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoDetalleBeanSwingJInternalFrame cajaingresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresodetalleBeanSwingJInternalFrame.jTtoolBarCajaIngresoDetalle.setBorder(borderResaltar);
		
		this.resaltaridCajaIngresoDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCajaIngresoDetalle() {
		return this.resaltaridCajaIngresoDetalle;
	}

	public void setResaltaridCajaIngresoDetalle(Border borderResaltar) {
		this.resaltaridCajaIngresoDetalle= borderResaltar;
	}

	public Boolean getMostraridCajaIngresoDetalle() {
		return this.mostraridCajaIngresoDetalle;
	}

	public void setMostraridCajaIngresoDetalle(Boolean mostraridCajaIngresoDetalle) {
		this.mostraridCajaIngresoDetalle= mostraridCajaIngresoDetalle;
	}

	public Boolean getActivaridCajaIngresoDetalle() {
		return this.activaridCajaIngresoDetalle;
	}

	public void setActivaridCajaIngresoDetalle(Boolean activaridCajaIngresoDetalle) {
		this.activaridCajaIngresoDetalle= activaridCajaIngresoDetalle;
	}

	public Border setResaltarid_caja_ingresoCajaIngresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoDetalleBeanSwingJInternalFrame cajaingresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresodetalleBeanSwingJInternalFrame.jTtoolBarCajaIngresoDetalle.setBorder(borderResaltar);
		
		this.resaltarid_caja_ingresoCajaIngresoDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_caja_ingresoCajaIngresoDetalle() {
		return this.resaltarid_caja_ingresoCajaIngresoDetalle;
	}

	public void setResaltarid_caja_ingresoCajaIngresoDetalle(Border borderResaltar) {
		this.resaltarid_caja_ingresoCajaIngresoDetalle= borderResaltar;
	}

	public Boolean getMostrarid_caja_ingresoCajaIngresoDetalle() {
		return this.mostrarid_caja_ingresoCajaIngresoDetalle;
	}

	public void setMostrarid_caja_ingresoCajaIngresoDetalle(Boolean mostrarid_caja_ingresoCajaIngresoDetalle) {
		this.mostrarid_caja_ingresoCajaIngresoDetalle= mostrarid_caja_ingresoCajaIngresoDetalle;
	}

	public Boolean getActivarid_caja_ingresoCajaIngresoDetalle() {
		return this.activarid_caja_ingresoCajaIngresoDetalle;
	}

	public void setActivarid_caja_ingresoCajaIngresoDetalle(Boolean activarid_caja_ingresoCajaIngresoDetalle) {
		this.activarid_caja_ingresoCajaIngresoDetalle= activarid_caja_ingresoCajaIngresoDetalle;
	}

	public Boolean getCargarid_caja_ingresoCajaIngresoDetalle() {
		return this.cargarid_caja_ingresoCajaIngresoDetalle;
	}

	public void setCargarid_caja_ingresoCajaIngresoDetalle(Boolean cargarid_caja_ingresoCajaIngresoDetalle) {
		this.cargarid_caja_ingresoCajaIngresoDetalle= cargarid_caja_ingresoCajaIngresoDetalle;
	}

	public Border setResaltarid_empresaCajaIngresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoDetalleBeanSwingJInternalFrame cajaingresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresodetalleBeanSwingJInternalFrame.jTtoolBarCajaIngresoDetalle.setBorder(borderResaltar);
		
		this.resaltarid_empresaCajaIngresoDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCajaIngresoDetalle() {
		return this.resaltarid_empresaCajaIngresoDetalle;
	}

	public void setResaltarid_empresaCajaIngresoDetalle(Border borderResaltar) {
		this.resaltarid_empresaCajaIngresoDetalle= borderResaltar;
	}

	public Boolean getMostrarid_empresaCajaIngresoDetalle() {
		return this.mostrarid_empresaCajaIngresoDetalle;
	}

	public void setMostrarid_empresaCajaIngresoDetalle(Boolean mostrarid_empresaCajaIngresoDetalle) {
		this.mostrarid_empresaCajaIngresoDetalle= mostrarid_empresaCajaIngresoDetalle;
	}

	public Boolean getActivarid_empresaCajaIngresoDetalle() {
		return this.activarid_empresaCajaIngresoDetalle;
	}

	public void setActivarid_empresaCajaIngresoDetalle(Boolean activarid_empresaCajaIngresoDetalle) {
		this.activarid_empresaCajaIngresoDetalle= activarid_empresaCajaIngresoDetalle;
	}

	public Boolean getCargarid_empresaCajaIngresoDetalle() {
		return this.cargarid_empresaCajaIngresoDetalle;
	}

	public void setCargarid_empresaCajaIngresoDetalle(Boolean cargarid_empresaCajaIngresoDetalle) {
		this.cargarid_empresaCajaIngresoDetalle= cargarid_empresaCajaIngresoDetalle;
	}

	public Border setResaltarid_sucursalCajaIngresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoDetalleBeanSwingJInternalFrame cajaingresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresodetalleBeanSwingJInternalFrame.jTtoolBarCajaIngresoDetalle.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCajaIngresoDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCajaIngresoDetalle() {
		return this.resaltarid_sucursalCajaIngresoDetalle;
	}

	public void setResaltarid_sucursalCajaIngresoDetalle(Border borderResaltar) {
		this.resaltarid_sucursalCajaIngresoDetalle= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCajaIngresoDetalle() {
		return this.mostrarid_sucursalCajaIngresoDetalle;
	}

	public void setMostrarid_sucursalCajaIngresoDetalle(Boolean mostrarid_sucursalCajaIngresoDetalle) {
		this.mostrarid_sucursalCajaIngresoDetalle= mostrarid_sucursalCajaIngresoDetalle;
	}

	public Boolean getActivarid_sucursalCajaIngresoDetalle() {
		return this.activarid_sucursalCajaIngresoDetalle;
	}

	public void setActivarid_sucursalCajaIngresoDetalle(Boolean activarid_sucursalCajaIngresoDetalle) {
		this.activarid_sucursalCajaIngresoDetalle= activarid_sucursalCajaIngresoDetalle;
	}

	public Boolean getCargarid_sucursalCajaIngresoDetalle() {
		return this.cargarid_sucursalCajaIngresoDetalle;
	}

	public void setCargarid_sucursalCajaIngresoDetalle(Boolean cargarid_sucursalCajaIngresoDetalle) {
		this.cargarid_sucursalCajaIngresoDetalle= cargarid_sucursalCajaIngresoDetalle;
	}

	public Border setResaltarid_clienteCajaIngresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoDetalleBeanSwingJInternalFrame cajaingresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresodetalleBeanSwingJInternalFrame.jTtoolBarCajaIngresoDetalle.setBorder(borderResaltar);
		
		this.resaltarid_clienteCajaIngresoDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteCajaIngresoDetalle() {
		return this.resaltarid_clienteCajaIngresoDetalle;
	}

	public void setResaltarid_clienteCajaIngresoDetalle(Border borderResaltar) {
		this.resaltarid_clienteCajaIngresoDetalle= borderResaltar;
	}

	public Boolean getMostrarid_clienteCajaIngresoDetalle() {
		return this.mostrarid_clienteCajaIngresoDetalle;
	}

	public void setMostrarid_clienteCajaIngresoDetalle(Boolean mostrarid_clienteCajaIngresoDetalle) {
		this.mostrarid_clienteCajaIngresoDetalle= mostrarid_clienteCajaIngresoDetalle;
	}

	public Boolean getActivarid_clienteCajaIngresoDetalle() {
		return this.activarid_clienteCajaIngresoDetalle;
	}

	public void setActivarid_clienteCajaIngresoDetalle(Boolean activarid_clienteCajaIngresoDetalle) {
		this.activarid_clienteCajaIngresoDetalle= activarid_clienteCajaIngresoDetalle;
	}

	public Boolean getCargarid_clienteCajaIngresoDetalle() {
		return this.cargarid_clienteCajaIngresoDetalle;
	}

	public void setCargarid_clienteCajaIngresoDetalle(Boolean cargarid_clienteCajaIngresoDetalle) {
		this.cargarid_clienteCajaIngresoDetalle= cargarid_clienteCajaIngresoDetalle;
	}

	public Border setResaltarid_facturaCajaIngresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoDetalleBeanSwingJInternalFrame cajaingresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresodetalleBeanSwingJInternalFrame.jTtoolBarCajaIngresoDetalle.setBorder(borderResaltar);
		
		this.resaltarid_facturaCajaIngresoDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaCajaIngresoDetalle() {
		return this.resaltarid_facturaCajaIngresoDetalle;
	}

	public void setResaltarid_facturaCajaIngresoDetalle(Border borderResaltar) {
		this.resaltarid_facturaCajaIngresoDetalle= borderResaltar;
	}

	public Boolean getMostrarid_facturaCajaIngresoDetalle() {
		return this.mostrarid_facturaCajaIngresoDetalle;
	}

	public void setMostrarid_facturaCajaIngresoDetalle(Boolean mostrarid_facturaCajaIngresoDetalle) {
		this.mostrarid_facturaCajaIngresoDetalle= mostrarid_facturaCajaIngresoDetalle;
	}

	public Boolean getActivarid_facturaCajaIngresoDetalle() {
		return this.activarid_facturaCajaIngresoDetalle;
	}

	public void setActivarid_facturaCajaIngresoDetalle(Boolean activarid_facturaCajaIngresoDetalle) {
		this.activarid_facturaCajaIngresoDetalle= activarid_facturaCajaIngresoDetalle;
	}

	public Boolean getCargarid_facturaCajaIngresoDetalle() {
		return this.cargarid_facturaCajaIngresoDetalle;
	}

	public void setCargarid_facturaCajaIngresoDetalle(Boolean cargarid_facturaCajaIngresoDetalle) {
		this.cargarid_facturaCajaIngresoDetalle= cargarid_facturaCajaIngresoDetalle;
	}

	public Border setResaltarconceptoCajaIngresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoDetalleBeanSwingJInternalFrame cajaingresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresodetalleBeanSwingJInternalFrame.jTtoolBarCajaIngresoDetalle.setBorder(borderResaltar);
		
		this.resaltarconceptoCajaIngresoDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarconceptoCajaIngresoDetalle() {
		return this.resaltarconceptoCajaIngresoDetalle;
	}

	public void setResaltarconceptoCajaIngresoDetalle(Border borderResaltar) {
		this.resaltarconceptoCajaIngresoDetalle= borderResaltar;
	}

	public Boolean getMostrarconceptoCajaIngresoDetalle() {
		return this.mostrarconceptoCajaIngresoDetalle;
	}

	public void setMostrarconceptoCajaIngresoDetalle(Boolean mostrarconceptoCajaIngresoDetalle) {
		this.mostrarconceptoCajaIngresoDetalle= mostrarconceptoCajaIngresoDetalle;
	}

	public Boolean getActivarconceptoCajaIngresoDetalle() {
		return this.activarconceptoCajaIngresoDetalle;
	}

	public void setActivarconceptoCajaIngresoDetalle(Boolean activarconceptoCajaIngresoDetalle) {
		this.activarconceptoCajaIngresoDetalle= activarconceptoCajaIngresoDetalle;
	}

	public Border setResaltarvalorCajaIngresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoDetalleBeanSwingJInternalFrame cajaingresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresodetalleBeanSwingJInternalFrame.jTtoolBarCajaIngresoDetalle.setBorder(borderResaltar);
		
		this.resaltarvalorCajaIngresoDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorCajaIngresoDetalle() {
		return this.resaltarvalorCajaIngresoDetalle;
	}

	public void setResaltarvalorCajaIngresoDetalle(Border borderResaltar) {
		this.resaltarvalorCajaIngresoDetalle= borderResaltar;
	}

	public Boolean getMostrarvalorCajaIngresoDetalle() {
		return this.mostrarvalorCajaIngresoDetalle;
	}

	public void setMostrarvalorCajaIngresoDetalle(Boolean mostrarvalorCajaIngresoDetalle) {
		this.mostrarvalorCajaIngresoDetalle= mostrarvalorCajaIngresoDetalle;
	}

	public Boolean getActivarvalorCajaIngresoDetalle() {
		return this.activarvalorCajaIngresoDetalle;
	}

	public void setActivarvalorCajaIngresoDetalle(Boolean activarvalorCajaIngresoDetalle) {
		this.activarvalorCajaIngresoDetalle= activarvalorCajaIngresoDetalle;
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
		
		
		this.setMostraridCajaIngresoDetalle(esInicial);
		this.setMostrarid_caja_ingresoCajaIngresoDetalle(esInicial);
		this.setMostrarid_empresaCajaIngresoDetalle(esInicial);
		this.setMostrarid_sucursalCajaIngresoDetalle(esInicial);
		this.setMostrarid_clienteCajaIngresoDetalle(esInicial);
		this.setMostrarid_facturaCajaIngresoDetalle(esInicial);
		this.setMostrarconceptoCajaIngresoDetalle(esInicial);
		this.setMostrarvalorCajaIngresoDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.ID)) {
				this.setMostraridCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.IDCAJAINGRESO)) {
				this.setMostrarid_caja_ingresoCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.CONCEPTO)) {
				this.setMostrarconceptoCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.VALOR)) {
				this.setMostrarvalorCajaIngresoDetalle(esAsigna);
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
		
		
		this.setActivaridCajaIngresoDetalle(esInicial);
		this.setActivarid_caja_ingresoCajaIngresoDetalle(esInicial);
		this.setActivarid_empresaCajaIngresoDetalle(esInicial);
		this.setActivarid_sucursalCajaIngresoDetalle(esInicial);
		this.setActivarid_clienteCajaIngresoDetalle(esInicial);
		this.setActivarid_facturaCajaIngresoDetalle(esInicial);
		this.setActivarconceptoCajaIngresoDetalle(esInicial);
		this.setActivarvalorCajaIngresoDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.ID)) {
				this.setActivaridCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.IDCAJAINGRESO)) {
				this.setActivarid_caja_ingresoCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.CONCEPTO)) {
				this.setActivarconceptoCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.VALOR)) {
				this.setActivarvalorCajaIngresoDetalle(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CajaIngresoDetalleBeanSwingJInternalFrame cajaingresodetalleBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCajaIngresoDetalle(esInicial);
		this.setResaltarid_caja_ingresoCajaIngresoDetalle(esInicial);
		this.setResaltarid_empresaCajaIngresoDetalle(esInicial);
		this.setResaltarid_sucursalCajaIngresoDetalle(esInicial);
		this.setResaltarid_clienteCajaIngresoDetalle(esInicial);
		this.setResaltarid_facturaCajaIngresoDetalle(esInicial);
		this.setResaltarconceptoCajaIngresoDetalle(esInicial);
		this.setResaltarvalorCajaIngresoDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.ID)) {
				this.setResaltaridCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.IDCAJAINGRESO)) {
				this.setResaltarid_caja_ingresoCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.CONCEPTO)) {
				this.setResaltarconceptoCajaIngresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoDetalleConstantesFunciones.VALOR)) {
				this.setResaltarvalorCajaIngresoDetalle(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CajaIngresoDetalleBeanSwingJInternalFrame cajaingresodetalleBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCajaIngresoCajaIngresoDetalle=true;

	public Boolean getMostrarFK_IdCajaIngresoCajaIngresoDetalle() {
		return this.mostrarFK_IdCajaIngresoCajaIngresoDetalle;
	}

	public void setMostrarFK_IdCajaIngresoCajaIngresoDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCajaIngresoCajaIngresoDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteCajaIngresoDetalle=true;

	public Boolean getMostrarFK_IdClienteCajaIngresoDetalle() {
		return this.mostrarFK_IdClienteCajaIngresoDetalle;
	}

	public void setMostrarFK_IdClienteCajaIngresoDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteCajaIngresoDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCajaIngresoDetalle=true;

	public Boolean getMostrarFK_IdEmpresaCajaIngresoDetalle() {
		return this.mostrarFK_IdEmpresaCajaIngresoDetalle;
	}

	public void setMostrarFK_IdEmpresaCajaIngresoDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCajaIngresoDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaCajaIngresoDetalle=true;

	public Boolean getMostrarFK_IdFacturaCajaIngresoDetalle() {
		return this.mostrarFK_IdFacturaCajaIngresoDetalle;
	}

	public void setMostrarFK_IdFacturaCajaIngresoDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaCajaIngresoDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCajaIngresoDetalle=true;

	public Boolean getMostrarFK_IdSucursalCajaIngresoDetalle() {
		return this.mostrarFK_IdSucursalCajaIngresoDetalle;
	}

	public void setMostrarFK_IdSucursalCajaIngresoDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCajaIngresoDetalle= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCajaIngresoCajaIngresoDetalle=true;

	public Boolean getActivarFK_IdCajaIngresoCajaIngresoDetalle() {
		return this.activarFK_IdCajaIngresoCajaIngresoDetalle;
	}

	public void setActivarFK_IdCajaIngresoCajaIngresoDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdCajaIngresoCajaIngresoDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteCajaIngresoDetalle=true;

	public Boolean getActivarFK_IdClienteCajaIngresoDetalle() {
		return this.activarFK_IdClienteCajaIngresoDetalle;
	}

	public void setActivarFK_IdClienteCajaIngresoDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdClienteCajaIngresoDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCajaIngresoDetalle=true;

	public Boolean getActivarFK_IdEmpresaCajaIngresoDetalle() {
		return this.activarFK_IdEmpresaCajaIngresoDetalle;
	}

	public void setActivarFK_IdEmpresaCajaIngresoDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCajaIngresoDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaCajaIngresoDetalle=true;

	public Boolean getActivarFK_IdFacturaCajaIngresoDetalle() {
		return this.activarFK_IdFacturaCajaIngresoDetalle;
	}

	public void setActivarFK_IdFacturaCajaIngresoDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaCajaIngresoDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCajaIngresoDetalle=true;

	public Boolean getActivarFK_IdSucursalCajaIngresoDetalle() {
		return this.activarFK_IdSucursalCajaIngresoDetalle;
	}

	public void setActivarFK_IdSucursalCajaIngresoDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCajaIngresoDetalle= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCajaIngresoCajaIngresoDetalle=null;

	public Border getResaltarFK_IdCajaIngresoCajaIngresoDetalle() {
		return this.resaltarFK_IdCajaIngresoCajaIngresoDetalle;
	}

	public void setResaltarFK_IdCajaIngresoCajaIngresoDetalle(Border borderResaltar) {
		this.resaltarFK_IdCajaIngresoCajaIngresoDetalle= borderResaltar;
	}

	public void setResaltarFK_IdCajaIngresoCajaIngresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoDetalleBeanSwingJInternalFrame cajaingresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCajaIngresoCajaIngresoDetalle= borderResaltar;
	}

	public Border resaltarFK_IdClienteCajaIngresoDetalle=null;

	public Border getResaltarFK_IdClienteCajaIngresoDetalle() {
		return this.resaltarFK_IdClienteCajaIngresoDetalle;
	}

	public void setResaltarFK_IdClienteCajaIngresoDetalle(Border borderResaltar) {
		this.resaltarFK_IdClienteCajaIngresoDetalle= borderResaltar;
	}

	public void setResaltarFK_IdClienteCajaIngresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoDetalleBeanSwingJInternalFrame cajaingresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteCajaIngresoDetalle= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCajaIngresoDetalle=null;

	public Border getResaltarFK_IdEmpresaCajaIngresoDetalle() {
		return this.resaltarFK_IdEmpresaCajaIngresoDetalle;
	}

	public void setResaltarFK_IdEmpresaCajaIngresoDetalle(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCajaIngresoDetalle= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCajaIngresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoDetalleBeanSwingJInternalFrame cajaingresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCajaIngresoDetalle= borderResaltar;
	}

	public Border resaltarFK_IdFacturaCajaIngresoDetalle=null;

	public Border getResaltarFK_IdFacturaCajaIngresoDetalle() {
		return this.resaltarFK_IdFacturaCajaIngresoDetalle;
	}

	public void setResaltarFK_IdFacturaCajaIngresoDetalle(Border borderResaltar) {
		this.resaltarFK_IdFacturaCajaIngresoDetalle= borderResaltar;
	}

	public void setResaltarFK_IdFacturaCajaIngresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoDetalleBeanSwingJInternalFrame cajaingresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaCajaIngresoDetalle= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCajaIngresoDetalle=null;

	public Border getResaltarFK_IdSucursalCajaIngresoDetalle() {
		return this.resaltarFK_IdSucursalCajaIngresoDetalle;
	}

	public void setResaltarFK_IdSucursalCajaIngresoDetalle(Border borderResaltar) {
		this.resaltarFK_IdSucursalCajaIngresoDetalle= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCajaIngresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoDetalleBeanSwingJInternalFrame cajaingresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCajaIngresoDetalle= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}