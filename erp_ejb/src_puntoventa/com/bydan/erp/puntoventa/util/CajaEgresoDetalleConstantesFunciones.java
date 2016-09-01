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


import com.bydan.erp.puntoventa.util.CajaEgresoDetalleConstantesFunciones;
import com.bydan.erp.puntoventa.util.CajaEgresoDetalleParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CajaEgresoDetalleParameterGeneral;

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
final public class CajaEgresoDetalleConstantesFunciones extends CajaEgresoDetalleConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CajaEgresoDetalle";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CajaEgresoDetalle"+CajaEgresoDetalleConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CajaEgresoDetalleHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CajaEgresoDetalleHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CajaEgresoDetalleConstantesFunciones.SCHEMA+"_"+CajaEgresoDetalleConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CajaEgresoDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CajaEgresoDetalleConstantesFunciones.SCHEMA+"_"+CajaEgresoDetalleConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CajaEgresoDetalleConstantesFunciones.SCHEMA+"_"+CajaEgresoDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CajaEgresoDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CajaEgresoDetalleConstantesFunciones.SCHEMA+"_"+CajaEgresoDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaEgresoDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajaEgresoDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaEgresoDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaEgresoDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajaEgresoDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaEgresoDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CajaEgresoDetalleConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CajaEgresoDetalleConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CajaEgresoDetalleConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CajaEgresoDetalleConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Caja Egreso Detalles";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Caja Egreso Detalle";
	public static final String SCLASSWEBTITULO_LOWER="Caja Egreso Detalle";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CajaEgresoDetalle";
	public static final String OBJECTNAME="cajaegresodetalle";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="caja_egreso_detalle";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cajaegresodetalle from "+CajaEgresoDetalleConstantesFunciones.SPERSISTENCENAME+" cajaegresodetalle";
	public static String QUERYSELECTNATIVE="select "+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".id,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".version_row,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".id_caja_egreso,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".id_empresa,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".id_sucursal,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".id_cliente,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".id_factura,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".concepto,"+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME+".valor from "+CajaEgresoDetalleConstantesFunciones.SCHEMA+"."+CajaEgresoDetalleConstantesFunciones.TABLENAME;//+" as "+CajaEgresoDetalleConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CajaEgresoDetalleConstantesFuncionesAdditional cajaegresodetalleConstantesFuncionesAdditional=null;
	
	public CajaEgresoDetalleConstantesFuncionesAdditional getCajaEgresoDetalleConstantesFuncionesAdditional() {
		return this.cajaegresodetalleConstantesFuncionesAdditional;
	}
	
	public void setCajaEgresoDetalleConstantesFuncionesAdditional(CajaEgresoDetalleConstantesFuncionesAdditional cajaegresodetalleConstantesFuncionesAdditional) {
		try {
			this.cajaegresodetalleConstantesFuncionesAdditional=cajaegresodetalleConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCAJAEGRESO= "id_caja_egreso";
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
    	public static final String LABEL_IDCAJAEGRESO= "Caja Egreso";
		public static final String LABEL_IDCAJAEGRESO_LOWER= "Caja Egreso";
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
		
	
	public static String getCajaEgresoDetalleLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CajaEgresoDetalleConstantesFunciones.IDCAJAEGRESO)) {sLabelColumna=CajaEgresoDetalleConstantesFunciones.LABEL_IDCAJAEGRESO;}
		if(sNombreColumna.equals(CajaEgresoDetalleConstantesFunciones.IDEMPRESA)) {sLabelColumna=CajaEgresoDetalleConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CajaEgresoDetalleConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CajaEgresoDetalleConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CajaEgresoDetalleConstantesFunciones.IDCLIENTE)) {sLabelColumna=CajaEgresoDetalleConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(CajaEgresoDetalleConstantesFunciones.IDFACTURA)) {sLabelColumna=CajaEgresoDetalleConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(CajaEgresoDetalleConstantesFunciones.CONCEPTO)) {sLabelColumna=CajaEgresoDetalleConstantesFunciones.LABEL_CONCEPTO;}
		if(sNombreColumna.equals(CajaEgresoDetalleConstantesFunciones.VALOR)) {sLabelColumna=CajaEgresoDetalleConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getCajaEgresoDetalleDescripcion(CajaEgresoDetalle cajaegresodetalle) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cajaegresodetalle !=null/* && cajaegresodetalle.getId()!=0*/) {
			if(cajaegresodetalle.getId()!=null) {
				sDescripcion=cajaegresodetalle.getId().toString();
			}//cajaegresodetallecajaegresodetalle.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCajaEgresoDetalleDescripcionDetallado(CajaEgresoDetalle cajaegresodetalle) {
		String sDescripcion="";
			
		sDescripcion+=CajaEgresoDetalleConstantesFunciones.ID+"=";
		sDescripcion+=cajaegresodetalle.getId().toString()+",";
		sDescripcion+=CajaEgresoDetalleConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cajaegresodetalle.getVersionRow().toString()+",";
		sDescripcion+=CajaEgresoDetalleConstantesFunciones.IDCAJAEGRESO+"=";
		sDescripcion+=cajaegresodetalle.getid_caja_egreso().toString()+",";
		sDescripcion+=CajaEgresoDetalleConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cajaegresodetalle.getid_empresa().toString()+",";
		sDescripcion+=CajaEgresoDetalleConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cajaegresodetalle.getid_sucursal().toString()+",";
		sDescripcion+=CajaEgresoDetalleConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=cajaegresodetalle.getid_cliente().toString()+",";
		sDescripcion+=CajaEgresoDetalleConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=cajaegresodetalle.getid_factura().toString()+",";
		sDescripcion+=CajaEgresoDetalleConstantesFunciones.CONCEPTO+"=";
		sDescripcion+=cajaegresodetalle.getconcepto()+",";
		sDescripcion+=CajaEgresoDetalleConstantesFunciones.VALOR+"=";
		sDescripcion+=cajaegresodetalle.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCajaEgresoDetalleDescripcion(CajaEgresoDetalle cajaegresodetalle,String sValor) throws Exception {			
		if(cajaegresodetalle !=null) {
			//cajaegresodetallecajaegresodetalle.getId().toString();
		}		
	}
	
		

	public static String getCajaEgresoDescripcion(CajaEgreso cajaegreso) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cajaegreso!=null/*&&cajaegreso.getId()>0*/) {
			sDescripcion=CajaEgresoConstantesFunciones.getCajaEgresoDescripcion(cajaegreso);
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
		} else if(sNombreIndice.equals("FK_IdCajaEgreso")) {
			sNombreIndice="Tipo=  Por Caja Egreso";
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

	public static String getDetalleIndiceFK_IdCajaEgreso(Long id_caja_egreso) {
		String sDetalleIndice=" Parametros->";
		if(id_caja_egreso!=null) {sDetalleIndice+=" Codigo Unico De Caja Egreso="+id_caja_egreso.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosCajaEgresoDetalle(CajaEgresoDetalle cajaegresodetalle,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cajaegresodetalle.setconcepto(cajaegresodetalle.getconcepto().trim());
	}
	
	public static void quitarEspaciosCajaEgresoDetalles(List<CajaEgresoDetalle> cajaegresodetalles,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CajaEgresoDetalle cajaegresodetalle: cajaegresodetalles) {
			cajaegresodetalle.setconcepto(cajaegresodetalle.getconcepto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajaEgresoDetalle(CajaEgresoDetalle cajaegresodetalle,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cajaegresodetalle.getConCambioAuxiliar()) {
			cajaegresodetalle.setIsDeleted(cajaegresodetalle.getIsDeletedAuxiliar());	
			cajaegresodetalle.setIsNew(cajaegresodetalle.getIsNewAuxiliar());	
			cajaegresodetalle.setIsChanged(cajaegresodetalle.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cajaegresodetalle.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cajaegresodetalle.setIsDeletedAuxiliar(false);	
			cajaegresodetalle.setIsNewAuxiliar(false);	
			cajaegresodetalle.setIsChangedAuxiliar(false);
			
			cajaegresodetalle.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajaEgresoDetalles(List<CajaEgresoDetalle> cajaegresodetalles,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CajaEgresoDetalle cajaegresodetalle : cajaegresodetalles) {
			if(conAsignarBase && cajaegresodetalle.getConCambioAuxiliar()) {
				cajaegresodetalle.setIsDeleted(cajaegresodetalle.getIsDeletedAuxiliar());	
				cajaegresodetalle.setIsNew(cajaegresodetalle.getIsNewAuxiliar());	
				cajaegresodetalle.setIsChanged(cajaegresodetalle.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cajaegresodetalle.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cajaegresodetalle.setIsDeletedAuxiliar(false);	
				cajaegresodetalle.setIsNewAuxiliar(false);	
				cajaegresodetalle.setIsChangedAuxiliar(false);
				
				cajaegresodetalle.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCajaEgresoDetalle(CajaEgresoDetalle cajaegresodetalle,Boolean conEnteros) throws Exception  {
		cajaegresodetalle.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCajaEgresoDetalles(List<CajaEgresoDetalle> cajaegresodetalles,Boolean conEnteros) throws Exception  {
		
		for(CajaEgresoDetalle cajaegresodetalle: cajaegresodetalles) {
			cajaegresodetalle.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCajaEgresoDetalle(List<CajaEgresoDetalle> cajaegresodetalles,CajaEgresoDetalle cajaegresodetalleAux) throws Exception  {
		CajaEgresoDetalleConstantesFunciones.InicializarValoresCajaEgresoDetalle(cajaegresodetalleAux,true);
		
		for(CajaEgresoDetalle cajaegresodetalle: cajaegresodetalles) {
			if(cajaegresodetalle.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cajaegresodetalleAux.setvalor(cajaegresodetalleAux.getvalor()+cajaegresodetalle.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaEgresoDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CajaEgresoDetalleConstantesFunciones.getArrayColumnasGlobalesCajaEgresoDetalle(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaEgresoDetalle(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaEgresoDetalleConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaEgresoDetalleConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaEgresoDetalleConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaEgresoDetalleConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCajaEgresoDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CajaEgresoDetalle> cajaegresodetalles,CajaEgresoDetalle cajaegresodetalle,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CajaEgresoDetalle cajaegresodetalleAux: cajaegresodetalles) {
			if(cajaegresodetalleAux!=null && cajaegresodetalle!=null) {
				if((cajaegresodetalleAux.getId()==null && cajaegresodetalle.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cajaegresodetalleAux.getId()!=null && cajaegresodetalle.getId()!=null){
					if(cajaegresodetalleAux.getId().equals(cajaegresodetalle.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCajaEgresoDetalle(List<CajaEgresoDetalle> cajaegresodetalles) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(CajaEgresoDetalle cajaegresodetalle: cajaegresodetalles) {			
			if(cajaegresodetalle.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=cajaegresodetalle.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaEgresoDetalleConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(CajaEgresoDetalleConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCajaEgresoDetalle() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CajaEgresoDetalleConstantesFunciones.LABEL_ID, CajaEgresoDetalleConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoDetalleConstantesFunciones.LABEL_VERSIONROW, CajaEgresoDetalleConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoDetalleConstantesFunciones.LABEL_IDCAJAEGRESO, CajaEgresoDetalleConstantesFunciones.IDCAJAEGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoDetalleConstantesFunciones.LABEL_IDEMPRESA, CajaEgresoDetalleConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoDetalleConstantesFunciones.LABEL_IDSUCURSAL, CajaEgresoDetalleConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoDetalleConstantesFunciones.LABEL_IDCLIENTE, CajaEgresoDetalleConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoDetalleConstantesFunciones.LABEL_IDFACTURA, CajaEgresoDetalleConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoDetalleConstantesFunciones.LABEL_CONCEPTO, CajaEgresoDetalleConstantesFunciones.CONCEPTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaEgresoDetalleConstantesFunciones.LABEL_VALOR, CajaEgresoDetalleConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCajaEgresoDetalle() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoDetalleConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoDetalleConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoDetalleConstantesFunciones.IDCAJAEGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoDetalleConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoDetalleConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoDetalleConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoDetalleConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoDetalleConstantesFunciones.CONCEPTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaEgresoDetalleConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaEgresoDetalle() throws Exception  {
		return CajaEgresoDetalleConstantesFunciones.getTiposSeleccionarCajaEgresoDetalle(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaEgresoDetalle(Boolean conFk) throws Exception  {
		return CajaEgresoDetalleConstantesFunciones.getTiposSeleccionarCajaEgresoDetalle(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaEgresoDetalle(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaEgresoDetalleConstantesFunciones.LABEL_IDCAJAEGRESO);
			reporte.setsDescripcion(CajaEgresoDetalleConstantesFunciones.LABEL_IDCAJAEGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaEgresoDetalleConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CajaEgresoDetalleConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaEgresoDetalleConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CajaEgresoDetalleConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaEgresoDetalleConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(CajaEgresoDetalleConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaEgresoDetalleConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(CajaEgresoDetalleConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaEgresoDetalleConstantesFunciones.LABEL_CONCEPTO);
			reporte.setsDescripcion(CajaEgresoDetalleConstantesFunciones.LABEL_CONCEPTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaEgresoDetalleConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(CajaEgresoDetalleConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCajaEgresoDetalle(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCajaEgresoDetalle(CajaEgresoDetalle cajaegresodetalleAux) throws Exception {
		
			cajaegresodetalleAux.setcajaegreso_descripcion(CajaEgresoConstantesFunciones.getCajaEgresoDescripcion(cajaegresodetalleAux.getCajaEgreso()));
			cajaegresodetalleAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajaegresodetalleAux.getEmpresa()));
			cajaegresodetalleAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cajaegresodetalleAux.getSucursal()));
			cajaegresodetalleAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(cajaegresodetalleAux.getCliente()));
			cajaegresodetalleAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(cajaegresodetalleAux.getFactura()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCajaEgresoDetalle(List<CajaEgresoDetalle> cajaegresodetallesTemp) throws Exception {
		for(CajaEgresoDetalle cajaegresodetalleAux:cajaegresodetallesTemp) {
			
			cajaegresodetalleAux.setcajaegreso_descripcion(CajaEgresoConstantesFunciones.getCajaEgresoDescripcion(cajaegresodetalleAux.getCajaEgreso()));
			cajaegresodetalleAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajaegresodetalleAux.getEmpresa()));
			cajaegresodetalleAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cajaegresodetalleAux.getSucursal()));
			cajaegresodetalleAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(cajaegresodetalleAux.getCliente()));
			cajaegresodetalleAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(cajaegresodetalleAux.getFactura()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCajaEgresoDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CajaEgreso.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Factura.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CajaEgreso.class)) {
						classes.add(new Classe(CajaEgreso.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCajaEgresoDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CajaEgreso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaEgreso.class)); continue;
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

					if(CajaEgreso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaEgreso.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaEgresoDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajaEgresoDetalleConstantesFunciones.getClassesRelationshipsOfCajaEgresoDetalle(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaEgresoDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajaEgresoDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajaEgresoDetalleConstantesFunciones.getClassesRelationshipsFromStringsOfCajaEgresoDetalle(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajaEgresoDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CajaEgresoDetalle cajaegresodetalle,List<CajaEgresoDetalle> cajaegresodetalles,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CajaEgresoDetalle cajaegresodetalleEncontrado=null;
			
			for(CajaEgresoDetalle cajaegresodetalleLocal:cajaegresodetalles) {
				if(cajaegresodetalleLocal.getId().equals(cajaegresodetalle.getId())) {
					cajaegresodetalleEncontrado=cajaegresodetalleLocal;
					
					cajaegresodetalleLocal.setIsChanged(cajaegresodetalle.getIsChanged());
					cajaegresodetalleLocal.setIsNew(cajaegresodetalle.getIsNew());
					cajaegresodetalleLocal.setIsDeleted(cajaegresodetalle.getIsDeleted());
					
					cajaegresodetalleLocal.setGeneralEntityOriginal(cajaegresodetalle.getGeneralEntityOriginal());
					
					cajaegresodetalleLocal.setId(cajaegresodetalle.getId());	
					cajaegresodetalleLocal.setVersionRow(cajaegresodetalle.getVersionRow());	
					cajaegresodetalleLocal.setid_caja_egreso(cajaegresodetalle.getid_caja_egreso());	
					cajaegresodetalleLocal.setid_empresa(cajaegresodetalle.getid_empresa());	
					cajaegresodetalleLocal.setid_sucursal(cajaegresodetalle.getid_sucursal());	
					cajaegresodetalleLocal.setid_cliente(cajaegresodetalle.getid_cliente());	
					cajaegresodetalleLocal.setid_factura(cajaegresodetalle.getid_factura());	
					cajaegresodetalleLocal.setconcepto(cajaegresodetalle.getconcepto());	
					cajaegresodetalleLocal.setvalor(cajaegresodetalle.getvalor());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cajaegresodetalle.getIsDeleted()) {
				if(!existe) {
					cajaegresodetalles.add(cajaegresodetalle);
				}
			} else {
				if(cajaegresodetalleEncontrado!=null && permiteQuitar)  {
					cajaegresodetalles.remove(cajaegresodetalleEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CajaEgresoDetalle cajaegresodetalle,List<CajaEgresoDetalle> cajaegresodetalles) throws Exception {
		try	{			
			for(CajaEgresoDetalle cajaegresodetalleLocal:cajaegresodetalles) {
				if(cajaegresodetalleLocal.getId().equals(cajaegresodetalle.getId())) {
					cajaegresodetalleLocal.setIsSelected(cajaegresodetalle.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCajaEgresoDetalle(List<CajaEgresoDetalle> cajaegresodetallesAux) throws Exception {
		//this.cajaegresodetallesAux=cajaegresodetallesAux;
		
		for(CajaEgresoDetalle cajaegresodetalleAux:cajaegresodetallesAux) {
			if(cajaegresodetalleAux.getIsChanged()) {
				cajaegresodetalleAux.setIsChanged(false);
			}		
			
			if(cajaegresodetalleAux.getIsNew()) {
				cajaegresodetalleAux.setIsNew(false);
			}	
			
			if(cajaegresodetalleAux.getIsDeleted()) {
				cajaegresodetalleAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCajaEgresoDetalle(CajaEgresoDetalle cajaegresodetalleAux) throws Exception {
		//this.cajaegresodetalleAux=cajaegresodetalleAux;
		
			if(cajaegresodetalleAux.getIsChanged()) {
				cajaegresodetalleAux.setIsChanged(false);
			}		
			
			if(cajaegresodetalleAux.getIsNew()) {
				cajaegresodetalleAux.setIsNew(false);
			}	
			
			if(cajaegresodetalleAux.getIsDeleted()) {
				cajaegresodetalleAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CajaEgresoDetalle cajaegresodetalleAsignar,CajaEgresoDetalle cajaegresodetalle) throws Exception {
		cajaegresodetalleAsignar.setId(cajaegresodetalle.getId());	
		cajaegresodetalleAsignar.setVersionRow(cajaegresodetalle.getVersionRow());	
		cajaegresodetalleAsignar.setid_caja_egreso(cajaegresodetalle.getid_caja_egreso());
		cajaegresodetalleAsignar.setcajaegreso_descripcion(cajaegresodetalle.getcajaegreso_descripcion());	
		cajaegresodetalleAsignar.setid_empresa(cajaegresodetalle.getid_empresa());
		cajaegresodetalleAsignar.setempresa_descripcion(cajaegresodetalle.getempresa_descripcion());	
		cajaegresodetalleAsignar.setid_sucursal(cajaegresodetalle.getid_sucursal());
		cajaegresodetalleAsignar.setsucursal_descripcion(cajaegresodetalle.getsucursal_descripcion());	
		cajaegresodetalleAsignar.setid_cliente(cajaegresodetalle.getid_cliente());
		cajaegresodetalleAsignar.setcliente_descripcion(cajaegresodetalle.getcliente_descripcion());	
		cajaegresodetalleAsignar.setid_factura(cajaegresodetalle.getid_factura());
		cajaegresodetalleAsignar.setfactura_descripcion(cajaegresodetalle.getfactura_descripcion());	
		cajaegresodetalleAsignar.setconcepto(cajaegresodetalle.getconcepto());	
		cajaegresodetalleAsignar.setvalor(cajaegresodetalle.getvalor());	
	}
	
	public static void inicializarCajaEgresoDetalle(CajaEgresoDetalle cajaegresodetalle) throws Exception {
		try {
				cajaegresodetalle.setId(0L);	
					
				cajaegresodetalle.setid_caja_egreso(-1L);	
				cajaegresodetalle.setid_empresa(-1L);	
				cajaegresodetalle.setid_sucursal(-1L);	
				cajaegresodetalle.setid_cliente(-1L);	
				cajaegresodetalle.setid_factura(-1L);	
				cajaegresodetalle.setconcepto("");	
				cajaegresodetalle.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCajaEgresoDetalle(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaEgresoDetalleConstantesFunciones.LABEL_IDCAJAEGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaEgresoDetalleConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaEgresoDetalleConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaEgresoDetalleConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaEgresoDetalleConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaEgresoDetalleConstantesFunciones.LABEL_CONCEPTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaEgresoDetalleConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCajaEgresoDetalle(String sTipo,Row row,Workbook workbook,CajaEgresoDetalle cajaegresodetalle,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaegresodetalle.getcajaegreso_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaegresodetalle.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaegresodetalle.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaegresodetalle.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaegresodetalle.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaegresodetalle.getconcepto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaegresodetalle.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCajaEgresoDetalle=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCajaEgresoDetalle() {
		return this.sFinalQueryCajaEgresoDetalle;
	}
	
	public void setsFinalQueryCajaEgresoDetalle(String sFinalQueryCajaEgresoDetalle) {
		this.sFinalQueryCajaEgresoDetalle= sFinalQueryCajaEgresoDetalle;
	}
	
	public Border resaltarSeleccionarCajaEgresoDetalle=null;
	
	public Border setResaltarSeleccionarCajaEgresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoDetalleBeanSwingJInternalFrame cajaegresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cajaegresodetalleBeanSwingJInternalFrame.jTtoolBarCajaEgresoDetalle.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCajaEgresoDetalle= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCajaEgresoDetalle() {
		return this.resaltarSeleccionarCajaEgresoDetalle;
	}
	
	public void setResaltarSeleccionarCajaEgresoDetalle(Border borderResaltarSeleccionarCajaEgresoDetalle) {
		this.resaltarSeleccionarCajaEgresoDetalle= borderResaltarSeleccionarCajaEgresoDetalle;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCajaEgresoDetalle=null;
	public Boolean mostraridCajaEgresoDetalle=true;
	public Boolean activaridCajaEgresoDetalle=true;

	public Border resaltarid_caja_egresoCajaEgresoDetalle=null;
	public Boolean mostrarid_caja_egresoCajaEgresoDetalle=true;
	public Boolean activarid_caja_egresoCajaEgresoDetalle=true;
	public Boolean cargarid_caja_egresoCajaEgresoDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_caja_egresoCajaEgresoDetalle=false;//ConEventDepend=true

	public Border resaltarid_empresaCajaEgresoDetalle=null;
	public Boolean mostrarid_empresaCajaEgresoDetalle=true;
	public Boolean activarid_empresaCajaEgresoDetalle=true;
	public Boolean cargarid_empresaCajaEgresoDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCajaEgresoDetalle=false;//ConEventDepend=true

	public Border resaltarid_sucursalCajaEgresoDetalle=null;
	public Boolean mostrarid_sucursalCajaEgresoDetalle=true;
	public Boolean activarid_sucursalCajaEgresoDetalle=true;
	public Boolean cargarid_sucursalCajaEgresoDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCajaEgresoDetalle=false;//ConEventDepend=true

	public Border resaltarid_clienteCajaEgresoDetalle=null;
	public Boolean mostrarid_clienteCajaEgresoDetalle=true;
	public Boolean activarid_clienteCajaEgresoDetalle=true;
	public Boolean cargarid_clienteCajaEgresoDetalle=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteCajaEgresoDetalle=false;//ConEventDepend=true

	public Border resaltarid_facturaCajaEgresoDetalle=null;
	public Boolean mostrarid_facturaCajaEgresoDetalle=true;
	public Boolean activarid_facturaCajaEgresoDetalle=true;
	public Boolean cargarid_facturaCajaEgresoDetalle=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaCajaEgresoDetalle=false;//ConEventDepend=true

	public Border resaltarconceptoCajaEgresoDetalle=null;
	public Boolean mostrarconceptoCajaEgresoDetalle=true;
	public Boolean activarconceptoCajaEgresoDetalle=true;

	public Border resaltarvalorCajaEgresoDetalle=null;
	public Boolean mostrarvalorCajaEgresoDetalle=true;
	public Boolean activarvalorCajaEgresoDetalle=true;

	
	

	public Border setResaltaridCajaEgresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoDetalleBeanSwingJInternalFrame cajaegresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresodetalleBeanSwingJInternalFrame.jTtoolBarCajaEgresoDetalle.setBorder(borderResaltar);
		
		this.resaltaridCajaEgresoDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCajaEgresoDetalle() {
		return this.resaltaridCajaEgresoDetalle;
	}

	public void setResaltaridCajaEgresoDetalle(Border borderResaltar) {
		this.resaltaridCajaEgresoDetalle= borderResaltar;
	}

	public Boolean getMostraridCajaEgresoDetalle() {
		return this.mostraridCajaEgresoDetalle;
	}

	public void setMostraridCajaEgresoDetalle(Boolean mostraridCajaEgresoDetalle) {
		this.mostraridCajaEgresoDetalle= mostraridCajaEgresoDetalle;
	}

	public Boolean getActivaridCajaEgresoDetalle() {
		return this.activaridCajaEgresoDetalle;
	}

	public void setActivaridCajaEgresoDetalle(Boolean activaridCajaEgresoDetalle) {
		this.activaridCajaEgresoDetalle= activaridCajaEgresoDetalle;
	}

	public Border setResaltarid_caja_egresoCajaEgresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoDetalleBeanSwingJInternalFrame cajaegresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresodetalleBeanSwingJInternalFrame.jTtoolBarCajaEgresoDetalle.setBorder(borderResaltar);
		
		this.resaltarid_caja_egresoCajaEgresoDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_caja_egresoCajaEgresoDetalle() {
		return this.resaltarid_caja_egresoCajaEgresoDetalle;
	}

	public void setResaltarid_caja_egresoCajaEgresoDetalle(Border borderResaltar) {
		this.resaltarid_caja_egresoCajaEgresoDetalle= borderResaltar;
	}

	public Boolean getMostrarid_caja_egresoCajaEgresoDetalle() {
		return this.mostrarid_caja_egresoCajaEgresoDetalle;
	}

	public void setMostrarid_caja_egresoCajaEgresoDetalle(Boolean mostrarid_caja_egresoCajaEgresoDetalle) {
		this.mostrarid_caja_egresoCajaEgresoDetalle= mostrarid_caja_egresoCajaEgresoDetalle;
	}

	public Boolean getActivarid_caja_egresoCajaEgresoDetalle() {
		return this.activarid_caja_egresoCajaEgresoDetalle;
	}

	public void setActivarid_caja_egresoCajaEgresoDetalle(Boolean activarid_caja_egresoCajaEgresoDetalle) {
		this.activarid_caja_egresoCajaEgresoDetalle= activarid_caja_egresoCajaEgresoDetalle;
	}

	public Boolean getCargarid_caja_egresoCajaEgresoDetalle() {
		return this.cargarid_caja_egresoCajaEgresoDetalle;
	}

	public void setCargarid_caja_egresoCajaEgresoDetalle(Boolean cargarid_caja_egresoCajaEgresoDetalle) {
		this.cargarid_caja_egresoCajaEgresoDetalle= cargarid_caja_egresoCajaEgresoDetalle;
	}

	public Border setResaltarid_empresaCajaEgresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoDetalleBeanSwingJInternalFrame cajaegresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresodetalleBeanSwingJInternalFrame.jTtoolBarCajaEgresoDetalle.setBorder(borderResaltar);
		
		this.resaltarid_empresaCajaEgresoDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCajaEgresoDetalle() {
		return this.resaltarid_empresaCajaEgresoDetalle;
	}

	public void setResaltarid_empresaCajaEgresoDetalle(Border borderResaltar) {
		this.resaltarid_empresaCajaEgresoDetalle= borderResaltar;
	}

	public Boolean getMostrarid_empresaCajaEgresoDetalle() {
		return this.mostrarid_empresaCajaEgresoDetalle;
	}

	public void setMostrarid_empresaCajaEgresoDetalle(Boolean mostrarid_empresaCajaEgresoDetalle) {
		this.mostrarid_empresaCajaEgresoDetalle= mostrarid_empresaCajaEgresoDetalle;
	}

	public Boolean getActivarid_empresaCajaEgresoDetalle() {
		return this.activarid_empresaCajaEgresoDetalle;
	}

	public void setActivarid_empresaCajaEgresoDetalle(Boolean activarid_empresaCajaEgresoDetalle) {
		this.activarid_empresaCajaEgresoDetalle= activarid_empresaCajaEgresoDetalle;
	}

	public Boolean getCargarid_empresaCajaEgresoDetalle() {
		return this.cargarid_empresaCajaEgresoDetalle;
	}

	public void setCargarid_empresaCajaEgresoDetalle(Boolean cargarid_empresaCajaEgresoDetalle) {
		this.cargarid_empresaCajaEgresoDetalle= cargarid_empresaCajaEgresoDetalle;
	}

	public Border setResaltarid_sucursalCajaEgresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoDetalleBeanSwingJInternalFrame cajaegresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresodetalleBeanSwingJInternalFrame.jTtoolBarCajaEgresoDetalle.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCajaEgresoDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCajaEgresoDetalle() {
		return this.resaltarid_sucursalCajaEgresoDetalle;
	}

	public void setResaltarid_sucursalCajaEgresoDetalle(Border borderResaltar) {
		this.resaltarid_sucursalCajaEgresoDetalle= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCajaEgresoDetalle() {
		return this.mostrarid_sucursalCajaEgresoDetalle;
	}

	public void setMostrarid_sucursalCajaEgresoDetalle(Boolean mostrarid_sucursalCajaEgresoDetalle) {
		this.mostrarid_sucursalCajaEgresoDetalle= mostrarid_sucursalCajaEgresoDetalle;
	}

	public Boolean getActivarid_sucursalCajaEgresoDetalle() {
		return this.activarid_sucursalCajaEgresoDetalle;
	}

	public void setActivarid_sucursalCajaEgresoDetalle(Boolean activarid_sucursalCajaEgresoDetalle) {
		this.activarid_sucursalCajaEgresoDetalle= activarid_sucursalCajaEgresoDetalle;
	}

	public Boolean getCargarid_sucursalCajaEgresoDetalle() {
		return this.cargarid_sucursalCajaEgresoDetalle;
	}

	public void setCargarid_sucursalCajaEgresoDetalle(Boolean cargarid_sucursalCajaEgresoDetalle) {
		this.cargarid_sucursalCajaEgresoDetalle= cargarid_sucursalCajaEgresoDetalle;
	}

	public Border setResaltarid_clienteCajaEgresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoDetalleBeanSwingJInternalFrame cajaegresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresodetalleBeanSwingJInternalFrame.jTtoolBarCajaEgresoDetalle.setBorder(borderResaltar);
		
		this.resaltarid_clienteCajaEgresoDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteCajaEgresoDetalle() {
		return this.resaltarid_clienteCajaEgresoDetalle;
	}

	public void setResaltarid_clienteCajaEgresoDetalle(Border borderResaltar) {
		this.resaltarid_clienteCajaEgresoDetalle= borderResaltar;
	}

	public Boolean getMostrarid_clienteCajaEgresoDetalle() {
		return this.mostrarid_clienteCajaEgresoDetalle;
	}

	public void setMostrarid_clienteCajaEgresoDetalle(Boolean mostrarid_clienteCajaEgresoDetalle) {
		this.mostrarid_clienteCajaEgresoDetalle= mostrarid_clienteCajaEgresoDetalle;
	}

	public Boolean getActivarid_clienteCajaEgresoDetalle() {
		return this.activarid_clienteCajaEgresoDetalle;
	}

	public void setActivarid_clienteCajaEgresoDetalle(Boolean activarid_clienteCajaEgresoDetalle) {
		this.activarid_clienteCajaEgresoDetalle= activarid_clienteCajaEgresoDetalle;
	}

	public Boolean getCargarid_clienteCajaEgresoDetalle() {
		return this.cargarid_clienteCajaEgresoDetalle;
	}

	public void setCargarid_clienteCajaEgresoDetalle(Boolean cargarid_clienteCajaEgresoDetalle) {
		this.cargarid_clienteCajaEgresoDetalle= cargarid_clienteCajaEgresoDetalle;
	}

	public Border setResaltarid_facturaCajaEgresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoDetalleBeanSwingJInternalFrame cajaegresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresodetalleBeanSwingJInternalFrame.jTtoolBarCajaEgresoDetalle.setBorder(borderResaltar);
		
		this.resaltarid_facturaCajaEgresoDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaCajaEgresoDetalle() {
		return this.resaltarid_facturaCajaEgresoDetalle;
	}

	public void setResaltarid_facturaCajaEgresoDetalle(Border borderResaltar) {
		this.resaltarid_facturaCajaEgresoDetalle= borderResaltar;
	}

	public Boolean getMostrarid_facturaCajaEgresoDetalle() {
		return this.mostrarid_facturaCajaEgresoDetalle;
	}

	public void setMostrarid_facturaCajaEgresoDetalle(Boolean mostrarid_facturaCajaEgresoDetalle) {
		this.mostrarid_facturaCajaEgresoDetalle= mostrarid_facturaCajaEgresoDetalle;
	}

	public Boolean getActivarid_facturaCajaEgresoDetalle() {
		return this.activarid_facturaCajaEgresoDetalle;
	}

	public void setActivarid_facturaCajaEgresoDetalle(Boolean activarid_facturaCajaEgresoDetalle) {
		this.activarid_facturaCajaEgresoDetalle= activarid_facturaCajaEgresoDetalle;
	}

	public Boolean getCargarid_facturaCajaEgresoDetalle() {
		return this.cargarid_facturaCajaEgresoDetalle;
	}

	public void setCargarid_facturaCajaEgresoDetalle(Boolean cargarid_facturaCajaEgresoDetalle) {
		this.cargarid_facturaCajaEgresoDetalle= cargarid_facturaCajaEgresoDetalle;
	}

	public Border setResaltarconceptoCajaEgresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoDetalleBeanSwingJInternalFrame cajaegresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresodetalleBeanSwingJInternalFrame.jTtoolBarCajaEgresoDetalle.setBorder(borderResaltar);
		
		this.resaltarconceptoCajaEgresoDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarconceptoCajaEgresoDetalle() {
		return this.resaltarconceptoCajaEgresoDetalle;
	}

	public void setResaltarconceptoCajaEgresoDetalle(Border borderResaltar) {
		this.resaltarconceptoCajaEgresoDetalle= borderResaltar;
	}

	public Boolean getMostrarconceptoCajaEgresoDetalle() {
		return this.mostrarconceptoCajaEgresoDetalle;
	}

	public void setMostrarconceptoCajaEgresoDetalle(Boolean mostrarconceptoCajaEgresoDetalle) {
		this.mostrarconceptoCajaEgresoDetalle= mostrarconceptoCajaEgresoDetalle;
	}

	public Boolean getActivarconceptoCajaEgresoDetalle() {
		return this.activarconceptoCajaEgresoDetalle;
	}

	public void setActivarconceptoCajaEgresoDetalle(Boolean activarconceptoCajaEgresoDetalle) {
		this.activarconceptoCajaEgresoDetalle= activarconceptoCajaEgresoDetalle;
	}

	public Border setResaltarvalorCajaEgresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoDetalleBeanSwingJInternalFrame cajaegresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaegresodetalleBeanSwingJInternalFrame.jTtoolBarCajaEgresoDetalle.setBorder(borderResaltar);
		
		this.resaltarvalorCajaEgresoDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorCajaEgresoDetalle() {
		return this.resaltarvalorCajaEgresoDetalle;
	}

	public void setResaltarvalorCajaEgresoDetalle(Border borderResaltar) {
		this.resaltarvalorCajaEgresoDetalle= borderResaltar;
	}

	public Boolean getMostrarvalorCajaEgresoDetalle() {
		return this.mostrarvalorCajaEgresoDetalle;
	}

	public void setMostrarvalorCajaEgresoDetalle(Boolean mostrarvalorCajaEgresoDetalle) {
		this.mostrarvalorCajaEgresoDetalle= mostrarvalorCajaEgresoDetalle;
	}

	public Boolean getActivarvalorCajaEgresoDetalle() {
		return this.activarvalorCajaEgresoDetalle;
	}

	public void setActivarvalorCajaEgresoDetalle(Boolean activarvalorCajaEgresoDetalle) {
		this.activarvalorCajaEgresoDetalle= activarvalorCajaEgresoDetalle;
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
		
		
		this.setMostraridCajaEgresoDetalle(esInicial);
		this.setMostrarid_caja_egresoCajaEgresoDetalle(esInicial);
		this.setMostrarid_empresaCajaEgresoDetalle(esInicial);
		this.setMostrarid_sucursalCajaEgresoDetalle(esInicial);
		this.setMostrarid_clienteCajaEgresoDetalle(esInicial);
		this.setMostrarid_facturaCajaEgresoDetalle(esInicial);
		this.setMostrarconceptoCajaEgresoDetalle(esInicial);
		this.setMostrarvalorCajaEgresoDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.ID)) {
				this.setMostraridCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.IDCAJAEGRESO)) {
				this.setMostrarid_caja_egresoCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.CONCEPTO)) {
				this.setMostrarconceptoCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.VALOR)) {
				this.setMostrarvalorCajaEgresoDetalle(esAsigna);
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
		
		
		this.setActivaridCajaEgresoDetalle(esInicial);
		this.setActivarid_caja_egresoCajaEgresoDetalle(esInicial);
		this.setActivarid_empresaCajaEgresoDetalle(esInicial);
		this.setActivarid_sucursalCajaEgresoDetalle(esInicial);
		this.setActivarid_clienteCajaEgresoDetalle(esInicial);
		this.setActivarid_facturaCajaEgresoDetalle(esInicial);
		this.setActivarconceptoCajaEgresoDetalle(esInicial);
		this.setActivarvalorCajaEgresoDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.ID)) {
				this.setActivaridCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.IDCAJAEGRESO)) {
				this.setActivarid_caja_egresoCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.CONCEPTO)) {
				this.setActivarconceptoCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.VALOR)) {
				this.setActivarvalorCajaEgresoDetalle(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CajaEgresoDetalleBeanSwingJInternalFrame cajaegresodetalleBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCajaEgresoDetalle(esInicial);
		this.setResaltarid_caja_egresoCajaEgresoDetalle(esInicial);
		this.setResaltarid_empresaCajaEgresoDetalle(esInicial);
		this.setResaltarid_sucursalCajaEgresoDetalle(esInicial);
		this.setResaltarid_clienteCajaEgresoDetalle(esInicial);
		this.setResaltarid_facturaCajaEgresoDetalle(esInicial);
		this.setResaltarconceptoCajaEgresoDetalle(esInicial);
		this.setResaltarvalorCajaEgresoDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.ID)) {
				this.setResaltaridCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.IDCAJAEGRESO)) {
				this.setResaltarid_caja_egresoCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.CONCEPTO)) {
				this.setResaltarconceptoCajaEgresoDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaEgresoDetalleConstantesFunciones.VALOR)) {
				this.setResaltarvalorCajaEgresoDetalle(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CajaEgresoDetalleBeanSwingJInternalFrame cajaegresodetalleBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCajaEgresoCajaEgresoDetalle=true;

	public Boolean getMostrarFK_IdCajaEgresoCajaEgresoDetalle() {
		return this.mostrarFK_IdCajaEgresoCajaEgresoDetalle;
	}

	public void setMostrarFK_IdCajaEgresoCajaEgresoDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCajaEgresoCajaEgresoDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteCajaEgresoDetalle=true;

	public Boolean getMostrarFK_IdClienteCajaEgresoDetalle() {
		return this.mostrarFK_IdClienteCajaEgresoDetalle;
	}

	public void setMostrarFK_IdClienteCajaEgresoDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteCajaEgresoDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCajaEgresoDetalle=true;

	public Boolean getMostrarFK_IdEmpresaCajaEgresoDetalle() {
		return this.mostrarFK_IdEmpresaCajaEgresoDetalle;
	}

	public void setMostrarFK_IdEmpresaCajaEgresoDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCajaEgresoDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaCajaEgresoDetalle=true;

	public Boolean getMostrarFK_IdFacturaCajaEgresoDetalle() {
		return this.mostrarFK_IdFacturaCajaEgresoDetalle;
	}

	public void setMostrarFK_IdFacturaCajaEgresoDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaCajaEgresoDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCajaEgresoDetalle=true;

	public Boolean getMostrarFK_IdSucursalCajaEgresoDetalle() {
		return this.mostrarFK_IdSucursalCajaEgresoDetalle;
	}

	public void setMostrarFK_IdSucursalCajaEgresoDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCajaEgresoDetalle= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCajaEgresoCajaEgresoDetalle=true;

	public Boolean getActivarFK_IdCajaEgresoCajaEgresoDetalle() {
		return this.activarFK_IdCajaEgresoCajaEgresoDetalle;
	}

	public void setActivarFK_IdCajaEgresoCajaEgresoDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdCajaEgresoCajaEgresoDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteCajaEgresoDetalle=true;

	public Boolean getActivarFK_IdClienteCajaEgresoDetalle() {
		return this.activarFK_IdClienteCajaEgresoDetalle;
	}

	public void setActivarFK_IdClienteCajaEgresoDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdClienteCajaEgresoDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCajaEgresoDetalle=true;

	public Boolean getActivarFK_IdEmpresaCajaEgresoDetalle() {
		return this.activarFK_IdEmpresaCajaEgresoDetalle;
	}

	public void setActivarFK_IdEmpresaCajaEgresoDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCajaEgresoDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaCajaEgresoDetalle=true;

	public Boolean getActivarFK_IdFacturaCajaEgresoDetalle() {
		return this.activarFK_IdFacturaCajaEgresoDetalle;
	}

	public void setActivarFK_IdFacturaCajaEgresoDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaCajaEgresoDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCajaEgresoDetalle=true;

	public Boolean getActivarFK_IdSucursalCajaEgresoDetalle() {
		return this.activarFK_IdSucursalCajaEgresoDetalle;
	}

	public void setActivarFK_IdSucursalCajaEgresoDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCajaEgresoDetalle= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCajaEgresoCajaEgresoDetalle=null;

	public Border getResaltarFK_IdCajaEgresoCajaEgresoDetalle() {
		return this.resaltarFK_IdCajaEgresoCajaEgresoDetalle;
	}

	public void setResaltarFK_IdCajaEgresoCajaEgresoDetalle(Border borderResaltar) {
		this.resaltarFK_IdCajaEgresoCajaEgresoDetalle= borderResaltar;
	}

	public void setResaltarFK_IdCajaEgresoCajaEgresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoDetalleBeanSwingJInternalFrame cajaegresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCajaEgresoCajaEgresoDetalle= borderResaltar;
	}

	public Border resaltarFK_IdClienteCajaEgresoDetalle=null;

	public Border getResaltarFK_IdClienteCajaEgresoDetalle() {
		return this.resaltarFK_IdClienteCajaEgresoDetalle;
	}

	public void setResaltarFK_IdClienteCajaEgresoDetalle(Border borderResaltar) {
		this.resaltarFK_IdClienteCajaEgresoDetalle= borderResaltar;
	}

	public void setResaltarFK_IdClienteCajaEgresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoDetalleBeanSwingJInternalFrame cajaegresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteCajaEgresoDetalle= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCajaEgresoDetalle=null;

	public Border getResaltarFK_IdEmpresaCajaEgresoDetalle() {
		return this.resaltarFK_IdEmpresaCajaEgresoDetalle;
	}

	public void setResaltarFK_IdEmpresaCajaEgresoDetalle(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCajaEgresoDetalle= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCajaEgresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoDetalleBeanSwingJInternalFrame cajaegresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCajaEgresoDetalle= borderResaltar;
	}

	public Border resaltarFK_IdFacturaCajaEgresoDetalle=null;

	public Border getResaltarFK_IdFacturaCajaEgresoDetalle() {
		return this.resaltarFK_IdFacturaCajaEgresoDetalle;
	}

	public void setResaltarFK_IdFacturaCajaEgresoDetalle(Border borderResaltar) {
		this.resaltarFK_IdFacturaCajaEgresoDetalle= borderResaltar;
	}

	public void setResaltarFK_IdFacturaCajaEgresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoDetalleBeanSwingJInternalFrame cajaegresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaCajaEgresoDetalle= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCajaEgresoDetalle=null;

	public Border getResaltarFK_IdSucursalCajaEgresoDetalle() {
		return this.resaltarFK_IdSucursalCajaEgresoDetalle;
	}

	public void setResaltarFK_IdSucursalCajaEgresoDetalle(Border borderResaltar) {
		this.resaltarFK_IdSucursalCajaEgresoDetalle= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCajaEgresoDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*CajaEgresoDetalleBeanSwingJInternalFrame cajaegresodetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCajaEgresoDetalle= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}