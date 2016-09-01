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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.TipoPrestamoConstantesFunciones;
import com.bydan.erp.nomina.util.TipoPrestamoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoPrestamoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoPrestamoConstantesFunciones extends TipoPrestamoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoPrestamo";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoPrestamo"+TipoPrestamoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoPrestamoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoPrestamoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoPrestamoConstantesFunciones.SCHEMA+"_"+TipoPrestamoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoPrestamoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoPrestamoConstantesFunciones.SCHEMA+"_"+TipoPrestamoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoPrestamoConstantesFunciones.SCHEMA+"_"+TipoPrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoPrestamoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoPrestamoConstantesFunciones.SCHEMA+"_"+TipoPrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPrestamoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPrestamoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoPrestamoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoPrestamoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoPrestamoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoPrestamoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Prestamos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Prestamo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Prestamo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoPrestamo";
	public static final String OBJECTNAME="tipoprestamo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_prestamo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoprestamo from "+TipoPrestamoConstantesFunciones.SPERSISTENCENAME+" tipoprestamo";
	public static String QUERYSELECTNATIVE="select "+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".id,"+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".version_row,"+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".id_empresa,"+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".id_rubro_emplea,"+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".codigo,"+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".nombre,"+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".con_pago from "+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME;//+" as "+TipoPrestamoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoPrestamoConstantesFuncionesAdditional tipoprestamoConstantesFuncionesAdditional=null;
	
	public TipoPrestamoConstantesFuncionesAdditional getTipoPrestamoConstantesFuncionesAdditional() {
		return this.tipoprestamoConstantesFuncionesAdditional;
	}
	
	public void setTipoPrestamoConstantesFuncionesAdditional(TipoPrestamoConstantesFuncionesAdditional tipoprestamoConstantesFuncionesAdditional) {
		try {
			this.tipoprestamoConstantesFuncionesAdditional=tipoprestamoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDRUBROEMPLEA= "id_rubro_emplea";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String CONPAGO= "con_pago";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDRUBROEMPLEA= "Idrubro Emplea";
		public static final String LABEL_IDRUBROEMPLEA_LOWER= "Rubro Emplea";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_CONPAGO= "Con Pago";
		public static final String LABEL_CONPAGO_LOWER= "Con Pago";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getTipoPrestamoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoPrestamoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoPrestamoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoPrestamoConstantesFunciones.IDRUBROEMPLEA)) {sLabelColumna=TipoPrestamoConstantesFunciones.LABEL_IDRUBROEMPLEA;}
		if(sNombreColumna.equals(TipoPrestamoConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=TipoPrestamoConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(TipoPrestamoConstantesFunciones.CODIGO)) {sLabelColumna=TipoPrestamoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoPrestamoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoPrestamoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoPrestamoConstantesFunciones.CONPAGO)) {sLabelColumna=TipoPrestamoConstantesFunciones.LABEL_CONPAGO;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String getcon_pagoDescripcion(TipoPrestamo tipoprestamo) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tipoprestamo.getcon_pago()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_pagoHtmlDescripcion(TipoPrestamo tipoprestamo) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tipoprestamo.getId(),tipoprestamo.getcon_pago());

		return sDescripcion;
	}	
	
	public static String getTipoPrestamoDescripcion(TipoPrestamo tipoprestamo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoprestamo !=null/* && tipoprestamo.getId()!=0*/) {
			sDescripcion=tipoprestamo.getcodigo();//tipoprestamotipoprestamo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoPrestamoDescripcionDetallado(TipoPrestamo tipoprestamo) {
		String sDescripcion="";
			
		sDescripcion+=TipoPrestamoConstantesFunciones.ID+"=";
		sDescripcion+=tipoprestamo.getId().toString()+",";
		sDescripcion+=TipoPrestamoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoprestamo.getVersionRow().toString()+",";
		sDescripcion+=TipoPrestamoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoprestamo.getid_empresa().toString()+",";
		sDescripcion+=TipoPrestamoConstantesFunciones.IDRUBROEMPLEA+"=";
		sDescripcion+=tipoprestamo.getid_rubro_emplea().toString()+",";
		sDescripcion+=TipoPrestamoConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=tipoprestamo.getid_cuenta_contable().toString()+",";
		sDescripcion+=TipoPrestamoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoprestamo.getcodigo()+",";
		sDescripcion+=TipoPrestamoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoprestamo.getnombre()+",";
		sDescripcion+=TipoPrestamoConstantesFunciones.CONPAGO+"=";
		sDescripcion+=tipoprestamo.getcon_pago().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoPrestamoDescripcion(TipoPrestamo tipoprestamo,String sValor) throws Exception {			
		if(tipoprestamo !=null) {
			tipoprestamo.setcodigo(sValor);;//tipoprestamotipoprestamo.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getRubroEmpleaDescripcion(RubroEmplea rubroemplea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(rubroemplea!=null/*&&rubroemplea.getId()>0*/) {
			sDescripcion=RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(rubroemplea);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoPrestamo")) {
			sNombreIndice="Tipo=  Por Idrubro Emplea";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPrestamo(Long id_rubro_emplea) {
		String sDetalleIndice=" Parametros->";
		if(id_rubro_emplea!=null) {sDetalleIndice+=" Codigo Unico De Idrubro Emplea="+id_rubro_emplea.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoPrestamo(TipoPrestamo tipoprestamo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoprestamo.setcodigo(tipoprestamo.getcodigo().trim());
		tipoprestamo.setnombre(tipoprestamo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoPrestamos(List<TipoPrestamo> tipoprestamos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoPrestamo tipoprestamo: tipoprestamos) {
			tipoprestamo.setcodigo(tipoprestamo.getcodigo().trim());
			tipoprestamo.setnombre(tipoprestamo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPrestamo(TipoPrestamo tipoprestamo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoprestamo.getConCambioAuxiliar()) {
			tipoprestamo.setIsDeleted(tipoprestamo.getIsDeletedAuxiliar());	
			tipoprestamo.setIsNew(tipoprestamo.getIsNewAuxiliar());	
			tipoprestamo.setIsChanged(tipoprestamo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoprestamo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoprestamo.setIsDeletedAuxiliar(false);	
			tipoprestamo.setIsNewAuxiliar(false);	
			tipoprestamo.setIsChangedAuxiliar(false);
			
			tipoprestamo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPrestamos(List<TipoPrestamo> tipoprestamos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoPrestamo tipoprestamo : tipoprestamos) {
			if(conAsignarBase && tipoprestamo.getConCambioAuxiliar()) {
				tipoprestamo.setIsDeleted(tipoprestamo.getIsDeletedAuxiliar());	
				tipoprestamo.setIsNew(tipoprestamo.getIsNewAuxiliar());	
				tipoprestamo.setIsChanged(tipoprestamo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoprestamo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoprestamo.setIsDeletedAuxiliar(false);	
				tipoprestamo.setIsNewAuxiliar(false);	
				tipoprestamo.setIsChangedAuxiliar(false);
				
				tipoprestamo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoPrestamo(TipoPrestamo tipoprestamo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoPrestamos(List<TipoPrestamo> tipoprestamos,Boolean conEnteros) throws Exception  {
		
		for(TipoPrestamo tipoprestamo: tipoprestamos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoPrestamo(List<TipoPrestamo> tipoprestamos,TipoPrestamo tipoprestamoAux) throws Exception  {
		TipoPrestamoConstantesFunciones.InicializarValoresTipoPrestamo(tipoprestamoAux,true);
		
		for(TipoPrestamo tipoprestamo: tipoprestamos) {
			if(tipoprestamo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPrestamo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoPrestamoConstantesFunciones.getArrayColumnasGlobalesTipoPrestamo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPrestamo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoPrestamoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoPrestamoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoPrestamo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoPrestamo> tipoprestamos,TipoPrestamo tipoprestamo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoPrestamo tipoprestamoAux: tipoprestamos) {
			if(tipoprestamoAux!=null && tipoprestamo!=null) {
				if((tipoprestamoAux.getId()==null && tipoprestamo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoprestamoAux.getId()!=null && tipoprestamo.getId()!=null){
					if(tipoprestamoAux.getId().equals(tipoprestamo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoPrestamo(List<TipoPrestamo> tipoprestamos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoPrestamo tipoprestamo: tipoprestamos) {			
			if(tipoprestamo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoPrestamo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoPrestamoConstantesFunciones.LABEL_ID, TipoPrestamoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrestamoConstantesFunciones.LABEL_VERSIONROW, TipoPrestamoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrestamoConstantesFunciones.LABEL_IDEMPRESA, TipoPrestamoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrestamoConstantesFunciones.LABEL_IDRUBROEMPLEA, TipoPrestamoConstantesFunciones.IDRUBROEMPLEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrestamoConstantesFunciones.LABEL_IDCUENTACONTABLE, TipoPrestamoConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrestamoConstantesFunciones.LABEL_CODIGO, TipoPrestamoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrestamoConstantesFunciones.LABEL_NOMBRE, TipoPrestamoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPrestamoConstantesFunciones.LABEL_CONPAGO, TipoPrestamoConstantesFunciones.CONPAGO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoPrestamo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoPrestamoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrestamoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrestamoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrestamoConstantesFunciones.IDRUBROEMPLEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrestamoConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrestamoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrestamoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPrestamoConstantesFunciones.CONPAGO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPrestamo() throws Exception  {
		return TipoPrestamoConstantesFunciones.getTiposSeleccionarTipoPrestamo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPrestamo(Boolean conFk) throws Exception  {
		return TipoPrestamoConstantesFunciones.getTiposSeleccionarTipoPrestamo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPrestamo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrestamoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoPrestamoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrestamoConstantesFunciones.LABEL_IDRUBROEMPLEA);
			reporte.setsDescripcion(TipoPrestamoConstantesFunciones.LABEL_IDRUBROEMPLEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrestamoConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(TipoPrestamoConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrestamoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoPrestamoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrestamoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoPrestamoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPrestamoConstantesFunciones.LABEL_CONPAGO);
			reporte.setsDescripcion(TipoPrestamoConstantesFunciones.LABEL_CONPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoPrestamo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPrestamo(TipoPrestamo tipoprestamoAux) throws Exception {
		
			tipoprestamoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoprestamoAux.getEmpresa()));
			tipoprestamoAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(tipoprestamoAux.getRubroEmplea()));
			tipoprestamoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipoprestamoAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPrestamo(List<TipoPrestamo> tipoprestamosTemp) throws Exception {
		for(TipoPrestamo tipoprestamoAux:tipoprestamosTemp) {
			
			tipoprestamoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoprestamoAux.getEmpresa()));
			tipoprestamoAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(tipoprestamoAux.getRubroEmplea()));
			tipoprestamoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipoprestamoAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPrestamo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(RubroEmplea.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RubroEmplea.class)) {
						classes.add(new Classe(RubroEmplea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoPrestamo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPrestamo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPrestamoConstantesFunciones.getClassesRelationshipsOfTipoPrestamo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPrestamo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Prestamo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Prestamo.class)) {
						classes.add(new Classe(Prestamo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPrestamo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPrestamoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoPrestamo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPrestamo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Prestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Prestamo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Prestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Prestamo.class)); continue;
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
	public static void actualizarLista(TipoPrestamo tipoprestamo,List<TipoPrestamo> tipoprestamos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoPrestamo tipoprestamoEncontrado=null;
			
			for(TipoPrestamo tipoprestamoLocal:tipoprestamos) {
				if(tipoprestamoLocal.getId().equals(tipoprestamo.getId())) {
					tipoprestamoEncontrado=tipoprestamoLocal;
					
					tipoprestamoLocal.setIsChanged(tipoprestamo.getIsChanged());
					tipoprestamoLocal.setIsNew(tipoprestamo.getIsNew());
					tipoprestamoLocal.setIsDeleted(tipoprestamo.getIsDeleted());
					
					tipoprestamoLocal.setGeneralEntityOriginal(tipoprestamo.getGeneralEntityOriginal());
					
					tipoprestamoLocal.setId(tipoprestamo.getId());	
					tipoprestamoLocal.setVersionRow(tipoprestamo.getVersionRow());	
					tipoprestamoLocal.setid_empresa(tipoprestamo.getid_empresa());	
					tipoprestamoLocal.setid_rubro_emplea(tipoprestamo.getid_rubro_emplea());	
					tipoprestamoLocal.setid_cuenta_contable(tipoprestamo.getid_cuenta_contable());	
					tipoprestamoLocal.setcodigo(tipoprestamo.getcodigo());	
					tipoprestamoLocal.setnombre(tipoprestamo.getnombre());	
					tipoprestamoLocal.setcon_pago(tipoprestamo.getcon_pago());	
					
					
					tipoprestamoLocal.setPrestamos(tipoprestamo.getPrestamos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoprestamo.getIsDeleted()) {
				if(!existe) {
					tipoprestamos.add(tipoprestamo);
				}
			} else {
				if(tipoprestamoEncontrado!=null && permiteQuitar)  {
					tipoprestamos.remove(tipoprestamoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoPrestamo tipoprestamo,List<TipoPrestamo> tipoprestamos) throws Exception {
		try	{			
			for(TipoPrestamo tipoprestamoLocal:tipoprestamos) {
				if(tipoprestamoLocal.getId().equals(tipoprestamo.getId())) {
					tipoprestamoLocal.setIsSelected(tipoprestamo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoPrestamo(List<TipoPrestamo> tipoprestamosAux) throws Exception {
		//this.tipoprestamosAux=tipoprestamosAux;
		
		for(TipoPrestamo tipoprestamoAux:tipoprestamosAux) {
			if(tipoprestamoAux.getIsChanged()) {
				tipoprestamoAux.setIsChanged(false);
			}		
			
			if(tipoprestamoAux.getIsNew()) {
				tipoprestamoAux.setIsNew(false);
			}	
			
			if(tipoprestamoAux.getIsDeleted()) {
				tipoprestamoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoPrestamo(TipoPrestamo tipoprestamoAux) throws Exception {
		//this.tipoprestamoAux=tipoprestamoAux;
		
			if(tipoprestamoAux.getIsChanged()) {
				tipoprestamoAux.setIsChanged(false);
			}		
			
			if(tipoprestamoAux.getIsNew()) {
				tipoprestamoAux.setIsNew(false);
			}	
			
			if(tipoprestamoAux.getIsDeleted()) {
				tipoprestamoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoPrestamo tipoprestamoAsignar,TipoPrestamo tipoprestamo) throws Exception {
		tipoprestamoAsignar.setId(tipoprestamo.getId());	
		tipoprestamoAsignar.setVersionRow(tipoprestamo.getVersionRow());	
		tipoprestamoAsignar.setid_empresa(tipoprestamo.getid_empresa());
		tipoprestamoAsignar.setempresa_descripcion(tipoprestamo.getempresa_descripcion());	
		tipoprestamoAsignar.setid_rubro_emplea(tipoprestamo.getid_rubro_emplea());
		tipoprestamoAsignar.setrubroemplea_descripcion(tipoprestamo.getrubroemplea_descripcion());	
		tipoprestamoAsignar.setid_cuenta_contable(tipoprestamo.getid_cuenta_contable());
		tipoprestamoAsignar.setcuentacontable_descripcion(tipoprestamo.getcuentacontable_descripcion());	
		tipoprestamoAsignar.setcodigo(tipoprestamo.getcodigo());	
		tipoprestamoAsignar.setnombre(tipoprestamo.getnombre());	
		tipoprestamoAsignar.setcon_pago(tipoprestamo.getcon_pago());	
	}
	
	public static void inicializarTipoPrestamo(TipoPrestamo tipoprestamo) throws Exception {
		try {
				tipoprestamo.setId(0L);	
					
				tipoprestamo.setid_empresa(-1L);	
				tipoprestamo.setid_rubro_emplea(-1L);	
				tipoprestamo.setid_cuenta_contable(-1L);	
				tipoprestamo.setcodigo("");	
				tipoprestamo.setnombre("");	
				tipoprestamo.setcon_pago(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoPrestamo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrestamoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrestamoConstantesFunciones.LABEL_IDRUBROEMPLEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrestamoConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrestamoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrestamoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPrestamoConstantesFunciones.LABEL_CONPAGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoPrestamo(String sTipo,Row row,Workbook workbook,TipoPrestamo tipoprestamo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprestamo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprestamo.getrubroemplea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprestamo.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprestamo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprestamo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tipoprestamo.getcon_pago()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoPrestamo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoPrestamo() {
		return this.sFinalQueryTipoPrestamo;
	}
	
	public void setsFinalQueryTipoPrestamo(String sFinalQueryTipoPrestamo) {
		this.sFinalQueryTipoPrestamo= sFinalQueryTipoPrestamo;
	}
	
	public Border resaltarSeleccionarTipoPrestamo=null;
	
	public Border setResaltarSeleccionarTipoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrestamoBeanSwingJInternalFrame tipoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoprestamoBeanSwingJInternalFrame.jTtoolBarTipoPrestamo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoPrestamo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoPrestamo() {
		return this.resaltarSeleccionarTipoPrestamo;
	}
	
	public void setResaltarSeleccionarTipoPrestamo(Border borderResaltarSeleccionarTipoPrestamo) {
		this.resaltarSeleccionarTipoPrestamo= borderResaltarSeleccionarTipoPrestamo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoPrestamo=null;
	public Boolean mostraridTipoPrestamo=true;
	public Boolean activaridTipoPrestamo=true;

	public Border resaltarid_empresaTipoPrestamo=null;
	public Boolean mostrarid_empresaTipoPrestamo=true;
	public Boolean activarid_empresaTipoPrestamo=true;
	public Boolean cargarid_empresaTipoPrestamo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoPrestamo=false;//ConEventDepend=true

	public Border resaltarid_rubro_empleaTipoPrestamo=null;
	public Boolean mostrarid_rubro_empleaTipoPrestamo=true;
	public Boolean activarid_rubro_empleaTipoPrestamo=true;
	public Boolean cargarid_rubro_empleaTipoPrestamo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_rubro_empleaTipoPrestamo=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableTipoPrestamo=null;
	public Boolean mostrarid_cuenta_contableTipoPrestamo=true;
	public Boolean activarid_cuenta_contableTipoPrestamo=true;
	public Boolean cargarid_cuenta_contableTipoPrestamo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableTipoPrestamo=false;//ConEventDepend=true

	public Border resaltarcodigoTipoPrestamo=null;
	public Boolean mostrarcodigoTipoPrestamo=true;
	public Boolean activarcodigoTipoPrestamo=true;

	public Border resaltarnombreTipoPrestamo=null;
	public Boolean mostrarnombreTipoPrestamo=true;
	public Boolean activarnombreTipoPrestamo=true;

	public Border resaltarcon_pagoTipoPrestamo=null;
	public Boolean mostrarcon_pagoTipoPrestamo=true;
	public Boolean activarcon_pagoTipoPrestamo=true;

	
	

	public Border setResaltaridTipoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrestamoBeanSwingJInternalFrame tipoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprestamoBeanSwingJInternalFrame.jTtoolBarTipoPrestamo.setBorder(borderResaltar);
		
		this.resaltaridTipoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoPrestamo() {
		return this.resaltaridTipoPrestamo;
	}

	public void setResaltaridTipoPrestamo(Border borderResaltar) {
		this.resaltaridTipoPrestamo= borderResaltar;
	}

	public Boolean getMostraridTipoPrestamo() {
		return this.mostraridTipoPrestamo;
	}

	public void setMostraridTipoPrestamo(Boolean mostraridTipoPrestamo) {
		this.mostraridTipoPrestamo= mostraridTipoPrestamo;
	}

	public Boolean getActivaridTipoPrestamo() {
		return this.activaridTipoPrestamo;
	}

	public void setActivaridTipoPrestamo(Boolean activaridTipoPrestamo) {
		this.activaridTipoPrestamo= activaridTipoPrestamo;
	}

	public Border setResaltarid_empresaTipoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrestamoBeanSwingJInternalFrame tipoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprestamoBeanSwingJInternalFrame.jTtoolBarTipoPrestamo.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoPrestamo() {
		return this.resaltarid_empresaTipoPrestamo;
	}

	public void setResaltarid_empresaTipoPrestamo(Border borderResaltar) {
		this.resaltarid_empresaTipoPrestamo= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoPrestamo() {
		return this.mostrarid_empresaTipoPrestamo;
	}

	public void setMostrarid_empresaTipoPrestamo(Boolean mostrarid_empresaTipoPrestamo) {
		this.mostrarid_empresaTipoPrestamo= mostrarid_empresaTipoPrestamo;
	}

	public Boolean getActivarid_empresaTipoPrestamo() {
		return this.activarid_empresaTipoPrestamo;
	}

	public void setActivarid_empresaTipoPrestamo(Boolean activarid_empresaTipoPrestamo) {
		this.activarid_empresaTipoPrestamo= activarid_empresaTipoPrestamo;
	}

	public Boolean getCargarid_empresaTipoPrestamo() {
		return this.cargarid_empresaTipoPrestamo;
	}

	public void setCargarid_empresaTipoPrestamo(Boolean cargarid_empresaTipoPrestamo) {
		this.cargarid_empresaTipoPrestamo= cargarid_empresaTipoPrestamo;
	}

	public Border setResaltarid_rubro_empleaTipoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrestamoBeanSwingJInternalFrame tipoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprestamoBeanSwingJInternalFrame.jTtoolBarTipoPrestamo.setBorder(borderResaltar);
		
		this.resaltarid_rubro_empleaTipoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_rubro_empleaTipoPrestamo() {
		return this.resaltarid_rubro_empleaTipoPrestamo;
	}

	public void setResaltarid_rubro_empleaTipoPrestamo(Border borderResaltar) {
		this.resaltarid_rubro_empleaTipoPrestamo= borderResaltar;
	}

	public Boolean getMostrarid_rubro_empleaTipoPrestamo() {
		return this.mostrarid_rubro_empleaTipoPrestamo;
	}

	public void setMostrarid_rubro_empleaTipoPrestamo(Boolean mostrarid_rubro_empleaTipoPrestamo) {
		this.mostrarid_rubro_empleaTipoPrestamo= mostrarid_rubro_empleaTipoPrestamo;
	}

	public Boolean getActivarid_rubro_empleaTipoPrestamo() {
		return this.activarid_rubro_empleaTipoPrestamo;
	}

	public void setActivarid_rubro_empleaTipoPrestamo(Boolean activarid_rubro_empleaTipoPrestamo) {
		this.activarid_rubro_empleaTipoPrestamo= activarid_rubro_empleaTipoPrestamo;
	}

	public Boolean getCargarid_rubro_empleaTipoPrestamo() {
		return this.cargarid_rubro_empleaTipoPrestamo;
	}

	public void setCargarid_rubro_empleaTipoPrestamo(Boolean cargarid_rubro_empleaTipoPrestamo) {
		this.cargarid_rubro_empleaTipoPrestamo= cargarid_rubro_empleaTipoPrestamo;
	}

	public Border setResaltarid_cuenta_contableTipoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrestamoBeanSwingJInternalFrame tipoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprestamoBeanSwingJInternalFrame.jTtoolBarTipoPrestamo.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableTipoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableTipoPrestamo() {
		return this.resaltarid_cuenta_contableTipoPrestamo;
	}

	public void setResaltarid_cuenta_contableTipoPrestamo(Border borderResaltar) {
		this.resaltarid_cuenta_contableTipoPrestamo= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableTipoPrestamo() {
		return this.mostrarid_cuenta_contableTipoPrestamo;
	}

	public void setMostrarid_cuenta_contableTipoPrestamo(Boolean mostrarid_cuenta_contableTipoPrestamo) {
		this.mostrarid_cuenta_contableTipoPrestamo= mostrarid_cuenta_contableTipoPrestamo;
	}

	public Boolean getActivarid_cuenta_contableTipoPrestamo() {
		return this.activarid_cuenta_contableTipoPrestamo;
	}

	public void setActivarid_cuenta_contableTipoPrestamo(Boolean activarid_cuenta_contableTipoPrestamo) {
		this.activarid_cuenta_contableTipoPrestamo= activarid_cuenta_contableTipoPrestamo;
	}

	public Boolean getCargarid_cuenta_contableTipoPrestamo() {
		return this.cargarid_cuenta_contableTipoPrestamo;
	}

	public void setCargarid_cuenta_contableTipoPrestamo(Boolean cargarid_cuenta_contableTipoPrestamo) {
		this.cargarid_cuenta_contableTipoPrestamo= cargarid_cuenta_contableTipoPrestamo;
	}

	public Border setResaltarcodigoTipoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrestamoBeanSwingJInternalFrame tipoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprestamoBeanSwingJInternalFrame.jTtoolBarTipoPrestamo.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoPrestamo() {
		return this.resaltarcodigoTipoPrestamo;
	}

	public void setResaltarcodigoTipoPrestamo(Border borderResaltar) {
		this.resaltarcodigoTipoPrestamo= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoPrestamo() {
		return this.mostrarcodigoTipoPrestamo;
	}

	public void setMostrarcodigoTipoPrestamo(Boolean mostrarcodigoTipoPrestamo) {
		this.mostrarcodigoTipoPrestamo= mostrarcodigoTipoPrestamo;
	}

	public Boolean getActivarcodigoTipoPrestamo() {
		return this.activarcodigoTipoPrestamo;
	}

	public void setActivarcodigoTipoPrestamo(Boolean activarcodigoTipoPrestamo) {
		this.activarcodigoTipoPrestamo= activarcodigoTipoPrestamo;
	}

	public Border setResaltarnombreTipoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrestamoBeanSwingJInternalFrame tipoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprestamoBeanSwingJInternalFrame.jTtoolBarTipoPrestamo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoPrestamo() {
		return this.resaltarnombreTipoPrestamo;
	}

	public void setResaltarnombreTipoPrestamo(Border borderResaltar) {
		this.resaltarnombreTipoPrestamo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoPrestamo() {
		return this.mostrarnombreTipoPrestamo;
	}

	public void setMostrarnombreTipoPrestamo(Boolean mostrarnombreTipoPrestamo) {
		this.mostrarnombreTipoPrestamo= mostrarnombreTipoPrestamo;
	}

	public Boolean getActivarnombreTipoPrestamo() {
		return this.activarnombreTipoPrestamo;
	}

	public void setActivarnombreTipoPrestamo(Boolean activarnombreTipoPrestamo) {
		this.activarnombreTipoPrestamo= activarnombreTipoPrestamo;
	}

	public Border setResaltarcon_pagoTipoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrestamoBeanSwingJInternalFrame tipoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprestamoBeanSwingJInternalFrame.jTtoolBarTipoPrestamo.setBorder(borderResaltar);
		
		this.resaltarcon_pagoTipoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_pagoTipoPrestamo() {
		return this.resaltarcon_pagoTipoPrestamo;
	}

	public void setResaltarcon_pagoTipoPrestamo(Border borderResaltar) {
		this.resaltarcon_pagoTipoPrestamo= borderResaltar;
	}

	public Boolean getMostrarcon_pagoTipoPrestamo() {
		return this.mostrarcon_pagoTipoPrestamo;
	}

	public void setMostrarcon_pagoTipoPrestamo(Boolean mostrarcon_pagoTipoPrestamo) {
		this.mostrarcon_pagoTipoPrestamo= mostrarcon_pagoTipoPrestamo;
	}

	public Boolean getActivarcon_pagoTipoPrestamo() {
		return this.activarcon_pagoTipoPrestamo;
	}

	public void setActivarcon_pagoTipoPrestamo(Boolean activarcon_pagoTipoPrestamo) {
		this.activarcon_pagoTipoPrestamo= activarcon_pagoTipoPrestamo;
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
		
		
		this.setMostraridTipoPrestamo(esInicial);
		this.setMostrarid_empresaTipoPrestamo(esInicial);
		this.setMostrarid_rubro_empleaTipoPrestamo(esInicial);
		this.setMostrarid_cuenta_contableTipoPrestamo(esInicial);
		this.setMostrarcodigoTipoPrestamo(esInicial);
		this.setMostrarnombreTipoPrestamo(esInicial);
		this.setMostrarcon_pagoTipoPrestamo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.ID)) {
				this.setMostraridTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.IDRUBROEMPLEA)) {
				this.setMostrarid_rubro_empleaTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.CONPAGO)) {
				this.setMostrarcon_pagoTipoPrestamo(esAsigna);
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
		
		
		this.setActivaridTipoPrestamo(esInicial);
		this.setActivarid_empresaTipoPrestamo(esInicial);
		this.setActivarid_rubro_empleaTipoPrestamo(esInicial);
		this.setActivarid_cuenta_contableTipoPrestamo(esInicial);
		this.setActivarcodigoTipoPrestamo(esInicial);
		this.setActivarnombreTipoPrestamo(esInicial);
		this.setActivarcon_pagoTipoPrestamo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.ID)) {
				this.setActivaridTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.IDRUBROEMPLEA)) {
				this.setActivarid_rubro_empleaTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.CONPAGO)) {
				this.setActivarcon_pagoTipoPrestamo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPrestamoBeanSwingJInternalFrame tipoprestamoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoPrestamo(esInicial);
		this.setResaltarid_empresaTipoPrestamo(esInicial);
		this.setResaltarid_rubro_empleaTipoPrestamo(esInicial);
		this.setResaltarid_cuenta_contableTipoPrestamo(esInicial);
		this.setResaltarcodigoTipoPrestamo(esInicial);
		this.setResaltarnombreTipoPrestamo(esInicial);
		this.setResaltarcon_pagoTipoPrestamo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.ID)) {
				this.setResaltaridTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.IDRUBROEMPLEA)) {
				this.setResaltarid_rubro_empleaTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPrestamoConstantesFunciones.CONPAGO)) {
				this.setResaltarcon_pagoTipoPrestamo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPrestamoTipoPrestamo=null;

	public Border getResaltarPrestamoTipoPrestamo() {
		return this.resaltarPrestamoTipoPrestamo;
	}

	public void setResaltarPrestamoTipoPrestamo(Border borderResaltarPrestamo) {
		if(borderResaltarPrestamo!=null) {
			this.resaltarPrestamoTipoPrestamo= borderResaltarPrestamo;
		}
	}

	public Border setResaltarPrestamoTipoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrestamoBeanSwingJInternalFrame tipoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltarPrestamo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprestamoBeanSwingJInternalFrame.jTtoolBarTipoPrestamo.setBorder(borderResaltarPrestamo);
			
		this.resaltarPrestamoTipoPrestamo= borderResaltarPrestamo;

		 return borderResaltarPrestamo;
	}



	public Boolean mostrarPrestamoTipoPrestamo=true;

	public Boolean getMostrarPrestamoTipoPrestamo() {
		return this.mostrarPrestamoTipoPrestamo;
	}

	public void setMostrarPrestamoTipoPrestamo(Boolean visibilidadResaltarPrestamo) {
		this.mostrarPrestamoTipoPrestamo= visibilidadResaltarPrestamo;
	}



	public Boolean activarPrestamoTipoPrestamo=true;

	public Boolean gethabilitarResaltarPrestamoTipoPrestamo() {
		return this.activarPrestamoTipoPrestamo;
	}

	public void setActivarPrestamoTipoPrestamo(Boolean habilitarResaltarPrestamo) {
		this.activarPrestamoTipoPrestamo= habilitarResaltarPrestamo;
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

		this.setMostrarPrestamoTipoPrestamo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Prestamo.class)) {
				this.setMostrarPrestamoTipoPrestamo(esAsigna);
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

		this.setActivarPrestamoTipoPrestamo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Prestamo.class)) {
				this.setActivarPrestamoTipoPrestamo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPrestamoBeanSwingJInternalFrame tipoprestamoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPrestamoTipoPrestamo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Prestamo.class)) {
				this.setResaltarPrestamoTipoPrestamo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCuentaContableTipoPrestamo=true;

	public Boolean getMostrarFK_IdCuentaContableTipoPrestamo() {
		return this.mostrarFK_IdCuentaContableTipoPrestamo;
	}

	public void setMostrarFK_IdCuentaContableTipoPrestamo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableTipoPrestamo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoPrestamo=true;

	public Boolean getMostrarFK_IdEmpresaTipoPrestamo() {
		return this.mostrarFK_IdEmpresaTipoPrestamo;
	}

	public void setMostrarFK_IdEmpresaTipoPrestamo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoPrestamo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrestamoTipoPrestamo=true;

	public Boolean getMostrarFK_IdTipoPrestamoTipoPrestamo() {
		return this.mostrarFK_IdTipoPrestamoTipoPrestamo;
	}

	public void setMostrarFK_IdTipoPrestamoTipoPrestamo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrestamoTipoPrestamo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableTipoPrestamo=true;

	public Boolean getActivarFK_IdCuentaContableTipoPrestamo() {
		return this.activarFK_IdCuentaContableTipoPrestamo;
	}

	public void setActivarFK_IdCuentaContableTipoPrestamo(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableTipoPrestamo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoPrestamo=true;

	public Boolean getActivarFK_IdEmpresaTipoPrestamo() {
		return this.activarFK_IdEmpresaTipoPrestamo;
	}

	public void setActivarFK_IdEmpresaTipoPrestamo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoPrestamo= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrestamoTipoPrestamo=true;

	public Boolean getActivarFK_IdTipoPrestamoTipoPrestamo() {
		return this.activarFK_IdTipoPrestamoTipoPrestamo;
	}

	public void setActivarFK_IdTipoPrestamoTipoPrestamo(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrestamoTipoPrestamo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableTipoPrestamo=null;

	public Border getResaltarFK_IdCuentaContableTipoPrestamo() {
		return this.resaltarFK_IdCuentaContableTipoPrestamo;
	}

	public void setResaltarFK_IdCuentaContableTipoPrestamo(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableTipoPrestamo= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableTipoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrestamoBeanSwingJInternalFrame tipoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableTipoPrestamo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoPrestamo=null;

	public Border getResaltarFK_IdEmpresaTipoPrestamo() {
		return this.resaltarFK_IdEmpresaTipoPrestamo;
	}

	public void setResaltarFK_IdEmpresaTipoPrestamo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoPrestamo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrestamoBeanSwingJInternalFrame tipoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoPrestamo= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrestamoTipoPrestamo=null;

	public Border getResaltarFK_IdTipoPrestamoTipoPrestamo() {
		return this.resaltarFK_IdTipoPrestamoTipoPrestamo;
	}

	public void setResaltarFK_IdTipoPrestamoTipoPrestamo(Border borderResaltar) {
		this.resaltarFK_IdTipoPrestamoTipoPrestamo= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrestamoTipoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPrestamoBeanSwingJInternalFrame tipoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrestamoTipoPrestamo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}