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


import com.bydan.erp.puntoventa.util.DepositoBancoConstantesFunciones;
import com.bydan.erp.puntoventa.util.DepositoBancoParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.DepositoBancoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DepositoBancoConstantesFunciones extends DepositoBancoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DepositoBanco";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DepositoBanco"+DepositoBancoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DepositoBancoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DepositoBancoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DepositoBancoConstantesFunciones.SCHEMA+"_"+DepositoBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DepositoBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DepositoBancoConstantesFunciones.SCHEMA+"_"+DepositoBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DepositoBancoConstantesFunciones.SCHEMA+"_"+DepositoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DepositoBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DepositoBancoConstantesFunciones.SCHEMA+"_"+DepositoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DepositoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DepositoBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DepositoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DepositoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DepositoBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DepositoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DepositoBancoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DepositoBancoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DepositoBancoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DepositoBancoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Deposito Bancos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Deposito Banco";
	public static final String SCLASSWEBTITULO_LOWER="Deposito Banco";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DepositoBanco";
	public static final String OBJECTNAME="depositobanco";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="deposito_banco";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select depositobanco from "+DepositoBancoConstantesFunciones.SPERSISTENCENAME+" depositobanco";
	public static String QUERYSELECTNATIVE="select "+DepositoBancoConstantesFunciones.SCHEMA+"."+DepositoBancoConstantesFunciones.TABLENAME+".id,"+DepositoBancoConstantesFunciones.SCHEMA+"."+DepositoBancoConstantesFunciones.TABLENAME+".version_row,"+DepositoBancoConstantesFunciones.SCHEMA+"."+DepositoBancoConstantesFunciones.TABLENAME+".id_empresa,"+DepositoBancoConstantesFunciones.SCHEMA+"."+DepositoBancoConstantesFunciones.TABLENAME+".id_sucursal,"+DepositoBancoConstantesFunciones.SCHEMA+"."+DepositoBancoConstantesFunciones.TABLENAME+".id_usuario,"+DepositoBancoConstantesFunciones.SCHEMA+"."+DepositoBancoConstantesFunciones.TABLENAME+".id_banco,"+DepositoBancoConstantesFunciones.SCHEMA+"."+DepositoBancoConstantesFunciones.TABLENAME+".id_asiento_contable,"+DepositoBancoConstantesFunciones.SCHEMA+"."+DepositoBancoConstantesFunciones.TABLENAME+".fecha,"+DepositoBancoConstantesFunciones.SCHEMA+"."+DepositoBancoConstantesFunciones.TABLENAME+".valor_efectivo,"+DepositoBancoConstantesFunciones.SCHEMA+"."+DepositoBancoConstantesFunciones.TABLENAME+".valor_cheque,"+DepositoBancoConstantesFunciones.SCHEMA+"."+DepositoBancoConstantesFunciones.TABLENAME+".descripcion from "+DepositoBancoConstantesFunciones.SCHEMA+"."+DepositoBancoConstantesFunciones.TABLENAME;//+" as "+DepositoBancoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DepositoBancoConstantesFuncionesAdditional depositobancoConstantesFuncionesAdditional=null;
	
	public DepositoBancoConstantesFuncionesAdditional getDepositoBancoConstantesFuncionesAdditional() {
		return this.depositobancoConstantesFuncionesAdditional;
	}
	
	public void setDepositoBancoConstantesFuncionesAdditional(DepositoBancoConstantesFuncionesAdditional depositobancoConstantesFuncionesAdditional) {
		try {
			this.depositobancoConstantesFuncionesAdditional=depositobancoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDBANCO= "id_banco";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String FECHA= "fecha";
    public static final String VALOREFECTIVO= "valor_efectivo";
    public static final String VALORCHEQUE= "valor_cheque";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDBANCO= "Banco";
		public static final String LABEL_IDBANCO_LOWER= "Banco";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_VALOREFECTIVO= "Valor Efectivo";
		public static final String LABEL_VALOREFECTIVO_LOWER= "Valor Efectivo";
    	public static final String LABEL_VALORCHEQUE= "Valor Cheque";
		public static final String LABEL_VALORCHEQUE_LOWER= "Valor Cheque";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDepositoBancoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DepositoBancoConstantesFunciones.IDEMPRESA)) {sLabelColumna=DepositoBancoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DepositoBancoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DepositoBancoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DepositoBancoConstantesFunciones.IDUSUARIO)) {sLabelColumna=DepositoBancoConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(DepositoBancoConstantesFunciones.IDBANCO)) {sLabelColumna=DepositoBancoConstantesFunciones.LABEL_IDBANCO;}
		if(sNombreColumna.equals(DepositoBancoConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=DepositoBancoConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(DepositoBancoConstantesFunciones.FECHA)) {sLabelColumna=DepositoBancoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(DepositoBancoConstantesFunciones.VALOREFECTIVO)) {sLabelColumna=DepositoBancoConstantesFunciones.LABEL_VALOREFECTIVO;}
		if(sNombreColumna.equals(DepositoBancoConstantesFunciones.VALORCHEQUE)) {sLabelColumna=DepositoBancoConstantesFunciones.LABEL_VALORCHEQUE;}
		if(sNombreColumna.equals(DepositoBancoConstantesFunciones.DESCRIPCION)) {sLabelColumna=DepositoBancoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDepositoBancoDescripcion(DepositoBanco depositobanco) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(depositobanco !=null/* && depositobanco.getId()!=0*/) {
			if(depositobanco.getId()!=null) {
				sDescripcion=depositobanco.getId().toString();
			}//depositobancodepositobanco.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDepositoBancoDescripcionDetallado(DepositoBanco depositobanco) {
		String sDescripcion="";
			
		sDescripcion+=DepositoBancoConstantesFunciones.ID+"=";
		sDescripcion+=depositobanco.getId().toString()+",";
		sDescripcion+=DepositoBancoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=depositobanco.getVersionRow().toString()+",";
		sDescripcion+=DepositoBancoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=depositobanco.getid_empresa().toString()+",";
		sDescripcion+=DepositoBancoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=depositobanco.getid_sucursal().toString()+",";
		sDescripcion+=DepositoBancoConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=depositobanco.getid_usuario().toString()+",";
		sDescripcion+=DepositoBancoConstantesFunciones.IDBANCO+"=";
		sDescripcion+=depositobanco.getid_banco().toString()+",";
		sDescripcion+=DepositoBancoConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=depositobanco.getid_asiento_contable().toString()+",";
		sDescripcion+=DepositoBancoConstantesFunciones.FECHA+"=";
		sDescripcion+=depositobanco.getfecha().toString()+",";
		sDescripcion+=DepositoBancoConstantesFunciones.VALOREFECTIVO+"=";
		sDescripcion+=depositobanco.getvalor_efectivo().toString()+",";
		sDescripcion+=DepositoBancoConstantesFunciones.VALORCHEQUE+"=";
		sDescripcion+=depositobanco.getvalor_cheque().toString()+",";
		sDescripcion+=DepositoBancoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=depositobanco.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setDepositoBancoDescripcion(DepositoBanco depositobanco,String sValor) throws Exception {			
		if(depositobanco !=null) {
			//depositobancodepositobanco.getId().toString();
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getBancoDescripcion(Banco banco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(banco!=null/*&&banco.getId()>0*/) {
			sDescripcion=BancoConstantesFunciones.getBancoDescripcion(banco);
		}

		return sDescripcion;
	}

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdBanco")) {
			sNombreIndice="Tipo=  Por Banco";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBanco(Long id_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_banco!=null) {sDetalleIndice+=" Codigo Unico De Banco="+id_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDepositoBanco(DepositoBanco depositobanco,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		depositobanco.setdescripcion(depositobanco.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDepositoBancos(List<DepositoBanco> depositobancos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DepositoBanco depositobanco: depositobancos) {
			depositobanco.setdescripcion(depositobanco.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDepositoBanco(DepositoBanco depositobanco,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && depositobanco.getConCambioAuxiliar()) {
			depositobanco.setIsDeleted(depositobanco.getIsDeletedAuxiliar());	
			depositobanco.setIsNew(depositobanco.getIsNewAuxiliar());	
			depositobanco.setIsChanged(depositobanco.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			depositobanco.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			depositobanco.setIsDeletedAuxiliar(false);	
			depositobanco.setIsNewAuxiliar(false);	
			depositobanco.setIsChangedAuxiliar(false);
			
			depositobanco.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDepositoBancos(List<DepositoBanco> depositobancos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DepositoBanco depositobanco : depositobancos) {
			if(conAsignarBase && depositobanco.getConCambioAuxiliar()) {
				depositobanco.setIsDeleted(depositobanco.getIsDeletedAuxiliar());	
				depositobanco.setIsNew(depositobanco.getIsNewAuxiliar());	
				depositobanco.setIsChanged(depositobanco.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				depositobanco.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				depositobanco.setIsDeletedAuxiliar(false);	
				depositobanco.setIsNewAuxiliar(false);	
				depositobanco.setIsChangedAuxiliar(false);
				
				depositobanco.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDepositoBanco(DepositoBanco depositobanco,Boolean conEnteros) throws Exception  {
		depositobanco.setvalor_efectivo(0.0);
		depositobanco.setvalor_cheque(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDepositoBancos(List<DepositoBanco> depositobancos,Boolean conEnteros) throws Exception  {
		
		for(DepositoBanco depositobanco: depositobancos) {
			depositobanco.setvalor_efectivo(0.0);
			depositobanco.setvalor_cheque(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDepositoBanco(List<DepositoBanco> depositobancos,DepositoBanco depositobancoAux) throws Exception  {
		DepositoBancoConstantesFunciones.InicializarValoresDepositoBanco(depositobancoAux,true);
		
		for(DepositoBanco depositobanco: depositobancos) {
			if(depositobanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			depositobancoAux.setvalor_efectivo(depositobancoAux.getvalor_efectivo()+depositobanco.getvalor_efectivo());			
			depositobancoAux.setvalor_cheque(depositobancoAux.getvalor_cheque()+depositobanco.getvalor_cheque());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDepositoBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DepositoBancoConstantesFunciones.getArrayColumnasGlobalesDepositoBanco(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDepositoBanco(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DepositoBancoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DepositoBancoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DepositoBancoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DepositoBancoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DepositoBancoConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DepositoBancoConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDepositoBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DepositoBanco> depositobancos,DepositoBanco depositobanco,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DepositoBanco depositobancoAux: depositobancos) {
			if(depositobancoAux!=null && depositobanco!=null) {
				if((depositobancoAux.getId()==null && depositobanco.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(depositobancoAux.getId()!=null && depositobanco.getId()!=null){
					if(depositobancoAux.getId().equals(depositobanco.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDepositoBanco(List<DepositoBanco> depositobancos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_efectivoTotal=0.0;
		Double valor_chequeTotal=0.0;
	
		for(DepositoBanco depositobanco: depositobancos) {			
			if(depositobanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_efectivoTotal+=depositobanco.getvalor_efectivo();
			valor_chequeTotal+=depositobanco.getvalor_cheque();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepositoBancoConstantesFunciones.VALOREFECTIVO);
		datoGeneral.setsDescripcion(DepositoBancoConstantesFunciones.LABEL_VALOREFECTIVO);
		datoGeneral.setdValorDouble(valor_efectivoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepositoBancoConstantesFunciones.VALORCHEQUE);
		datoGeneral.setsDescripcion(DepositoBancoConstantesFunciones.LABEL_VALORCHEQUE);
		datoGeneral.setdValorDouble(valor_chequeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDepositoBanco() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DepositoBancoConstantesFunciones.LABEL_ID, DepositoBancoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepositoBancoConstantesFunciones.LABEL_VERSIONROW, DepositoBancoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepositoBancoConstantesFunciones.LABEL_IDEMPRESA, DepositoBancoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepositoBancoConstantesFunciones.LABEL_IDSUCURSAL, DepositoBancoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepositoBancoConstantesFunciones.LABEL_IDUSUARIO, DepositoBancoConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepositoBancoConstantesFunciones.LABEL_IDBANCO, DepositoBancoConstantesFunciones.IDBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepositoBancoConstantesFunciones.LABEL_IDASIENTOCONTABLE, DepositoBancoConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepositoBancoConstantesFunciones.LABEL_FECHA, DepositoBancoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepositoBancoConstantesFunciones.LABEL_VALOREFECTIVO, DepositoBancoConstantesFunciones.VALOREFECTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepositoBancoConstantesFunciones.LABEL_VALORCHEQUE, DepositoBancoConstantesFunciones.VALORCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepositoBancoConstantesFunciones.LABEL_DESCRIPCION, DepositoBancoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDepositoBanco() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DepositoBancoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepositoBancoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepositoBancoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepositoBancoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepositoBancoConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepositoBancoConstantesFunciones.IDBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepositoBancoConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepositoBancoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepositoBancoConstantesFunciones.VALOREFECTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepositoBancoConstantesFunciones.VALORCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepositoBancoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDepositoBanco() throws Exception  {
		return DepositoBancoConstantesFunciones.getTiposSeleccionarDepositoBanco(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDepositoBanco(Boolean conFk) throws Exception  {
		return DepositoBancoConstantesFunciones.getTiposSeleccionarDepositoBanco(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDepositoBanco(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepositoBancoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DepositoBancoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepositoBancoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DepositoBancoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepositoBancoConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(DepositoBancoConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepositoBancoConstantesFunciones.LABEL_IDBANCO);
			reporte.setsDescripcion(DepositoBancoConstantesFunciones.LABEL_IDBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepositoBancoConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(DepositoBancoConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepositoBancoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(DepositoBancoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepositoBancoConstantesFunciones.LABEL_VALOREFECTIVO);
			reporte.setsDescripcion(DepositoBancoConstantesFunciones.LABEL_VALOREFECTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepositoBancoConstantesFunciones.LABEL_VALORCHEQUE);
			reporte.setsDescripcion(DepositoBancoConstantesFunciones.LABEL_VALORCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepositoBancoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DepositoBancoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDepositoBanco(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDepositoBanco(DepositoBanco depositobancoAux) throws Exception {
		
			depositobancoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(depositobancoAux.getEmpresa()));
			depositobancoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(depositobancoAux.getSucursal()));
			depositobancoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(depositobancoAux.getUsuario()));
			depositobancoAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(depositobancoAux.getBanco()));
			depositobancoAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(depositobancoAux.getAsientoContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDepositoBanco(List<DepositoBanco> depositobancosTemp) throws Exception {
		for(DepositoBanco depositobancoAux:depositobancosTemp) {
			
			depositobancoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(depositobancoAux.getEmpresa()));
			depositobancoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(depositobancoAux.getSucursal()));
			depositobancoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(depositobancoAux.getUsuario()));
			depositobancoAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(depositobancoAux.getBanco()));
			depositobancoAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(depositobancoAux.getAsientoContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDepositoBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Banco.class));
				classes.add(new Classe(AsientoContable.class));
				
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
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Banco.class)) {
						classes.add(new Classe(Banco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDepositoBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDepositoBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DepositoBancoConstantesFunciones.getClassesRelationshipsOfDepositoBanco(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDepositoBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDepositoBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DepositoBancoConstantesFunciones.getClassesRelationshipsFromStringsOfDepositoBanco(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDepositoBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DepositoBanco depositobanco,List<DepositoBanco> depositobancos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DepositoBanco depositobancoEncontrado=null;
			
			for(DepositoBanco depositobancoLocal:depositobancos) {
				if(depositobancoLocal.getId().equals(depositobanco.getId())) {
					depositobancoEncontrado=depositobancoLocal;
					
					depositobancoLocal.setIsChanged(depositobanco.getIsChanged());
					depositobancoLocal.setIsNew(depositobanco.getIsNew());
					depositobancoLocal.setIsDeleted(depositobanco.getIsDeleted());
					
					depositobancoLocal.setGeneralEntityOriginal(depositobanco.getGeneralEntityOriginal());
					
					depositobancoLocal.setId(depositobanco.getId());	
					depositobancoLocal.setVersionRow(depositobanco.getVersionRow());	
					depositobancoLocal.setid_empresa(depositobanco.getid_empresa());	
					depositobancoLocal.setid_sucursal(depositobanco.getid_sucursal());	
					depositobancoLocal.setid_usuario(depositobanco.getid_usuario());	
					depositobancoLocal.setid_banco(depositobanco.getid_banco());	
					depositobancoLocal.setid_asiento_contable(depositobanco.getid_asiento_contable());	
					depositobancoLocal.setfecha(depositobanco.getfecha());	
					depositobancoLocal.setvalor_efectivo(depositobanco.getvalor_efectivo());	
					depositobancoLocal.setvalor_cheque(depositobanco.getvalor_cheque());	
					depositobancoLocal.setdescripcion(depositobanco.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!depositobanco.getIsDeleted()) {
				if(!existe) {
					depositobancos.add(depositobanco);
				}
			} else {
				if(depositobancoEncontrado!=null && permiteQuitar)  {
					depositobancos.remove(depositobancoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DepositoBanco depositobanco,List<DepositoBanco> depositobancos) throws Exception {
		try	{			
			for(DepositoBanco depositobancoLocal:depositobancos) {
				if(depositobancoLocal.getId().equals(depositobanco.getId())) {
					depositobancoLocal.setIsSelected(depositobanco.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDepositoBanco(List<DepositoBanco> depositobancosAux) throws Exception {
		//this.depositobancosAux=depositobancosAux;
		
		for(DepositoBanco depositobancoAux:depositobancosAux) {
			if(depositobancoAux.getIsChanged()) {
				depositobancoAux.setIsChanged(false);
			}		
			
			if(depositobancoAux.getIsNew()) {
				depositobancoAux.setIsNew(false);
			}	
			
			if(depositobancoAux.getIsDeleted()) {
				depositobancoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDepositoBanco(DepositoBanco depositobancoAux) throws Exception {
		//this.depositobancoAux=depositobancoAux;
		
			if(depositobancoAux.getIsChanged()) {
				depositobancoAux.setIsChanged(false);
			}		
			
			if(depositobancoAux.getIsNew()) {
				depositobancoAux.setIsNew(false);
			}	
			
			if(depositobancoAux.getIsDeleted()) {
				depositobancoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DepositoBanco depositobancoAsignar,DepositoBanco depositobanco) throws Exception {
		depositobancoAsignar.setId(depositobanco.getId());	
		depositobancoAsignar.setVersionRow(depositobanco.getVersionRow());	
		depositobancoAsignar.setid_empresa(depositobanco.getid_empresa());
		depositobancoAsignar.setempresa_descripcion(depositobanco.getempresa_descripcion());	
		depositobancoAsignar.setid_sucursal(depositobanco.getid_sucursal());
		depositobancoAsignar.setsucursal_descripcion(depositobanco.getsucursal_descripcion());	
		depositobancoAsignar.setid_usuario(depositobanco.getid_usuario());
		depositobancoAsignar.setusuario_descripcion(depositobanco.getusuario_descripcion());	
		depositobancoAsignar.setid_banco(depositobanco.getid_banco());
		depositobancoAsignar.setbanco_descripcion(depositobanco.getbanco_descripcion());	
		depositobancoAsignar.setid_asiento_contable(depositobanco.getid_asiento_contable());
		depositobancoAsignar.setasientocontable_descripcion(depositobanco.getasientocontable_descripcion());	
		depositobancoAsignar.setfecha(depositobanco.getfecha());	
		depositobancoAsignar.setvalor_efectivo(depositobanco.getvalor_efectivo());	
		depositobancoAsignar.setvalor_cheque(depositobanco.getvalor_cheque());	
		depositobancoAsignar.setdescripcion(depositobanco.getdescripcion());	
	}
	
	public static void inicializarDepositoBanco(DepositoBanco depositobanco) throws Exception {
		try {
				depositobanco.setId(0L);	
					
				depositobanco.setid_empresa(-1L);	
				depositobanco.setid_sucursal(-1L);	
				depositobanco.setid_usuario(-1L);	
				depositobanco.setid_banco(-1L);	
				depositobanco.setid_asiento_contable(null);	
				depositobanco.setfecha(new Date());	
				depositobanco.setvalor_efectivo(0.0);	
				depositobanco.setvalor_cheque(0.0);	
				depositobanco.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDepositoBanco(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DepositoBancoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepositoBancoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepositoBancoConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepositoBancoConstantesFunciones.LABEL_IDBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepositoBancoConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepositoBancoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepositoBancoConstantesFunciones.LABEL_VALOREFECTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepositoBancoConstantesFunciones.LABEL_VALORCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepositoBancoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDepositoBanco(String sTipo,Row row,Workbook workbook,DepositoBanco depositobanco,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(depositobanco.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depositobanco.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depositobanco.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depositobanco.getbanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depositobanco.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depositobanco.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depositobanco.getvalor_efectivo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depositobanco.getvalor_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depositobanco.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDepositoBanco=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDepositoBanco() {
		return this.sFinalQueryDepositoBanco;
	}
	
	public void setsFinalQueryDepositoBanco(String sFinalQueryDepositoBanco) {
		this.sFinalQueryDepositoBanco= sFinalQueryDepositoBanco;
	}
	
	public Border resaltarSeleccionarDepositoBanco=null;
	
	public Border setResaltarSeleccionarDepositoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//depositobancoBeanSwingJInternalFrame.jTtoolBarDepositoBanco.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDepositoBanco= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDepositoBanco() {
		return this.resaltarSeleccionarDepositoBanco;
	}
	
	public void setResaltarSeleccionarDepositoBanco(Border borderResaltarSeleccionarDepositoBanco) {
		this.resaltarSeleccionarDepositoBanco= borderResaltarSeleccionarDepositoBanco;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDepositoBanco=null;
	public Boolean mostraridDepositoBanco=true;
	public Boolean activaridDepositoBanco=true;

	public Border resaltarid_empresaDepositoBanco=null;
	public Boolean mostrarid_empresaDepositoBanco=true;
	public Boolean activarid_empresaDepositoBanco=true;
	public Boolean cargarid_empresaDepositoBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDepositoBanco=false;//ConEventDepend=true

	public Border resaltarid_sucursalDepositoBanco=null;
	public Boolean mostrarid_sucursalDepositoBanco=true;
	public Boolean activarid_sucursalDepositoBanco=true;
	public Boolean cargarid_sucursalDepositoBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDepositoBanco=false;//ConEventDepend=true

	public Border resaltarid_usuarioDepositoBanco=null;
	public Boolean mostrarid_usuarioDepositoBanco=true;
	public Boolean activarid_usuarioDepositoBanco=true;
	public Boolean cargarid_usuarioDepositoBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioDepositoBanco=false;//ConEventDepend=true

	public Border resaltarid_bancoDepositoBanco=null;
	public Boolean mostrarid_bancoDepositoBanco=true;
	public Boolean activarid_bancoDepositoBanco=true;
	public Boolean cargarid_bancoDepositoBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bancoDepositoBanco=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableDepositoBanco=null;
	public Boolean mostrarid_asiento_contableDepositoBanco=true;
	public Boolean activarid_asiento_contableDepositoBanco=true;
	public Boolean cargarid_asiento_contableDepositoBanco=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableDepositoBanco=false;//ConEventDepend=true

	public Border resaltarfechaDepositoBanco=null;
	public Boolean mostrarfechaDepositoBanco=true;
	public Boolean activarfechaDepositoBanco=true;

	public Border resaltarvalor_efectivoDepositoBanco=null;
	public Boolean mostrarvalor_efectivoDepositoBanco=true;
	public Boolean activarvalor_efectivoDepositoBanco=true;

	public Border resaltarvalor_chequeDepositoBanco=null;
	public Boolean mostrarvalor_chequeDepositoBanco=true;
	public Boolean activarvalor_chequeDepositoBanco=true;

	public Border resaltardescripcionDepositoBanco=null;
	public Boolean mostrardescripcionDepositoBanco=true;
	public Boolean activardescripcionDepositoBanco=true;

	
	

	public Border setResaltaridDepositoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depositobancoBeanSwingJInternalFrame.jTtoolBarDepositoBanco.setBorder(borderResaltar);
		
		this.resaltaridDepositoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDepositoBanco() {
		return this.resaltaridDepositoBanco;
	}

	public void setResaltaridDepositoBanco(Border borderResaltar) {
		this.resaltaridDepositoBanco= borderResaltar;
	}

	public Boolean getMostraridDepositoBanco() {
		return this.mostraridDepositoBanco;
	}

	public void setMostraridDepositoBanco(Boolean mostraridDepositoBanco) {
		this.mostraridDepositoBanco= mostraridDepositoBanco;
	}

	public Boolean getActivaridDepositoBanco() {
		return this.activaridDepositoBanco;
	}

	public void setActivaridDepositoBanco(Boolean activaridDepositoBanco) {
		this.activaridDepositoBanco= activaridDepositoBanco;
	}

	public Border setResaltarid_empresaDepositoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depositobancoBeanSwingJInternalFrame.jTtoolBarDepositoBanco.setBorder(borderResaltar);
		
		this.resaltarid_empresaDepositoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDepositoBanco() {
		return this.resaltarid_empresaDepositoBanco;
	}

	public void setResaltarid_empresaDepositoBanco(Border borderResaltar) {
		this.resaltarid_empresaDepositoBanco= borderResaltar;
	}

	public Boolean getMostrarid_empresaDepositoBanco() {
		return this.mostrarid_empresaDepositoBanco;
	}

	public void setMostrarid_empresaDepositoBanco(Boolean mostrarid_empresaDepositoBanco) {
		this.mostrarid_empresaDepositoBanco= mostrarid_empresaDepositoBanco;
	}

	public Boolean getActivarid_empresaDepositoBanco() {
		return this.activarid_empresaDepositoBanco;
	}

	public void setActivarid_empresaDepositoBanco(Boolean activarid_empresaDepositoBanco) {
		this.activarid_empresaDepositoBanco= activarid_empresaDepositoBanco;
	}

	public Boolean getCargarid_empresaDepositoBanco() {
		return this.cargarid_empresaDepositoBanco;
	}

	public void setCargarid_empresaDepositoBanco(Boolean cargarid_empresaDepositoBanco) {
		this.cargarid_empresaDepositoBanco= cargarid_empresaDepositoBanco;
	}

	public Border setResaltarid_sucursalDepositoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depositobancoBeanSwingJInternalFrame.jTtoolBarDepositoBanco.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDepositoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDepositoBanco() {
		return this.resaltarid_sucursalDepositoBanco;
	}

	public void setResaltarid_sucursalDepositoBanco(Border borderResaltar) {
		this.resaltarid_sucursalDepositoBanco= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDepositoBanco() {
		return this.mostrarid_sucursalDepositoBanco;
	}

	public void setMostrarid_sucursalDepositoBanco(Boolean mostrarid_sucursalDepositoBanco) {
		this.mostrarid_sucursalDepositoBanco= mostrarid_sucursalDepositoBanco;
	}

	public Boolean getActivarid_sucursalDepositoBanco() {
		return this.activarid_sucursalDepositoBanco;
	}

	public void setActivarid_sucursalDepositoBanco(Boolean activarid_sucursalDepositoBanco) {
		this.activarid_sucursalDepositoBanco= activarid_sucursalDepositoBanco;
	}

	public Boolean getCargarid_sucursalDepositoBanco() {
		return this.cargarid_sucursalDepositoBanco;
	}

	public void setCargarid_sucursalDepositoBanco(Boolean cargarid_sucursalDepositoBanco) {
		this.cargarid_sucursalDepositoBanco= cargarid_sucursalDepositoBanco;
	}

	public Border setResaltarid_usuarioDepositoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depositobancoBeanSwingJInternalFrame.jTtoolBarDepositoBanco.setBorder(borderResaltar);
		
		this.resaltarid_usuarioDepositoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioDepositoBanco() {
		return this.resaltarid_usuarioDepositoBanco;
	}

	public void setResaltarid_usuarioDepositoBanco(Border borderResaltar) {
		this.resaltarid_usuarioDepositoBanco= borderResaltar;
	}

	public Boolean getMostrarid_usuarioDepositoBanco() {
		return this.mostrarid_usuarioDepositoBanco;
	}

	public void setMostrarid_usuarioDepositoBanco(Boolean mostrarid_usuarioDepositoBanco) {
		this.mostrarid_usuarioDepositoBanco= mostrarid_usuarioDepositoBanco;
	}

	public Boolean getActivarid_usuarioDepositoBanco() {
		return this.activarid_usuarioDepositoBanco;
	}

	public void setActivarid_usuarioDepositoBanco(Boolean activarid_usuarioDepositoBanco) {
		this.activarid_usuarioDepositoBanco= activarid_usuarioDepositoBanco;
	}

	public Boolean getCargarid_usuarioDepositoBanco() {
		return this.cargarid_usuarioDepositoBanco;
	}

	public void setCargarid_usuarioDepositoBanco(Boolean cargarid_usuarioDepositoBanco) {
		this.cargarid_usuarioDepositoBanco= cargarid_usuarioDepositoBanco;
	}

	public Border setResaltarid_bancoDepositoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depositobancoBeanSwingJInternalFrame.jTtoolBarDepositoBanco.setBorder(borderResaltar);
		
		this.resaltarid_bancoDepositoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bancoDepositoBanco() {
		return this.resaltarid_bancoDepositoBanco;
	}

	public void setResaltarid_bancoDepositoBanco(Border borderResaltar) {
		this.resaltarid_bancoDepositoBanco= borderResaltar;
	}

	public Boolean getMostrarid_bancoDepositoBanco() {
		return this.mostrarid_bancoDepositoBanco;
	}

	public void setMostrarid_bancoDepositoBanco(Boolean mostrarid_bancoDepositoBanco) {
		this.mostrarid_bancoDepositoBanco= mostrarid_bancoDepositoBanco;
	}

	public Boolean getActivarid_bancoDepositoBanco() {
		return this.activarid_bancoDepositoBanco;
	}

	public void setActivarid_bancoDepositoBanco(Boolean activarid_bancoDepositoBanco) {
		this.activarid_bancoDepositoBanco= activarid_bancoDepositoBanco;
	}

	public Boolean getCargarid_bancoDepositoBanco() {
		return this.cargarid_bancoDepositoBanco;
	}

	public void setCargarid_bancoDepositoBanco(Boolean cargarid_bancoDepositoBanco) {
		this.cargarid_bancoDepositoBanco= cargarid_bancoDepositoBanco;
	}

	public Border setResaltarid_asiento_contableDepositoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depositobancoBeanSwingJInternalFrame.jTtoolBarDepositoBanco.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableDepositoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableDepositoBanco() {
		return this.resaltarid_asiento_contableDepositoBanco;
	}

	public void setResaltarid_asiento_contableDepositoBanco(Border borderResaltar) {
		this.resaltarid_asiento_contableDepositoBanco= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableDepositoBanco() {
		return this.mostrarid_asiento_contableDepositoBanco;
	}

	public void setMostrarid_asiento_contableDepositoBanco(Boolean mostrarid_asiento_contableDepositoBanco) {
		this.mostrarid_asiento_contableDepositoBanco= mostrarid_asiento_contableDepositoBanco;
	}

	public Boolean getActivarid_asiento_contableDepositoBanco() {
		return this.activarid_asiento_contableDepositoBanco;
	}

	public void setActivarid_asiento_contableDepositoBanco(Boolean activarid_asiento_contableDepositoBanco) {
		this.activarid_asiento_contableDepositoBanco= activarid_asiento_contableDepositoBanco;
	}

	public Boolean getCargarid_asiento_contableDepositoBanco() {
		return this.cargarid_asiento_contableDepositoBanco;
	}

	public void setCargarid_asiento_contableDepositoBanco(Boolean cargarid_asiento_contableDepositoBanco) {
		this.cargarid_asiento_contableDepositoBanco= cargarid_asiento_contableDepositoBanco;
	}

	public Border setResaltarfechaDepositoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depositobancoBeanSwingJInternalFrame.jTtoolBarDepositoBanco.setBorder(borderResaltar);
		
		this.resaltarfechaDepositoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaDepositoBanco() {
		return this.resaltarfechaDepositoBanco;
	}

	public void setResaltarfechaDepositoBanco(Border borderResaltar) {
		this.resaltarfechaDepositoBanco= borderResaltar;
	}

	public Boolean getMostrarfechaDepositoBanco() {
		return this.mostrarfechaDepositoBanco;
	}

	public void setMostrarfechaDepositoBanco(Boolean mostrarfechaDepositoBanco) {
		this.mostrarfechaDepositoBanco= mostrarfechaDepositoBanco;
	}

	public Boolean getActivarfechaDepositoBanco() {
		return this.activarfechaDepositoBanco;
	}

	public void setActivarfechaDepositoBanco(Boolean activarfechaDepositoBanco) {
		this.activarfechaDepositoBanco= activarfechaDepositoBanco;
	}

	public Border setResaltarvalor_efectivoDepositoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depositobancoBeanSwingJInternalFrame.jTtoolBarDepositoBanco.setBorder(borderResaltar);
		
		this.resaltarvalor_efectivoDepositoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_efectivoDepositoBanco() {
		return this.resaltarvalor_efectivoDepositoBanco;
	}

	public void setResaltarvalor_efectivoDepositoBanco(Border borderResaltar) {
		this.resaltarvalor_efectivoDepositoBanco= borderResaltar;
	}

	public Boolean getMostrarvalor_efectivoDepositoBanco() {
		return this.mostrarvalor_efectivoDepositoBanco;
	}

	public void setMostrarvalor_efectivoDepositoBanco(Boolean mostrarvalor_efectivoDepositoBanco) {
		this.mostrarvalor_efectivoDepositoBanco= mostrarvalor_efectivoDepositoBanco;
	}

	public Boolean getActivarvalor_efectivoDepositoBanco() {
		return this.activarvalor_efectivoDepositoBanco;
	}

	public void setActivarvalor_efectivoDepositoBanco(Boolean activarvalor_efectivoDepositoBanco) {
		this.activarvalor_efectivoDepositoBanco= activarvalor_efectivoDepositoBanco;
	}

	public Border setResaltarvalor_chequeDepositoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depositobancoBeanSwingJInternalFrame.jTtoolBarDepositoBanco.setBorder(borderResaltar);
		
		this.resaltarvalor_chequeDepositoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_chequeDepositoBanco() {
		return this.resaltarvalor_chequeDepositoBanco;
	}

	public void setResaltarvalor_chequeDepositoBanco(Border borderResaltar) {
		this.resaltarvalor_chequeDepositoBanco= borderResaltar;
	}

	public Boolean getMostrarvalor_chequeDepositoBanco() {
		return this.mostrarvalor_chequeDepositoBanco;
	}

	public void setMostrarvalor_chequeDepositoBanco(Boolean mostrarvalor_chequeDepositoBanco) {
		this.mostrarvalor_chequeDepositoBanco= mostrarvalor_chequeDepositoBanco;
	}

	public Boolean getActivarvalor_chequeDepositoBanco() {
		return this.activarvalor_chequeDepositoBanco;
	}

	public void setActivarvalor_chequeDepositoBanco(Boolean activarvalor_chequeDepositoBanco) {
		this.activarvalor_chequeDepositoBanco= activarvalor_chequeDepositoBanco;
	}

	public Border setResaltardescripcionDepositoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depositobancoBeanSwingJInternalFrame.jTtoolBarDepositoBanco.setBorder(borderResaltar);
		
		this.resaltardescripcionDepositoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDepositoBanco() {
		return this.resaltardescripcionDepositoBanco;
	}

	public void setResaltardescripcionDepositoBanco(Border borderResaltar) {
		this.resaltardescripcionDepositoBanco= borderResaltar;
	}

	public Boolean getMostrardescripcionDepositoBanco() {
		return this.mostrardescripcionDepositoBanco;
	}

	public void setMostrardescripcionDepositoBanco(Boolean mostrardescripcionDepositoBanco) {
		this.mostrardescripcionDepositoBanco= mostrardescripcionDepositoBanco;
	}

	public Boolean getActivardescripcionDepositoBanco() {
		return this.activardescripcionDepositoBanco;
	}

	public void setActivardescripcionDepositoBanco(Boolean activardescripcionDepositoBanco) {
		this.activardescripcionDepositoBanco= activardescripcionDepositoBanco;
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
		
		
		this.setMostraridDepositoBanco(esInicial);
		this.setMostrarid_empresaDepositoBanco(esInicial);
		this.setMostrarid_sucursalDepositoBanco(esInicial);
		this.setMostrarid_usuarioDepositoBanco(esInicial);
		this.setMostrarid_bancoDepositoBanco(esInicial);
		this.setMostrarid_asiento_contableDepositoBanco(esInicial);
		this.setMostrarfechaDepositoBanco(esInicial);
		this.setMostrarvalor_efectivoDepositoBanco(esInicial);
		this.setMostrarvalor_chequeDepositoBanco(esInicial);
		this.setMostrardescripcionDepositoBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DepositoBancoConstantesFunciones.ID)) {
				this.setMostraridDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.IDBANCO)) {
				this.setMostrarid_bancoDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.FECHA)) {
				this.setMostrarfechaDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.VALOREFECTIVO)) {
				this.setMostrarvalor_efectivoDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.VALORCHEQUE)) {
				this.setMostrarvalor_chequeDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDepositoBanco(esAsigna);
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
		
		
		this.setActivaridDepositoBanco(esInicial);
		this.setActivarid_empresaDepositoBanco(esInicial);
		this.setActivarid_sucursalDepositoBanco(esInicial);
		this.setActivarid_usuarioDepositoBanco(esInicial);
		this.setActivarid_bancoDepositoBanco(esInicial);
		this.setActivarid_asiento_contableDepositoBanco(esInicial);
		this.setActivarfechaDepositoBanco(esInicial);
		this.setActivarvalor_efectivoDepositoBanco(esInicial);
		this.setActivarvalor_chequeDepositoBanco(esInicial);
		this.setActivardescripcionDepositoBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DepositoBancoConstantesFunciones.ID)) {
				this.setActivaridDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.IDBANCO)) {
				this.setActivarid_bancoDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.FECHA)) {
				this.setActivarfechaDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.VALOREFECTIVO)) {
				this.setActivarvalor_efectivoDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.VALORCHEQUE)) {
				this.setActivarvalor_chequeDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDepositoBanco(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDepositoBanco(esInicial);
		this.setResaltarid_empresaDepositoBanco(esInicial);
		this.setResaltarid_sucursalDepositoBanco(esInicial);
		this.setResaltarid_usuarioDepositoBanco(esInicial);
		this.setResaltarid_bancoDepositoBanco(esInicial);
		this.setResaltarid_asiento_contableDepositoBanco(esInicial);
		this.setResaltarfechaDepositoBanco(esInicial);
		this.setResaltarvalor_efectivoDepositoBanco(esInicial);
		this.setResaltarvalor_chequeDepositoBanco(esInicial);
		this.setResaltardescripcionDepositoBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DepositoBancoConstantesFunciones.ID)) {
				this.setResaltaridDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.IDBANCO)) {
				this.setResaltarid_bancoDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.FECHA)) {
				this.setResaltarfechaDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.VALOREFECTIVO)) {
				this.setResaltarvalor_efectivoDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.VALORCHEQUE)) {
				this.setResaltarvalor_chequeDepositoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepositoBancoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDepositoBanco(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableDepositoBanco=true;

	public Boolean getMostrarFK_IdAsientoContableDepositoBanco() {
		return this.mostrarFK_IdAsientoContableDepositoBanco;
	}

	public void setMostrarFK_IdAsientoContableDepositoBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableDepositoBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBancoDepositoBanco=true;

	public Boolean getMostrarFK_IdBancoDepositoBanco() {
		return this.mostrarFK_IdBancoDepositoBanco;
	}

	public void setMostrarFK_IdBancoDepositoBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBancoDepositoBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDepositoBanco=true;

	public Boolean getMostrarFK_IdEmpresaDepositoBanco() {
		return this.mostrarFK_IdEmpresaDepositoBanco;
	}

	public void setMostrarFK_IdEmpresaDepositoBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDepositoBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDepositoBanco=true;

	public Boolean getMostrarFK_IdSucursalDepositoBanco() {
		return this.mostrarFK_IdSucursalDepositoBanco;
	}

	public void setMostrarFK_IdSucursalDepositoBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDepositoBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioDepositoBanco=true;

	public Boolean getMostrarFK_IdUsuarioDepositoBanco() {
		return this.mostrarFK_IdUsuarioDepositoBanco;
	}

	public void setMostrarFK_IdUsuarioDepositoBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioDepositoBanco= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableDepositoBanco=true;

	public Boolean getActivarFK_IdAsientoContableDepositoBanco() {
		return this.activarFK_IdAsientoContableDepositoBanco;
	}

	public void setActivarFK_IdAsientoContableDepositoBanco(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableDepositoBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdBancoDepositoBanco=true;

	public Boolean getActivarFK_IdBancoDepositoBanco() {
		return this.activarFK_IdBancoDepositoBanco;
	}

	public void setActivarFK_IdBancoDepositoBanco(Boolean habilitarResaltar) {
		this.activarFK_IdBancoDepositoBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDepositoBanco=true;

	public Boolean getActivarFK_IdEmpresaDepositoBanco() {
		return this.activarFK_IdEmpresaDepositoBanco;
	}

	public void setActivarFK_IdEmpresaDepositoBanco(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDepositoBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDepositoBanco=true;

	public Boolean getActivarFK_IdSucursalDepositoBanco() {
		return this.activarFK_IdSucursalDepositoBanco;
	}

	public void setActivarFK_IdSucursalDepositoBanco(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDepositoBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioDepositoBanco=true;

	public Boolean getActivarFK_IdUsuarioDepositoBanco() {
		return this.activarFK_IdUsuarioDepositoBanco;
	}

	public void setActivarFK_IdUsuarioDepositoBanco(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioDepositoBanco= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableDepositoBanco=null;

	public Border getResaltarFK_IdAsientoContableDepositoBanco() {
		return this.resaltarFK_IdAsientoContableDepositoBanco;
	}

	public void setResaltarFK_IdAsientoContableDepositoBanco(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableDepositoBanco= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableDepositoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableDepositoBanco= borderResaltar;
	}

	public Border resaltarFK_IdBancoDepositoBanco=null;

	public Border getResaltarFK_IdBancoDepositoBanco() {
		return this.resaltarFK_IdBancoDepositoBanco;
	}

	public void setResaltarFK_IdBancoDepositoBanco(Border borderResaltar) {
		this.resaltarFK_IdBancoDepositoBanco= borderResaltar;
	}

	public void setResaltarFK_IdBancoDepositoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBancoDepositoBanco= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDepositoBanco=null;

	public Border getResaltarFK_IdEmpresaDepositoBanco() {
		return this.resaltarFK_IdEmpresaDepositoBanco;
	}

	public void setResaltarFK_IdEmpresaDepositoBanco(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDepositoBanco= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDepositoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDepositoBanco= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDepositoBanco=null;

	public Border getResaltarFK_IdSucursalDepositoBanco() {
		return this.resaltarFK_IdSucursalDepositoBanco;
	}

	public void setResaltarFK_IdSucursalDepositoBanco(Border borderResaltar) {
		this.resaltarFK_IdSucursalDepositoBanco= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDepositoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDepositoBanco= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioDepositoBanco=null;

	public Border getResaltarFK_IdUsuarioDepositoBanco() {
		return this.resaltarFK_IdUsuarioDepositoBanco;
	}

	public void setResaltarFK_IdUsuarioDepositoBanco(Border borderResaltar) {
		this.resaltarFK_IdUsuarioDepositoBanco= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioDepositoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*DepositoBancoBeanSwingJInternalFrame depositobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioDepositoBanco= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}