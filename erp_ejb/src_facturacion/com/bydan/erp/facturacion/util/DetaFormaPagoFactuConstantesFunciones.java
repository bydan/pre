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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.DetaFormaPagoFactuConstantesFunciones;
import com.bydan.erp.facturacion.util.DetaFormaPagoFactuParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetaFormaPagoFactuParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetaFormaPagoFactuConstantesFunciones extends DetaFormaPagoFactuConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetaFormaPagoFactu";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetaFormaPagoFactu"+DetaFormaPagoFactuConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetaFormaPagoFactuHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetaFormaPagoFactuHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetaFormaPagoFactuConstantesFunciones.SCHEMA+"_"+DetaFormaPagoFactuConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetaFormaPagoFactuHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetaFormaPagoFactuConstantesFunciones.SCHEMA+"_"+DetaFormaPagoFactuConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetaFormaPagoFactuConstantesFunciones.SCHEMA+"_"+DetaFormaPagoFactuConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetaFormaPagoFactuHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetaFormaPagoFactuConstantesFunciones.SCHEMA+"_"+DetaFormaPagoFactuConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetaFormaPagoFactuConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetaFormaPagoFactuHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetaFormaPagoFactuConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetaFormaPagoFactuConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetaFormaPagoFactuHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetaFormaPagoFactuConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetaFormaPagoFactuConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetaFormaPagoFactuConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetaFormaPagoFactuConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetaFormaPagoFactuConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Deta Forma Pago Factus";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Deta Forma Pago Factu";
	public static final String SCLASSWEBTITULO_LOWER="Deta Forma Pago Factu";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetaFormaPagoFactu";
	public static final String OBJECTNAME="detaformapagofactu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="deta_forma_pago_factu";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detaformapagofactu from "+DetaFormaPagoFactuConstantesFunciones.SPERSISTENCENAME+" detaformapagofactu";
	public static String QUERYSELECTNATIVE="select "+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+".id,"+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+".version_row,"+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+".id_empresa,"+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+".id_tipo_forma_pago,"+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+".nombre,"+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+".descripcion from "+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME;//+" as "+DetaFormaPagoFactuConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetaFormaPagoFactuConstantesFuncionesAdditional detaformapagofactuConstantesFuncionesAdditional=null;
	
	public DetaFormaPagoFactuConstantesFuncionesAdditional getDetaFormaPagoFactuConstantesFuncionesAdditional() {
		return this.detaformapagofactuConstantesFuncionesAdditional;
	}
	
	public void setDetaFormaPagoFactuConstantesFuncionesAdditional(DetaFormaPagoFactuConstantesFuncionesAdditional detaformapagofactuConstantesFuncionesAdditional) {
		try {
			this.detaformapagofactuConstantesFuncionesAdditional=detaformapagofactuConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOFORMAPAGO= "id_tipo_forma_pago";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOFORMAPAGO= "Tipo Forma Pago";
		public static final String LABEL_IDTIPOFORMAPAGO_LOWER= "Tipo Forma Pago";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetaFormaPagoFactuLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetaFormaPagoFactuConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetaFormaPagoFactuConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetaFormaPagoFactuConstantesFunciones.IDTIPOFORMAPAGO)) {sLabelColumna=DetaFormaPagoFactuConstantesFunciones.LABEL_IDTIPOFORMAPAGO;}
		if(sNombreColumna.equals(DetaFormaPagoFactuConstantesFunciones.NOMBRE)) {sLabelColumna=DetaFormaPagoFactuConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(DetaFormaPagoFactuConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetaFormaPagoFactuConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getDetaFormaPagoFactuDescripcion(DetaFormaPagoFactu detaformapagofactu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detaformapagofactu !=null/* && detaformapagofactu.getId()!=0*/) {
			sDescripcion=detaformapagofactu.getnombre();//detaformapagofactudetaformapagofactu.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDetaFormaPagoFactuDescripcionDetallado(DetaFormaPagoFactu detaformapagofactu) {
		String sDescripcion="";
			
		sDescripcion+=DetaFormaPagoFactuConstantesFunciones.ID+"=";
		sDescripcion+=detaformapagofactu.getId().toString()+",";
		sDescripcion+=DetaFormaPagoFactuConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detaformapagofactu.getVersionRow().toString()+",";
		sDescripcion+=DetaFormaPagoFactuConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detaformapagofactu.getid_empresa().toString()+",";
		sDescripcion+=DetaFormaPagoFactuConstantesFunciones.IDTIPOFORMAPAGO+"=";
		sDescripcion+=detaformapagofactu.getid_tipo_forma_pago().toString()+",";
		sDescripcion+=DetaFormaPagoFactuConstantesFunciones.NOMBRE+"=";
		sDescripcion+=detaformapagofactu.getnombre()+",";
		sDescripcion+=DetaFormaPagoFactuConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detaformapagofactu.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setDetaFormaPagoFactuDescripcion(DetaFormaPagoFactu detaformapagofactu,String sValor) throws Exception {			
		if(detaformapagofactu !=null) {
			detaformapagofactu.setnombre(sValor);;//detaformapagofactudetaformapagofactu.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoFormaPagoDescripcion(TipoFormaPago tipoformapago) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoformapago!=null/*&&tipoformapago.getId()>0*/) {
			sDescripcion=TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(tipoformapago);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoFormaPago")) {
			sNombreIndice="Tipo=  Por Tipo Forma Pago";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFormaPago(Long id_tipo_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De Tipo Forma Pago="+id_tipo_forma_pago.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetaFormaPagoFactu(DetaFormaPagoFactu detaformapagofactu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detaformapagofactu.setnombre(detaformapagofactu.getnombre().trim());
		detaformapagofactu.setdescripcion(detaformapagofactu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetaFormaPagoFactus(List<DetaFormaPagoFactu> detaformapagofactus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetaFormaPagoFactu detaformapagofactu: detaformapagofactus) {
			detaformapagofactu.setnombre(detaformapagofactu.getnombre().trim());
			detaformapagofactu.setdescripcion(detaformapagofactu.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetaFormaPagoFactu(DetaFormaPagoFactu detaformapagofactu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detaformapagofactu.getConCambioAuxiliar()) {
			detaformapagofactu.setIsDeleted(detaformapagofactu.getIsDeletedAuxiliar());	
			detaformapagofactu.setIsNew(detaformapagofactu.getIsNewAuxiliar());	
			detaformapagofactu.setIsChanged(detaformapagofactu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detaformapagofactu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detaformapagofactu.setIsDeletedAuxiliar(false);	
			detaformapagofactu.setIsNewAuxiliar(false);	
			detaformapagofactu.setIsChangedAuxiliar(false);
			
			detaformapagofactu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetaFormaPagoFactus(List<DetaFormaPagoFactu> detaformapagofactus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetaFormaPagoFactu detaformapagofactu : detaformapagofactus) {
			if(conAsignarBase && detaformapagofactu.getConCambioAuxiliar()) {
				detaformapagofactu.setIsDeleted(detaformapagofactu.getIsDeletedAuxiliar());	
				detaformapagofactu.setIsNew(detaformapagofactu.getIsNewAuxiliar());	
				detaformapagofactu.setIsChanged(detaformapagofactu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detaformapagofactu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detaformapagofactu.setIsDeletedAuxiliar(false);	
				detaformapagofactu.setIsNewAuxiliar(false);	
				detaformapagofactu.setIsChangedAuxiliar(false);
				
				detaformapagofactu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetaFormaPagoFactu(DetaFormaPagoFactu detaformapagofactu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetaFormaPagoFactus(List<DetaFormaPagoFactu> detaformapagofactus,Boolean conEnteros) throws Exception  {
		
		for(DetaFormaPagoFactu detaformapagofactu: detaformapagofactus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetaFormaPagoFactu(List<DetaFormaPagoFactu> detaformapagofactus,DetaFormaPagoFactu detaformapagofactuAux) throws Exception  {
		DetaFormaPagoFactuConstantesFunciones.InicializarValoresDetaFormaPagoFactu(detaformapagofactuAux,true);
		
		for(DetaFormaPagoFactu detaformapagofactu: detaformapagofactus) {
			if(detaformapagofactu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetaFormaPagoFactu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetaFormaPagoFactuConstantesFunciones.getArrayColumnasGlobalesDetaFormaPagoFactu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetaFormaPagoFactu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetaFormaPagoFactuConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetaFormaPagoFactuConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetaFormaPagoFactu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetaFormaPagoFactu> detaformapagofactus,DetaFormaPagoFactu detaformapagofactu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetaFormaPagoFactu detaformapagofactuAux: detaformapagofactus) {
			if(detaformapagofactuAux!=null && detaformapagofactu!=null) {
				if((detaformapagofactuAux.getId()==null && detaformapagofactu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detaformapagofactuAux.getId()!=null && detaformapagofactu.getId()!=null){
					if(detaformapagofactuAux.getId().equals(detaformapagofactu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetaFormaPagoFactu(List<DetaFormaPagoFactu> detaformapagofactus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DetaFormaPagoFactu detaformapagofactu: detaformapagofactus) {			
			if(detaformapagofactu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetaFormaPagoFactu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetaFormaPagoFactuConstantesFunciones.LABEL_ID, DetaFormaPagoFactuConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoFactuConstantesFunciones.LABEL_VERSIONROW, DetaFormaPagoFactuConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoFactuConstantesFunciones.LABEL_IDEMPRESA, DetaFormaPagoFactuConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoFactuConstantesFunciones.LABEL_IDTIPOFORMAPAGO, DetaFormaPagoFactuConstantesFunciones.IDTIPOFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoFactuConstantesFunciones.LABEL_NOMBRE, DetaFormaPagoFactuConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoFactuConstantesFunciones.LABEL_DESCRIPCION, DetaFormaPagoFactuConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetaFormaPagoFactu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoFactuConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoFactuConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoFactuConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoFactuConstantesFunciones.IDTIPOFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoFactuConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoFactuConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetaFormaPagoFactu() throws Exception  {
		return DetaFormaPagoFactuConstantesFunciones.getTiposSeleccionarDetaFormaPagoFactu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetaFormaPagoFactu(Boolean conFk) throws Exception  {
		return DetaFormaPagoFactuConstantesFunciones.getTiposSeleccionarDetaFormaPagoFactu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetaFormaPagoFactu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoFactuConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetaFormaPagoFactuConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoFactuConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
			reporte.setsDescripcion(DetaFormaPagoFactuConstantesFunciones.LABEL_IDTIPOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoFactuConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(DetaFormaPagoFactuConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoFactuConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetaFormaPagoFactuConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetaFormaPagoFactu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetaFormaPagoFactu(DetaFormaPagoFactu detaformapagofactuAux) throws Exception {
		
			detaformapagofactuAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detaformapagofactuAux.getEmpresa()));
			detaformapagofactuAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(detaformapagofactuAux.getTipoFormaPago()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetaFormaPagoFactu(List<DetaFormaPagoFactu> detaformapagofactusTemp) throws Exception {
		for(DetaFormaPagoFactu detaformapagofactuAux:detaformapagofactusTemp) {
			
			detaformapagofactuAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detaformapagofactuAux.getEmpresa()));
			detaformapagofactuAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(detaformapagofactuAux.getTipoFormaPago()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetaFormaPagoFactu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoFormaPago.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFormaPago.class)) {
						classes.add(new Classe(TipoFormaPago.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetaFormaPagoFactu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetaFormaPagoFactu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetaFormaPagoFactuConstantesFunciones.getClassesRelationshipsOfDetaFormaPagoFactu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetaFormaPagoFactu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetaFormaPago.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetaFormaPago.class)) {
						classes.add(new Classe(DetaFormaPago.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetaFormaPagoFactu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetaFormaPagoFactuConstantesFunciones.getClassesRelationshipsFromStringsOfDetaFormaPagoFactu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetaFormaPagoFactu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetaFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaFormaPago.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetaFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaFormaPago.class)); continue;
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
	public static void actualizarLista(DetaFormaPagoFactu detaformapagofactu,List<DetaFormaPagoFactu> detaformapagofactus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetaFormaPagoFactu detaformapagofactuEncontrado=null;
			
			for(DetaFormaPagoFactu detaformapagofactuLocal:detaformapagofactus) {
				if(detaformapagofactuLocal.getId().equals(detaformapagofactu.getId())) {
					detaformapagofactuEncontrado=detaformapagofactuLocal;
					
					detaformapagofactuLocal.setIsChanged(detaformapagofactu.getIsChanged());
					detaformapagofactuLocal.setIsNew(detaformapagofactu.getIsNew());
					detaformapagofactuLocal.setIsDeleted(detaformapagofactu.getIsDeleted());
					
					detaformapagofactuLocal.setGeneralEntityOriginal(detaformapagofactu.getGeneralEntityOriginal());
					
					detaformapagofactuLocal.setId(detaformapagofactu.getId());	
					detaformapagofactuLocal.setVersionRow(detaformapagofactu.getVersionRow());	
					detaformapagofactuLocal.setid_empresa(detaformapagofactu.getid_empresa());	
					detaformapagofactuLocal.setid_tipo_forma_pago(detaformapagofactu.getid_tipo_forma_pago());	
					detaformapagofactuLocal.setnombre(detaformapagofactu.getnombre());	
					detaformapagofactuLocal.setdescripcion(detaformapagofactu.getdescripcion());	
					
					
					detaformapagofactuLocal.setDetaFormaPagos(detaformapagofactu.getDetaFormaPagos());
					
					existe=true;
					break;
				}
			}
			
			if(!detaformapagofactu.getIsDeleted()) {
				if(!existe) {
					detaformapagofactus.add(detaformapagofactu);
				}
			} else {
				if(detaformapagofactuEncontrado!=null && permiteQuitar)  {
					detaformapagofactus.remove(detaformapagofactuEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetaFormaPagoFactu detaformapagofactu,List<DetaFormaPagoFactu> detaformapagofactus) throws Exception {
		try	{			
			for(DetaFormaPagoFactu detaformapagofactuLocal:detaformapagofactus) {
				if(detaformapagofactuLocal.getId().equals(detaformapagofactu.getId())) {
					detaformapagofactuLocal.setIsSelected(detaformapagofactu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetaFormaPagoFactu(List<DetaFormaPagoFactu> detaformapagofactusAux) throws Exception {
		//this.detaformapagofactusAux=detaformapagofactusAux;
		
		for(DetaFormaPagoFactu detaformapagofactuAux:detaformapagofactusAux) {
			if(detaformapagofactuAux.getIsChanged()) {
				detaformapagofactuAux.setIsChanged(false);
			}		
			
			if(detaformapagofactuAux.getIsNew()) {
				detaformapagofactuAux.setIsNew(false);
			}	
			
			if(detaformapagofactuAux.getIsDeleted()) {
				detaformapagofactuAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetaFormaPagoFactu(DetaFormaPagoFactu detaformapagofactuAux) throws Exception {
		//this.detaformapagofactuAux=detaformapagofactuAux;
		
			if(detaformapagofactuAux.getIsChanged()) {
				detaformapagofactuAux.setIsChanged(false);
			}		
			
			if(detaformapagofactuAux.getIsNew()) {
				detaformapagofactuAux.setIsNew(false);
			}	
			
			if(detaformapagofactuAux.getIsDeleted()) {
				detaformapagofactuAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetaFormaPagoFactu detaformapagofactuAsignar,DetaFormaPagoFactu detaformapagofactu) throws Exception {
		detaformapagofactuAsignar.setId(detaformapagofactu.getId());	
		detaformapagofactuAsignar.setVersionRow(detaformapagofactu.getVersionRow());	
		detaformapagofactuAsignar.setid_empresa(detaformapagofactu.getid_empresa());
		detaformapagofactuAsignar.setempresa_descripcion(detaformapagofactu.getempresa_descripcion());	
		detaformapagofactuAsignar.setid_tipo_forma_pago(detaformapagofactu.getid_tipo_forma_pago());
		detaformapagofactuAsignar.settipoformapago_descripcion(detaformapagofactu.gettipoformapago_descripcion());	
		detaformapagofactuAsignar.setnombre(detaformapagofactu.getnombre());	
		detaformapagofactuAsignar.setdescripcion(detaformapagofactu.getdescripcion());	
	}
	
	public static void inicializarDetaFormaPagoFactu(DetaFormaPagoFactu detaformapagofactu) throws Exception {
		try {
				detaformapagofactu.setId(0L);	
					
				detaformapagofactu.setid_empresa(-1L);	
				detaformapagofactu.setid_tipo_forma_pago(-1L);	
				detaformapagofactu.setnombre("");	
				detaformapagofactu.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetaFormaPagoFactu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoFactuConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoFactuConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoFactuConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoFactuConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetaFormaPagoFactu(String sTipo,Row row,Workbook workbook,DetaFormaPagoFactu detaformapagofactu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapagofactu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapagofactu.gettipoformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapagofactu.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapagofactu.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetaFormaPagoFactu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetaFormaPagoFactu() {
		return this.sFinalQueryDetaFormaPagoFactu;
	}
	
	public void setsFinalQueryDetaFormaPagoFactu(String sFinalQueryDetaFormaPagoFactu) {
		this.sFinalQueryDetaFormaPagoFactu= sFinalQueryDetaFormaPagoFactu;
	}
	
	public Border resaltarSeleccionarDetaFormaPagoFactu=null;
	
	public Border setResaltarSeleccionarDetaFormaPagoFactu(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoFactuBeanSwingJInternalFrame detaformapagofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detaformapagofactuBeanSwingJInternalFrame.jTtoolBarDetaFormaPagoFactu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetaFormaPagoFactu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetaFormaPagoFactu() {
		return this.resaltarSeleccionarDetaFormaPagoFactu;
	}
	
	public void setResaltarSeleccionarDetaFormaPagoFactu(Border borderResaltarSeleccionarDetaFormaPagoFactu) {
		this.resaltarSeleccionarDetaFormaPagoFactu= borderResaltarSeleccionarDetaFormaPagoFactu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetaFormaPagoFactu=null;
	public Boolean mostraridDetaFormaPagoFactu=true;
	public Boolean activaridDetaFormaPagoFactu=true;

	public Border resaltarid_empresaDetaFormaPagoFactu=null;
	public Boolean mostrarid_empresaDetaFormaPagoFactu=true;
	public Boolean activarid_empresaDetaFormaPagoFactu=true;
	public Boolean cargarid_empresaDetaFormaPagoFactu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetaFormaPagoFactu=false;//ConEventDepend=true

	public Border resaltarid_tipo_forma_pagoDetaFormaPagoFactu=null;
	public Boolean mostrarid_tipo_forma_pagoDetaFormaPagoFactu=true;
	public Boolean activarid_tipo_forma_pagoDetaFormaPagoFactu=true;
	public Boolean cargarid_tipo_forma_pagoDetaFormaPagoFactu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_forma_pagoDetaFormaPagoFactu=false;//ConEventDepend=true

	public Border resaltarnombreDetaFormaPagoFactu=null;
	public Boolean mostrarnombreDetaFormaPagoFactu=true;
	public Boolean activarnombreDetaFormaPagoFactu=true;

	public Border resaltardescripcionDetaFormaPagoFactu=null;
	public Boolean mostrardescripcionDetaFormaPagoFactu=true;
	public Boolean activardescripcionDetaFormaPagoFactu=true;

	
	

	public Border setResaltaridDetaFormaPagoFactu(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoFactuBeanSwingJInternalFrame detaformapagofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagofactuBeanSwingJInternalFrame.jTtoolBarDetaFormaPagoFactu.setBorder(borderResaltar);
		
		this.resaltaridDetaFormaPagoFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetaFormaPagoFactu() {
		return this.resaltaridDetaFormaPagoFactu;
	}

	public void setResaltaridDetaFormaPagoFactu(Border borderResaltar) {
		this.resaltaridDetaFormaPagoFactu= borderResaltar;
	}

	public Boolean getMostraridDetaFormaPagoFactu() {
		return this.mostraridDetaFormaPagoFactu;
	}

	public void setMostraridDetaFormaPagoFactu(Boolean mostraridDetaFormaPagoFactu) {
		this.mostraridDetaFormaPagoFactu= mostraridDetaFormaPagoFactu;
	}

	public Boolean getActivaridDetaFormaPagoFactu() {
		return this.activaridDetaFormaPagoFactu;
	}

	public void setActivaridDetaFormaPagoFactu(Boolean activaridDetaFormaPagoFactu) {
		this.activaridDetaFormaPagoFactu= activaridDetaFormaPagoFactu;
	}

	public Border setResaltarid_empresaDetaFormaPagoFactu(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoFactuBeanSwingJInternalFrame detaformapagofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagofactuBeanSwingJInternalFrame.jTtoolBarDetaFormaPagoFactu.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetaFormaPagoFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetaFormaPagoFactu() {
		return this.resaltarid_empresaDetaFormaPagoFactu;
	}

	public void setResaltarid_empresaDetaFormaPagoFactu(Border borderResaltar) {
		this.resaltarid_empresaDetaFormaPagoFactu= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetaFormaPagoFactu() {
		return this.mostrarid_empresaDetaFormaPagoFactu;
	}

	public void setMostrarid_empresaDetaFormaPagoFactu(Boolean mostrarid_empresaDetaFormaPagoFactu) {
		this.mostrarid_empresaDetaFormaPagoFactu= mostrarid_empresaDetaFormaPagoFactu;
	}

	public Boolean getActivarid_empresaDetaFormaPagoFactu() {
		return this.activarid_empresaDetaFormaPagoFactu;
	}

	public void setActivarid_empresaDetaFormaPagoFactu(Boolean activarid_empresaDetaFormaPagoFactu) {
		this.activarid_empresaDetaFormaPagoFactu= activarid_empresaDetaFormaPagoFactu;
	}

	public Boolean getCargarid_empresaDetaFormaPagoFactu() {
		return this.cargarid_empresaDetaFormaPagoFactu;
	}

	public void setCargarid_empresaDetaFormaPagoFactu(Boolean cargarid_empresaDetaFormaPagoFactu) {
		this.cargarid_empresaDetaFormaPagoFactu= cargarid_empresaDetaFormaPagoFactu;
	}

	public Border setResaltarid_tipo_forma_pagoDetaFormaPagoFactu(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoFactuBeanSwingJInternalFrame detaformapagofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagofactuBeanSwingJInternalFrame.jTtoolBarDetaFormaPagoFactu.setBorder(borderResaltar);
		
		this.resaltarid_tipo_forma_pagoDetaFormaPagoFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_forma_pagoDetaFormaPagoFactu() {
		return this.resaltarid_tipo_forma_pagoDetaFormaPagoFactu;
	}

	public void setResaltarid_tipo_forma_pagoDetaFormaPagoFactu(Border borderResaltar) {
		this.resaltarid_tipo_forma_pagoDetaFormaPagoFactu= borderResaltar;
	}

	public Boolean getMostrarid_tipo_forma_pagoDetaFormaPagoFactu() {
		return this.mostrarid_tipo_forma_pagoDetaFormaPagoFactu;
	}

	public void setMostrarid_tipo_forma_pagoDetaFormaPagoFactu(Boolean mostrarid_tipo_forma_pagoDetaFormaPagoFactu) {
		this.mostrarid_tipo_forma_pagoDetaFormaPagoFactu= mostrarid_tipo_forma_pagoDetaFormaPagoFactu;
	}

	public Boolean getActivarid_tipo_forma_pagoDetaFormaPagoFactu() {
		return this.activarid_tipo_forma_pagoDetaFormaPagoFactu;
	}

	public void setActivarid_tipo_forma_pagoDetaFormaPagoFactu(Boolean activarid_tipo_forma_pagoDetaFormaPagoFactu) {
		this.activarid_tipo_forma_pagoDetaFormaPagoFactu= activarid_tipo_forma_pagoDetaFormaPagoFactu;
	}

	public Boolean getCargarid_tipo_forma_pagoDetaFormaPagoFactu() {
		return this.cargarid_tipo_forma_pagoDetaFormaPagoFactu;
	}

	public void setCargarid_tipo_forma_pagoDetaFormaPagoFactu(Boolean cargarid_tipo_forma_pagoDetaFormaPagoFactu) {
		this.cargarid_tipo_forma_pagoDetaFormaPagoFactu= cargarid_tipo_forma_pagoDetaFormaPagoFactu;
	}

	public Border setResaltarnombreDetaFormaPagoFactu(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoFactuBeanSwingJInternalFrame detaformapagofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagofactuBeanSwingJInternalFrame.jTtoolBarDetaFormaPagoFactu.setBorder(borderResaltar);
		
		this.resaltarnombreDetaFormaPagoFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreDetaFormaPagoFactu() {
		return this.resaltarnombreDetaFormaPagoFactu;
	}

	public void setResaltarnombreDetaFormaPagoFactu(Border borderResaltar) {
		this.resaltarnombreDetaFormaPagoFactu= borderResaltar;
	}

	public Boolean getMostrarnombreDetaFormaPagoFactu() {
		return this.mostrarnombreDetaFormaPagoFactu;
	}

	public void setMostrarnombreDetaFormaPagoFactu(Boolean mostrarnombreDetaFormaPagoFactu) {
		this.mostrarnombreDetaFormaPagoFactu= mostrarnombreDetaFormaPagoFactu;
	}

	public Boolean getActivarnombreDetaFormaPagoFactu() {
		return this.activarnombreDetaFormaPagoFactu;
	}

	public void setActivarnombreDetaFormaPagoFactu(Boolean activarnombreDetaFormaPagoFactu) {
		this.activarnombreDetaFormaPagoFactu= activarnombreDetaFormaPagoFactu;
	}

	public Border setResaltardescripcionDetaFormaPagoFactu(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoFactuBeanSwingJInternalFrame detaformapagofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagofactuBeanSwingJInternalFrame.jTtoolBarDetaFormaPagoFactu.setBorder(borderResaltar);
		
		this.resaltardescripcionDetaFormaPagoFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetaFormaPagoFactu() {
		return this.resaltardescripcionDetaFormaPagoFactu;
	}

	public void setResaltardescripcionDetaFormaPagoFactu(Border borderResaltar) {
		this.resaltardescripcionDetaFormaPagoFactu= borderResaltar;
	}

	public Boolean getMostrardescripcionDetaFormaPagoFactu() {
		return this.mostrardescripcionDetaFormaPagoFactu;
	}

	public void setMostrardescripcionDetaFormaPagoFactu(Boolean mostrardescripcionDetaFormaPagoFactu) {
		this.mostrardescripcionDetaFormaPagoFactu= mostrardescripcionDetaFormaPagoFactu;
	}

	public Boolean getActivardescripcionDetaFormaPagoFactu() {
		return this.activardescripcionDetaFormaPagoFactu;
	}

	public void setActivardescripcionDetaFormaPagoFactu(Boolean activardescripcionDetaFormaPagoFactu) {
		this.activardescripcionDetaFormaPagoFactu= activardescripcionDetaFormaPagoFactu;
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
		
		
		this.setMostraridDetaFormaPagoFactu(esInicial);
		this.setMostrarid_empresaDetaFormaPagoFactu(esInicial);
		this.setMostrarid_tipo_forma_pagoDetaFormaPagoFactu(esInicial);
		this.setMostrarnombreDetaFormaPagoFactu(esInicial);
		this.setMostrardescripcionDetaFormaPagoFactu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetaFormaPagoFactuConstantesFunciones.ID)) {
				this.setMostraridDetaFormaPagoFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoFactuConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetaFormaPagoFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoFactuConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setMostrarid_tipo_forma_pagoDetaFormaPagoFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoFactuConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreDetaFormaPagoFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoFactuConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetaFormaPagoFactu(esAsigna);
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
		
		
		this.setActivaridDetaFormaPagoFactu(esInicial);
		this.setActivarid_empresaDetaFormaPagoFactu(esInicial);
		this.setActivarid_tipo_forma_pagoDetaFormaPagoFactu(esInicial);
		this.setActivarnombreDetaFormaPagoFactu(esInicial);
		this.setActivardescripcionDetaFormaPagoFactu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetaFormaPagoFactuConstantesFunciones.ID)) {
				this.setActivaridDetaFormaPagoFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoFactuConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetaFormaPagoFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoFactuConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setActivarid_tipo_forma_pagoDetaFormaPagoFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoFactuConstantesFunciones.NOMBRE)) {
				this.setActivarnombreDetaFormaPagoFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoFactuConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetaFormaPagoFactu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetaFormaPagoFactuBeanSwingJInternalFrame detaformapagofactuBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetaFormaPagoFactu(esInicial);
		this.setResaltarid_empresaDetaFormaPagoFactu(esInicial);
		this.setResaltarid_tipo_forma_pagoDetaFormaPagoFactu(esInicial);
		this.setResaltarnombreDetaFormaPagoFactu(esInicial);
		this.setResaltardescripcionDetaFormaPagoFactu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetaFormaPagoFactuConstantesFunciones.ID)) {
				this.setResaltaridDetaFormaPagoFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoFactuConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetaFormaPagoFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoFactuConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setResaltarid_tipo_forma_pagoDetaFormaPagoFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoFactuConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreDetaFormaPagoFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoFactuConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetaFormaPagoFactu(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetaFormaPagoDetaFormaPagoFactu=null;

	public Border getResaltarDetaFormaPagoDetaFormaPagoFactu() {
		return this.resaltarDetaFormaPagoDetaFormaPagoFactu;
	}

	public void setResaltarDetaFormaPagoDetaFormaPagoFactu(Border borderResaltarDetaFormaPago) {
		if(borderResaltarDetaFormaPago!=null) {
			this.resaltarDetaFormaPagoDetaFormaPagoFactu= borderResaltarDetaFormaPago;
		}
	}

	public Border setResaltarDetaFormaPagoDetaFormaPagoFactu(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoFactuBeanSwingJInternalFrame detaformapagofactuBeanSwingJInternalFrame*/) {
		Border borderResaltarDetaFormaPago=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detaformapagofactuBeanSwingJInternalFrame.jTtoolBarDetaFormaPagoFactu.setBorder(borderResaltarDetaFormaPago);
			
		this.resaltarDetaFormaPagoDetaFormaPagoFactu= borderResaltarDetaFormaPago;

		 return borderResaltarDetaFormaPago;
	}



	public Boolean mostrarDetaFormaPagoDetaFormaPagoFactu=true;

	public Boolean getMostrarDetaFormaPagoDetaFormaPagoFactu() {
		return this.mostrarDetaFormaPagoDetaFormaPagoFactu;
	}

	public void setMostrarDetaFormaPagoDetaFormaPagoFactu(Boolean visibilidadResaltarDetaFormaPago) {
		this.mostrarDetaFormaPagoDetaFormaPagoFactu= visibilidadResaltarDetaFormaPago;
	}



	public Boolean activarDetaFormaPagoDetaFormaPagoFactu=true;

	public Boolean gethabilitarResaltarDetaFormaPagoDetaFormaPagoFactu() {
		return this.activarDetaFormaPagoDetaFormaPagoFactu;
	}

	public void setActivarDetaFormaPagoDetaFormaPagoFactu(Boolean habilitarResaltarDetaFormaPago) {
		this.activarDetaFormaPagoDetaFormaPagoFactu= habilitarResaltarDetaFormaPago;
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

		this.setMostrarDetaFormaPagoDetaFormaPagoFactu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetaFormaPago.class)) {
				this.setMostrarDetaFormaPagoDetaFormaPagoFactu(esAsigna);
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

		this.setActivarDetaFormaPagoDetaFormaPagoFactu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetaFormaPago.class)) {
				this.setActivarDetaFormaPagoDetaFormaPagoFactu(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetaFormaPagoFactuBeanSwingJInternalFrame detaformapagofactuBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetaFormaPagoDetaFormaPagoFactu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetaFormaPago.class)) {
				this.setResaltarDetaFormaPagoDetaFormaPagoFactu(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombreDetaFormaPagoFactu=true;

	public Boolean getMostrarBusquedaPorNombreDetaFormaPagoFactu() {
		return this.mostrarBusquedaPorNombreDetaFormaPagoFactu;
	}

	public void setMostrarBusquedaPorNombreDetaFormaPagoFactu(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreDetaFormaPagoFactu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetaFormaPagoFactu=true;

	public Boolean getMostrarFK_IdEmpresaDetaFormaPagoFactu() {
		return this.mostrarFK_IdEmpresaDetaFormaPagoFactu;
	}

	public void setMostrarFK_IdEmpresaDetaFormaPagoFactu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetaFormaPagoFactu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFormaPagoDetaFormaPagoFactu=true;

	public Boolean getMostrarFK_IdTipoFormaPagoDetaFormaPagoFactu() {
		return this.mostrarFK_IdTipoFormaPagoDetaFormaPagoFactu;
	}

	public void setMostrarFK_IdTipoFormaPagoDetaFormaPagoFactu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFormaPagoDetaFormaPagoFactu= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreDetaFormaPagoFactu=true;

	public Boolean getActivarBusquedaPorNombreDetaFormaPagoFactu() {
		return this.activarBusquedaPorNombreDetaFormaPagoFactu;
	}

	public void setActivarBusquedaPorNombreDetaFormaPagoFactu(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreDetaFormaPagoFactu= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetaFormaPagoFactu=true;

	public Boolean getActivarFK_IdEmpresaDetaFormaPagoFactu() {
		return this.activarFK_IdEmpresaDetaFormaPagoFactu;
	}

	public void setActivarFK_IdEmpresaDetaFormaPagoFactu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetaFormaPagoFactu= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFormaPagoDetaFormaPagoFactu=true;

	public Boolean getActivarFK_IdTipoFormaPagoDetaFormaPagoFactu() {
		return this.activarFK_IdTipoFormaPagoDetaFormaPagoFactu;
	}

	public void setActivarFK_IdTipoFormaPagoDetaFormaPagoFactu(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFormaPagoDetaFormaPagoFactu= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreDetaFormaPagoFactu=null;

	public Border getResaltarBusquedaPorNombreDetaFormaPagoFactu() {
		return this.resaltarBusquedaPorNombreDetaFormaPagoFactu;
	}

	public void setResaltarBusquedaPorNombreDetaFormaPagoFactu(Border borderResaltar) {
		this.resaltarBusquedaPorNombreDetaFormaPagoFactu= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreDetaFormaPagoFactu(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoFactuBeanSwingJInternalFrame detaformapagofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreDetaFormaPagoFactu= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetaFormaPagoFactu=null;

	public Border getResaltarFK_IdEmpresaDetaFormaPagoFactu() {
		return this.resaltarFK_IdEmpresaDetaFormaPagoFactu;
	}

	public void setResaltarFK_IdEmpresaDetaFormaPagoFactu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetaFormaPagoFactu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetaFormaPagoFactu(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoFactuBeanSwingJInternalFrame detaformapagofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetaFormaPagoFactu= borderResaltar;
	}

	public Border resaltarFK_IdTipoFormaPagoDetaFormaPagoFactu=null;

	public Border getResaltarFK_IdTipoFormaPagoDetaFormaPagoFactu() {
		return this.resaltarFK_IdTipoFormaPagoDetaFormaPagoFactu;
	}

	public void setResaltarFK_IdTipoFormaPagoDetaFormaPagoFactu(Border borderResaltar) {
		this.resaltarFK_IdTipoFormaPagoDetaFormaPagoFactu= borderResaltar;
	}

	public void setResaltarFK_IdTipoFormaPagoDetaFormaPagoFactu(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoFactuBeanSwingJInternalFrame detaformapagofactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFormaPagoDetaFormaPagoFactu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}