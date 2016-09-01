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


import com.bydan.erp.nomina.util.TallaVestidoConstantesFunciones;
import com.bydan.erp.nomina.util.TallaVestidoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TallaVestidoParameterGeneral;

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
final public class TallaVestidoConstantesFunciones extends TallaVestidoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TallaVestido";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TallaVestido"+TallaVestidoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TallaVestidoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TallaVestidoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TallaVestidoConstantesFunciones.SCHEMA+"_"+TallaVestidoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TallaVestidoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TallaVestidoConstantesFunciones.SCHEMA+"_"+TallaVestidoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TallaVestidoConstantesFunciones.SCHEMA+"_"+TallaVestidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TallaVestidoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TallaVestidoConstantesFunciones.SCHEMA+"_"+TallaVestidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TallaVestidoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TallaVestidoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TallaVestidoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TallaVestidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TallaVestidoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TallaVestidoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TallaVestidoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TallaVestidoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TallaVestidoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TallaVestidoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Talla Vestidos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Talla Vestido";
	public static final String SCLASSWEBTITULO_LOWER="Talla Vestido";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TallaVestido";
	public static final String OBJECTNAME="tallavestido";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="talla_vestido";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tallavestido from "+TallaVestidoConstantesFunciones.SPERSISTENCENAME+" tallavestido";
	public static String QUERYSELECTNATIVE="select "+TallaVestidoConstantesFunciones.SCHEMA+"."+TallaVestidoConstantesFunciones.TABLENAME+".id,"+TallaVestidoConstantesFunciones.SCHEMA+"."+TallaVestidoConstantesFunciones.TABLENAME+".version_row,"+TallaVestidoConstantesFunciones.SCHEMA+"."+TallaVestidoConstantesFunciones.TABLENAME+".id_empresa,"+TallaVestidoConstantesFunciones.SCHEMA+"."+TallaVestidoConstantesFunciones.TABLENAME+".id_empleado,"+TallaVestidoConstantesFunciones.SCHEMA+"."+TallaVestidoConstantesFunciones.TABLENAME+".id_vestimenta,"+TallaVestidoConstantesFunciones.SCHEMA+"."+TallaVestidoConstantesFunciones.TABLENAME+".talla,"+TallaVestidoConstantesFunciones.SCHEMA+"."+TallaVestidoConstantesFunciones.TABLENAME+".cantidad,"+TallaVestidoConstantesFunciones.SCHEMA+"."+TallaVestidoConstantesFunciones.TABLENAME+".descripcion from "+TallaVestidoConstantesFunciones.SCHEMA+"."+TallaVestidoConstantesFunciones.TABLENAME;//+" as "+TallaVestidoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TallaVestidoConstantesFuncionesAdditional tallavestidoConstantesFuncionesAdditional=null;
	
	public TallaVestidoConstantesFuncionesAdditional getTallaVestidoConstantesFuncionesAdditional() {
		return this.tallavestidoConstantesFuncionesAdditional;
	}
	
	public void setTallaVestidoConstantesFuncionesAdditional(TallaVestidoConstantesFuncionesAdditional tallavestidoConstantesFuncionesAdditional) {
		try {
			this.tallavestidoConstantesFuncionesAdditional=tallavestidoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDVESTIMENTA= "id_vestimenta";
    public static final String TALLA= "talla";
    public static final String CANTIDAD= "cantidad";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDVESTIMENTA= "Vestimenta";
		public static final String LABEL_IDVESTIMENTA_LOWER= "Vestimenta";
    	public static final String LABEL_TALLA= "Talla";
		public static final String LABEL_TALLA_LOWER= "Talla";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTallaVestidoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TallaVestidoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TallaVestidoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TallaVestidoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=TallaVestidoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(TallaVestidoConstantesFunciones.IDVESTIMENTA)) {sLabelColumna=TallaVestidoConstantesFunciones.LABEL_IDVESTIMENTA;}
		if(sNombreColumna.equals(TallaVestidoConstantesFunciones.TALLA)) {sLabelColumna=TallaVestidoConstantesFunciones.LABEL_TALLA;}
		if(sNombreColumna.equals(TallaVestidoConstantesFunciones.CANTIDAD)) {sLabelColumna=TallaVestidoConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(TallaVestidoConstantesFunciones.DESCRIPCION)) {sLabelColumna=TallaVestidoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getTallaVestidoDescripcion(TallaVestido tallavestido) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tallavestido !=null/* && tallavestido.getId()!=0*/) {
			if(tallavestido.getId()!=null) {
				sDescripcion=tallavestido.getId().toString();
			}//tallavestidotallavestido.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTallaVestidoDescripcionDetallado(TallaVestido tallavestido) {
		String sDescripcion="";
			
		sDescripcion+=TallaVestidoConstantesFunciones.ID+"=";
		sDescripcion+=tallavestido.getId().toString()+",";
		sDescripcion+=TallaVestidoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tallavestido.getVersionRow().toString()+",";
		sDescripcion+=TallaVestidoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tallavestido.getid_empresa().toString()+",";
		sDescripcion+=TallaVestidoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=tallavestido.getid_empleado().toString()+",";
		sDescripcion+=TallaVestidoConstantesFunciones.IDVESTIMENTA+"=";
		sDescripcion+=tallavestido.getid_vestimenta().toString()+",";
		sDescripcion+=TallaVestidoConstantesFunciones.TALLA+"=";
		sDescripcion+=tallavestido.gettalla().toString()+",";
		sDescripcion+=TallaVestidoConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=tallavestido.getcantidad().toString()+",";
		sDescripcion+=TallaVestidoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tallavestido.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTallaVestidoDescripcion(TallaVestido tallavestido,String sValor) throws Exception {			
		if(tallavestido !=null) {
			//tallavestidotallavestido.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getVestimentaDescripcion(Vestimenta vestimenta) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vestimenta!=null/*&&vestimenta.getId()>0*/) {
			sDescripcion=VestimentaConstantesFunciones.getVestimentaDescripcion(vestimenta);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdVestimenta")) {
			sNombreIndice="Tipo=  Por Vestimenta";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
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

	public static String getDetalleIndiceFK_IdVestimenta(Long id_vestimenta) {
		String sDetalleIndice=" Parametros->";
		if(id_vestimenta!=null) {sDetalleIndice+=" Codigo Unico De Vestimenta="+id_vestimenta.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTallaVestido(TallaVestido tallavestido,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tallavestido.setdescripcion(tallavestido.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTallaVestidos(List<TallaVestido> tallavestidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TallaVestido tallavestido: tallavestidos) {
			tallavestido.setdescripcion(tallavestido.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTallaVestido(TallaVestido tallavestido,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tallavestido.getConCambioAuxiliar()) {
			tallavestido.setIsDeleted(tallavestido.getIsDeletedAuxiliar());	
			tallavestido.setIsNew(tallavestido.getIsNewAuxiliar());	
			tallavestido.setIsChanged(tallavestido.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tallavestido.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tallavestido.setIsDeletedAuxiliar(false);	
			tallavestido.setIsNewAuxiliar(false);	
			tallavestido.setIsChangedAuxiliar(false);
			
			tallavestido.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTallaVestidos(List<TallaVestido> tallavestidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TallaVestido tallavestido : tallavestidos) {
			if(conAsignarBase && tallavestido.getConCambioAuxiliar()) {
				tallavestido.setIsDeleted(tallavestido.getIsDeletedAuxiliar());	
				tallavestido.setIsNew(tallavestido.getIsNewAuxiliar());	
				tallavestido.setIsChanged(tallavestido.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tallavestido.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tallavestido.setIsDeletedAuxiliar(false);	
				tallavestido.setIsNewAuxiliar(false);	
				tallavestido.setIsChangedAuxiliar(false);
				
				tallavestido.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTallaVestido(TallaVestido tallavestido,Boolean conEnteros) throws Exception  {
		tallavestido.settalla(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			tallavestido.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresTallaVestidos(List<TallaVestido> tallavestidos,Boolean conEnteros) throws Exception  {
		
		for(TallaVestido tallavestido: tallavestidos) {
			tallavestido.settalla(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				tallavestido.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaTallaVestido(List<TallaVestido> tallavestidos,TallaVestido tallavestidoAux) throws Exception  {
		TallaVestidoConstantesFunciones.InicializarValoresTallaVestido(tallavestidoAux,true);
		
		for(TallaVestido tallavestido: tallavestidos) {
			if(tallavestido.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tallavestidoAux.settalla(tallavestidoAux.gettalla()+tallavestido.gettalla());			
			tallavestidoAux.setcantidad(tallavestidoAux.getcantidad()+tallavestido.getcantidad());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTallaVestido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TallaVestidoConstantesFunciones.getArrayColumnasGlobalesTallaVestido(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTallaVestido(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TallaVestidoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TallaVestidoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTallaVestido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TallaVestido> tallavestidos,TallaVestido tallavestido,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TallaVestido tallavestidoAux: tallavestidos) {
			if(tallavestidoAux!=null && tallavestido!=null) {
				if((tallavestidoAux.getId()==null && tallavestido.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tallavestidoAux.getId()!=null && tallavestido.getId()!=null){
					if(tallavestidoAux.getId().equals(tallavestido.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTallaVestido(List<TallaVestido> tallavestidos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double tallaTotal=0.0;
	
		for(TallaVestido tallavestido: tallavestidos) {			
			if(tallavestido.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tallaTotal+=tallavestido.gettalla();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TallaVestidoConstantesFunciones.TALLA);
		datoGeneral.setsDescripcion(TallaVestidoConstantesFunciones.LABEL_TALLA);
		datoGeneral.setdValorDouble(tallaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTallaVestido() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TallaVestidoConstantesFunciones.LABEL_ID, TallaVestidoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TallaVestidoConstantesFunciones.LABEL_VERSIONROW, TallaVestidoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TallaVestidoConstantesFunciones.LABEL_IDEMPRESA, TallaVestidoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TallaVestidoConstantesFunciones.LABEL_IDEMPLEADO, TallaVestidoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TallaVestidoConstantesFunciones.LABEL_IDVESTIMENTA, TallaVestidoConstantesFunciones.IDVESTIMENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TallaVestidoConstantesFunciones.LABEL_TALLA, TallaVestidoConstantesFunciones.TALLA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TallaVestidoConstantesFunciones.LABEL_CANTIDAD, TallaVestidoConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TallaVestidoConstantesFunciones.LABEL_DESCRIPCION, TallaVestidoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTallaVestido() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TallaVestidoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TallaVestidoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TallaVestidoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TallaVestidoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TallaVestidoConstantesFunciones.IDVESTIMENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TallaVestidoConstantesFunciones.TALLA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TallaVestidoConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TallaVestidoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTallaVestido() throws Exception  {
		return TallaVestidoConstantesFunciones.getTiposSeleccionarTallaVestido(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTallaVestido(Boolean conFk) throws Exception  {
		return TallaVestidoConstantesFunciones.getTiposSeleccionarTallaVestido(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTallaVestido(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TallaVestidoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TallaVestidoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TallaVestidoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(TallaVestidoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TallaVestidoConstantesFunciones.LABEL_IDVESTIMENTA);
			reporte.setsDescripcion(TallaVestidoConstantesFunciones.LABEL_IDVESTIMENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TallaVestidoConstantesFunciones.LABEL_TALLA);
			reporte.setsDescripcion(TallaVestidoConstantesFunciones.LABEL_TALLA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TallaVestidoConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(TallaVestidoConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TallaVestidoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TallaVestidoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTallaVestido(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTallaVestido(TallaVestido tallavestidoAux) throws Exception {
		
			tallavestidoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tallavestidoAux.getEmpresa()));
			tallavestidoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(tallavestidoAux.getEmpleado()));
			tallavestidoAux.setvestimenta_descripcion(VestimentaConstantesFunciones.getVestimentaDescripcion(tallavestidoAux.getVestimenta()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTallaVestido(List<TallaVestido> tallavestidosTemp) throws Exception {
		for(TallaVestido tallavestidoAux:tallavestidosTemp) {
			
			tallavestidoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tallavestidoAux.getEmpresa()));
			tallavestidoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(tallavestidoAux.getEmpleado()));
			tallavestidoAux.setvestimenta_descripcion(VestimentaConstantesFunciones.getVestimentaDescripcion(tallavestidoAux.getVestimenta()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTallaVestido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Vestimenta.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vestimenta.class)) {
						classes.add(new Classe(Vestimenta.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTallaVestido(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Vestimenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vestimenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Vestimenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vestimenta.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTallaVestido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TallaVestidoConstantesFunciones.getClassesRelationshipsOfTallaVestido(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTallaVestido(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTallaVestido(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TallaVestidoConstantesFunciones.getClassesRelationshipsFromStringsOfTallaVestido(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTallaVestido(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TallaVestido tallavestido,List<TallaVestido> tallavestidos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TallaVestido tallavestidoEncontrado=null;
			
			for(TallaVestido tallavestidoLocal:tallavestidos) {
				if(tallavestidoLocal.getId().equals(tallavestido.getId())) {
					tallavestidoEncontrado=tallavestidoLocal;
					
					tallavestidoLocal.setIsChanged(tallavestido.getIsChanged());
					tallavestidoLocal.setIsNew(tallavestido.getIsNew());
					tallavestidoLocal.setIsDeleted(tallavestido.getIsDeleted());
					
					tallavestidoLocal.setGeneralEntityOriginal(tallavestido.getGeneralEntityOriginal());
					
					tallavestidoLocal.setId(tallavestido.getId());	
					tallavestidoLocal.setVersionRow(tallavestido.getVersionRow());	
					tallavestidoLocal.setid_empresa(tallavestido.getid_empresa());	
					tallavestidoLocal.setid_empleado(tallavestido.getid_empleado());	
					tallavestidoLocal.setid_vestimenta(tallavestido.getid_vestimenta());	
					tallavestidoLocal.settalla(tallavestido.gettalla());	
					tallavestidoLocal.setcantidad(tallavestido.getcantidad());	
					tallavestidoLocal.setdescripcion(tallavestido.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tallavestido.getIsDeleted()) {
				if(!existe) {
					tallavestidos.add(tallavestido);
				}
			} else {
				if(tallavestidoEncontrado!=null && permiteQuitar)  {
					tallavestidos.remove(tallavestidoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TallaVestido tallavestido,List<TallaVestido> tallavestidos) throws Exception {
		try	{			
			for(TallaVestido tallavestidoLocal:tallavestidos) {
				if(tallavestidoLocal.getId().equals(tallavestido.getId())) {
					tallavestidoLocal.setIsSelected(tallavestido.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTallaVestido(List<TallaVestido> tallavestidosAux) throws Exception {
		//this.tallavestidosAux=tallavestidosAux;
		
		for(TallaVestido tallavestidoAux:tallavestidosAux) {
			if(tallavestidoAux.getIsChanged()) {
				tallavestidoAux.setIsChanged(false);
			}		
			
			if(tallavestidoAux.getIsNew()) {
				tallavestidoAux.setIsNew(false);
			}	
			
			if(tallavestidoAux.getIsDeleted()) {
				tallavestidoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTallaVestido(TallaVestido tallavestidoAux) throws Exception {
		//this.tallavestidoAux=tallavestidoAux;
		
			if(tallavestidoAux.getIsChanged()) {
				tallavestidoAux.setIsChanged(false);
			}		
			
			if(tallavestidoAux.getIsNew()) {
				tallavestidoAux.setIsNew(false);
			}	
			
			if(tallavestidoAux.getIsDeleted()) {
				tallavestidoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TallaVestido tallavestidoAsignar,TallaVestido tallavestido) throws Exception {
		tallavestidoAsignar.setId(tallavestido.getId());	
		tallavestidoAsignar.setVersionRow(tallavestido.getVersionRow());	
		tallavestidoAsignar.setid_empresa(tallavestido.getid_empresa());
		tallavestidoAsignar.setempresa_descripcion(tallavestido.getempresa_descripcion());	
		tallavestidoAsignar.setid_empleado(tallavestido.getid_empleado());
		tallavestidoAsignar.setempleado_descripcion(tallavestido.getempleado_descripcion());	
		tallavestidoAsignar.setid_vestimenta(tallavestido.getid_vestimenta());
		tallavestidoAsignar.setvestimenta_descripcion(tallavestido.getvestimenta_descripcion());	
		tallavestidoAsignar.settalla(tallavestido.gettalla());	
		tallavestidoAsignar.setcantidad(tallavestido.getcantidad());	
		tallavestidoAsignar.setdescripcion(tallavestido.getdescripcion());	
	}
	
	public static void inicializarTallaVestido(TallaVestido tallavestido) throws Exception {
		try {
				tallavestido.setId(0L);	
					
				tallavestido.setid_empresa(-1L);	
				tallavestido.setid_empleado(-1L);	
				tallavestido.setid_vestimenta(-1L);	
				tallavestido.settalla(0.0);	
				tallavestido.setcantidad(0);	
				tallavestido.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTallaVestido(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TallaVestidoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TallaVestidoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TallaVestidoConstantesFunciones.LABEL_IDVESTIMENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TallaVestidoConstantesFunciones.LABEL_TALLA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TallaVestidoConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TallaVestidoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTallaVestido(String sTipo,Row row,Workbook workbook,TallaVestido tallavestido,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tallavestido.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tallavestido.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tallavestido.getvestimenta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tallavestido.gettalla());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tallavestido.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tallavestido.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTallaVestido=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTallaVestido() {
		return this.sFinalQueryTallaVestido;
	}
	
	public void setsFinalQueryTallaVestido(String sFinalQueryTallaVestido) {
		this.sFinalQueryTallaVestido= sFinalQueryTallaVestido;
	}
	
	public Border resaltarSeleccionarTallaVestido=null;
	
	public Border setResaltarSeleccionarTallaVestido(ParametroGeneralUsuario parametroGeneralUsuario/*TallaVestidoBeanSwingJInternalFrame tallavestidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tallavestidoBeanSwingJInternalFrame.jTtoolBarTallaVestido.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTallaVestido= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTallaVestido() {
		return this.resaltarSeleccionarTallaVestido;
	}
	
	public void setResaltarSeleccionarTallaVestido(Border borderResaltarSeleccionarTallaVestido) {
		this.resaltarSeleccionarTallaVestido= borderResaltarSeleccionarTallaVestido;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTallaVestido=null;
	public Boolean mostraridTallaVestido=true;
	public Boolean activaridTallaVestido=true;

	public Border resaltarid_empresaTallaVestido=null;
	public Boolean mostrarid_empresaTallaVestido=true;
	public Boolean activarid_empresaTallaVestido=true;
	public Boolean cargarid_empresaTallaVestido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTallaVestido=false;//ConEventDepend=true

	public Border resaltarid_empleadoTallaVestido=null;
	public Boolean mostrarid_empleadoTallaVestido=true;
	public Boolean activarid_empleadoTallaVestido=true;
	public Boolean cargarid_empleadoTallaVestido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoTallaVestido=false;//ConEventDepend=true

	public Border resaltarid_vestimentaTallaVestido=null;
	public Boolean mostrarid_vestimentaTallaVestido=true;
	public Boolean activarid_vestimentaTallaVestido=true;
	public Boolean cargarid_vestimentaTallaVestido=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vestimentaTallaVestido=false;//ConEventDepend=true

	public Border resaltartallaTallaVestido=null;
	public Boolean mostrartallaTallaVestido=true;
	public Boolean activartallaTallaVestido=true;

	public Border resaltarcantidadTallaVestido=null;
	public Boolean mostrarcantidadTallaVestido=true;
	public Boolean activarcantidadTallaVestido=true;

	public Border resaltardescripcionTallaVestido=null;
	public Boolean mostrardescripcionTallaVestido=true;
	public Boolean activardescripcionTallaVestido=true;

	
	

	public Border setResaltaridTallaVestido(ParametroGeneralUsuario parametroGeneralUsuario/*TallaVestidoBeanSwingJInternalFrame tallavestidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tallavestidoBeanSwingJInternalFrame.jTtoolBarTallaVestido.setBorder(borderResaltar);
		
		this.resaltaridTallaVestido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTallaVestido() {
		return this.resaltaridTallaVestido;
	}

	public void setResaltaridTallaVestido(Border borderResaltar) {
		this.resaltaridTallaVestido= borderResaltar;
	}

	public Boolean getMostraridTallaVestido() {
		return this.mostraridTallaVestido;
	}

	public void setMostraridTallaVestido(Boolean mostraridTallaVestido) {
		this.mostraridTallaVestido= mostraridTallaVestido;
	}

	public Boolean getActivaridTallaVestido() {
		return this.activaridTallaVestido;
	}

	public void setActivaridTallaVestido(Boolean activaridTallaVestido) {
		this.activaridTallaVestido= activaridTallaVestido;
	}

	public Border setResaltarid_empresaTallaVestido(ParametroGeneralUsuario parametroGeneralUsuario/*TallaVestidoBeanSwingJInternalFrame tallavestidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tallavestidoBeanSwingJInternalFrame.jTtoolBarTallaVestido.setBorder(borderResaltar);
		
		this.resaltarid_empresaTallaVestido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTallaVestido() {
		return this.resaltarid_empresaTallaVestido;
	}

	public void setResaltarid_empresaTallaVestido(Border borderResaltar) {
		this.resaltarid_empresaTallaVestido= borderResaltar;
	}

	public Boolean getMostrarid_empresaTallaVestido() {
		return this.mostrarid_empresaTallaVestido;
	}

	public void setMostrarid_empresaTallaVestido(Boolean mostrarid_empresaTallaVestido) {
		this.mostrarid_empresaTallaVestido= mostrarid_empresaTallaVestido;
	}

	public Boolean getActivarid_empresaTallaVestido() {
		return this.activarid_empresaTallaVestido;
	}

	public void setActivarid_empresaTallaVestido(Boolean activarid_empresaTallaVestido) {
		this.activarid_empresaTallaVestido= activarid_empresaTallaVestido;
	}

	public Boolean getCargarid_empresaTallaVestido() {
		return this.cargarid_empresaTallaVestido;
	}

	public void setCargarid_empresaTallaVestido(Boolean cargarid_empresaTallaVestido) {
		this.cargarid_empresaTallaVestido= cargarid_empresaTallaVestido;
	}

	public Border setResaltarid_empleadoTallaVestido(ParametroGeneralUsuario parametroGeneralUsuario/*TallaVestidoBeanSwingJInternalFrame tallavestidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tallavestidoBeanSwingJInternalFrame.jTtoolBarTallaVestido.setBorder(borderResaltar);
		
		this.resaltarid_empleadoTallaVestido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoTallaVestido() {
		return this.resaltarid_empleadoTallaVestido;
	}

	public void setResaltarid_empleadoTallaVestido(Border borderResaltar) {
		this.resaltarid_empleadoTallaVestido= borderResaltar;
	}

	public Boolean getMostrarid_empleadoTallaVestido() {
		return this.mostrarid_empleadoTallaVestido;
	}

	public void setMostrarid_empleadoTallaVestido(Boolean mostrarid_empleadoTallaVestido) {
		this.mostrarid_empleadoTallaVestido= mostrarid_empleadoTallaVestido;
	}

	public Boolean getActivarid_empleadoTallaVestido() {
		return this.activarid_empleadoTallaVestido;
	}

	public void setActivarid_empleadoTallaVestido(Boolean activarid_empleadoTallaVestido) {
		this.activarid_empleadoTallaVestido= activarid_empleadoTallaVestido;
	}

	public Boolean getCargarid_empleadoTallaVestido() {
		return this.cargarid_empleadoTallaVestido;
	}

	public void setCargarid_empleadoTallaVestido(Boolean cargarid_empleadoTallaVestido) {
		this.cargarid_empleadoTallaVestido= cargarid_empleadoTallaVestido;
	}

	public Border setResaltarid_vestimentaTallaVestido(ParametroGeneralUsuario parametroGeneralUsuario/*TallaVestidoBeanSwingJInternalFrame tallavestidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tallavestidoBeanSwingJInternalFrame.jTtoolBarTallaVestido.setBorder(borderResaltar);
		
		this.resaltarid_vestimentaTallaVestido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vestimentaTallaVestido() {
		return this.resaltarid_vestimentaTallaVestido;
	}

	public void setResaltarid_vestimentaTallaVestido(Border borderResaltar) {
		this.resaltarid_vestimentaTallaVestido= borderResaltar;
	}

	public Boolean getMostrarid_vestimentaTallaVestido() {
		return this.mostrarid_vestimentaTallaVestido;
	}

	public void setMostrarid_vestimentaTallaVestido(Boolean mostrarid_vestimentaTallaVestido) {
		this.mostrarid_vestimentaTallaVestido= mostrarid_vestimentaTallaVestido;
	}

	public Boolean getActivarid_vestimentaTallaVestido() {
		return this.activarid_vestimentaTallaVestido;
	}

	public void setActivarid_vestimentaTallaVestido(Boolean activarid_vestimentaTallaVestido) {
		this.activarid_vestimentaTallaVestido= activarid_vestimentaTallaVestido;
	}

	public Boolean getCargarid_vestimentaTallaVestido() {
		return this.cargarid_vestimentaTallaVestido;
	}

	public void setCargarid_vestimentaTallaVestido(Boolean cargarid_vestimentaTallaVestido) {
		this.cargarid_vestimentaTallaVestido= cargarid_vestimentaTallaVestido;
	}

	public Border setResaltartallaTallaVestido(ParametroGeneralUsuario parametroGeneralUsuario/*TallaVestidoBeanSwingJInternalFrame tallavestidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tallavestidoBeanSwingJInternalFrame.jTtoolBarTallaVestido.setBorder(borderResaltar);
		
		this.resaltartallaTallaVestido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartallaTallaVestido() {
		return this.resaltartallaTallaVestido;
	}

	public void setResaltartallaTallaVestido(Border borderResaltar) {
		this.resaltartallaTallaVestido= borderResaltar;
	}

	public Boolean getMostrartallaTallaVestido() {
		return this.mostrartallaTallaVestido;
	}

	public void setMostrartallaTallaVestido(Boolean mostrartallaTallaVestido) {
		this.mostrartallaTallaVestido= mostrartallaTallaVestido;
	}

	public Boolean getActivartallaTallaVestido() {
		return this.activartallaTallaVestido;
	}

	public void setActivartallaTallaVestido(Boolean activartallaTallaVestido) {
		this.activartallaTallaVestido= activartallaTallaVestido;
	}

	public Border setResaltarcantidadTallaVestido(ParametroGeneralUsuario parametroGeneralUsuario/*TallaVestidoBeanSwingJInternalFrame tallavestidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tallavestidoBeanSwingJInternalFrame.jTtoolBarTallaVestido.setBorder(borderResaltar);
		
		this.resaltarcantidadTallaVestido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadTallaVestido() {
		return this.resaltarcantidadTallaVestido;
	}

	public void setResaltarcantidadTallaVestido(Border borderResaltar) {
		this.resaltarcantidadTallaVestido= borderResaltar;
	}

	public Boolean getMostrarcantidadTallaVestido() {
		return this.mostrarcantidadTallaVestido;
	}

	public void setMostrarcantidadTallaVestido(Boolean mostrarcantidadTallaVestido) {
		this.mostrarcantidadTallaVestido= mostrarcantidadTallaVestido;
	}

	public Boolean getActivarcantidadTallaVestido() {
		return this.activarcantidadTallaVestido;
	}

	public void setActivarcantidadTallaVestido(Boolean activarcantidadTallaVestido) {
		this.activarcantidadTallaVestido= activarcantidadTallaVestido;
	}

	public Border setResaltardescripcionTallaVestido(ParametroGeneralUsuario parametroGeneralUsuario/*TallaVestidoBeanSwingJInternalFrame tallavestidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tallavestidoBeanSwingJInternalFrame.jTtoolBarTallaVestido.setBorder(borderResaltar);
		
		this.resaltardescripcionTallaVestido= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTallaVestido() {
		return this.resaltardescripcionTallaVestido;
	}

	public void setResaltardescripcionTallaVestido(Border borderResaltar) {
		this.resaltardescripcionTallaVestido= borderResaltar;
	}

	public Boolean getMostrardescripcionTallaVestido() {
		return this.mostrardescripcionTallaVestido;
	}

	public void setMostrardescripcionTallaVestido(Boolean mostrardescripcionTallaVestido) {
		this.mostrardescripcionTallaVestido= mostrardescripcionTallaVestido;
	}

	public Boolean getActivardescripcionTallaVestido() {
		return this.activardescripcionTallaVestido;
	}

	public void setActivardescripcionTallaVestido(Boolean activardescripcionTallaVestido) {
		this.activardescripcionTallaVestido= activardescripcionTallaVestido;
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
		
		
		this.setMostraridTallaVestido(esInicial);
		this.setMostrarid_empresaTallaVestido(esInicial);
		this.setMostrarid_empleadoTallaVestido(esInicial);
		this.setMostrarid_vestimentaTallaVestido(esInicial);
		this.setMostrartallaTallaVestido(esInicial);
		this.setMostrarcantidadTallaVestido(esInicial);
		this.setMostrardescripcionTallaVestido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TallaVestidoConstantesFunciones.ID)) {
				this.setMostraridTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.IDVESTIMENTA)) {
				this.setMostrarid_vestimentaTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.TALLA)) {
				this.setMostrartallaTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTallaVestido(esAsigna);
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
		
		
		this.setActivaridTallaVestido(esInicial);
		this.setActivarid_empresaTallaVestido(esInicial);
		this.setActivarid_empleadoTallaVestido(esInicial);
		this.setActivarid_vestimentaTallaVestido(esInicial);
		this.setActivartallaTallaVestido(esInicial);
		this.setActivarcantidadTallaVestido(esInicial);
		this.setActivardescripcionTallaVestido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TallaVestidoConstantesFunciones.ID)) {
				this.setActivaridTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.IDVESTIMENTA)) {
				this.setActivarid_vestimentaTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.TALLA)) {
				this.setActivartallaTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTallaVestido(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TallaVestidoBeanSwingJInternalFrame tallavestidoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTallaVestido(esInicial);
		this.setResaltarid_empresaTallaVestido(esInicial);
		this.setResaltarid_empleadoTallaVestido(esInicial);
		this.setResaltarid_vestimentaTallaVestido(esInicial);
		this.setResaltartallaTallaVestido(esInicial);
		this.setResaltarcantidadTallaVestido(esInicial);
		this.setResaltardescripcionTallaVestido(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TallaVestidoConstantesFunciones.ID)) {
				this.setResaltaridTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.IDVESTIMENTA)) {
				this.setResaltarid_vestimentaTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.TALLA)) {
				this.setResaltartallaTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadTallaVestido(esAsigna);
				continue;
			}

			if(campo.clase.equals(TallaVestidoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTallaVestido(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TallaVestidoBeanSwingJInternalFrame tallavestidoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoTallaVestido=true;

	public Boolean getMostrarFK_IdEmpleadoTallaVestido() {
		return this.mostrarFK_IdEmpleadoTallaVestido;
	}

	public void setMostrarFK_IdEmpleadoTallaVestido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoTallaVestido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTallaVestido=true;

	public Boolean getMostrarFK_IdEmpresaTallaVestido() {
		return this.mostrarFK_IdEmpresaTallaVestido;
	}

	public void setMostrarFK_IdEmpresaTallaVestido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTallaVestido= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVestimentaTallaVestido=true;

	public Boolean getMostrarFK_IdVestimentaTallaVestido() {
		return this.mostrarFK_IdVestimentaTallaVestido;
	}

	public void setMostrarFK_IdVestimentaTallaVestido(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVestimentaTallaVestido= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoTallaVestido=true;

	public Boolean getActivarFK_IdEmpleadoTallaVestido() {
		return this.activarFK_IdEmpleadoTallaVestido;
	}

	public void setActivarFK_IdEmpleadoTallaVestido(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoTallaVestido= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTallaVestido=true;

	public Boolean getActivarFK_IdEmpresaTallaVestido() {
		return this.activarFK_IdEmpresaTallaVestido;
	}

	public void setActivarFK_IdEmpresaTallaVestido(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTallaVestido= habilitarResaltar;
	}

	public Boolean activarFK_IdVestimentaTallaVestido=true;

	public Boolean getActivarFK_IdVestimentaTallaVestido() {
		return this.activarFK_IdVestimentaTallaVestido;
	}

	public void setActivarFK_IdVestimentaTallaVestido(Boolean habilitarResaltar) {
		this.activarFK_IdVestimentaTallaVestido= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoTallaVestido=null;

	public Border getResaltarFK_IdEmpleadoTallaVestido() {
		return this.resaltarFK_IdEmpleadoTallaVestido;
	}

	public void setResaltarFK_IdEmpleadoTallaVestido(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoTallaVestido= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoTallaVestido(ParametroGeneralUsuario parametroGeneralUsuario/*TallaVestidoBeanSwingJInternalFrame tallavestidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoTallaVestido= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTallaVestido=null;

	public Border getResaltarFK_IdEmpresaTallaVestido() {
		return this.resaltarFK_IdEmpresaTallaVestido;
	}

	public void setResaltarFK_IdEmpresaTallaVestido(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTallaVestido= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTallaVestido(ParametroGeneralUsuario parametroGeneralUsuario/*TallaVestidoBeanSwingJInternalFrame tallavestidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTallaVestido= borderResaltar;
	}

	public Border resaltarFK_IdVestimentaTallaVestido=null;

	public Border getResaltarFK_IdVestimentaTallaVestido() {
		return this.resaltarFK_IdVestimentaTallaVestido;
	}

	public void setResaltarFK_IdVestimentaTallaVestido(Border borderResaltar) {
		this.resaltarFK_IdVestimentaTallaVestido= borderResaltar;
	}

	public void setResaltarFK_IdVestimentaTallaVestido(ParametroGeneralUsuario parametroGeneralUsuario/*TallaVestidoBeanSwingJInternalFrame tallavestidoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVestimentaTallaVestido= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}