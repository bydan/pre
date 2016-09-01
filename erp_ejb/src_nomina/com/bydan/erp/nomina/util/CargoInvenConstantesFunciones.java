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


import com.bydan.erp.nomina.util.CargoInvenConstantesFunciones;
import com.bydan.erp.nomina.util.CargoInvenParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CargoInvenParameterGeneral;

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
final public class CargoInvenConstantesFunciones extends CargoInvenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CargoInven";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CargoInven"+CargoInvenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CargoInvenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CargoInvenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CargoInvenConstantesFunciones.SCHEMA+"_"+CargoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CargoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CargoInvenConstantesFunciones.SCHEMA+"_"+CargoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CargoInvenConstantesFunciones.SCHEMA+"_"+CargoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CargoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CargoInvenConstantesFunciones.SCHEMA+"_"+CargoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CargoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CargoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CargoInvenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CargoInvenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CargoInvenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CargoInvenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cargo Inventarioes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cargo Inventario";
	public static final String SCLASSWEBTITULO_LOWER="Cargo Inven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CargoInven";
	public static final String OBJECTNAME="cargoinven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="cargo_inven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cargoinven from "+CargoInvenConstantesFunciones.SPERSISTENCENAME+" cargoinven";
	public static String QUERYSELECTNATIVE="select "+CargoInvenConstantesFunciones.SCHEMA+"."+CargoInvenConstantesFunciones.TABLENAME+".id,"+CargoInvenConstantesFunciones.SCHEMA+"."+CargoInvenConstantesFunciones.TABLENAME+".version_row,"+CargoInvenConstantesFunciones.SCHEMA+"."+CargoInvenConstantesFunciones.TABLENAME+".id_empresa,"+CargoInvenConstantesFunciones.SCHEMA+"."+CargoInvenConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CargoInvenConstantesFunciones.SCHEMA+"."+CargoInvenConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+CargoInvenConstantesFunciones.SCHEMA+"."+CargoInvenConstantesFunciones.TABLENAME+".con_sri,"+CargoInvenConstantesFunciones.SCHEMA+"."+CargoInvenConstantesFunciones.TABLENAME+".descripcion from "+CargoInvenConstantesFunciones.SCHEMA+"."+CargoInvenConstantesFunciones.TABLENAME;//+" as "+CargoInvenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CargoInvenConstantesFuncionesAdditional cargoinvenConstantesFuncionesAdditional=null;
	
	public CargoInvenConstantesFuncionesAdditional getCargoInvenConstantesFuncionesAdditional() {
		return this.cargoinvenConstantesFuncionesAdditional;
	}
	
	public void setCargoInvenConstantesFuncionesAdditional(CargoInvenConstantesFuncionesAdditional cargoinvenConstantesFuncionesAdditional) {
		try {
			this.cargoinvenConstantesFuncionesAdditional=cargoinvenConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDCUENTACONTABLECREDITO= "id_cuenta_contable_credito";
    public static final String CONSRI= "con_sri";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta C. Debito";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDCUENTACONTABLECREDITO= "Cuenta C. Credito";
		public static final String LABEL_IDCUENTACONTABLECREDITO_LOWER= "Cuenta Contable Credito";
    	public static final String LABEL_CONSRI= "Con Sri";
		public static final String LABEL_CONSRI_LOWER= "Con Sri";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCargoInvenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CargoInvenConstantesFunciones.IDEMPRESA)) {sLabelColumna=CargoInvenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CargoInvenConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=CargoInvenConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(CargoInvenConstantesFunciones.IDCUENTACONTABLECREDITO)) {sLabelColumna=CargoInvenConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO;}
		if(sNombreColumna.equals(CargoInvenConstantesFunciones.CONSRI)) {sLabelColumna=CargoInvenConstantesFunciones.LABEL_CONSRI;}
		if(sNombreColumna.equals(CargoInvenConstantesFunciones.DESCRIPCION)) {sLabelColumna=CargoInvenConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getcon_sriDescripcion(CargoInven cargoinven) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cargoinven.getcon_sri()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_sriHtmlDescripcion(CargoInven cargoinven) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cargoinven.getId(),cargoinven.getcon_sri());

		return sDescripcion;
	}	
			
	
	public static String getCargoInvenDescripcion(CargoInven cargoinven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cargoinven !=null/* && cargoinven.getId()!=0*/) {
			if(cargoinven.getId()!=null) {
				sDescripcion=cargoinven.getId().toString();
			}//cargoinvencargoinven.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCargoInvenDescripcionDetallado(CargoInven cargoinven) {
		String sDescripcion="";
			
		sDescripcion+=CargoInvenConstantesFunciones.ID+"=";
		sDescripcion+=cargoinven.getId().toString()+",";
		sDescripcion+=CargoInvenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cargoinven.getVersionRow().toString()+",";
		sDescripcion+=CargoInvenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cargoinven.getid_empresa().toString()+",";
		sDescripcion+=CargoInvenConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=cargoinven.getid_cuenta_contable().toString()+",";
		sDescripcion+=CargoInvenConstantesFunciones.IDCUENTACONTABLECREDITO+"=";
		sDescripcion+=cargoinven.getid_cuenta_contable_credito().toString()+",";
		sDescripcion+=CargoInvenConstantesFunciones.CONSRI+"=";
		sDescripcion+=cargoinven.getcon_sri().toString()+",";
		sDescripcion+=CargoInvenConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=cargoinven.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setCargoInvenDescripcion(CargoInven cargoinven,String sValor) throws Exception {			
		if(cargoinven !=null) {
			//cargoinvencargoinven.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getCuentaContableCreditoDescripcion(CuentaContable cuentacontable) {
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
		} else if(sNombreIndice.equals("FK_IdCargoInven")) {
			sNombreIndice="Tipo=  Por Cuenta C. Credito";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta C. Debito";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCargoInven(Long id_cuenta_contable_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Credito="+id_cuenta_contable_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Debito="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCargoInven(CargoInven cargoinven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cargoinven.setdescripcion(cargoinven.getdescripcion().trim());
	}
	
	public static void quitarEspaciosCargoInvens(List<CargoInven> cargoinvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CargoInven cargoinven: cargoinvens) {
			cargoinven.setdescripcion(cargoinven.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCargoInven(CargoInven cargoinven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cargoinven.getConCambioAuxiliar()) {
			cargoinven.setIsDeleted(cargoinven.getIsDeletedAuxiliar());	
			cargoinven.setIsNew(cargoinven.getIsNewAuxiliar());	
			cargoinven.setIsChanged(cargoinven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cargoinven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cargoinven.setIsDeletedAuxiliar(false);	
			cargoinven.setIsNewAuxiliar(false);	
			cargoinven.setIsChangedAuxiliar(false);
			
			cargoinven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCargoInvens(List<CargoInven> cargoinvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CargoInven cargoinven : cargoinvens) {
			if(conAsignarBase && cargoinven.getConCambioAuxiliar()) {
				cargoinven.setIsDeleted(cargoinven.getIsDeletedAuxiliar());	
				cargoinven.setIsNew(cargoinven.getIsNewAuxiliar());	
				cargoinven.setIsChanged(cargoinven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cargoinven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cargoinven.setIsDeletedAuxiliar(false);	
				cargoinven.setIsNewAuxiliar(false);	
				cargoinven.setIsChangedAuxiliar(false);
				
				cargoinven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCargoInven(CargoInven cargoinven,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCargoInvens(List<CargoInven> cargoinvens,Boolean conEnteros) throws Exception  {
		
		for(CargoInven cargoinven: cargoinvens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCargoInven(List<CargoInven> cargoinvens,CargoInven cargoinvenAux) throws Exception  {
		CargoInvenConstantesFunciones.InicializarValoresCargoInven(cargoinvenAux,true);
		
		for(CargoInven cargoinven: cargoinvens) {
			if(cargoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCargoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CargoInvenConstantesFunciones.getArrayColumnasGlobalesCargoInven(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCargoInven(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CargoInvenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CargoInvenConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCargoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CargoInven> cargoinvens,CargoInven cargoinven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CargoInven cargoinvenAux: cargoinvens) {
			if(cargoinvenAux!=null && cargoinven!=null) {
				if((cargoinvenAux.getId()==null && cargoinven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cargoinvenAux.getId()!=null && cargoinven.getId()!=null){
					if(cargoinvenAux.getId().equals(cargoinven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCargoInven(List<CargoInven> cargoinvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CargoInven cargoinven: cargoinvens) {			
			if(cargoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCargoInven() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CargoInvenConstantesFunciones.LABEL_ID, CargoInvenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoInvenConstantesFunciones.LABEL_VERSIONROW, CargoInvenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoInvenConstantesFunciones.LABEL_IDEMPRESA, CargoInvenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoInvenConstantesFunciones.LABEL_IDCUENTACONTABLE, CargoInvenConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoInvenConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO, CargoInvenConstantesFunciones.IDCUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoInvenConstantesFunciones.LABEL_CONSRI, CargoInvenConstantesFunciones.CONSRI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoInvenConstantesFunciones.LABEL_DESCRIPCION, CargoInvenConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCargoInven() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CargoInvenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoInvenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoInvenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoInvenConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoInvenConstantesFunciones.IDCUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoInvenConstantesFunciones.CONSRI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoInvenConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCargoInven() throws Exception  {
		return CargoInvenConstantesFunciones.getTiposSeleccionarCargoInven(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCargoInven(Boolean conFk) throws Exception  {
		return CargoInvenConstantesFunciones.getTiposSeleccionarCargoInven(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCargoInven(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoInvenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CargoInvenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoInvenConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(CargoInvenConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoInvenConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
			reporte.setsDescripcion(CargoInvenConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoInvenConstantesFunciones.LABEL_CONSRI);
			reporte.setsDescripcion(CargoInvenConstantesFunciones.LABEL_CONSRI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoInvenConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(CargoInvenConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCargoInven(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCargoInven(CargoInven cargoinvenAux) throws Exception {
		
			cargoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cargoinvenAux.getEmpresa()));
			cargoinvenAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cargoinvenAux.getCuentaContable()));
			cargoinvenAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cargoinvenAux.getCuentaContableCredito()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCargoInven(List<CargoInven> cargoinvensTemp) throws Exception {
		for(CargoInven cargoinvenAux:cargoinvensTemp) {
			
			cargoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cargoinvenAux.getEmpresa()));
			cargoinvenAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cargoinvenAux.getCuentaContable()));
			cargoinvenAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cargoinvenAux.getCuentaContableCredito()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCargoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCargoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCargoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CargoInvenConstantesFunciones.getClassesRelationshipsOfCargoInven(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCargoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCargoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CargoInvenConstantesFunciones.getClassesRelationshipsFromStringsOfCargoInven(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCargoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CargoInven cargoinven,List<CargoInven> cargoinvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CargoInven cargoinvenEncontrado=null;
			
			for(CargoInven cargoinvenLocal:cargoinvens) {
				if(cargoinvenLocal.getId().equals(cargoinven.getId())) {
					cargoinvenEncontrado=cargoinvenLocal;
					
					cargoinvenLocal.setIsChanged(cargoinven.getIsChanged());
					cargoinvenLocal.setIsNew(cargoinven.getIsNew());
					cargoinvenLocal.setIsDeleted(cargoinven.getIsDeleted());
					
					cargoinvenLocal.setGeneralEntityOriginal(cargoinven.getGeneralEntityOriginal());
					
					cargoinvenLocal.setId(cargoinven.getId());	
					cargoinvenLocal.setVersionRow(cargoinven.getVersionRow());	
					cargoinvenLocal.setid_empresa(cargoinven.getid_empresa());	
					cargoinvenLocal.setid_cuenta_contable(cargoinven.getid_cuenta_contable());	
					cargoinvenLocal.setid_cuenta_contable_credito(cargoinven.getid_cuenta_contable_credito());	
					cargoinvenLocal.setcon_sri(cargoinven.getcon_sri());	
					cargoinvenLocal.setdescripcion(cargoinven.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cargoinven.getIsDeleted()) {
				if(!existe) {
					cargoinvens.add(cargoinven);
				}
			} else {
				if(cargoinvenEncontrado!=null && permiteQuitar)  {
					cargoinvens.remove(cargoinvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CargoInven cargoinven,List<CargoInven> cargoinvens) throws Exception {
		try	{			
			for(CargoInven cargoinvenLocal:cargoinvens) {
				if(cargoinvenLocal.getId().equals(cargoinven.getId())) {
					cargoinvenLocal.setIsSelected(cargoinven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCargoInven(List<CargoInven> cargoinvensAux) throws Exception {
		//this.cargoinvensAux=cargoinvensAux;
		
		for(CargoInven cargoinvenAux:cargoinvensAux) {
			if(cargoinvenAux.getIsChanged()) {
				cargoinvenAux.setIsChanged(false);
			}		
			
			if(cargoinvenAux.getIsNew()) {
				cargoinvenAux.setIsNew(false);
			}	
			
			if(cargoinvenAux.getIsDeleted()) {
				cargoinvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCargoInven(CargoInven cargoinvenAux) throws Exception {
		//this.cargoinvenAux=cargoinvenAux;
		
			if(cargoinvenAux.getIsChanged()) {
				cargoinvenAux.setIsChanged(false);
			}		
			
			if(cargoinvenAux.getIsNew()) {
				cargoinvenAux.setIsNew(false);
			}	
			
			if(cargoinvenAux.getIsDeleted()) {
				cargoinvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CargoInven cargoinvenAsignar,CargoInven cargoinven) throws Exception {
		cargoinvenAsignar.setId(cargoinven.getId());	
		cargoinvenAsignar.setVersionRow(cargoinven.getVersionRow());	
		cargoinvenAsignar.setid_empresa(cargoinven.getid_empresa());
		cargoinvenAsignar.setempresa_descripcion(cargoinven.getempresa_descripcion());	
		cargoinvenAsignar.setid_cuenta_contable(cargoinven.getid_cuenta_contable());
		cargoinvenAsignar.setcuentacontable_descripcion(cargoinven.getcuentacontable_descripcion());	
		cargoinvenAsignar.setid_cuenta_contable_credito(cargoinven.getid_cuenta_contable_credito());
		cargoinvenAsignar.setcuentacontablecredito_descripcion(cargoinven.getcuentacontablecredito_descripcion());	
		cargoinvenAsignar.setcon_sri(cargoinven.getcon_sri());	
		cargoinvenAsignar.setdescripcion(cargoinven.getdescripcion());	
	}
	
	public static void inicializarCargoInven(CargoInven cargoinven) throws Exception {
		try {
				cargoinven.setId(0L);	
					
				cargoinven.setid_empresa(-1L);	
				cargoinven.setid_cuenta_contable(-1L);	
				cargoinven.setid_cuenta_contable_credito(-1L);	
				cargoinven.setcon_sri(false);	
				cargoinven.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCargoInven(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoInvenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoInvenConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoInvenConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoInvenConstantesFunciones.LABEL_CONSRI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoInvenConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCargoInven(String sTipo,Row row,Workbook workbook,CargoInven cargoinven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cargoinven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargoinven.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargoinven.getcuentacontablecredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cargoinven.getcon_sri()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargoinven.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCargoInven=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCargoInven() {
		return this.sFinalQueryCargoInven;
	}
	
	public void setsFinalQueryCargoInven(String sFinalQueryCargoInven) {
		this.sFinalQueryCargoInven= sFinalQueryCargoInven;
	}
	
	public Border resaltarSeleccionarCargoInven=null;
	
	public Border setResaltarSeleccionarCargoInven(ParametroGeneralUsuario parametroGeneralUsuario/*CargoInvenBeanSwingJInternalFrame cargoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cargoinvenBeanSwingJInternalFrame.jTtoolBarCargoInven.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCargoInven= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCargoInven() {
		return this.resaltarSeleccionarCargoInven;
	}
	
	public void setResaltarSeleccionarCargoInven(Border borderResaltarSeleccionarCargoInven) {
		this.resaltarSeleccionarCargoInven= borderResaltarSeleccionarCargoInven;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCargoInven=null;
	public Boolean mostraridCargoInven=true;
	public Boolean activaridCargoInven=true;

	public Border resaltarid_empresaCargoInven=null;
	public Boolean mostrarid_empresaCargoInven=true;
	public Boolean activarid_empresaCargoInven=true;
	public Boolean cargarid_empresaCargoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCargoInven=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableCargoInven=null;
	public Boolean mostrarid_cuenta_contableCargoInven=true;
	public Boolean activarid_cuenta_contableCargoInven=true;
	public Boolean cargarid_cuenta_contableCargoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableCargoInven=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_creditoCargoInven=null;
	public Boolean mostrarid_cuenta_contable_creditoCargoInven=true;
	public Boolean activarid_cuenta_contable_creditoCargoInven=true;
	public Boolean cargarid_cuenta_contable_creditoCargoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_creditoCargoInven=false;//ConEventDepend=true

	public Border resaltarcon_sriCargoInven=null;
	public Boolean mostrarcon_sriCargoInven=true;
	public Boolean activarcon_sriCargoInven=true;

	public Border resaltardescripcionCargoInven=null;
	public Boolean mostrardescripcionCargoInven=true;
	public Boolean activardescripcionCargoInven=true;

	
	

	public Border setResaltaridCargoInven(ParametroGeneralUsuario parametroGeneralUsuario/*CargoInvenBeanSwingJInternalFrame cargoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoinvenBeanSwingJInternalFrame.jTtoolBarCargoInven.setBorder(borderResaltar);
		
		this.resaltaridCargoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCargoInven() {
		return this.resaltaridCargoInven;
	}

	public void setResaltaridCargoInven(Border borderResaltar) {
		this.resaltaridCargoInven= borderResaltar;
	}

	public Boolean getMostraridCargoInven() {
		return this.mostraridCargoInven;
	}

	public void setMostraridCargoInven(Boolean mostraridCargoInven) {
		this.mostraridCargoInven= mostraridCargoInven;
	}

	public Boolean getActivaridCargoInven() {
		return this.activaridCargoInven;
	}

	public void setActivaridCargoInven(Boolean activaridCargoInven) {
		this.activaridCargoInven= activaridCargoInven;
	}

	public Border setResaltarid_empresaCargoInven(ParametroGeneralUsuario parametroGeneralUsuario/*CargoInvenBeanSwingJInternalFrame cargoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoinvenBeanSwingJInternalFrame.jTtoolBarCargoInven.setBorder(borderResaltar);
		
		this.resaltarid_empresaCargoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCargoInven() {
		return this.resaltarid_empresaCargoInven;
	}

	public void setResaltarid_empresaCargoInven(Border borderResaltar) {
		this.resaltarid_empresaCargoInven= borderResaltar;
	}

	public Boolean getMostrarid_empresaCargoInven() {
		return this.mostrarid_empresaCargoInven;
	}

	public void setMostrarid_empresaCargoInven(Boolean mostrarid_empresaCargoInven) {
		this.mostrarid_empresaCargoInven= mostrarid_empresaCargoInven;
	}

	public Boolean getActivarid_empresaCargoInven() {
		return this.activarid_empresaCargoInven;
	}

	public void setActivarid_empresaCargoInven(Boolean activarid_empresaCargoInven) {
		this.activarid_empresaCargoInven= activarid_empresaCargoInven;
	}

	public Boolean getCargarid_empresaCargoInven() {
		return this.cargarid_empresaCargoInven;
	}

	public void setCargarid_empresaCargoInven(Boolean cargarid_empresaCargoInven) {
		this.cargarid_empresaCargoInven= cargarid_empresaCargoInven;
	}

	public Border setResaltarid_cuenta_contableCargoInven(ParametroGeneralUsuario parametroGeneralUsuario/*CargoInvenBeanSwingJInternalFrame cargoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoinvenBeanSwingJInternalFrame.jTtoolBarCargoInven.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableCargoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableCargoInven() {
		return this.resaltarid_cuenta_contableCargoInven;
	}

	public void setResaltarid_cuenta_contableCargoInven(Border borderResaltar) {
		this.resaltarid_cuenta_contableCargoInven= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableCargoInven() {
		return this.mostrarid_cuenta_contableCargoInven;
	}

	public void setMostrarid_cuenta_contableCargoInven(Boolean mostrarid_cuenta_contableCargoInven) {
		this.mostrarid_cuenta_contableCargoInven= mostrarid_cuenta_contableCargoInven;
	}

	public Boolean getActivarid_cuenta_contableCargoInven() {
		return this.activarid_cuenta_contableCargoInven;
	}

	public void setActivarid_cuenta_contableCargoInven(Boolean activarid_cuenta_contableCargoInven) {
		this.activarid_cuenta_contableCargoInven= activarid_cuenta_contableCargoInven;
	}

	public Boolean getCargarid_cuenta_contableCargoInven() {
		return this.cargarid_cuenta_contableCargoInven;
	}

	public void setCargarid_cuenta_contableCargoInven(Boolean cargarid_cuenta_contableCargoInven) {
		this.cargarid_cuenta_contableCargoInven= cargarid_cuenta_contableCargoInven;
	}

	public Border setResaltarid_cuenta_contable_creditoCargoInven(ParametroGeneralUsuario parametroGeneralUsuario/*CargoInvenBeanSwingJInternalFrame cargoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoinvenBeanSwingJInternalFrame.jTtoolBarCargoInven.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_creditoCargoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_creditoCargoInven() {
		return this.resaltarid_cuenta_contable_creditoCargoInven;
	}

	public void setResaltarid_cuenta_contable_creditoCargoInven(Border borderResaltar) {
		this.resaltarid_cuenta_contable_creditoCargoInven= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_creditoCargoInven() {
		return this.mostrarid_cuenta_contable_creditoCargoInven;
	}

	public void setMostrarid_cuenta_contable_creditoCargoInven(Boolean mostrarid_cuenta_contable_creditoCargoInven) {
		this.mostrarid_cuenta_contable_creditoCargoInven= mostrarid_cuenta_contable_creditoCargoInven;
	}

	public Boolean getActivarid_cuenta_contable_creditoCargoInven() {
		return this.activarid_cuenta_contable_creditoCargoInven;
	}

	public void setActivarid_cuenta_contable_creditoCargoInven(Boolean activarid_cuenta_contable_creditoCargoInven) {
		this.activarid_cuenta_contable_creditoCargoInven= activarid_cuenta_contable_creditoCargoInven;
	}

	public Boolean getCargarid_cuenta_contable_creditoCargoInven() {
		return this.cargarid_cuenta_contable_creditoCargoInven;
	}

	public void setCargarid_cuenta_contable_creditoCargoInven(Boolean cargarid_cuenta_contable_creditoCargoInven) {
		this.cargarid_cuenta_contable_creditoCargoInven= cargarid_cuenta_contable_creditoCargoInven;
	}

	public Border setResaltarcon_sriCargoInven(ParametroGeneralUsuario parametroGeneralUsuario/*CargoInvenBeanSwingJInternalFrame cargoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoinvenBeanSwingJInternalFrame.jTtoolBarCargoInven.setBorder(borderResaltar);
		
		this.resaltarcon_sriCargoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_sriCargoInven() {
		return this.resaltarcon_sriCargoInven;
	}

	public void setResaltarcon_sriCargoInven(Border borderResaltar) {
		this.resaltarcon_sriCargoInven= borderResaltar;
	}

	public Boolean getMostrarcon_sriCargoInven() {
		return this.mostrarcon_sriCargoInven;
	}

	public void setMostrarcon_sriCargoInven(Boolean mostrarcon_sriCargoInven) {
		this.mostrarcon_sriCargoInven= mostrarcon_sriCargoInven;
	}

	public Boolean getActivarcon_sriCargoInven() {
		return this.activarcon_sriCargoInven;
	}

	public void setActivarcon_sriCargoInven(Boolean activarcon_sriCargoInven) {
		this.activarcon_sriCargoInven= activarcon_sriCargoInven;
	}

	public Border setResaltardescripcionCargoInven(ParametroGeneralUsuario parametroGeneralUsuario/*CargoInvenBeanSwingJInternalFrame cargoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoinvenBeanSwingJInternalFrame.jTtoolBarCargoInven.setBorder(borderResaltar);
		
		this.resaltardescripcionCargoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionCargoInven() {
		return this.resaltardescripcionCargoInven;
	}

	public void setResaltardescripcionCargoInven(Border borderResaltar) {
		this.resaltardescripcionCargoInven= borderResaltar;
	}

	public Boolean getMostrardescripcionCargoInven() {
		return this.mostrardescripcionCargoInven;
	}

	public void setMostrardescripcionCargoInven(Boolean mostrardescripcionCargoInven) {
		this.mostrardescripcionCargoInven= mostrardescripcionCargoInven;
	}

	public Boolean getActivardescripcionCargoInven() {
		return this.activardescripcionCargoInven;
	}

	public void setActivardescripcionCargoInven(Boolean activardescripcionCargoInven) {
		this.activardescripcionCargoInven= activardescripcionCargoInven;
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
		
		
		this.setMostraridCargoInven(esInicial);
		this.setMostrarid_empresaCargoInven(esInicial);
		this.setMostrarid_cuenta_contableCargoInven(esInicial);
		this.setMostrarid_cuenta_contable_creditoCargoInven(esInicial);
		this.setMostrarcon_sriCargoInven(esInicial);
		this.setMostrardescripcionCargoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CargoInvenConstantesFunciones.ID)) {
				this.setMostraridCargoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoInvenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCargoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoInvenConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableCargoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoInvenConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setMostrarid_cuenta_contable_creditoCargoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoInvenConstantesFunciones.CONSRI)) {
				this.setMostrarcon_sriCargoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoInvenConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionCargoInven(esAsigna);
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
		
		
		this.setActivaridCargoInven(esInicial);
		this.setActivarid_empresaCargoInven(esInicial);
		this.setActivarid_cuenta_contableCargoInven(esInicial);
		this.setActivarid_cuenta_contable_creditoCargoInven(esInicial);
		this.setActivarcon_sriCargoInven(esInicial);
		this.setActivardescripcionCargoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CargoInvenConstantesFunciones.ID)) {
				this.setActivaridCargoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoInvenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCargoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoInvenConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableCargoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoInvenConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setActivarid_cuenta_contable_creditoCargoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoInvenConstantesFunciones.CONSRI)) {
				this.setActivarcon_sriCargoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoInvenConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionCargoInven(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CargoInvenBeanSwingJInternalFrame cargoinvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCargoInven(esInicial);
		this.setResaltarid_empresaCargoInven(esInicial);
		this.setResaltarid_cuenta_contableCargoInven(esInicial);
		this.setResaltarid_cuenta_contable_creditoCargoInven(esInicial);
		this.setResaltarcon_sriCargoInven(esInicial);
		this.setResaltardescripcionCargoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CargoInvenConstantesFunciones.ID)) {
				this.setResaltaridCargoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoInvenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCargoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoInvenConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableCargoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoInvenConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setResaltarid_cuenta_contable_creditoCargoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoInvenConstantesFunciones.CONSRI)) {
				this.setResaltarcon_sriCargoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoInvenConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionCargoInven(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CargoInvenBeanSwingJInternalFrame cargoinvenBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCargoInvenCargoInven=true;

	public Boolean getMostrarFK_IdCargoInvenCargoInven() {
		return this.mostrarFK_IdCargoInvenCargoInven;
	}

	public void setMostrarFK_IdCargoInvenCargoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCargoInvenCargoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCargoInven=true;

	public Boolean getMostrarFK_IdCuentaContableCargoInven() {
		return this.mostrarFK_IdCuentaContableCargoInven;
	}

	public void setMostrarFK_IdCuentaContableCargoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCargoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCargoInven=true;

	public Boolean getMostrarFK_IdEmpresaCargoInven() {
		return this.mostrarFK_IdEmpresaCargoInven;
	}

	public void setMostrarFK_IdEmpresaCargoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCargoInven= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCargoInvenCargoInven=true;

	public Boolean getActivarFK_IdCargoInvenCargoInven() {
		return this.activarFK_IdCargoInvenCargoInven;
	}

	public void setActivarFK_IdCargoInvenCargoInven(Boolean habilitarResaltar) {
		this.activarFK_IdCargoInvenCargoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCargoInven=true;

	public Boolean getActivarFK_IdCuentaContableCargoInven() {
		return this.activarFK_IdCuentaContableCargoInven;
	}

	public void setActivarFK_IdCuentaContableCargoInven(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCargoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCargoInven=true;

	public Boolean getActivarFK_IdEmpresaCargoInven() {
		return this.activarFK_IdEmpresaCargoInven;
	}

	public void setActivarFK_IdEmpresaCargoInven(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCargoInven= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCargoInvenCargoInven=null;

	public Border getResaltarFK_IdCargoInvenCargoInven() {
		return this.resaltarFK_IdCargoInvenCargoInven;
	}

	public void setResaltarFK_IdCargoInvenCargoInven(Border borderResaltar) {
		this.resaltarFK_IdCargoInvenCargoInven= borderResaltar;
	}

	public void setResaltarFK_IdCargoInvenCargoInven(ParametroGeneralUsuario parametroGeneralUsuario/*CargoInvenBeanSwingJInternalFrame cargoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCargoInvenCargoInven= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCargoInven=null;

	public Border getResaltarFK_IdCuentaContableCargoInven() {
		return this.resaltarFK_IdCuentaContableCargoInven;
	}

	public void setResaltarFK_IdCuentaContableCargoInven(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCargoInven= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCargoInven(ParametroGeneralUsuario parametroGeneralUsuario/*CargoInvenBeanSwingJInternalFrame cargoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCargoInven= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCargoInven=null;

	public Border getResaltarFK_IdEmpresaCargoInven() {
		return this.resaltarFK_IdEmpresaCargoInven;
	}

	public void setResaltarFK_IdEmpresaCargoInven(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCargoInven= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCargoInven(ParametroGeneralUsuario parametroGeneralUsuario/*CargoInvenBeanSwingJInternalFrame cargoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCargoInven= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}