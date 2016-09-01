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


import com.bydan.erp.nomina.util.RubroEstructuraConstantesFunciones;
import com.bydan.erp.nomina.util.RubroEstructuraParameterReturnGeneral;
//import com.bydan.erp.nomina.util.RubroEstructuraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RubroEstructuraConstantesFunciones extends RubroEstructuraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="RubroEstructura";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RubroEstructura"+RubroEstructuraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RubroEstructuraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RubroEstructuraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RubroEstructuraConstantesFunciones.SCHEMA+"_"+RubroEstructuraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RubroEstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RubroEstructuraConstantesFunciones.SCHEMA+"_"+RubroEstructuraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RubroEstructuraConstantesFunciones.SCHEMA+"_"+RubroEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RubroEstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RubroEstructuraConstantesFunciones.SCHEMA+"_"+RubroEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubroEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RubroEstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubroEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubroEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RubroEstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubroEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RubroEstructuraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RubroEstructuraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RubroEstructuraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RubroEstructuraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Rubro Estructuras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Rubro Estructura";
	public static final String SCLASSWEBTITULO_LOWER="Rubro Estructura";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RubroEstructura";
	public static final String OBJECTNAME="rubroestructura";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="rubro_estructura";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select rubroestructura from "+RubroEstructuraConstantesFunciones.SPERSISTENCENAME+" rubroestructura";
	public static String QUERYSELECTNATIVE="select "+RubroEstructuraConstantesFunciones.SCHEMA+"."+RubroEstructuraConstantesFunciones.TABLENAME+".id,"+RubroEstructuraConstantesFunciones.SCHEMA+"."+RubroEstructuraConstantesFunciones.TABLENAME+".version_row,"+RubroEstructuraConstantesFunciones.SCHEMA+"."+RubroEstructuraConstantesFunciones.TABLENAME+".id_empresa,"+RubroEstructuraConstantesFunciones.SCHEMA+"."+RubroEstructuraConstantesFunciones.TABLENAME+".id_sucursal,"+RubroEstructuraConstantesFunciones.SCHEMA+"."+RubroEstructuraConstantesFunciones.TABLENAME+".id_estructura,"+RubroEstructuraConstantesFunciones.SCHEMA+"."+RubroEstructuraConstantesFunciones.TABLENAME+".id_rubro_emplea,"+RubroEstructuraConstantesFunciones.SCHEMA+"."+RubroEstructuraConstantesFunciones.TABLENAME+".esta_activo from "+RubroEstructuraConstantesFunciones.SCHEMA+"."+RubroEstructuraConstantesFunciones.TABLENAME;//+" as "+RubroEstructuraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RubroEstructuraConstantesFuncionesAdditional rubroestructuraConstantesFuncionesAdditional=null;
	
	public RubroEstructuraConstantesFuncionesAdditional getRubroEstructuraConstantesFuncionesAdditional() {
		return this.rubroestructuraConstantesFuncionesAdditional;
	}
	
	public void setRubroEstructuraConstantesFuncionesAdditional(RubroEstructuraConstantesFuncionesAdditional rubroestructuraConstantesFuncionesAdditional) {
		try {
			this.rubroestructuraConstantesFuncionesAdditional=rubroestructuraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDRUBROEMPLEA= "id_rubro_emplea";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDRUBROEMPLEA= "Rubro Emplea";
		public static final String LABEL_IDRUBROEMPLEA_LOWER= "Rubro Emplea";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
		
	
	public static String getRubroEstructuraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RubroEstructuraConstantesFunciones.IDEMPRESA)) {sLabelColumna=RubroEstructuraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RubroEstructuraConstantesFunciones.IDSUCURSAL)) {sLabelColumna=RubroEstructuraConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(RubroEstructuraConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=RubroEstructuraConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(RubroEstructuraConstantesFunciones.IDRUBROEMPLEA)) {sLabelColumna=RubroEstructuraConstantesFunciones.LABEL_IDRUBROEMPLEA;}
		if(sNombreColumna.equals(RubroEstructuraConstantesFunciones.ESTAACTIVO)) {sLabelColumna=RubroEstructuraConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(RubroEstructura rubroestructura) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!rubroestructura.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(RubroEstructura rubroestructura) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(rubroestructura.getId(),rubroestructura.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getRubroEstructuraDescripcion(RubroEstructura rubroestructura) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(rubroestructura !=null/* && rubroestructura.getId()!=0*/) {
			if(rubroestructura.getId()!=null) {
				sDescripcion=rubroestructura.getId().toString();
			}//rubroestructurarubroestructura.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRubroEstructuraDescripcionDetallado(RubroEstructura rubroestructura) {
		String sDescripcion="";
			
		sDescripcion+=RubroEstructuraConstantesFunciones.ID+"=";
		sDescripcion+=rubroestructura.getId().toString()+",";
		sDescripcion+=RubroEstructuraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=rubroestructura.getVersionRow().toString()+",";
		sDescripcion+=RubroEstructuraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=rubroestructura.getid_empresa().toString()+",";
		sDescripcion+=RubroEstructuraConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=rubroestructura.getid_sucursal().toString()+",";
		sDescripcion+=RubroEstructuraConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=rubroestructura.getid_estructura().toString()+",";
		sDescripcion+=RubroEstructuraConstantesFunciones.IDRUBROEMPLEA+"=";
		sDescripcion+=rubroestructura.getid_rubro_emplea().toString()+",";
		sDescripcion+=RubroEstructuraConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=rubroestructura.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRubroEstructuraDescripcion(RubroEstructura rubroestructura,String sValor) throws Exception {			
		if(rubroestructura !=null) {
			//rubroestructurarubroestructura.getId().toString();
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

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdRubroEmplea")) {
			sNombreIndice="Tipo=  Por Rubro Emplea";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRubroEmplea(Long id_rubro_emplea) {
		String sDetalleIndice=" Parametros->";
		if(id_rubro_emplea!=null) {sDetalleIndice+=" Codigo Unico De Rubro Emplea="+id_rubro_emplea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRubroEstructura(RubroEstructura rubroestructura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosRubroEstructuras(List<RubroEstructura> rubroestructuras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RubroEstructura rubroestructura: rubroestructuras) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRubroEstructura(RubroEstructura rubroestructura,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && rubroestructura.getConCambioAuxiliar()) {
			rubroestructura.setIsDeleted(rubroestructura.getIsDeletedAuxiliar());	
			rubroestructura.setIsNew(rubroestructura.getIsNewAuxiliar());	
			rubroestructura.setIsChanged(rubroestructura.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			rubroestructura.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			rubroestructura.setIsDeletedAuxiliar(false);	
			rubroestructura.setIsNewAuxiliar(false);	
			rubroestructura.setIsChangedAuxiliar(false);
			
			rubroestructura.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRubroEstructuras(List<RubroEstructura> rubroestructuras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RubroEstructura rubroestructura : rubroestructuras) {
			if(conAsignarBase && rubroestructura.getConCambioAuxiliar()) {
				rubroestructura.setIsDeleted(rubroestructura.getIsDeletedAuxiliar());	
				rubroestructura.setIsNew(rubroestructura.getIsNewAuxiliar());	
				rubroestructura.setIsChanged(rubroestructura.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				rubroestructura.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				rubroestructura.setIsDeletedAuxiliar(false);	
				rubroestructura.setIsNewAuxiliar(false);	
				rubroestructura.setIsChangedAuxiliar(false);
				
				rubroestructura.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRubroEstructura(RubroEstructura rubroestructura,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRubroEstructuras(List<RubroEstructura> rubroestructuras,Boolean conEnteros) throws Exception  {
		
		for(RubroEstructura rubroestructura: rubroestructuras) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRubroEstructura(List<RubroEstructura> rubroestructuras,RubroEstructura rubroestructuraAux) throws Exception  {
		RubroEstructuraConstantesFunciones.InicializarValoresRubroEstructura(rubroestructuraAux,true);
		
		for(RubroEstructura rubroestructura: rubroestructuras) {
			if(rubroestructura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRubroEstructura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RubroEstructuraConstantesFunciones.getArrayColumnasGlobalesRubroEstructura(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRubroEstructura(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RubroEstructuraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RubroEstructuraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RubroEstructuraConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RubroEstructuraConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRubroEstructura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RubroEstructura> rubroestructuras,RubroEstructura rubroestructura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RubroEstructura rubroestructuraAux: rubroestructuras) {
			if(rubroestructuraAux!=null && rubroestructura!=null) {
				if((rubroestructuraAux.getId()==null && rubroestructura.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(rubroestructuraAux.getId()!=null && rubroestructura.getId()!=null){
					if(rubroestructuraAux.getId().equals(rubroestructura.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRubroEstructura(List<RubroEstructura> rubroestructuras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(RubroEstructura rubroestructura: rubroestructuras) {			
			if(rubroestructura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRubroEstructura() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RubroEstructuraConstantesFunciones.LABEL_ID, RubroEstructuraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEstructuraConstantesFunciones.LABEL_VERSIONROW, RubroEstructuraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEstructuraConstantesFunciones.LABEL_IDEMPRESA, RubroEstructuraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEstructuraConstantesFunciones.LABEL_IDSUCURSAL, RubroEstructuraConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEstructuraConstantesFunciones.LABEL_IDESTRUCTURA, RubroEstructuraConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEstructuraConstantesFunciones.LABEL_IDRUBROEMPLEA, RubroEstructuraConstantesFunciones.IDRUBROEMPLEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEstructuraConstantesFunciones.LABEL_ESTAACTIVO, RubroEstructuraConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRubroEstructura() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RubroEstructuraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEstructuraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEstructuraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEstructuraConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEstructuraConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEstructuraConstantesFunciones.IDRUBROEMPLEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEstructuraConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRubroEstructura() throws Exception  {
		return RubroEstructuraConstantesFunciones.getTiposSeleccionarRubroEstructura(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRubroEstructura(Boolean conFk) throws Exception  {
		return RubroEstructuraConstantesFunciones.getTiposSeleccionarRubroEstructura(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRubroEstructura(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEstructuraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RubroEstructuraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEstructuraConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(RubroEstructuraConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEstructuraConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(RubroEstructuraConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEstructuraConstantesFunciones.LABEL_IDRUBROEMPLEA);
			reporte.setsDescripcion(RubroEstructuraConstantesFunciones.LABEL_IDRUBROEMPLEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEstructuraConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(RubroEstructuraConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRubroEstructura(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRubroEstructura(RubroEstructura rubroestructuraAux) throws Exception {
		
			rubroestructuraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rubroestructuraAux.getEmpresa()));
			rubroestructuraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(rubroestructuraAux.getSucursal()));
			rubroestructuraAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(rubroestructuraAux.getEstructura()));
			rubroestructuraAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(rubroestructuraAux.getRubroEmplea()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRubroEstructura(List<RubroEstructura> rubroestructurasTemp) throws Exception {
		for(RubroEstructura rubroestructuraAux:rubroestructurasTemp) {
			
			rubroestructuraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rubroestructuraAux.getEmpresa()));
			rubroestructuraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(rubroestructuraAux.getSucursal()));
			rubroestructuraAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(rubroestructuraAux.getEstructura()));
			rubroestructuraAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(rubroestructuraAux.getRubroEmplea()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRubroEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(RubroEmplea.class));
				
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
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RubroEmplea.class)) {
						classes.add(new Classe(RubroEmplea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRubroEstructura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
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

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRubroEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RubroEstructuraConstantesFunciones.getClassesRelationshipsOfRubroEstructura(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRubroEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRubroEstructura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RubroEstructuraConstantesFunciones.getClassesRelationshipsFromStringsOfRubroEstructura(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRubroEstructura(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(RubroEstructura rubroestructura,List<RubroEstructura> rubroestructuras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			RubroEstructura rubroestructuraEncontrado=null;
			
			for(RubroEstructura rubroestructuraLocal:rubroestructuras) {
				if(rubroestructuraLocal.getId().equals(rubroestructura.getId())) {
					rubroestructuraEncontrado=rubroestructuraLocal;
					
					rubroestructuraLocal.setIsChanged(rubroestructura.getIsChanged());
					rubroestructuraLocal.setIsNew(rubroestructura.getIsNew());
					rubroestructuraLocal.setIsDeleted(rubroestructura.getIsDeleted());
					
					rubroestructuraLocal.setGeneralEntityOriginal(rubroestructura.getGeneralEntityOriginal());
					
					rubroestructuraLocal.setId(rubroestructura.getId());	
					rubroestructuraLocal.setVersionRow(rubroestructura.getVersionRow());	
					rubroestructuraLocal.setid_empresa(rubroestructura.getid_empresa());	
					rubroestructuraLocal.setid_sucursal(rubroestructura.getid_sucursal());	
					rubroestructuraLocal.setid_estructura(rubroestructura.getid_estructura());	
					rubroestructuraLocal.setid_rubro_emplea(rubroestructura.getid_rubro_emplea());	
					rubroestructuraLocal.setesta_activo(rubroestructura.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!rubroestructura.getIsDeleted()) {
				if(!existe) {
					rubroestructuras.add(rubroestructura);
				}
			} else {
				if(rubroestructuraEncontrado!=null && permiteQuitar)  {
					rubroestructuras.remove(rubroestructuraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(RubroEstructura rubroestructura,List<RubroEstructura> rubroestructuras) throws Exception {
		try	{			
			for(RubroEstructura rubroestructuraLocal:rubroestructuras) {
				if(rubroestructuraLocal.getId().equals(rubroestructura.getId())) {
					rubroestructuraLocal.setIsSelected(rubroestructura.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRubroEstructura(List<RubroEstructura> rubroestructurasAux) throws Exception {
		//this.rubroestructurasAux=rubroestructurasAux;
		
		for(RubroEstructura rubroestructuraAux:rubroestructurasAux) {
			if(rubroestructuraAux.getIsChanged()) {
				rubroestructuraAux.setIsChanged(false);
			}		
			
			if(rubroestructuraAux.getIsNew()) {
				rubroestructuraAux.setIsNew(false);
			}	
			
			if(rubroestructuraAux.getIsDeleted()) {
				rubroestructuraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRubroEstructura(RubroEstructura rubroestructuraAux) throws Exception {
		//this.rubroestructuraAux=rubroestructuraAux;
		
			if(rubroestructuraAux.getIsChanged()) {
				rubroestructuraAux.setIsChanged(false);
			}		
			
			if(rubroestructuraAux.getIsNew()) {
				rubroestructuraAux.setIsNew(false);
			}	
			
			if(rubroestructuraAux.getIsDeleted()) {
				rubroestructuraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RubroEstructura rubroestructuraAsignar,RubroEstructura rubroestructura) throws Exception {
		rubroestructuraAsignar.setId(rubroestructura.getId());	
		rubroestructuraAsignar.setVersionRow(rubroestructura.getVersionRow());	
		rubroestructuraAsignar.setid_empresa(rubroestructura.getid_empresa());
		rubroestructuraAsignar.setempresa_descripcion(rubroestructura.getempresa_descripcion());	
		rubroestructuraAsignar.setid_sucursal(rubroestructura.getid_sucursal());
		rubroestructuraAsignar.setsucursal_descripcion(rubroestructura.getsucursal_descripcion());	
		rubroestructuraAsignar.setid_estructura(rubroestructura.getid_estructura());
		rubroestructuraAsignar.setestructura_descripcion(rubroestructura.getestructura_descripcion());	
		rubroestructuraAsignar.setid_rubro_emplea(rubroestructura.getid_rubro_emplea());
		rubroestructuraAsignar.setrubroemplea_descripcion(rubroestructura.getrubroemplea_descripcion());	
		rubroestructuraAsignar.setesta_activo(rubroestructura.getesta_activo());	
	}
	
	public static void inicializarRubroEstructura(RubroEstructura rubroestructura) throws Exception {
		try {
				rubroestructura.setId(0L);	
					
				rubroestructura.setid_empresa(-1L);	
				rubroestructura.setid_sucursal(-1L);	
				rubroestructura.setid_estructura(-1L);	
				rubroestructura.setid_rubro_emplea(-1L);	
				rubroestructura.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRubroEstructura(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEstructuraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEstructuraConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEstructuraConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEstructuraConstantesFunciones.LABEL_IDRUBROEMPLEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEstructuraConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRubroEstructura(String sTipo,Row row,Workbook workbook,RubroEstructura rubroestructura,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroestructura.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroestructura.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroestructura.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroestructura.getrubroemplea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(rubroestructura.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRubroEstructura=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRubroEstructura() {
		return this.sFinalQueryRubroEstructura;
	}
	
	public void setsFinalQueryRubroEstructura(String sFinalQueryRubroEstructura) {
		this.sFinalQueryRubroEstructura= sFinalQueryRubroEstructura;
	}
	
	public Border resaltarSeleccionarRubroEstructura=null;
	
	public Border setResaltarSeleccionarRubroEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEstructuraBeanSwingJInternalFrame rubroestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//rubroestructuraBeanSwingJInternalFrame.jTtoolBarRubroEstructura.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRubroEstructura= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRubroEstructura() {
		return this.resaltarSeleccionarRubroEstructura;
	}
	
	public void setResaltarSeleccionarRubroEstructura(Border borderResaltarSeleccionarRubroEstructura) {
		this.resaltarSeleccionarRubroEstructura= borderResaltarSeleccionarRubroEstructura;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRubroEstructura=null;
	public Boolean mostraridRubroEstructura=true;
	public Boolean activaridRubroEstructura=true;

	public Border resaltarid_empresaRubroEstructura=null;
	public Boolean mostrarid_empresaRubroEstructura=true;
	public Boolean activarid_empresaRubroEstructura=true;
	public Boolean cargarid_empresaRubroEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRubroEstructura=false;//ConEventDepend=true

	public Border resaltarid_sucursalRubroEstructura=null;
	public Boolean mostrarid_sucursalRubroEstructura=true;
	public Boolean activarid_sucursalRubroEstructura=true;
	public Boolean cargarid_sucursalRubroEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalRubroEstructura=false;//ConEventDepend=true

	public Border resaltarid_estructuraRubroEstructura=null;
	public Boolean mostrarid_estructuraRubroEstructura=true;
	public Boolean activarid_estructuraRubroEstructura=true;
	public Boolean cargarid_estructuraRubroEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraRubroEstructura=false;//ConEventDepend=true

	public Border resaltarid_rubro_empleaRubroEstructura=null;
	public Boolean mostrarid_rubro_empleaRubroEstructura=true;
	public Boolean activarid_rubro_empleaRubroEstructura=true;
	public Boolean cargarid_rubro_empleaRubroEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_rubro_empleaRubroEstructura=false;//ConEventDepend=true

	public Border resaltaresta_activoRubroEstructura=null;
	public Boolean mostraresta_activoRubroEstructura=true;
	public Boolean activaresta_activoRubroEstructura=true;

	
	

	public Border setResaltaridRubroEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEstructuraBeanSwingJInternalFrame rubroestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroestructuraBeanSwingJInternalFrame.jTtoolBarRubroEstructura.setBorder(borderResaltar);
		
		this.resaltaridRubroEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRubroEstructura() {
		return this.resaltaridRubroEstructura;
	}

	public void setResaltaridRubroEstructura(Border borderResaltar) {
		this.resaltaridRubroEstructura= borderResaltar;
	}

	public Boolean getMostraridRubroEstructura() {
		return this.mostraridRubroEstructura;
	}

	public void setMostraridRubroEstructura(Boolean mostraridRubroEstructura) {
		this.mostraridRubroEstructura= mostraridRubroEstructura;
	}

	public Boolean getActivaridRubroEstructura() {
		return this.activaridRubroEstructura;
	}

	public void setActivaridRubroEstructura(Boolean activaridRubroEstructura) {
		this.activaridRubroEstructura= activaridRubroEstructura;
	}

	public Border setResaltarid_empresaRubroEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEstructuraBeanSwingJInternalFrame rubroestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroestructuraBeanSwingJInternalFrame.jTtoolBarRubroEstructura.setBorder(borderResaltar);
		
		this.resaltarid_empresaRubroEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRubroEstructura() {
		return this.resaltarid_empresaRubroEstructura;
	}

	public void setResaltarid_empresaRubroEstructura(Border borderResaltar) {
		this.resaltarid_empresaRubroEstructura= borderResaltar;
	}

	public Boolean getMostrarid_empresaRubroEstructura() {
		return this.mostrarid_empresaRubroEstructura;
	}

	public void setMostrarid_empresaRubroEstructura(Boolean mostrarid_empresaRubroEstructura) {
		this.mostrarid_empresaRubroEstructura= mostrarid_empresaRubroEstructura;
	}

	public Boolean getActivarid_empresaRubroEstructura() {
		return this.activarid_empresaRubroEstructura;
	}

	public void setActivarid_empresaRubroEstructura(Boolean activarid_empresaRubroEstructura) {
		this.activarid_empresaRubroEstructura= activarid_empresaRubroEstructura;
	}

	public Boolean getCargarid_empresaRubroEstructura() {
		return this.cargarid_empresaRubroEstructura;
	}

	public void setCargarid_empresaRubroEstructura(Boolean cargarid_empresaRubroEstructura) {
		this.cargarid_empresaRubroEstructura= cargarid_empresaRubroEstructura;
	}

	public Border setResaltarid_sucursalRubroEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEstructuraBeanSwingJInternalFrame rubroestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroestructuraBeanSwingJInternalFrame.jTtoolBarRubroEstructura.setBorder(borderResaltar);
		
		this.resaltarid_sucursalRubroEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalRubroEstructura() {
		return this.resaltarid_sucursalRubroEstructura;
	}

	public void setResaltarid_sucursalRubroEstructura(Border borderResaltar) {
		this.resaltarid_sucursalRubroEstructura= borderResaltar;
	}

	public Boolean getMostrarid_sucursalRubroEstructura() {
		return this.mostrarid_sucursalRubroEstructura;
	}

	public void setMostrarid_sucursalRubroEstructura(Boolean mostrarid_sucursalRubroEstructura) {
		this.mostrarid_sucursalRubroEstructura= mostrarid_sucursalRubroEstructura;
	}

	public Boolean getActivarid_sucursalRubroEstructura() {
		return this.activarid_sucursalRubroEstructura;
	}

	public void setActivarid_sucursalRubroEstructura(Boolean activarid_sucursalRubroEstructura) {
		this.activarid_sucursalRubroEstructura= activarid_sucursalRubroEstructura;
	}

	public Boolean getCargarid_sucursalRubroEstructura() {
		return this.cargarid_sucursalRubroEstructura;
	}

	public void setCargarid_sucursalRubroEstructura(Boolean cargarid_sucursalRubroEstructura) {
		this.cargarid_sucursalRubroEstructura= cargarid_sucursalRubroEstructura;
	}

	public Border setResaltarid_estructuraRubroEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEstructuraBeanSwingJInternalFrame rubroestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroestructuraBeanSwingJInternalFrame.jTtoolBarRubroEstructura.setBorder(borderResaltar);
		
		this.resaltarid_estructuraRubroEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraRubroEstructura() {
		return this.resaltarid_estructuraRubroEstructura;
	}

	public void setResaltarid_estructuraRubroEstructura(Border borderResaltar) {
		this.resaltarid_estructuraRubroEstructura= borderResaltar;
	}

	public Boolean getMostrarid_estructuraRubroEstructura() {
		return this.mostrarid_estructuraRubroEstructura;
	}

	public void setMostrarid_estructuraRubroEstructura(Boolean mostrarid_estructuraRubroEstructura) {
		this.mostrarid_estructuraRubroEstructura= mostrarid_estructuraRubroEstructura;
	}

	public Boolean getActivarid_estructuraRubroEstructura() {
		return this.activarid_estructuraRubroEstructura;
	}

	public void setActivarid_estructuraRubroEstructura(Boolean activarid_estructuraRubroEstructura) {
		this.activarid_estructuraRubroEstructura= activarid_estructuraRubroEstructura;
	}

	public Boolean getCargarid_estructuraRubroEstructura() {
		return this.cargarid_estructuraRubroEstructura;
	}

	public void setCargarid_estructuraRubroEstructura(Boolean cargarid_estructuraRubroEstructura) {
		this.cargarid_estructuraRubroEstructura= cargarid_estructuraRubroEstructura;
	}

	public Border setResaltarid_rubro_empleaRubroEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEstructuraBeanSwingJInternalFrame rubroestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroestructuraBeanSwingJInternalFrame.jTtoolBarRubroEstructura.setBorder(borderResaltar);
		
		this.resaltarid_rubro_empleaRubroEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_rubro_empleaRubroEstructura() {
		return this.resaltarid_rubro_empleaRubroEstructura;
	}

	public void setResaltarid_rubro_empleaRubroEstructura(Border borderResaltar) {
		this.resaltarid_rubro_empleaRubroEstructura= borderResaltar;
	}

	public Boolean getMostrarid_rubro_empleaRubroEstructura() {
		return this.mostrarid_rubro_empleaRubroEstructura;
	}

	public void setMostrarid_rubro_empleaRubroEstructura(Boolean mostrarid_rubro_empleaRubroEstructura) {
		this.mostrarid_rubro_empleaRubroEstructura= mostrarid_rubro_empleaRubroEstructura;
	}

	public Boolean getActivarid_rubro_empleaRubroEstructura() {
		return this.activarid_rubro_empleaRubroEstructura;
	}

	public void setActivarid_rubro_empleaRubroEstructura(Boolean activarid_rubro_empleaRubroEstructura) {
		this.activarid_rubro_empleaRubroEstructura= activarid_rubro_empleaRubroEstructura;
	}

	public Boolean getCargarid_rubro_empleaRubroEstructura() {
		return this.cargarid_rubro_empleaRubroEstructura;
	}

	public void setCargarid_rubro_empleaRubroEstructura(Boolean cargarid_rubro_empleaRubroEstructura) {
		this.cargarid_rubro_empleaRubroEstructura= cargarid_rubro_empleaRubroEstructura;
	}

	public Border setResaltaresta_activoRubroEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEstructuraBeanSwingJInternalFrame rubroestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroestructuraBeanSwingJInternalFrame.jTtoolBarRubroEstructura.setBorder(borderResaltar);
		
		this.resaltaresta_activoRubroEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoRubroEstructura() {
		return this.resaltaresta_activoRubroEstructura;
	}

	public void setResaltaresta_activoRubroEstructura(Border borderResaltar) {
		this.resaltaresta_activoRubroEstructura= borderResaltar;
	}

	public Boolean getMostraresta_activoRubroEstructura() {
		return this.mostraresta_activoRubroEstructura;
	}

	public void setMostraresta_activoRubroEstructura(Boolean mostraresta_activoRubroEstructura) {
		this.mostraresta_activoRubroEstructura= mostraresta_activoRubroEstructura;
	}

	public Boolean getActivaresta_activoRubroEstructura() {
		return this.activaresta_activoRubroEstructura;
	}

	public void setActivaresta_activoRubroEstructura(Boolean activaresta_activoRubroEstructura) {
		this.activaresta_activoRubroEstructura= activaresta_activoRubroEstructura;
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
		
		
		this.setMostraridRubroEstructura(esInicial);
		this.setMostrarid_empresaRubroEstructura(esInicial);
		this.setMostrarid_sucursalRubroEstructura(esInicial);
		this.setMostrarid_estructuraRubroEstructura(esInicial);
		this.setMostrarid_rubro_empleaRubroEstructura(esInicial);
		this.setMostraresta_activoRubroEstructura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.ID)) {
				this.setMostraridRubroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRubroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalRubroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraRubroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.IDRUBROEMPLEA)) {
				this.setMostrarid_rubro_empleaRubroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoRubroEstructura(esAsigna);
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
		
		
		this.setActivaridRubroEstructura(esInicial);
		this.setActivarid_empresaRubroEstructura(esInicial);
		this.setActivarid_sucursalRubroEstructura(esInicial);
		this.setActivarid_estructuraRubroEstructura(esInicial);
		this.setActivarid_rubro_empleaRubroEstructura(esInicial);
		this.setActivaresta_activoRubroEstructura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.ID)) {
				this.setActivaridRubroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRubroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalRubroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraRubroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.IDRUBROEMPLEA)) {
				this.setActivarid_rubro_empleaRubroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoRubroEstructura(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RubroEstructuraBeanSwingJInternalFrame rubroestructuraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRubroEstructura(esInicial);
		this.setResaltarid_empresaRubroEstructura(esInicial);
		this.setResaltarid_sucursalRubroEstructura(esInicial);
		this.setResaltarid_estructuraRubroEstructura(esInicial);
		this.setResaltarid_rubro_empleaRubroEstructura(esInicial);
		this.setResaltaresta_activoRubroEstructura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.ID)) {
				this.setResaltaridRubroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRubroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalRubroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraRubroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.IDRUBROEMPLEA)) {
				this.setResaltarid_rubro_empleaRubroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEstructuraConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoRubroEstructura(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RubroEstructuraBeanSwingJInternalFrame rubroestructuraBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaRubroEstructura=true;

	public Boolean getMostrarFK_IdEmpresaRubroEstructura() {
		return this.mostrarFK_IdEmpresaRubroEstructura;
	}

	public void setMostrarFK_IdEmpresaRubroEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRubroEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraRubroEstructura=true;

	public Boolean getMostrarFK_IdEstructuraRubroEstructura() {
		return this.mostrarFK_IdEstructuraRubroEstructura;
	}

	public void setMostrarFK_IdEstructuraRubroEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraRubroEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRubroEmpleaRubroEstructura=true;

	public Boolean getMostrarFK_IdRubroEmpleaRubroEstructura() {
		return this.mostrarFK_IdRubroEmpleaRubroEstructura;
	}

	public void setMostrarFK_IdRubroEmpleaRubroEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRubroEmpleaRubroEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalRubroEstructura=true;

	public Boolean getMostrarFK_IdSucursalRubroEstructura() {
		return this.mostrarFK_IdSucursalRubroEstructura;
	}

	public void setMostrarFK_IdSucursalRubroEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalRubroEstructura= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaRubroEstructura=true;

	public Boolean getActivarFK_IdEmpresaRubroEstructura() {
		return this.activarFK_IdEmpresaRubroEstructura;
	}

	public void setActivarFK_IdEmpresaRubroEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRubroEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraRubroEstructura=true;

	public Boolean getActivarFK_IdEstructuraRubroEstructura() {
		return this.activarFK_IdEstructuraRubroEstructura;
	}

	public void setActivarFK_IdEstructuraRubroEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraRubroEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdRubroEmpleaRubroEstructura=true;

	public Boolean getActivarFK_IdRubroEmpleaRubroEstructura() {
		return this.activarFK_IdRubroEmpleaRubroEstructura;
	}

	public void setActivarFK_IdRubroEmpleaRubroEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdRubroEmpleaRubroEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalRubroEstructura=true;

	public Boolean getActivarFK_IdSucursalRubroEstructura() {
		return this.activarFK_IdSucursalRubroEstructura;
	}

	public void setActivarFK_IdSucursalRubroEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalRubroEstructura= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaRubroEstructura=null;

	public Border getResaltarFK_IdEmpresaRubroEstructura() {
		return this.resaltarFK_IdEmpresaRubroEstructura;
	}

	public void setResaltarFK_IdEmpresaRubroEstructura(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRubroEstructura= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRubroEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEstructuraBeanSwingJInternalFrame rubroestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRubroEstructura= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraRubroEstructura=null;

	public Border getResaltarFK_IdEstructuraRubroEstructura() {
		return this.resaltarFK_IdEstructuraRubroEstructura;
	}

	public void setResaltarFK_IdEstructuraRubroEstructura(Border borderResaltar) {
		this.resaltarFK_IdEstructuraRubroEstructura= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraRubroEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEstructuraBeanSwingJInternalFrame rubroestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraRubroEstructura= borderResaltar;
	}

	public Border resaltarFK_IdRubroEmpleaRubroEstructura=null;

	public Border getResaltarFK_IdRubroEmpleaRubroEstructura() {
		return this.resaltarFK_IdRubroEmpleaRubroEstructura;
	}

	public void setResaltarFK_IdRubroEmpleaRubroEstructura(Border borderResaltar) {
		this.resaltarFK_IdRubroEmpleaRubroEstructura= borderResaltar;
	}

	public void setResaltarFK_IdRubroEmpleaRubroEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEstructuraBeanSwingJInternalFrame rubroestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRubroEmpleaRubroEstructura= borderResaltar;
	}

	public Border resaltarFK_IdSucursalRubroEstructura=null;

	public Border getResaltarFK_IdSucursalRubroEstructura() {
		return this.resaltarFK_IdSucursalRubroEstructura;
	}

	public void setResaltarFK_IdSucursalRubroEstructura(Border borderResaltar) {
		this.resaltarFK_IdSucursalRubroEstructura= borderResaltar;
	}

	public void setResaltarFK_IdSucursalRubroEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEstructuraBeanSwingJInternalFrame rubroestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalRubroEstructura= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}